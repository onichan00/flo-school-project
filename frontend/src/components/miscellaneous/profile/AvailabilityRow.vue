<template>
  <div class="flex flex-col items-start my-4 md:my-0">
    <div class="flex flex-row items-center gap-2 w-full">
      <input id="default-checkbox" type="checkbox" v-model="getTime.available" @change="saveAvailability"
             class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 focus:ring-2"/>
      <p>{{ getTime.label }}</p>
    </div>
    <div class="flex flex-col items-center gap-2 w-full">
      <DatePicker
          @change="saveAvailability"
          type="time" format="HH:mm"
          :showMinute="true" :showSecond="false"
          :minute-step="15" :clearable="false"
          :disabled-time="notAfterEndTime"
          :disabled="isAvailable" v-model:value="getTime.start"
      />
      <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 14l-7 7m0 0l-7-7m7 7V3"></path>
      </svg>
      <DatePicker
          @change="saveAvailability"
          type="time" format="HH:mm"
          :showMinute="true" :showSecond="false"
          :minute-step="15" :clearable="false"
          :disabled-time="notBeforeStartTime"
          :disabled="isAvailable" v-model:value="getTime.end"
      />
    </div>
  </div>
</template>

<script>
import DatePicker from "vue-datepicker-next";

export default {
  name: 'AvailabilityRow',
  props: ['time'],
  emits: ['saveAvailability'],
  methods: {
    saveAvailability() {
      this.$emit('saveAvailability', this.time);
    },

    // Disable all the hours before the start time
    notBeforeStartTime(date) {
      return date < this.getTime.start;
    },

    // Disable all the hours after the end time
    notAfterEndTime(date) {
      return date > this.getTime.end;
    },
  },
  computed: {
    getTime() { // Round to the nearest 15 minutes
      const minutes = 15;
      const ms = 1000 * 60 * minutes;

      const start = new Date(this.time.start);
      const end = new Date(this.time.end);

      let time = this.time;

      time.start = new Date(Math.round(start.getTime() / ms) * ms);
      time.end = new Date(Math.round(end.getTime() / ms) * ms);

      return time;
    },

    isAvailable() {
      return !this.time.available;
    },
  },
  components: {
    DatePicker
  }
}
</script>

<style scoped>

</style>