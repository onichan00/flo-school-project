<template>
  <div>
    <CustomModal v-model="isOpen" @close="close">
      <template v-slot:title>{{ getTitle }}</template>
      <template v-slot:body>
        <div class="text-left space-y-4">
          <div class="flex flex-col md:flex-row gap-2 w-full mb-2">
            <div class="w-full md:w-1/2">
              <label for="meetingStart" class="block mb-1 text-sm font-medium text-gray-900">Start</label>
              <DatePicker
                  :lang="langObj" class="w-full"
                  type="datetime" format="DD-MM-YYYY HH:mm"
                  :showMinute="true" :showSecond="false"
                  :minute-step="5" :clearable="false"
                  id="meetingStart" v-model:value="getMeeting.start"
                  :disabled-time="notAfterEndTime"
              />
            </div>
            <div class="w-full md:w-1/2">
              <label for="meetingEnd" class="block mb-1 text-sm font-medium text-gray-900">End</label>
              <DatePicker
                  :lang="langObj" class="w-full"
                  type="datetime" format="DD-MM-YYYY HH:mm"
                  :showMinute="true" :showSecond="false"
                  :minute-step="5" :clearable="false"
                  id="meetingEnd" v-model:value="getMeeting.end"
                  :disabled-time="notBeforeStartTime"
              />
            </div>
          </div>
          <div>
            <label for="title" class="block mb-1 text-sm font-medium text-gray-900">Titel</label>
            <input id="title" type="text" v-model="getMeeting.title" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="Lunchen met..." required/>
          </div>
          <div>
            <label for="type" class="block mb-1 text-sm font-medium text-gray-900">Type</label>
            <select id="type" v-model="getMeeting.eventType" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
              <option selected disabled value="">Kies een type</option>
              <option value="WORK">Werk</option>
              <option value="FREE_DAY">Vrije dag</option>
              <option value="SICK">Ziekte/afwezigheid</option>
              <option value="VACATION">Vakantie</option>
              <option value="OTHER">Andere</option>
            </select>
          </div>
          <div>
            <label for="location" class="block mb-1 text-sm font-medium text-gray-900">Locatie</label>
            <input id="location" type="text" v-model="getMeeting.location" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="Starbucks..." required/>
          </div>
          <div>
            <label for="project" class="block mb-1 text-sm font-medium text-gray-900">Project</label>
            <select id="project" v-model="getMeeting.project" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
              <option selected disabled :value="{ id: 0 }">Geen project</option>
              <option v-for="project in projects" :value="project" :key="project.id">{{ project.name }}</option>
            </select>
          </div>
          <div>
            <label for="description" class="block mb-1 text-sm font-medium text-gray-900">Beschrijving</label>
            <textarea id="description" rows="4" v-model="getMeeting.description" class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500" placeholder="We gaan over zaken praten..."></textarea>
          </div>
        </div>
      </template>
      <template v-slot:footer>
        <button @click="save()" type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">{{ getPrimaryButtonText }}</button>
        <button @click="deleteEvent()" type="button" class="focus:outline-none text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5">Verwijder</button>
        <button @click="close()" type="button" class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-blue-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10">Annuleer</button>
      </template>
    </CustomModal>
  </div>
</template>

<script>
import CustomModal from "@/components/modals/CustomModal.vue";
import DatePicker from 'vue-datepicker-next';
import axios from "axios";

import { useToast } from "vue-toastification";
import {proxyObjToJson} from "@/plugins/objectManipulation";

export default {
  name: "UpcomingMeetingModal",
  props: ["open", "meeting", "user", "projects"],
  data() {
    return {
      langObj: {
        formatLocale: {
          firstDayOfWeek: 1
        },
      },
      meetingObj: null,
    }
  },
  methods: {
    /**
     * Saves or updates a meeting based on whether is has an ID.
     *
     * @emits updated - Emits the updated event after the event is saved
     */
    save() {
      // FIXME: Tijdens de POST request wordt de project verwijderd.

      const meeting = { ...this.meeting };
      const specialist = { ...this.user.specialist };
      const userID = this.$route.params.id;

      let URL = `${process.env.VUE_APP_API_URL}/api/events/`
      let protocol = "POST";
      let toastMsg = "Succesvol aangemaakt"

      // Remove nested objects to prevent update error on backend
      delete specialist.events;
      delete specialist.projects;

      meeting.user = proxyObjToJson(specialist)

      if (meeting.id !== 0) {
        protocol = "PUT";
        toastMsg = "Succesvol bijgewerkt";
        URL += `${meeting.id}`;
      }

      console.log(proxyObjToJson(meeting));

      axios({ method: protocol, url: URL, data: meeting })
        .then((res) => {
          useToast().success(toastMsg);

          this.close();
          this.$emit("updated", res.data);
        })
        .catch((err) => {
          console.log(err);
          useToast().error("Iets ging mis");
        })
    },
    /**
     * This method emits a close event.
     *
     * @emits close - Emits an event to close the modal
     */
    close() {
      this.$emit("close");
    },
    /**
     * This method deletes the event from the backend
     *
     * @emits deleted - Emits the deleted event that needs to be removed from the frontend
     */
    deleteEvent() {
      const meeting = { ...this.meeting };
      const URL = `${process.env.VUE_APP_API_URL}/api/events/${meeting.id}`;
      const protocol = "DELETE";
      const toastMsg = "Succesvol verwijderd";

      axios({ method: protocol, url: URL })
        .then((res) => {
          useToast().success(toastMsg);

          this.close();
          this.$emit("deleted", res.data);
        })
        .catch((err) => {
          console.log(err);
          useToast().error("Iets ging mis tijdens het verwijderen");
        })
    },

    notBeforeStartTime(date) {
      return new Date(date) < this.meeting.start;
    },
    notAfterEndTime(date) {
      return new Date(date) > this.meeting.end;
    },
  },
  watch: {
    meeting(value) {
      console.log(value);
    }
  },
  computed: {
    isOpen() {
      return this.open;
    },
    // TODO: Make sure the user can't start after the end time and vice versa

    getMeeting() {
      let time = this.meeting;

      time.start = new Date(this.meeting.start);
      time.end = new Date(this.meeting.end);

      return time;
    },
    getTitle() {
      return this.meeting.id === 0 ? "Nieuwe activiteit" : this.meeting.title;
    },
    getPrimaryButtonText() {
      return this.meeting.id === 0 ? "Creëer" : "Sla op";
    }
  },
  components: { DatePicker, CustomModal }
}
</script>

<style scoped>

</style>