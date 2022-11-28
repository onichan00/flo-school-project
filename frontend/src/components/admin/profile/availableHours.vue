<template>
  <div>
    <p class="text-left mb-4">Total Hours: {{ totalHours }}</p>
    <div class="flex flex-col gap-4">
      <div class="flex flex-row items-center gap-4">
        <p class="w-24 text-left">Monday</p>
        <input id="default-checkbox" type="checkbox" v-model="hours.monday.available"
               class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600"/>
        <date-picker v-model:value="hours.monday.start" :minute-step="30" :hour-options="hours" type="time"
                     value-type="format" format="HH:mm" :clearable="false"
                     :disabled="!hours.monday.available"></date-picker>
        <p>To</p>
        <date-picker v-model:value="hours.monday.end" :minute-step="30" :hour-options="hours" type="time"
                     value-type="format" format="HH:mm" :clearable="false"
                     :disabled="!hours.monday.available"></date-picker>
      </div>
      <div class="flex flex-row items-center gap-4">
        <p class="w-24 text-left">Tuesday</p>
        <input id="default-checkbox" type="checkbox" v-model="hours.tuesday.available"
               class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600"/>
        <date-picker v-model:value="hours.tuesday.start" :minute-step="30" :hour-options="hours" type="time"
                     value-type="format" format="HH:mm" :clearable="false"
                     :disabled="!hours.tuesday.available"></date-picker>
        <p>To</p>
        <date-picker v-model:value="hours.tuesday.end" :minute-step="30" :hour-options="hours" type="time"
                     value-type="format" format="HH:mm" :clearable="false"
                     :disabled="!hours.tuesday.available"></date-picker>
      </div>
      <div class="flex flex-row items-center gap-4">
        <p class="w-24 text-left">Wednesday</p>
        <input id="default-checkbox" type="checkbox" v-model="hours.wednesday.available"
               class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600"/>
        <date-picker v-model:value="hours.wednesday.start" :minute-step="30" :hour-options="hours" type="time"
                     value-type="format" :clearable="false" format="HH:mm"
                     :disabled="!hours.wednesday.available"></date-picker>
        <p>To</p>
        <date-picker v-model:value="hours.wednesday.end" :minute-step="30" :hour-options="hours" type="time"
                     value-type="format" :clearable="false" format="HH:mm"
                     :disabled="!hours.wednesday.available"></date-picker>
      </div>
      <div class="flex flex-row items-center gap-4">
        <p class="w-24 text-left">thursday</p>
        <input id="default-checkbox" type="checkbox" v-model="hours.thursday.available"
               class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600"/>
        <date-picker v-model:value="hours.thursday.start" :minute-step="30" :hour-options="hours" type="time"
                     value-type="format" format="HH:mm" :clearable="false"
                     :disabled="!hours.thursday.available"></date-picker>
        <p>To</p>
        <date-picker v-model:value="hours.thursday.end" :minute-step="30" :hour-options="hours" type="time"
                     value-type="format" format="HH:mm" :clearable="false"
                     :disabled="!hours.thursday.available"></date-picker>
      </div>
      <div class="flex flex-row items-center gap-4">
        <p class="w-24 text-left">Friday</p>
        <input id="default-checkbox" type="checkbox" v-model="hours.friday.available"
               class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600"/>
        <date-picker v-model:value="hours.friday.start" :minute-step="30" :hour-options="hours" type="time"
                     value-type="format" format="HH:mm" :clearable="false"
                     :disabled="!hours.friday.available"></date-picker>
        <p>To</p>
        <date-picker v-model:value="hours.friday.end" :minute-step="30" :hour-options="hours" type="time"
                     value-type="format" format="HH:mm" :clearable="false"
                     :disabled="!hours.friday.available"></date-picker>
      </div>
      <div class="flex flex-row items-center gap-4">
        <p class="w-24 text-left">Saturday</p>
        <input id="default-checkbox" type="checkbox" v-model="hours.saturday.available"
               class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600"/>
        <date-picker v-model:value="hours.saturday.start" :minute-step="30" :hour-options="hours" type="time"
                     value-type="format" format="HH:mm" :clearable="false"
                     :disabled="!hours.saturday.available"></date-picker>
        <p>To</p>
        <date-picker v-model:value="hours.saturday.end" :minute-step="30" :hour-options="hours" type="time"
                     value-type="format" format="HH:mm" :clearable="false"
                     :disabled="!hours.saturday.available"></date-picker>
      </div>
      <div class="flex flex-row items-center gap-4">
        <p class="w-24 text-left">Sunday</p>
        <input id="default-checkbox" type="checkbox" v-model="hours.sunday.available"
               class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600"/>
        <date-picker v-model:value="hours.sunday.start" :minute-step="30" :hour-options="hours" type="time"
                     value-type="format" format="HH:mm" :clearable="false"
                     :disabled="!hours.sunday.available"></date-picker>
        <p>To</p>
        <date-picker v-model:value="hours.sunday.end" :minute-step="30" :hour-options="hours" type="time"
                     value-type="format" format="HH:mm" :clearable="false"
                     :disabled="!hours.sunday.available"></date-picker>
      </div>
    </div>
    <div class="flex items-center space-x-2 mt-4">
      <button type="button"
              @click="$emit('update-hours')"
              class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center ">
        Save
      </button>
<!--              @click="resetHours"-->
      <button type="button"
              @click="$emit('getUserData')"
              class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-blue-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10">
        Reset
      </button>
    </div>
  </div>
</template>
<script>
import DatePicker from 'vue-datepicker-next';
import 'vue-datepicker-next/index.css';
import { ref } from 'vue';

// https://mengxiong10.github.io/vue-datepicker-next/index.html
// https://github.com/mengxiong10/vue-datepicker-next

// https://www.youtube.com/watch?v=ZcsCoTPPMD8
// https://github.com/gwenf/vue-nwjs-hours-tracking

// TODO Fix the save and reset button

export default {
  name: "AvailableHours",
  props: ['availableHours'],
  data() {
    return {
      totalHours: 40,
      hours: [],
    }
  },
  created() {
    this.hours = this.availableHours;
  },
  computed: {
    daysOfWeek() {
      return [this.hours.monday, this.hours.tuesday, this.hours.wednesday, this.hours.thursday, this.hours.friday, this.hours.saturday, this.hours.sunday];
    },
  },
  // FIXME - First time pressing reset button does not work
  watch: {
    availableHours: function(oldVal, newVal) {
      this.hours = newVal;
    },
    daysOfWeek: {
      handler: function (oldVal, newVal) {
        const today = new Date();
        const dayString = `${today.getFullYear()}-${today.getMonth()}-${today.getDate()}`;
        let calculatedTotalHours = 0;

        const hour = this.hours;

        const mondayDif = new Date(`${dayString} ${hour.monday.end}`).getHours() - new Date(`${dayString} ${hour.monday.start}`).getHours();
        const tuesdayDif = new Date(`${dayString} ${hour.tuesday.end}`).getHours() - new Date(`${dayString} ${hour.tuesday.start}`).getHours();
        const wednesdayDif = new Date(`${dayString} ${hour.wednesday.end}`).getHours() - new Date(`${dayString} ${hour.wednesday.start}`).getHours();
        const thursdayDif = new Date(`${dayString} ${hour.thursday.end}`).getHours() - new Date(`${dayString} ${hour.thursday.start}`).getHours();
        const fridayDif = new Date(`${dayString} ${hour.friday.end}`).getHours() - new Date(`${dayString} ${hour.friday.start}`).getHours();
        const saturdayDif = new Date(`${dayString} ${hour.saturday.end}`).getHours() - new Date(`${dayString} ${hour.saturday.start}`).getHours();
        const sundayDif = new Date(`${dayString} ${hour.sunday.end}`).getHours() - new Date(`${dayString} ${hour.sunday.start}`).getHours();

        if (hour.monday.available) calculatedTotalHours += mondayDif;
        if (hour.tuesday.available) calculatedTotalHours += tuesdayDif;
        if (hour.wednesday.available) calculatedTotalHours += wednesdayDif;
        if (hour.thursday.available) calculatedTotalHours += thursdayDif;
        if (hour.friday.available) calculatedTotalHours += fridayDif;
        if (hour.saturday.available) calculatedTotalHours += saturdayDif;
        if (hour.sunday.available) calculatedTotalHours += sundayDif;

        this.totalHours = calculatedTotalHours;
      }, deep: true
    },
  },
  components: {
    DatePicker,
  }
}
</script>
<style>

</style>