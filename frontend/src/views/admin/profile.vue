<template>
  <div v-if="!userObj">
    <p>Loading</p>
  </div>
  <div v-else>
    <div class="m-4 rounded-lg overflow-hidden shadow shadow-md">
      <div class="w-full h-48 banner" />
        <div class="h-24 flex flex-row justify-between">
          <img
              class="w-40 h-40 rounded-full ring-8 ring-white object-cover absolute -mt-20 ml-8"
              :src="userObj.photo"
              alt="Bordered avatar"
          >
        <div />
        <button @click="editUserInfoModalOpen = true" type="button" class="m-4 text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm p-2.5 text-center inline-flex items-center">
          <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15.232 5.232l3.536 3.536m-2.036-5.036a2.5 2.5 0 113.536 3.536L6.5 21.036H3v-3.572L16.732 3.732z"></path></svg>
          <span class="sr-only">Edit Profile</span>
        </button>
      </div>
      <div class="w-full text-left px-8 py-4">
        <p class="text-2xl">{{ userFullName(userObj) }}</p>
        <p class="text-gray-400">{{ firstLetterUpperCase(userObj.city) }}</p>
        <p class="mt-4 w-full md:w-2/3">{{ userObj.bio }}</p>

        <div class="mt-4">
          <p class="font-medium">Attachments</p>
          <ul class="w-full text-sm font-medium text-gray-900 bg-white rounded-lg border border-gray-200 divide-y">
            <AttachmentRow v-for="(attachment, index) in attachments" :key="index" :attachment="attachment"/>
          </ul>
        </div>

        <!-- TODO - Add to project buttons -->
  <!--      <div class="flex flex-row space-x-2 mt-4">-->
  <!--        <button type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mb-2 focus:outline-none">Default</button>-->
  <!--        <button type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mb-2 focus:outline-none">Default</button>-->
  <!--      </div>-->
      </div>
    </div>

    <UpcomingMeetingModal :open="upcomingMeetingModalOpen" :meeting="selectedMeeting" @close="upcomingMeetingModalOpen = false"/>
    <EditUserInfoModal :open="editUserInfoModalOpen" :user="userObj" @close="editUserInfoModalOpen = false"/>
    <SkillModal :open="skillModalOpen" :skills="skills" :user="userObj" @close="skillModalOpen = false"/>

    <!-- Skills -->
    <div v-if="userObj.userType === 2" class="m-4 rounded-lg px-8 py-4 text-left shadow shadow-md">
      <p class="text-xl mb-4">Vaardigheden</p>
      <div class="grid grid-cols-1 md:grid-cols-3 gap-4 mb-8">
        <SkillBadge v-for="(skill, index) in userObj.specialist.skills" :key="index" :skill="skill" @skillClicked="openSkillModal"/>

        <button @click="skillModalOpen = true" class="bg-green-100 hover:bg-green-200 text-green-900 p-4 rounded-md flex items-center justify-center">
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
        <ProjectCard v-for="(item, index) in userObj.specialist.project" :key="index" :project="item" />
      </div>
    </div>

    <!-- Availability -->
    <div v-if="userObj.userType === 2" class="m-4 rounded-lg px-8 py-4 text-left shadow shadow-md">
      <div class="flex flex-row justify-between items-center">
        <p class="text-xl">Beschikbaar: <span class="font-semibold">{{ availableHours }}</span> uren</p>
        <button @click="saveHours" type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center mr-2">
          <svg class="mr-2 -ml-1 w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M8 7H5a2 2 0 00-2 2v9a2 2 0 002 2h14a2 2 0 002-2V9a2 2 0 00-2-2h-3m-1 4l-3 3m0 0l-3-3m3 3V4"></path></svg>
          Save
        </button>
      </div>
<!--      <div class="flex flex-col md:flex-row mt-4 justify-between gap-2">-->
<!--        <AvailabilityRow v-for="(hour, index) in Object.keys(this.userObj.specialist.hours.days)" :key="index" :label="hour" :time="this.userObj.specialist.hours.days[hour]" @saveAvailability="saveAvailability"/>-->
<!--      </div>-->
    </div>

    <!-- TODO: When the modal updates, it will also update the value in here. Fix that the value here won't change. -->
    <!-- Calendar -->
    <div v-if="userObj.userType === 2" class="m-4 rounded-lg px-8 py-4 text-left shadow shadow-md">
      <p class="text-xl">Komende vergaderingen</p>

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
            <UpcomingMeeting v-for="(meeting, index) in eventsInDateRange" :key="index" :meeting="meeting" @meetingClicked="openUpcomingMeetingModal"/>
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
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import SkillBadge from "@/components/miscellaneous/profile/SkillBadge";
import Skill from "@/models/skill";
import UpcomingMeetingClass from "@/models/upcomingMeeting";
import ProjectCard from "@/components/miscellaneous/ProjectCard";
import UpcomingMeeting from "@/components/miscellaneous/profile/UpcomingMeeting";
import DatePicker from 'vue-datepicker-next';
import CalendarRow from "@/components/miscellaneous/profile/CalendarRow";
import AvailabilityRow from "@/components/miscellaneous/profile/AvailabilityRow";

import 'vue-datepicker-next/index.css';
import 'v-calendar/dist/style.css';
import 'vue-datepicker-next/locale/nl';
import AttachmentRow from "@/components/miscellaneous/profile/AttachmentRow";
import axios from "axios";

import { userFullName, firstLetterUpperCase } from "@/plugins/textManipulation";
import MeetingType from "@/components/miscellaneous/profile/MeetingType";
import UpcomingMeetingModal from "@/components/modals/profile/UpcomingMeetingModal.vue";
import upcomingMeeting from "@/components/miscellaneous/profile/UpcomingMeeting.vue";
import EditUserInfoModal from "@/components/modals/profile/EditUserInfoModal.vue";
import SkillModal from "@/components/modals/profile/SkillModal.vue";

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
      hours: [ // TODO make all references to this object dynamic to the api
        {
          label: "Dinsdag",
          start: new Date(2022, 11, 12, 9, 0),
          end: new Date(2022, 11, 12, 17, 0),
          available: true
        },
        {
          label: "Zaterdag",
          start: new Date(2022, 11, 12, 9, 0),
          end: new Date(2022, 11, 12, 17, 0),
          available: false
        },
        {
          label: "Maandag",
          start: new Date(2022, 11, 12, 9, 0),
          end: new Date(2022, 11, 12, 17, 0),
          available: true
        },
        {
          label: "Woensdag",
          start: new Date(2022, 11, 12, 9, 0),
          end: new Date(2022, 11, 12, 17, 0),
          available: true
        },

        {
          label: "Vrijdag",
          start: new Date(2022, 11, 12, 9, 0),
          end: new Date(2022, 11, 12, 17, 0),
          available: true
        },
        {
          label: "Zondag",
          start: new Date(2022, 11, 12, 9, 0),
          end: new Date(2022, 11, 12, 17, 0),
          available: false
        },
        {
          label: "Donderdag",
          start: new Date(2022, 11, 12, 9, 0),
          end: new Date(2022, 11, 12, 17, 0),
          available: true
        },
      ],
      skillModal: null,
      editUserInfoModal: null,
      upcomingMeetingModal: null,
      selectedSkill: new Skill(),
      selectedMeeting: new UpcomingMeetingClass(),
      meetingsDateRange: null,
      masks: {
        input: 'YYYY-MM-DD hh:mm',
      },
      skills: null,
      userSkills: null,
      projects: null,
      events: null,
      attachments: [
        {
          "name": "resume_front_end_developer.pdf"
        },
        {
          "name": "coverletter_front_end_developer.pdf"
        }
      ],
      upcomingMeetings: null,
      meetingRangeOpen: false,
      selectedWeek: new Date(),

      // ModalData
      upcomingMeetingModalOpen: false,
      editUserInfoModalOpen: false,
      skillModalOpen: false,
    }
  },
  computed: {
    attributes() {
      return [
          ...this.userObj.specialist.events.map(meeting => this.meetingFormat(meeting))
      ]
    },
    availableHours() {
      let calculatedTotalHours = 0;

      // TODO Calculate hours on the minutes and not hours

      this.hours.forEach(hour => {
        let start = hour.start;
        let end = hour.end;

        const difference = end.getHours() - start.getHours();
        // const difference = (end.getHours() - start.getHours());

        const diff = Math.abs(end - start);
        const minutes = Math.floor((diff/1000)/60);

        if (hour.available) {
          // calculatedTotalHours += Math.ceil(minutes / 60 );
          calculatedTotalHours += difference;
        }
      })

      return calculatedTotalHours;
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

      this.events.forEach(event => {
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
  },
  created() {
    this.selectMeetingRange(1);

    this.getUserData();
    this.getSkillsData();
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

          // FIXME: I get an error saying that the userObj is null
          console.log(res.data);
        })
        .catch(err => {
          console.log(err);
        })

      if (this.userObj !== null) {
        this.sortWeekDays();
      }
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

    saveHours() {
      console.log("SAVING!");
      console.table(this.userObj.specialist.hours);
    },

    meetingFormat(meeting) {
      const meetingStart = new Date(meeting.start);
      const meetingEnd = new Date(meeting.end);

      const multiDayMeeting = {
        highlight: {
          start: { fillMode: 'outline', color: this.getMeetingType(meeting.type) },
          base: { fillMode: 'light', color: this.getMeetingType(meeting.type) },
          end: { fillMode: 'outline', color: this.getMeetingType(meeting.type) },
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
          color: this.getMeetingType(meeting.type)
        },
        customData: meeting
      }

      return this.sameDay(meetingStart, meetingEnd) ? sameDayMeeting : multiDayMeeting;
    },
    getMeetingType(type) {
      // Available Colors: gray, red, orange, yellow, green, teal, blue, indigo, purple, pink
      let color;

      // Work           | Orange
      // Free day       | Blue
      // Sick / absent  | Pink
      // Vacation       | Green
      // Other          | Gray

      switch (type) {
        case 0: // Work
          color = "orange"
          break;
        case 1: // Free Day
          color = "blue"
          break;
        case 2: // Sick / Absent
          color = "pink"
          break;
        case 3: // Vacation
          color = "green"
          break;
        case 4: // Other
          color = "gray"
          break;
        default:
          color = "indigo";
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

    epochToDate() {
      const utcSeconds = 1234567890; // set epoch here
      const d = new Date(0); // The 0 there is the key, which sets the date to the epoch
      d.setUTCSeconds(utcSeconds);
    },

    sortWeekDays() {
      const weekOrder = {'Maandag': 0, 'Dinsdag': 1, 'Woensdag': 2, 'Donderdag': 3, 'Vrijdag': 4, 'Zaterdag': 5, 'Zondag': 6}

      const unsortedDays = Array(7);

      console.log(this.userObj);
      this.userObj.specialist.hours.days.forEach(hour => {
        const index = weekOrder[hour.label];

        unsortedDays[index] = hour;
      })

      this.hours = unsortedDays;
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

    saveAvailability(n) {
      this.range = n;
    },

    openSkillModal(n) {
      // this.selectedSkill = new Skill(n);
      this.skillModalOpen = true;
    },
    closeSkillModal() {
      this.skillModal.hide();
    },
    saveSkill() {
      // TODO Check if item already exists. Check on ID
      this.skills.push(this.selectedSkill)
      this.closeSkillModal();
    },

    openEditUserInfoModal() {
      this.editUserInfoModalOpen = true;
    },
    closeEditUserInfoModal() {
      this.editUserInfoModal.hide();
    },

    openUpcomingMeetingModal(meeting) {
      this.selectedMeeting = meeting;
      console.log(this.selectedMeeting);
      this.upcomingMeetingModalOpen = true;

      // TODO When opening the modal, move to the month of the meeting on the calendar
    },
    closeUpcomingMeetingModal() {
      this.upcomingMeetingModal.hide();
    },

    saveUpcomingMeeting() {
      this.upcomingMeetings.push(new UpcomingMeetingClass(this.selectedMeeting));

      this.closeUpcomingMeetingModal();
    }
  },
  components: {
    SkillModal,
    EditUserInfoModal,
    UpcomingMeetingModal,
    AttachmentRow,
    // AvailabilityRow,
    UpcomingMeeting,
    ProjectCard,
    SkillBadge,
    DatePicker,
    CalendarRow
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