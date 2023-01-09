<template>
  <div v-if="!userObj">
    <p>Loading...</p>
  </div>
  <div v-else>
    <div class="m-4 rounded-lg overflow-hidden shadow shadow-md">
      <div class="w-full h-48 banner" />
        <div class="h-24 flex flex-row justify-between">
          <img
            v-if="profileImage"
            :src="profileImage"
            class="w-40 h-40 rounded-full ring-8 ring-white object-cover absolute -mt-20 ml-8"
            alt="Bordered avatar"
          >
          <div v-else class="inline-flex items-center justify-center w-40 h-40 object-cover absolute -mt-20 ml-8 bg-gray-100 rounded-full">
            <span class="text-2xl font-medium text-gray-600">{{ getInitials }}</span>
          </div>
        <div />
        <button @click="editUserInfoModalOpen = true" type="button" class="m-4 text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm p-2.5 text-center inline-flex items-center">
          <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15.232 5.232l3.536 3.536m-2.036-5.036a2.5 2.5 0 113.536 3.536L6.5 21.036H3v-3.572L16.732 3.732z"></path></svg>
          <span class="sr-only">Edit Profile</span>
        </button>
      </div>
      <div class="w-full text-left px-8 py-4">
        <p class="text-2xl">{{ userFullName(getUser) }}</p>
        <p class="text-gray-400">{{ firstLetterUpperCase(getUser.city) }}</p>
        <p class="mt-4 w-full md:w-2/3">{{ getUser.bio }}</p>

        <div class="mt-4">
          <p class="font-medium">Attachments</p>
          <ul v-if="files !== null" class="w-full text-sm font-medium text-gray-900 bg-white rounded-lg border border-gray-200 divide-y">
            <AttachmentRow v-for="attachment in getAttachments" :key="attachment.id" :attachment="attachment"/>
          </ul>
        </div>
      </div>
    </div>

    <UpcomingMeetingModal :open="upcomingMeetingModalOpen" :user="userObj" :meeting="selectedMeeting" :projects="userObj.specialist.projects" @close="upcomingMeetingModalOpen = false" @deleted="removeEvent" @updated="updateEvent"/>
    <EditUserInfoModal :open="editUserInfoModalOpen" :user="userObj" :profileImage="profileImage" @close="editUserInfoModalOpen = false" @updated="updateUser"/>
    <SkillModal :open="skillModalOpen" :skills="skills" :user="userObj" :selectedSkill="selectedSkill" @close="skillModalOpen = false" @updated="updateSkills"/>

    <!-- Skills -->
    <div v-if="userObj.userType === 2" class="m-4 rounded-lg px-8 py-4 text-left shadow shadow-md">
      <p class="text-xl mb-4">Vaardigheden</p>
      <div class="grid grid-cols-1 md:grid-cols-3 gap-4 mb-8">
        <SkillBadge v-for="(skill, index) in userSkills" :key="index" :skill="skill" @skillClicked="openSkillModal"/>

        <button @click="openSkillModal(new UserSkill())" class="bg-green-100 hover:bg-green-200 text-green-900 p-4 rounded-md flex items-center justify-center">
          <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 6v6m0 0v6m0-6h6m-6 0H6"></path></svg>
        </button>
      </div>
    </div>

    <!-- Projects -->
    <div v-if="userObj.userType === 2" class="m-4 rounded-lg px-8 py-4 text-left shadow shadow-md">
      <p class="text-xl mb-4">Projecten</p>
      <div v-if="userObj.specialist.projects.length === 0">
        <p class="text-lg">Geen projecten beschikbaar</p>
      </div>
      <div v-else class="grid grid-cols-1 md:grid-cols-4 gap-4 mb-8">
        <ProjectCard v-for="project in userObj.specialist.projects" :key="project.id" :project="project" />
      </div>
    </div>

    <!-- Availability -->
    <div v-if="userObj.userType === 2" class="m-4 rounded-lg px-8 py-4 text-left shadow shadow-md">
      <p class="text-xl">Beschikbaarheid</p>
      <AvailabilityRow :hours="userObj.specialist.hours"/>
    </div>

    <!-- Calendar -->
    <div v-if="userObj.userType === 2" class="m-4 rounded-lg px-8 py-4 text-left shadow shadow-md">
      <p class="text-xl">Komende vergaderingen (aantal: {{ eventsInDateRange.length }})</p>

      <div class="flex flex-col md:flex-row">
        <div class="w-full md:w-2/3 md:pr-10">
          <DatePicker :lang="langObj" v-model:open="meetingRangeOpen" v-model:value="meetingsDateRange" type="date" range placeholder="Select a date range" :clearable="false">
            <template #footer>
              <div class="text-left flex flex-row flex-nowrap gap-2"> <!-- FIXME The button row doesn't overflow scroll so it looks forced and breaks the width -->
                <button class="mx-btn mx-btn-next" @click="selectMeetingRange(1)">Deze week</button>
                <button class="mx-btn mx-btn-next" @click="selectMeetingRange(2)">Deze maand</button>
                <button class="mx-btn mx-btn-next" @click="selectMeetingRange(3)">Volgende maand</button>
              </div>
            </template>
          </DatePicker>
          <div v-if="eventsInDateRange.length !== 0" class="divide-y">
            <UpcomingMeeting v-for="meeting in eventsInDateRange" :key="meeting.id" :meeting="meeting" @meetingClicked="openUpcomingMeetingModal"/>
          </div>
          <div v-else class="flex flex-col items-center mt-8">
            <svg class="w-32 h-32" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M18.364 18.364A9 9 0 005.636 5.636m12.728 12.728A9 9 0 015.636 5.636m12.728 12.728L5.636 5.636"></path></svg>
            <p class="text-xl w-1/2 text-center">Er zijn geen vergaderingen in het geselecteerde datumbereik</p>
          </div>
        </div>
        <div class="w-full md:w-1/3 mt-4 md:mt-0 flex flex-col">
          <v-calendar ref="calendar" is-expanded :attributes="attributes">
            <template #day-popover="{ dayTitle, attributes }">
              <div class="text-xs text-gray-300 font-semibold text-center">
                {{ dayTitle }}
              </div>
              <calendar-row
                v-for="attr in attributes"
                :key="attr.key"
                :attribute="attr"
                @click="openUpcomingMeetingModal(attr.customData)"
                class="cursor-pointer"
              >
                {{ attr.customData.title }}
              </calendar-row>
            </template>
          </v-calendar>
          <button @click="openUpcomingMeetingModal(null)" type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mt-2">Voeg activiteit toe</button>
          <div class="flex flex-row space-x-2 w-full mt-2">
            <div class="flex flex-col w-full text-center">
              <div class="w-full h-4 bg-red-500 rounded-sm" />
              <p>Afgewezen</p>
            </div>
            <div class="flex flex-col w-full text-center">
              <div class="w-full h-4 bg-blue-400 rounded-sm" />
              <p>Geen status</p>
            </div>
            <div class="flex flex-col w-full text-center">
              <div class="w-full h-4 bg-green-400 rounded-sm" />
              <p>Aanvaard</p>
            </div>
          </div>
        </div>
      </div>
    </div>

    <FileUpload />
  </div>
</template>
<script>
// Packages
import DatePicker from 'vue-datepicker-next';
import axios from "axios";

// Styling
import 'vue-datepicker-next/index.css';
import 'v-calendar/dist/style.css';
import 'vue-datepicker-next/locale/nl';

// Components
import ProjectCard from "@/components/admin/profile/ProjectCard";
import AttachmentRow from "@/components/miscellaneous/profile/AttachmentRow";
import CalendarRow from "@/components/miscellaneous/profile/CalendarRow";
import SkillBadge from "@/components/miscellaneous/profile/SkillBadge";
import UpcomingMeeting from "@/components/miscellaneous/profile/UpcomingMeeting.vue";
import AvailabilityRow from "@/components/miscellaneous/profile/AvailabilityRow.vue";

// Methods
import { userFullName, firstLetterUpperCase } from "@/plugins/textManipulation";

// Modals
import UpcomingMeetingModal from "@/components/modals/profile/UpcomingMeetingModal.vue";
import EditUserInfoModal from "@/components/modals/profile/EditUserInfoModal.vue";
import SkillModal from "@/components/modals/profile/SkillModal.vue";

// Models
import UserSkill from "@/models/userSkill";
import Skill from "@/models/skill";
import UpcomingMeetingClass from "@/models/upcomingMeeting";
import {proxyObjToJson} from "@/plugins/objectManipulation";
import FileUpload from "@/components/fileHandling/FileUpload.vue";

// TODO Create a backend route that with params gets all the correct meetings
export default {
  name: "UserProfile",
  data() {
    return {
      langObj: {
        formatLocale: {
          firstDayOfWeek: 1
        },
      },
      userObj: null,
      meetingsDateRange: null,
      skills: null,
      projects: null,
      events: null,
      files: [],
      meetingRangeOpen: false,

      profileImage: null,

      // Selected data
      selectedSkill: new UserSkill(),
      selectedMeeting: new UpcomingMeetingClass(),

      // ModalData
      upcomingMeetingModalOpen: false,
      editUserInfoModalOpen: false,
      skillModalOpen: false,
    }
  },
  computed: {
    UserSkill() {
      return UserSkill
    },
    attributes() {
      return [
          ...this.userObj.specialist.events.map(meeting => this.meetingFormat(meeting))
      ]
    },
    userSkills() {
      return this.userObj.specialist.skills;
    },
    getUser() {
      return this.userObj;
    },
    getInitials() {
      const firstName = this.userObj.first_name[0].toUpperCase();
      const lastName = this.userObj.last_name[0].toUpperCase();

      return firstName + lastName;
    },
    eventsInDateRange() {
      const start = this.meetingsDateRange[0];
      const end = this.meetingsDateRange[1];

      start.setHours(0);
      start.setMinutes(1);
      start.setSeconds(0);

      end.setHours(23);
      end.setMinutes(59);
      end.setSeconds(59);

      const meetingsInThisRange = [];

      this.userObj.specialist.events.forEach(event => {
        // console.log(event);
        const meetingStart = new Date(event.start);
        const meetingEnd = new Date(event.end);

        const afterStart = this.getEpochTime(start) <= this.getEpochTime(meetingStart);
        const beforeEnd = this.getEpochTime(end) > this.getEpochTime(meetingEnd);

        // TODO - Add a filter to show the meetings within the date range, if its a meeting of multiple days that goes
        //  beyond the before and after boolean

        if (afterStart && beforeEnd) {
          meetingsInThisRange.push(event);
        }
      })

      this.moveCalendarToSelectedMonth(start);

      return meetingsInThisRange;
    },
    getAttachments() {
      const files = [];

      for (const file in this.files) {
        const obj = this.files[file];

        if (obj.type === "application/pdf") {
          files.push(obj);
        }
      }

      return files;
    },
  },
  created() {
    this.selectMeetingRange(1);

    this.getUserData();
    this.getSkillsData();
    this.getFiles();
  },
  methods: {
    userFullName,
    firstLetterUpperCase,

    getUserData() {
      const userID = this.$route.params.id

      axios.get(`http://localhost:8080/api/users/${userID}`)
        .then(res => {
          this.userObj = res.data;
          this.events = res.data.specialist.events;
          this.userSkills = res.data.specialist.skills;

          this.processImage(res.data.photo);
        })
        .catch(err => {
          console.log(err);
        })
    },

    getSkillsData() {
      axios.get("http://localhost:8080/api/skills")
        .then((res) => {
          this.skills = res.data;
        })
        .catch((err) => {
          console.log(err);
        })
    },

    getFiles() {
      const ID = this.$route.params.id;
      const URL = `${process.env.VUE_APP_API_URL}/api/files/list/${ID}`;
      const PROTOCOL = "GET"

      axios({ url: URL, method: PROTOCOL })
        .then((res) => {
          console.log(res);
          this.files = res.data;
        })
        .catch((err) => {
          console.log(err);
        })
    },

    processImage(FILE_ID) {
      const URL = `${process.env.VUE_APP_API_URL}/api/files/${FILE_ID}`;
      const METHOD = "GET";
      const RESPONSE_TYPE = "blob";

      axios({ url: URL, method: METHOD, responseType: RESPONSE_TYPE })
        .then((res) => {
          console.log(res.data);
          const file = res.data;
          const reader = new FileReader();
          reader.readAsDataURL(file);

          reader.onload = (evt) => {
            console.log(evt.target.result.replaceAll(" ", ""));
            this.profileImage = evt.target.result;
            console.log(this.profileImage);
          }
        })
        .catch((err) => {
          console.log(err);
        })
    },

    saveUser() {
      const userID = this.$route.params.id;

      axios.put(`http://localhost:8080/api/users/update`, this.userObj)
        .then((res) => {
          console.log(res);
        })
        .catch((err) => {
          console.log(err);
        })
    },

    updateSkills(value) {
      this.userObj.specialist.skills = value;
    },

    updateUser(value) {
      this.userObj = value;
    },

    meetingFormat(meeting) {
      const meetingStart = new Date(meeting.start);
      const meetingEnd = new Date(meeting.end);

      const multiDayMeeting = {
        highlight: {
          start: { fillMode: 'outline', color: this.getMeetingType(meeting.accepted) },
          base: { fillMode: 'light', color: this.getMeetingType(meeting.accepted) },
          end: { fillMode: 'outline', color: this.getMeetingType(meeting.accepted) },
        },
        dates: { start: meetingStart, end: meetingEnd },
        popover: {
          label: meeting.title,
          visibility: 'focus',
          isInteractive: true
        },
        customData: meeting
      }

      const sameDayMeeting = {
        dates: [meetingStart, meetingEnd],
        popover: {
          label: meeting.title,
          visibility: 'focus',
          isInteractive: true
        },
        bar: {
          color: this.getMeetingType(meeting.accepted)
        },
        customData: meeting
      }

      return this.sameDay(meetingStart, meetingEnd) ? sameDayMeeting : multiDayMeeting;
    },
    getMeetingType(type) {
      // Available Colors: gray, red, orange, yellow, green, teal, blue, indigo, purple, pink
      let color;

      switch (type) {
        case -1: // Declined
          color = "red"
          break;
        case 0: // No status
          color = "blue"
          break;
        case 1: // Accepted
          color = "orange"
          break;
        default: // No accepted status available
          color = "gray"
      }

      return color;
    },
    sameDay(start, end) {
      return start.getFullYear() === end.getFullYear() &&
          start.getMonth() === end.getMonth() &&
          start.getDate() === end.getDate()
    },
    getEpochTime(date) {
      return date.getTime() / 1000;
    },
    selectMeetingRange(type) {
      // 1 = Next week | 2 = This month | 3 = Next month

      const today = new Date();

      let startDate;
      let endDate;

      switch (type) {
        case 1:
          endDate = new Date(today.getFullYear(), today.getMonth(), today.getDate() + 7);

          this.meetingsDateRange = [today, endDate];
          break;
        case 2:
          startDate = new Date(today.getFullYear(), today.getMonth(), 1);
          endDate = new Date(today.getFullYear(), today.getMonth() + 1, 0);

          this.meetingsDateRange = [startDate, endDate];
          break;
        case 3:
          startDate = new Date(today.getFullYear(), today.getMonth() + 1, 1)
          endDate = new Date(today.getFullYear(), today.getMonth() + 2, 0);

          this.meetingsDateRange = [startDate, endDate];
          break;
      }

      this.meetingRangeOpen = false;
    },

    async moveCalendarToSelectedMonth(date) {
      const calendar = this.$refs.calendar;
      // TODO - This prints undefined
      // console.log(calendar);

      if (calendar) {
        await calendar.move({ month: date.getMonth() + 1, year: date.getFullYear() });
      }
    },

    openSkillModal(userSkill) {
      this.selectedSkill = new UserSkill(userSkill)
      this.skillModalOpen = true;
    },

    openUpcomingMeetingModal(meeting) {
      this.selectedMeeting = new UpcomingMeetingClass(meeting);
      this.upcomingMeetingModalOpen = true;
    },

    removeEvent(event) {
      this.userObj.specialist.events = this.userObj.specialist.events.filter(evt => evt.id !== event.id);
    },
    updateEvent(event) {
      console.log("EVENT", event);
      const index = this.userObj.specialist.events.findIndex(evt => evt.id === event.id);

      if (index === -1) {
        this.userObj.specialist.events.push(event);
      } else {
        this.userObj.specialist.events[index] = event;
      }
    },
  },
  components: {
    FileUpload,
    AvailabilityRow,
    SkillModal,
    EditUserInfoModal,
    UpcomingMeetingModal,
    AttachmentRow,
    ProjectCard,
    SkillBadge,
    DatePicker,
    CalendarRow,
    UpcomingMeeting
  }
}
</script>
<style>
  .banner {
    background-image: linear-gradient(to right, #F15922 , #f17822)
  }

  .mx-datepicker {
    width: 100%;
  }

  .mx-input {
    background-color: #f9fafb !important;
    border-width: 1px !important;
    border-color: #d1d5db !important;
    color: #111827 !important;
    border-radius: 0.5rem !important;
    font-size: 0.875rem !important; /* 14px */
    line-height: 1.25rem !important; /* 20px */
    padding: 0.625rem !important; /* 10px */
    box-shadow: 0px 0px 0px 0px rgba(0,0,0,0) !important;
  }

  .mx-input:disabled {
    background-color: #e5e7eb !important;
    color: #6b7280 !important;
  }
</style>