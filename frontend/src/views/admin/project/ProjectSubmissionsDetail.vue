<template>
  <div class="container mx-auto px-10 py-4">
    <div class="grid grid-cols-1 md:grid-cols-3 gap-4">
      <div class="p-4 shadow-md rounded-md border border-gray-200 text-left">

        <p><strong>Naam:</strong> {{ dataObject.name }}</p>
        <!--        <p><strong>Company:</strong>{{ clientOfThisProject.company }}</p>-->
        <!--        <p><strong>Client: </strong>{{ specialistFullName(clientOfThisProject) }}</p>-->
        <p><strong>Gemaakt op: </strong>{{ formatDate(dataObject.created) }}</p>
      </div>
      <div class="relative py-8 flex items-center justify-center p-4 shadow-md rounded-md border border-gray-200">
        <p class="absolute bottom-2 right-2 text-gray-400">Total hours clocked</p>
        <p class="text-3xl">200h</p>
      </div>
      <!--TODO fix this bruh        -->
      <div
          class="relative py-8 flex items-center justify-center p-4 shadow-md rounded-md border border-gray-200 text-left">
        <p class="absolute bottom-2 right-2 text-gray-400">Most valuable coder</p>
        <!--<p class="text-3xl">{{ specialistFullName(specialistsOfThisProject[0]) }}</p>-->
      </div>
    </div>
    <hr class="my-4"/>
    <div class="flex flex-row justify-between my-4">
      <p class="text-left text-1xl font-medium mb-4">
        <span
            class="bg-red-100 text-red-800 text-sm font-medium mr-2 px-2.5 py-0.5 rounded dark:bg-red-200 dark:text-red-900"
            v-if="dataObject.status === 0">
        Canceled
      </span>
        <span
            class="bg-yellow-100 text-yellow-800 text-sm font-medium mr-2 px-2.5 py-0.5 rounded dark:bg-yellow-200 dark:text-yellow-900"
            v-if="dataObject.status === 1">
        On going
      </span>
        <span
            class="bg-green-100 text-green-800 text-sm font-medium mr-2 px-2.5 py-0.5 rounded dark:bg-green-200 dark:text-green-900"
            v-if="dataObject.status === 2">
        Done
      </span>
      </p>
      <button data-modal-toggle="editStatus-modal" class="bg-[#F05822] text-white font-bold rounded px-3">
        Edit status
      </button>
    </div>

    <div class="overflow-x-auto relative border border-gray-200 sm:rounded-lg">
      <table class="w-full text-sm rounded-md text-left text-gray-500 dark:text-gray-400">
        <thead class="text-xs border-b text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
        <tr>
          <th scope="col" class="py-3 px-6">
            Name
          </th>
          <th scope="col" class="py-3 px-6">
            Type
          </th>
          <th scope="col" class="py-3 px-6">
            Hours
          </th>
        </tr>
        </thead>
        <tbody>

        <tr v-for="specialist in specialistsOfThisProject" :key="specialist.id"
            @click="navigateToSpecialist(specialist)"
            class="cursor-pointer bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-orange-50 dark:hover:bg-gray-600">
          <td class="font-normal text-gray-500 flex items-center py-4 px-6 whitespace-nowrap dark:text-white">
            {{ specialistFullName(specialist) }}
          </td>
          <td class="py-4 px-6">
            {{ firstLetterUpperCase(specialist.specialistType) }}
          </td>
          <td class="py-4 px-6">
            94
          </td>
        </tr>
        <tr
            class="cursor-pointer bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-orange-50 dark:hover:bg-gray-600"
            type="button" data-modal-toggle="addSpecialistModal">
          <td class="py-4 px-6 inline-flex items-center gap-2">
            Add Specialist
            <Icon icon="ic:baseline-person-add-alt-1" class="text-lg"/>
          </td>
          <td></td>
          <td></td>
        </tr>
        </tbody>
      </table>
    </div>
    <hr class="my-4"/>
    <div class="project-description">
      <h2><strong>Project description</strong></h2>
      <p>{{ dataObject.description }}</p>
    </div>
    <button v-on:click="deleteProject" type="button"
            class="float-right focus:outline-none text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-900">
      Delete project
    </button>
  </div>

  <div id="addSpecialistModal" tabindex="-1" aria-hidden="true"
       class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 w-full md:inset-0 h-modal md:h-full">
    <div class="relative p-4 w-full max-w-2xl h-full md:h-auto">
      <!-- Modal content -->
      <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
        <!-- Modal header -->
        <div class="flex justify-between items-start p-4 rounded-t border-b dark:border-gray-600">
          <h3 class="text-xl font-semibold text-gray-900 dark:text-white">
            Add Specialist
          </h3>
          <button type="button"
                  class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white"
                  data-modal-toggle="addSpecialistModal">
            <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20"
                 xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd"
                    d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
                    clip-rule="evenodd"></path>
            </svg>
            <span class="sr-only">Close modal</span>
          </button>
        </div>
        <!-- Modal body -->
        <div class="p-6 space-y-6">
          <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-400">Select
            an specialist</label>
          <select id="availableSpecialists"
                  class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
            <option selected>Choose a specialist</option>
            <option v-for="specialist in availableSpecialists" :key="specialist.id">{{
                specialistFullName(specialist)
              }}
            </option>
          </select>
        </div>
        <!-- Modal footer -->
        <div class="flex items-center p-6 space-x-2 rounded-b border-t border-gray-200 dark:border-gray-600">
          <button data-modal-toggle="addSpecialistModal" type="button"
                  class="text-white bg-florijnOrange hover:bg-florijnOrange-300 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">
            Add
          </button>
          <button data-modal-toggle="addSpecialistModal" type="button"
                  class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-blue-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10">
            Cancel
          </button>
        </div>
      </div>
    </div>
  </div>

  <editProjectStatus v-bind:status="dataObject.status"/>
</template>

<script>
import {firstLetterUpperCase, formatDate, specialistFullName} from "@/plugins/textManipulation.js";
import {Icon} from '@iconify/vue';
import editProjectStatus from "@/components/admin/project/editProjectStatus";
import axios from "axios";

export default {
  name: "ProjectSubmissionsDetail",

  data() {
    return {
      dataObject: null,
      specialistsOfThisProject: [],
      clientOfThisProject: null,
      availableSpecialists: [],
      specialists: null,
      clients: null,
      modalObj: null,
      classObject: {
        'bg-green-100': this.dataObject === 0
      }
    }
  },

  async created() {
    await this.findProjectFromRouteParam(this.$route.params.id);

    this.specialistsOfThisProject = this.getSpecialistOfThisProject();
    this.clientOfThisProject = this.findClientFromId(this.dataObject.client);
    this.availableSpecialists = this.findAvailableSpecialists();
  },

  methods: {
    specialistFullName,
    firstLetterUpperCase,
    formatDate,

    declineProject() {
      history.back()
    },

    deleteProject() {
      const id = this.$route.params.id
      axios.delete(process.env.VUE_APP_API_URL + "/api/projects/" + id)
          .then((res) => {
            this.$router.push('/projects').then(() => {
              this.$router.go()
            })
            console.log(res)
          })
    },

    async getAllSpecialists() {
      await axios.get(process.env.VUE_APP_API_URL + "/api/users/speccialist")
          .then((res) => {
            console.log(res.data)
            this.specialists = res.data;
          })
          .catch((err) => {
            console.log(err);
          })
    },
    async findProjectFromRouteParam(id) {
      await axios.get(process.env.VUE_APP_API_URL + "/api/projects/" + id)
          .then((res) => {
            console.log(res.data)
            this.dataObject = res.data;
          })
          .catch((err) => {
            console.log(err);
          })
    },

    findSpecialistFromId(id) {
      return this.specialists.find(element => element.id === parseInt(id));
    },

    findAvailableSpecialists() {
      return this.specialists.filter((val) => {
        return this.dataObject.specialists.indexOf(val.id) === -1;
      })
    },

    findClientFromId(id) {
      return this.clients.find(element => element.id === parseInt(id));
    },

    async getSpecialistOfThisProject() {
      const projectId = this.$route.params.id;
      const project = this.findProjectFromRouteParam(projectId);
      let newSpecialists = [];

      await axios.get(process.env.VUE_APP_API_URL + "/api/users/specialist")
          .then((res) => {
            this.specialistsOfThisProject = res.data
          })
          .catch((err) => {
            console.log(err);
          })

      for (let i = 0; i < project.specialists.length; i++) {
        newSpecialists.push(
            this.findSpecialistFromId(project.specialists[i])
        );
      }

      return newSpecialists;
    },

    navigateToSpecialist(specialist) {
      this.$router.push('/profile/' + specialist.id)
    },
  },
  watch: {
    '$route'() {
      this.dataObject = this.findProjectFromRouteParam(this.$route.params.id);
      this.specialistsOfThisProject = this.getSpecialistOfThisProject();
      this.clientOfThisProject = this.findClientFromId(this.dataObject.client);
      this.availableSpecialists = this.findAvailableSpecialists();
    }
  },
  components: {
    Icon,
    editProjectStatus
  },


}
</script>


<style scoped>

</style>