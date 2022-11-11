<template>
  <div class="">
    <!-- <p>Please select a week</p> -->
    <!-- <date-picker v-model:value="week" type="week" placeholder="Select week" :clearable="false" :lang="langObject"></date-picker>
    <p>Week: {{ getWeekNumber }}</p> -->
    <button type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800">Add</button>
    <table class="w-full text-sm rounded-md text-left text-gray-500 dark:text-gray-400">
      <thead class="text-xs border-b text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
        <tr>
          <th scope="col" class="py-3 px-6">
            Name
          </th>
          <th scope="col" class="py-3 px-6">
            Date
          </th>
          <th scope="col" class="py-3 px-6">
            Start
          </th>
          <th scope="col" class="py-3 px-6">
            End
          </th>
        </tr>
      </thead>
      <tbody>

        <tr v-for="entry in entries" :key="entry.id"
          class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-orange-50 dark:hover:bg-gray-600">
          <td class="py-4 px-6">{{ getProject(entry.project).name }}</td>
          <td class="py-4 px-6">{{ getDate(entry.project.start) }}</td>
          <td class="py-4 px-6">{{ getHours(entry.project.start) }}</td>
          <td class="py-4 px-6">{{ getHours(entry.project.end) }}</td>
          <!-- <th scope="row" class="flex items-center py-4 px-6 text-gray-900 whitespace-nowrap dark:text-white">
            <div class="pl-3">
              <div class="text-base font-semibold">{{ specialist.firstName }}</div>
              <div class="font-normal text-gray-500">{{ specialist.email }}</div>
            </div>
          </th>
          <td class="py-4 px-6">
            {{ specialist.position }}
          </td>
          <td class="py-4 px-6">
            <div class="flex items-center">
              <div class="h-2.5 w-2.5 rounded-full bg-green-400 mr-2"></div>
              {{ specialist.status }}
            </div>
          </td>
          <td class="py-4 px-6">
            <a href="#" class="font-medium text-orange-500 hover:underline" data-modal-toggle="defaultModal">Edit
              user</a>
          </td> -->
        </tr>

      </tbody>

    </table>
  </div>
</template>


<script>
import dateFormat from 'dateformat';
import DatePicker from 'vue-datepicker-next';
import 'vue-datepicker-next/index.css';

export default {
  name: 'project-calendar',
  inject: ['projects'],
  data() {
    return {
      week: new Date(),
      langObject: {
        formatLocale: {
          firstDayOfWeek: 1,
        }
      },
      entries: [
        {
          id: 1,
          project: 1,
          start: new Date(),
          end: new Date(),
        },
        {
          id: 2,
          project: 3,
          start: new Date(),
          end: new Date(),
        },
        {
          id: 3,
          project: 2,
          start: new Date(),
          end: new Date(),
        }
      ]
    }
  },
  methods: {
    getProject(id) {
      return this.projects.find(element => element.id === parseInt(id));
    },
    getDate(epoch) {
      // const date = new Date(epoch);
      const date = new Date();
      // console.log(date);

      return dateFormat(date, "mmmm dS, yyyy");
    },
    getHours(epoch) {
      // const date = new Date(epoch);
      const date = new Date();

      return dateFormat(date, "hh:MM");
    },
    addEntry() {

    }
  },
  computed: {
    getWeekNumber() {
      return dateFormat(this.week, "W");
    },
  },
  components: {}
}
</script>