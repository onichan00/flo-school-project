<template>
  <button @click="$emit('meetingClicked', this.meeting)" class="py-4 w-full text-left flex flex-row justify-between hover:bg-gray-100">
    <div class="w-full flex flex-col md:flex-row items-center my-4">
      <img class="w-14 h-14 mb-4 md:mb-0 rounded-full object-cover" :src="meeting.project.bannerUrl" alt="Rounded avatar">
<!--      src="https://images.unsplash.com/photo-1558203728-00f45181dd84?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2074&q=80"-->
      <!-- TODO add a small div with the color of the meeting type -->
      <div class="w-full flex flex-col">
        <p class="px-4">{{ meeting.title }}</p>
        <div class="w-full flex flex-col md:flex-row items-center text-gray-400 md:divide-x-2">
          <span class="w-full md:w-1/2 flex flex-row px-4 space-x-1">
            <svg class="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z"></path></svg>
            <p>{{ date }}</p>
          </span>
          <span class="w-full md:w-1/2 flex flex-row px-4 space-x-1">
            <svg class="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M17.657 16.657L13.414 20.9a1.998 1.998 0 01-2.827 0l-4.244-4.243a8 8 0 1111.314 0z"></path><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 11a3 3 0 11-6 0 3 3 0 016 0z"></path></svg>
            <p>{{ meeting.location }}</p>
          </span>
        </div>
      </div>
    </div>
  </button>
</template>

<script>
import dateFormat from "dateformat";

export default {
  name: "UpcomingMeeting",
  props: ["meeting"],
  emits: ["meetingClicked"],
  computed: {
    date() {
      const goodDate = dateFormat(this.meeting.start, "mmmm ddS, yyyy 'at' HH:MM");

      // January 10th, 2022 at 17:00

      return goodDate;
    }
  }
}
</script>

<style scoped>

</style>