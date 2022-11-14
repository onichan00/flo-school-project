<template>
  <div class="">
    <!-- <p>Please select a week</p> -->
    <!-- <date-picker v-model:value="week" type="week" placeholder="Select week" :clearable="false" :lang="langObject"></date-picker>
    <p>Week: {{ getWeekNumber }}</p> -->
    <div class="flex flex-row justify-between mb-4">
      <p class="text-2xl">Calendar</p>
      <button type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 focus:outline-none" @click="openAddModal">Add</button>
    </div>
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

        <tr v-for="entry in entries" :key="entry.id" ref="entries" @click="editCalendarEntry(entry.id)"
          class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-orange-50 dark:hover:bg-gray-600 cursor-pointer">
          <td class="py-4 px-6">{{ getProject(entry.project).name }}</td>
          <td class="py-4 px-6">{{ getDate(entry.project.start) }}</td>
          <td class="py-4 px-6">{{ getHours(entry.project.start) }}</td>
          <!-- <td class="py-4 px-6">{{ entry.project.start }}</td> -->
          <!-- <td class="py-4 px-6">{{ entry.project.end }}</td> -->
          <td class="py-4 px-6">{{ getHours(entry.project.end) }}</td>
        </tr>
      </tbody>
    </table>

    <!-- Add entry modal -->
    <div id="defaultModal" tabindex="-1" aria-hidden="true" class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 w-full md:inset-0 h-modal md:h-full">
      <div class="relative p-4 w-full max-w-2xl h-full md:h-auto">
        <!-- Modal content -->
        <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
          <!-- Modal header -->
          <div class="flex justify-between items-start p-4 rounded-t border-b dark:border-gray-600">
            <h3 class="text-xl font-semibold text-gray-900 dark:text-white">
              Terms of Service
            </h3>
            <button type="button" class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white" data-modal-toggle="defaultModal">
              <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
              <span class="sr-only">Close modal</span>
            </button>
          </div>
          <!-- Modal body -->
          <div class="p-6 space-y-6">
            <p class="text-base leading-relaxed text-gray-500 dark:text-gray-400">
              With less than a month to go before the European Union enacts new consumer privacy laws for its citizens, companies around the world are updating their terms of service agreements to comply.
            </p>
            <p class="text-base leading-relaxed text-gray-500 dark:text-gray-400">
              The European Union's General Data Protection Regulation (G.D.P.R.) goes into effect on May 25 and is meant to ensure a common set of data rights in the European Union. It requires organizations to notify users as soon as possible of high-risk data breaches that could personally affect them.
            </p>
          </div>
          <!-- Modal footer -->
          <div class="flex items-center p-6 space-x-2 rounded-b border-t border-gray-200 dark:border-gray-600">
            <button data-modal-toggle="defaultModal" type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">I accept</button>
            <button data-modal-toggle="defaultModal" type="button" class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-blue-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10 dark:bg-gray-700 dark:text-gray-300 dark:border-gray-500 dark:hover:text-white dark:hover:bg-gray-600 dark:focus:ring-gray-600">Decline</button>
          </div>
        </div>
      </div>
    </div>

    <!-- Edit entry modal -->
    <div id="editEntryModal" tabindex="-1" aria-hidden="true" class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 w-full md:inset-0 h-modal md:h-full">
      <div class="relative p-4 w-full max-w-2xl h-full md:h-auto">
        <!-- Modal content -->
        <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
          <!-- Modal header -->
          <div class="flex justify-between items-start p-4 rounded-t border-b dark:border-gray-600">
            <h3 class="text-xl font-semibold text-gray-900 dark:text-white">
              <span v-if="addOrEdit === 1">Edit entry [{{ selectedEntry.id }}]</span>
              <span v-else>Add entry</span>
              
            </h3>
            <button @click="toggleEditModal" type="button" class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white">
              <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
              <span class="sr-only">Close modal</span>
            </button>
          </div>
          <!-- Modal body -->
          <div class="p-6 space-y-6 flex flex-col text-left">
            <div class="flex flex-col">
              <label>Project</label>
              <select v-model="selectedEntry.project">
                <option v-for="project in getAvailableProjects()" :value="project.id" :key="project.id">{{ project.name }}</option>
              </select>
            </div>
            <div class="flex flex-col">
              <label>Day</label>
              <date-picker v-model:value="selectedEntry.day" class="w-full" :clearable="false"></date-picker>
            </div>
            <div class="flex flex-col">
              <label>Hours</label>
              <div class="flex flex-row items-center gap-4">
                <date-picker class="w-full" v-model:value="selectedEntry.start" :minute-step="5" :hour-options="hours" type="time" :showSecond="false" :clearable="false"></date-picker>
                <p>To</p>
                <!-- TODO - Fix the format conversion to show the minutes and returns to a date object -->
                <date-picker class="w-full" v-model:value="selectedEntry.end" :hour-options="hours" type="time" :showSecond="false" :clearable="false"></date-picker>
              </div>
            </div>
          </div>
          <!-- Modal footer -->
          <div class="flex items-center p-6 space-x-2 rounded-b border-t border-gray-200">
            <div v-if="addOrEdit === 1" class="space-x-2">
              <button @click="toggleEditModal" type="button" class="text-white bg-green-500 hover:bg-green-600 focus:ring-4 focus:outline-none focus:ring-green-600 font-medium rounded-lg text-sm px-5 py-2.5 text-center">Save</button>
              <button @click="removeEntry" type="button" class="text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:outline-none focus:ring-red-600 font-medium rounded-lg text-sm px-5 py-2.5 text-center">Delete</button>
            </div>
              <button @click="addEntry" type="button" v-else class="text-white bg-florijnOrange hover:bg-florijnOrange-200 focus:ring-4 focus:outline-none focus:ring-florijnOrange-100 font-medium rounded-lg text-sm px-5 py-2.5 text-center">Add</button>
              
            <button @click="toggleEditModal" type="button" class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-blue-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10">Cancel</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>


<script>
import dateFormat from 'dateformat';
import DatePicker from 'vue-datepicker-next';
import 'vue-datepicker-next/index.css';
import 'flowbite/dist/flowbite.js'
import { ref } from "vue";

export default {
  name: 'project-calendar',
  inject: ['projects'],
  data() {
    return {
      week: new Date(),
      modal: '',
      entryModal: '',
      userID: 1,
      addOrEdit: 0,
      langObject: {
        formatLocale: {
          firstDayOfWeek: 1,
        }
      },
      selectedEntry: {
        id: 0,
        project: 0,
        day: new Date(),
        start: new Date(),
        end: new Date(),
      },
      entries: ref([
        {
          id: 1,
          project: 2,
          day: new Date(),
          start: new Date(),
          end: new Date(),
        },
        {
          id: 2,
          project: 5,
          day: new Date(),
          start: new Date(),
          end: new Date(),
        },
        {
          id: 3,
          project: 2,
          day: new Date(),
          start: new Date(),
          end: new Date(),
        }
      ]),
    }
  },
  // TODO - Make a watch function that checks for the id param and changes the data object
  // FIXME - The start and end time will not show the proper time. Rather the current time.
  mounted() {
    const targetEl = document.querySelector('#defaultModal');
    const editModalTargetEl = document.querySelector('#editEntryModal');

    // eslint-disable-next-line no-undef
    this.modal = new Modal(targetEl);
    // eslint-disable-next-line no-undef
    this.entryModal = new Modal(editModalTargetEl);
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
    getHours(date) {
      // const date = new Date(epoch);
      // const date = new Date();

      console.log(date);

      return dateFormat(date, "HH:MM");
    },
    openAddModal() {
      this.addOrEdit = 0;
      this.entryModal.show();
      const projects = this.getAvailableProjects();

      this.selectedEntry = {
        id: 1000,
        project: projects[0].id,
        day: new Date(),
        start: new Date(),
        end: new Date(),
      };
    },
    editCalendarEntry(id) {
      this.addOrEdit = 1;
      this.selectedEntry = this.entries.find(element => element.id === parseInt(id));
      this.entryModal.show();
    },
    toggleEditModal() {
      this.entryModal.toggle();
    },

    addEntry() {
      this.entries.push(this.selectedEntry);
      this.entryModal.hide();
    },

    removeEntry() {
      const index = this.entries.indexOf(this.selectedEntry.id);

      if (index !== 1) {
        this.entries.splice(index, 1);
        this.entryModal.hide();
      }
    },

    getAvailableProjects() {
      return this.projects.filter(element => element.status !== 0 && element.specialists.includes(this.userID));
    }
  },
  computed: {
    getWeekNumber() {
      return dateFormat(this.week, "W");
    },
    getEntries() {
      return this.entries;
    },
  },
  components: {
    DatePicker
  }
}
</script>