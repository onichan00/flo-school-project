<template>
  <div>
    <p class="text-left mb-4">Total Hours: {{ totalHours }}</p>
    <div class="flex flex-col gap-4">
      <div class="flex flex-row items-center gap-4">
        <p class="w-24 text-left">Monday</p>
        <input id="default-checkbox" type="checkbox" v-model="monday.available"
          class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600" />
        <date-picker v-model:value="monday.start" :minute-step="30" :hour-options="hours" type="time"
          value-type="format" format="HH:mm" :disabled="!monday.available"></date-picker>
        <p>To</p>
        <date-picker v-model:value="monday.end" :minute-step="30" :hour-options="hours" type="time" value-type="format"
          format="HH:mm" :disabled="!monday.available"></date-picker>
      </div>
      <div class="flex flex-row items-center gap-4">
        <p class="w-24 text-left">Tuesday</p>
        <input id="default-checkbox" type="checkbox" v-model="tuesday.available"
          class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600" />
        <date-picker v-model:value="tuesday.start" :minute-step="30" :hour-options="hours" type="time"
          value-type="format" format="HH:mm" :disabled="!tuesday.available"></date-picker>
        <p>To</p>
        <date-picker v-model:value="tuesday.end" :minute-step="30" :hour-options="hours" type="time" value-type="format"
          format="HH:mm" :disabled="!tuesday.available"></date-picker>
      </div>
      <div class="flex flex-row items-center gap-4">
        <p class="w-24 text-left">Wednesday</p>
        <input id="default-checkbox" type="checkbox" v-model="wednesday.available"
          class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600" />
        <date-picker v-model:value="wednesday.start" :minute-step="30" :hour-options="hours" type="time"
          value-type="format" format="HH:mm" :disabled="!wednesday.available"></date-picker>
        <p>To</p>
        <date-picker v-model:value="wednesday.end" :minute-step="30" :hour-options="hours" type="time"
          value-type="format" format="HH:mm" :disabled="!wednesday.available"></date-picker>
      </div>
      <div class="flex flex-row items-center gap-4">
        <p class="w-24 text-left">Thurday</p>
        <input id="default-checkbox" type="checkbox" v-model="thurday.available"
          class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600" />
        <date-picker v-model:value="thurday.start" :minute-step="30" :hour-options="hours" type="time"
          value-type="format" format="HH:mm" :disabled="!thurday.available"></date-picker>
        <p>To</p>
        <date-picker v-model:value="thurday.end" :minute-step="30" :hour-options="hours" type="time" value-type="format"
          format="HH:mm" :disabled="!thurday.available"></date-picker>
      </div>
      <div class="flex flex-row items-center gap-4">
        <p class="w-24 text-left">Friday</p>
        <input id="default-checkbox" type="checkbox" v-model="friday.available"
          class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600" />
        <date-picker v-model:value="friday.start" :minute-step="30" :hour-options="hours" type="time"
          value-type="format" format="HH:mm" :disabled="!friday.available"></date-picker>
        <p>To</p>
        <date-picker v-model:value="friday.end" :minute-step="30" :hour-options="hours" type="time" value-type="format"
          format="HH:mm" :disabled="!friday.available"></date-picker>
      </div>
      <div class="flex flex-row items-center gap-4">
        <p class="w-24 text-left">Saturday</p>
        <input id="default-checkbox" type="checkbox" v-model="saturday.available"
          class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600" />
        <date-picker v-model:value="saturday.start" :minute-step="30" :hour-options="hours" type="time"
          value-type="format" format="HH:mm" :disabled="!saturday.available"></date-picker>
        <p>To</p>
        <date-picker v-model:value="saturday.end" :minute-step="30" :hour-options="hours" type="time"
          value-type="format" format="HH:mm" :disabled="!saturday.available"></date-picker>
      </div>
      <div class="flex flex-row items-center gap-4">
        <p class="w-24 text-left">Sunday</p>
        <input id="default-checkbox" type="checkbox" v-model="sunday.available"
          class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600" />
        <date-picker v-model:value="sunday.start" :minute-step="30" :hour-options="hours" type="time"
          value-type="format" format="HH:mm" :disabled="!sunday.available"></date-picker>
        <p>To</p>
        <date-picker v-model:value="sunday.end" :minute-step="30" :hour-options="hours" type="time" value-type="format"
          format="HH:mm" :disabled="!sunday.available"></date-picker>
      </div>
    </div>
    <div>
      <p>Save</p>
      <p>Cancel</p>
    </div>
  </div>
</template>
<script>
import DatePicker from 'vue-datepicker-next';
import 'vue-datepicker-next/index.css';

// https://mengxiong10.github.io/vue-datepicker-next/index.html
// https://github.com/mengxiong10/vue-datepicker-next

export default {
  name: "AvailableHours",
  data() {
    return {
      totalHours: 40,
      monday: {
        label: "monday",
        available: true,
        start: "09:00",
        end: "17:00",
      },
      tuesday: {
        label: "tuesday",
        available: true,
        start: "09:00",
        end: "17:00",
      },
      wednesday: {
        label: "wednesday",
        available: true,
        start: "09:00",
        end: "17:00",
      },
      thurday: {
        label: "thurday",
        available: true,
        start: "09:00",
        end: "17:00",
      },
      friday: {
        label: "friday",
        available: true,
        start: "09:00",
        end: "17:00",
      },
      saturday: {
        label: "saturday",
        available: false,
        start: "09:00",
        end: "17:00"
      },
      sunday: {
        label: "sunday",
        available: false,
        start: "09:00",
        end: "17:00"
      }
    }
  },
  computed: {
    daysOfWeek() {
      return [this.monday, this.tuesday, this.wednesday, this.thurday, this.friday, this.saturday, this.sunday]
    },
  },
  watch: {
    daysOfWeek: {
      handler: function () {
        const today = new Date();
        const dayString = `${today.getDate()}/${today.getMonth()}/${today.getFullYear()}`;
        let calculatedTotalHours = 0;

        const mondayDif = new Date(`${dayString} ${this.monday.end}`).getHours() - new Date(`${dayString} ${this.monday.start}`).getHours();
        const tuesdayDif = new Date(`${dayString} ${this.tuesday.end}`).getHours() - new Date(`${dayString} ${this.tuesday.start}`).getHours();
        const wednesdayDif = new Date(`${dayString} ${this.wednesday.end}`).getHours() - new Date(`${dayString} ${this.wednesday.start}`).getHours();
        const thurdayDif = new Date(`${dayString} ${this.thurday.end}`).getHours() - new Date(`${dayString} ${this.thurday.start}`).getHours();
        const fridayDif = new Date(`${dayString} ${this.friday.end}`).getHours() - new Date(`${dayString} ${this.friday.start}`).getHours();
        const saturdayDif = new Date(`${dayString} ${this.saturday.end}`).getHours() - new Date(`${dayString} ${this.saturday.start}`).getHours();
        const sundayDif = new Date(`${dayString} ${this.sunday.end}`).getHours() - new Date(`${dayString} ${this.sunday.start}`).getHours();

        if (this.monday.available) calculatedTotalHours += mondayDif;
        if (this.tuesday.available) calculatedTotalHours += tuesdayDif;
        if (this.wednesday.available) calculatedTotalHours += wednesdayDif;
        if (this.thurday.available) calculatedTotalHours += thurdayDif;
        if (this.friday.available) calculatedTotalHours += fridayDif;
        if (this.saturday.available) calculatedTotalHours += saturdayDif;
        if (this.sunday.available) calculatedTotalHours += sundayDif;

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