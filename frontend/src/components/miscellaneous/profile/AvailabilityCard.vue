<template>
  <div class="flex flex-col items-start my-4 md:my-0">
    <div class="flex flex-row items-center gap-2 w-full">
      <input
        id="availableCheckbox"
        type="checkbox"
        v-model="getTime.available"
        @change="saveAvailability"
        class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 focus:ring-2"
      />
      <p>{{ day.label }}</p>
    </div>
    <div class="flex flex-col items-center gap-2 w-full">
      <DatePicker
        type="time" format="HH:mm"
        :showMinute="true" :showSecond="false"
        :minute-step="15" :clearable="false"
        :disabled-time="notAfterEndTime"
        :disabled="isAvailable" v-model:value="getTime.hourStart"
      />
      <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 14l-7 7m0 0l-7-7m7 7V3"></path>
      </svg>
      <DatePicker
        type="time" format="HH:mm"
        :showMinute="true" :showSecond="false"
        :minute-step="15" :clearable="false"
        :disabled-time="notBeforeStartTime"
        :disabled="isAvailable" v-model:value="getTime.hourEnd"
      />
    </div>
  </div>
</template>

<script>
import DatePicker from "vue-datepicker-next";

import {firstLetterUpperCase} from "@/plugins/textManipulation";

export default {
  name: 'AvailabilityCard',
  props: ['day'],
  emits: ['saveAvailability'],
  methods: {
    firstLetterUpperCase,
    saveAvailability() {
      this.$emit('saveAvailability', this.day);
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
    getTime() {
      return this.day
    },

    isAvailable() {
      return !this.day.available;
    },

    getTranslatedLabel() {
      const labels = {
        "sunday": "zondag",
        "saturday": "zaterdag",
        "friday": "vrijdag",
        "thursday": "donderdag",
        "wednesday": "woensdag",
        "tuesday": "dinsdag",
        "monday": "maandag"
      }

      return labels[this.label];
    }
  },
  components: {
    DatePicker
  }
}
</script>

<style scoped>

</style>