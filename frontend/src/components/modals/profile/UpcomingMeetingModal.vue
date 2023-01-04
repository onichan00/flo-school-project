<template>
  <div>
    <CustomModal v-model="isOpen" @close="close">
      <template v-slot:title>{{ getMeeting.title }}</template>
      <template v-slot:body>
        <div class="text-left space-y-4">
          <div class="flex flex-col md:flex-row gap-2 w-full mb-2">
            <div class="w-full md:w-1/2">
              <label for="meetingStart" class="block mb-1 text-sm font-medium text-gray-900">Start</label>
              <DatePicker :lang="langObj" class="w-full" type="datetime" format="DD-MM-YYYY HH:mm" :showMinute="true" :showSecond="false" :minute-step="5" :clearable="false" id="meetingStart" v-model:value="getMeeting.start"/>
            </div>
            <div class="w-full md:w-1/2">
              <label for="meetingEnd" class="block mb-1 text-sm font-medium text-gray-900">End</label>
              <DatePicker :lang="langObj" class="w-full" type="datetime" format="DD-MM-YYYY HH:mm" :showMinute="true" :showSecond="false" :minute-step="5" :clearable="false" id="meetingEnd" v-model:value="getMeeting.end"/>
            </div>
          </div>
          <div>
            <label for="title" class="block mb-1 text-sm font-medium text-gray-900">Titel</label>
            <input id="title" type="text" v-model="getMeeting.title" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="Lunchen met..." required/>
          </div>
          <div>
            <label for="type" class="block mb-1 text-sm font-medium text-gray-900">Type</label>
            <select id="type" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
              <option selected disabled value="-1">Kies een type</option>
              <option value="0">Werk</option>
              <option value="1">Vrije dag</option>
              <option value="2">Ziekte/afwezigheid</option>
              <option value="3">Vakantie</option>
              <option value="4">Andere</option>
            </select>
          </div>
          <div>
            <label for="location" class="block mb-1 text-sm font-medium text-gray-900">Locatie</label>
            <input id="location" type="text" v-model="getMeeting.location" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="Starbucks..." required/>
          </div>
          <div>
            <label for="description" class="block mb-1 text-sm font-medium text-gray-900">Beschrijving</label>
            <textarea id="description" rows="4" v-model="getMeeting.description" class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500" placeholder="We gaan over zaken praten..."></textarea>
          </div>
        </div>
      </template>
      <template v-slot:footer>
        <button @click="save()" type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">Save</button>
        <button @click="close()" type="button" class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-blue-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10">Cancel</button>
      </template>
    </CustomModal>
  </div>
</template>

<script>
import CustomModal from "@/components/modals/CustomModal.vue";
import DatePicker from 'vue-datepicker-next';
import axios from "axios";

import { useToast } from "vue-toastification";

export default {
  name: "UpcomingMeetingModal",
  props: ["open", "meeting"],
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
    save() {
      // FIXME - The meeting is not good formatted. Fix it. I'm missing ID. Check if the meeting is good fetched from the profile component
      console.log(this.meeting);

      axios.put(`http://localhost:8080/api/events/${this.meeting.id}`, this.meeting)
        .then((res) => {
          useToast().success("Succesvol bijgewerkt");
          this.close();
        })
        .catch((err) => {
          console.log(err);
        })
    },
    close() {
      this.$emit("close");
    }
  },
  computed: {
    isOpen() {
      return this.open;
    },
    getMeeting() {
      let time = this.meeting;

      time.start = new Date(this.meeting.start);
      time.end = new Date(this.meeting.end);

      return time;
    },
  },
  components: { DatePicker, CustomModal }
}
</script>

<style scoped>

</style>