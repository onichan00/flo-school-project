<template>
  <div>
    <p class="text-left mb-4">Total Hours: {{ totalHours }}</p>
    <div class="flex flex-col gap-4">
      <div class="flex flex-row items-center gap-4">
        <p class="w-24 text-left">Monday</p>
        <input id="default-checkbox" type="checkbox" v-model="this.hours.monday.available"
          class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600" />
        <date-picker v-model:value="this.hours.monday.start" :minute-step="30" :hour-options="hours" type="time"
        value-type="format" format="HH:mm" :clearable="false" :disabled="!this.hours.monday.available"></date-picker>
        <p>To</p>
        <date-picker v-model:value="this.hours.monday.end" :minute-step="30" :hour-options="hours" type="time" value-type="format" format="HH:mm" :clearable="false" :disabled="!this.hours.monday.available"></date-picker>
      </div>
      <div class="flex flex-row items-center gap-4">
        <p class="w-24 text-left">Tuesday</p>
        <input id="default-checkbox" type="checkbox" v-model="this.hours.tuesday.available"
          class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600" />
        <date-picker v-model:value="this.hours.tuesday.start" :minute-step="30" :hour-options="hours" type="time"
        value-type="format" format="HH:mm" :clearable="false" :disabled="!this.hours.tuesday.available"></date-picker>
        <p>To</p>
        <date-picker v-model:value="this.hours.tuesday.end" :minute-step="30" :hour-options="hours" type="time" value-type="format" format="HH:mm" :clearable="false" :disabled="!this.hours.tuesday.available"></date-picker>
      </div>
      <div class="flex flex-row items-center gap-4">
        <p class="w-24 text-left">Wednesday</p>
        <input id="default-checkbox" type="checkbox" v-model="this.hours.wednesday.available"
          class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600" />
        <date-picker v-model:value="this.hours.wednesday.start" :minute-step="30" :hour-options="hours" type="time" value-type="format" :clearable="false" format="HH:mm" :disabled="!this.hours.wednesday.available"></date-picker>
        <p>To</p>
        <date-picker v-model:value="this.hours.wednesday.end" :minute-step="30" :hour-options="hours" type="time" value-type="format" :clearable="false" format="HH:mm" :disabled="!this.hours.wednesday.available"></date-picker>
      </div>
      <div class="flex flex-row items-center gap-4">
        <p class="w-24 text-left">Thurday</p>
        <input id="default-checkbox" type="checkbox" v-model="this.hours.thurday.available"
          class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600" />
        <date-picker v-model:value="this.hours.thurday.start" :minute-step="30" :hour-options="hours" type="time"
        value-type="format" format="HH:mm" :clearable="false" :disabled="!this.hours.thurday.available"></date-picker>
        <p>To</p>
        <date-picker v-model:value="this.hours.thurday.end" :minute-step="30" :hour-options="hours" type="time" value-type="format" format="HH:mm" :clearable="false" :disabled="!this.hours.thurday.available"></date-picker>
      </div>
      <div class="flex flex-row items-center gap-4">
        <p class="w-24 text-left">Friday</p>
        <input id="default-checkbox" type="checkbox" v-model="this.hours.friday.available"
          class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600" />
        <date-picker v-model:value="this.hours.friday.start" :minute-step="30" :hour-options="hours" type="time"
        value-type="format" format="HH:mm" :clearable="false" :disabled="!this.hours.friday.available"></date-picker>
        <p>To</p>
        <date-picker v-model:value="this.hours.friday.end" :minute-step="30" :hour-options="hours" type="time" value-type="format" format="HH:mm" :clearable="false" :disabled="!this.hours.friday.available"></date-picker>
      </div>
      <div class="flex flex-row items-center gap-4">
        <p class="w-24 text-left">Saturday</p>
        <input id="default-checkbox" type="checkbox" v-model="this.hours.saturday.available"
          class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600" />
        <date-picker v-model:value="this.hours.saturday.start" :minute-step="30" :hour-options="hours" type="time" value-type="format" format="HH:mm" :clearable="false" :disabled="!this.hours.saturday.available"></date-picker>
        <p>To</p>
        <date-picker v-model:value="this.hours.saturday.end" :minute-step="30" :hour-options="hours" type="time" value-type="format" format="HH:mm" :clearable="false" :disabled="!this.hours.saturday.available"></date-picker>
      </div>
      <div class="flex flex-row items-center gap-4">
        <p class="w-24 text-left">Sunday</p>
        <input id="default-checkbox" type="checkbox" v-model="this.hours.sunday.available"
          class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600" />
        <date-picker v-model:value="this.hours.sunday.start" :minute-step="30" :hour-options="hours" type="time"
        value-type="format" format="HH:mm" :clearable="false" :disabled="!this.hours.sunday.available"></date-picker>
        <p>To</p>
        <date-picker v-model:value="this.hours.sunday.end" :minute-step="30" :hour-options="hours" type="time" value-type="format" format="HH:mm" :clearable="false" :disabled="!this.hours.sunday.available"></date-picker>
      </div>
    </div>
    <div class="flex items-center space-x-2 mt-4">
      <button type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center ">Save</button>
      <button type="button" class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-blue-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10">Reset</button>
  </div>
  </div>
</template>
<script>
import DatePicker from 'vue-datepicker-next';
import 'vue-datepicker-next/index.css';

// https://mengxiong10.github.io/vue-datepicker-next/index.html
// https://github.com/mengxiong10/vue-datepicker-next

// https://www.youtube.com/watch?v=ZcsCoTPPMD8
// https://github.com/gwenf/vue-nwjs-hours-tracking

// TODO Fix the save and reset button

export default {
  name: "AvailableHours",
  inject: ['availableHours'],
  data() {
    return {
      totalHours: 40,
      hours: [],
    }
  },
  created() {
    this.getAvailableHoursOfUser();
  },
  methods: {
    getAvailableHoursOfUser() {
      const userId = this.$route.params.id;

      this.hours = this.availableHours.find((element) => element.specialist === parseInt(userId)).hours;
    }
  },
  computed: {
    daysOfWeek() {
      return [this.hours.monday, this.hours.tuesday, this.hours.wednesday, this.hours.thurday, this.hours.friday, this.hours.saturday, this.hours.sunday]
    },
  },
  watch: {
    daysOfWeek: {
      handler: function () {
        const today = new Date();
        const dayString = `${today.getDate()}/${today.getMonth()}/${today.getFullYear()}`;
        let calculatedTotalHours = 0;

        const hour = this.hours;

        const mondayDif = new Date(`${dayString} ${hour.monday.end}`).getHours() - new Date(`${dayString} ${hour.monday.start}`).getHours();
        const tuesdayDif = new Date(`${dayString} ${hour.tuesday.end}`).getHours() - new Date(`${dayString} ${hour.tuesday.start}`).getHours();
        const wednesdayDif = new Date(`${dayString} ${hour.wednesday.end}`).getHours() - new Date(`${dayString} ${hour.wednesday.start}`).getHours();
        const thurdayDif = new Date(`${dayString} ${hour.thurday.end}`).getHours() - new Date(`${dayString} ${hour.thurday.start}`).getHours();
        const fridayDif = new Date(`${dayString} ${hour.friday.end}`).getHours() - new Date(`${dayString} ${hour.friday.start}`).getHours();
        const saturdayDif = new Date(`${dayString} ${hour.saturday.end}`).getHours() - new Date(`${dayString} ${hour.saturday.start}`).getHours();
        const sundayDif = new Date(`${dayString} ${hour.sunday.end}`).getHours() - new Date(`${dayString} ${hour.sunday.start}`).getHours();

        if (hour.monday.available) calculatedTotalHours += mondayDif;
        if (hour.tuesday.available) calculatedTotalHours += tuesdayDif;
        if (hour.wednesday.available) calculatedTotalHours += wednesdayDif;
        if (hour.thurday.available) calculatedTotalHours += thurdayDif;
        if (hour.friday.available) calculatedTotalHours += fridayDif;
        if (hour.saturday.available) calculatedTotalHours += saturdayDif;
        if (hour.sunday.available) calculatedTotalHours += sundayDif;

        this.totalHours = calculatedTotalHours;
      }, deep: true
    },
    '$route'() {
      this.getAvailableHoursOfUser()
    }
  },
  components: {
    DatePicker,
  }
}
</script>
<style>

</style>