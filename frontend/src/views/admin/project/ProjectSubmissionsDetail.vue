<template>
  <div class="container mx-auto px-10 py-4">
    <div class="grid grid-cols-1 md:grid-cols-3 gap-4">
      <div class="p-4 shadow-md rounded-md border border-gray-200 text-left">

        <p><strong>Naam:</strong> {{ dataObject.name }}</p>
        <!--        <p><strong>Company:</strong>{{ clientOfThisProject.company }}</p>-->
        <p><strong>Client: </strong>{{ specialistFullName(dataObject.user) }}</p>
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
        <p class="text-3xl">{{ specialistFullName(specialists[0]) }}</p>
      </div>
    </div>
    <hr class="my-4"/>
    <div class="flex flex-row justify-between my-4">
      <div v-if="dataObject.status === -1"><h1>Status: <a
          class="py-0.0 px-1.5 bg-gradient-to-r from-red-500 to-orange-600 text-white font-medium rounded-2xl">
        Geannuleerd</a></h1></div>
      <div v-else-if="dataObject.status === 0"><h1>Status: <a
          class="py-0.0 px-1.5 bg-gradient-to-r from-gray-400 to-gray-500 text-white font-medium rounded-2xl">
        Concept</a></h1></div>
      <div v-else-if="dataObject.status === 1"><h1>Status: <a
          class="py-0.0 px-1.5 bg-gradient-to-r from-green-300 to-green-400 text-white font-medium rounded-2xl">
        Geaccepteerd</a></h1>
      </div>
      <div v-else-if="dataObject.status === 2"><h1>Status: <a
          class="py-0.0 px-1.5 bg-gradient-to-r from-green-400 to-green-400 text-white font-medium rounded-2xl">
        Bezig</a></h1>
      </div>
      <div v-else-if="dataObject.status === 3"><h1>Status: <a
          class="py-0.0 px-1.5 bg-gradient-to-r from-green-500 to-green-600 text-white font-medium rounded-2xl">
        Afgerond</a></h1>
      </div>
      <button data-modal-toggle="editStatus-modal" class="bg-[#F05822] text-white font-bold rounded px-3">
        Edit status
      </button>
    </div>

    <div class="overflow-x-auto relative border border-gray-200 sm:rounded-lg">
      <table class="w-full text-sm rounded-md text-left text-gray-500 dark:text-gray-400">
        <thead class="text-xs border-b text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
        <tr>
          <th scope="col" class="px-6 py-3">
            Naam
          </th>
          <th scope="col" class="px-6 py-3">
            Specialist type
          </th>
          <th scope="col" class="px-6 py-3">
            Email
          </th>
          <th scope="col" class="px-6 py-3">
            Telefoon
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
            {{ firstLetterUpperCase(specialist.specialist.specialistType) }}
          </td>
          <td class="py-4 px-6">
            {{ specialist.email }}
          </td>
          <td class="py-4 px-6">
            {{ specialist.phone }}
          </td>
        </tr>
        <tr data-modal-toggle="addSpecialist-Modal-now"
            class="cursor-pointer bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-orange-50 dark:hover:bg-gray-600"
            type="button">
          <td v-on:click="goToAddSpecialist()" class="bg-gray-50 py-4 px-6 inline-flex items-center gap-2">
            <p style="padding-right: 5px" class="float-left">Pas team aan</p>
            <Icon icon="ic:baseline-person-add-alt-1" class="text-lg float-right"/>
          </td>
          <td></td>
          <td></td>
        </tr>
        </tbody>
      </table>
    </div>
    <hr class="my-4"/>
    <div class="project-description py-7">
      <h2><strong>Project description</strong></h2>
      <p>{{ dataObject.description }}</p>
    </div>

    <div class="not-prose relative bg-slate-50 rounded-xl overflow-hidden dark:bg-slate-800/25">
      <div style="background-position:10px 10px"
           class="absolute inset-0 bg-grid-slate-100 [mask-image:linear-gradient(0deg,#fff,rgba(255,255,255,0.6))] dark:bg-grid-slate-700/25 dark:[mask-image:linear-gradient(0deg,rgba(255,255,255,0.1),rgba(255,255,255,0.5))]"></div>
      <div class="relative rounded-xl overflow-auto p-8 ">

        <div
            class="w-72 float-left overflow-auto h-80 relative mx-auto bg-white dark:bg-slate-800 dark:highlight-white/5 shadow-lg ring-1 ring-black/5 rounded-xl flex flex-col divide-y dark:divide-slate-200/5">
          <div style="cursor: pointer" v-on:click="this.event.user = specialist.specialist"  v-for="specialist in specialists"
               :key="specialist.id"
               class="flex items-center gap-4 p-4 hover:bg-gray-50 dark:hover:bg-gray-600">
            <img class="w-12 h-12 rounded-full" :src="specialist.photo">
            <div class="flex flex-col">
              <strong class="text-slate-900 text-sm font-medium dark:text-slate-200">{{
                  this.fullName(specialist)
                }}</strong>
              <span class="text-slate-500 text-sm font-medium dark:text-slate-400">{{
                  specialist.specialist.specialistType
                }}</span>
            </div>
          </div>
        </div>


        <form class="w-4/5">
          <div class="flex flex-wrap -mx-3 mb-6">
            <div class="w-full md:w-1/2 px-3">
              <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">
                Titel
              </label>
              <input
                  class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                  type="text" placeholder="Event titel" v-model="event.title">
            </div>
            <div class="w-full md:w-1/2 px-3">
              <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">
                Locatie
              </label>
              <input
                  class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                  type="text" placeholder="Event locatie" v-model="event.location">
            </div>
          </div>
          <div class="flex flex-wrap -mx-3 mb-6">
            <div class="w-full md:w-1/2 px-3">
              <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">
                Start en Eind tijd
              </label>


              <input class="bg-gray-200 float-left w-1/2" type="datetime-local" v-model="event.start">
              <input class="bg-gray-200 float-left w-1/2" type="datetime-local" v-model="event.end">


            </div>
            <div class="w-full md:w-1/2 px-3">
              <div>
                <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">
                  Type
                </label>
                <select v-model="event.eventType"
                        class="block w-full px-4 py-2 mt-2 text-gray-700 bg-gray-200 border border-gray-300 rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-500 dark:focus:border-blue-500 focus:outline-none focus:ring">
                  <option value="WORK">Werk</option>
                  <option value="FREE_DAY">Vrij</option>
                  <option value="SICK">Ziek</option>
                  <option value="VACATION">Vakantie</option>
                  <option value="OTHER">Anders</option>
                </select>
              </div>
            </div>
          </div>
          <div class="flex flex-wrap -mx-3 mb-6">
            <div class="w-full px-3">
              <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-400">Beschrijving</label>
              <textarea v-model="event.description" id="message" rows="4"
                        class="block p-2.5 w-full text-sm text-gray-900 bg-gray-200 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                        placeholder="Beschrijving..."></textarea>
            </div>
          </div>
          <button v-on:click="this.createNewEvent()" class="float-right p-3 bg-[#F05822] text-white font-bold rounded ">
            Opslaan
          </button>
        </form>

      </div>
      <div class="absolute inset-0 pointer-events-none border border-black/5 rounded-xl dark:border-white/5"></div>
    </div>

    <br>
    <div class="flex items-center p-4 space-x-2 border-t border-gray-200">
      <button v-on:click="this.acceptedNumber = -1"
              class="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded">
        Afgewezen
      </button>
      <button v-on:click="this.acceptedNumber = 1"
              class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
        Geaccepteerd
      </button>
      <button v-on:click="this.acceptedNumber = 0"
              class="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded">
        Nieuw
      </button>
      <button v-on:click="this.acceptedNumber = 2"
              class="bg-[#F05822] hover:bg-orange-700 text-white font-bold py-2 px-4 rounded">
        Alles
      </button>
    </div>
    <div class="relative overflow-x-auto shadow-md sm:rounded-lg">
      <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
        <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
        <tr>
          <th scope="col" class="px-6 py-3">
            Titel
          </th>
          <th scope="col" class="px-6 py-3">
            Locatie
          </th>
          <th scope="col" class="px-6 py-3">
            Aantal minuten
          </th>
          <th scope="col" class="px-6 py-3">
            Beschrijving
          </th>
          <th scope="col" class="px-6 py-3">
            <span class="sr-only">Edit</span>
          </th>
        </tr>
        </thead>
        <tbody>
        <tr v-on:click="goToEvent(event)" v-for="event in getNewEvents(this.acceptedNumber)" v-bind:key="event.id"
            class=" bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">
          <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
            {{ event.title }}
          </th>
          <td class="px-6 py-4">
            {{ event.location }}
          </td>
          <td class="px-6 py-4">
            {{ event.title }}
          </td>
          <td class="px-6 py-4">
            {{ event.description }}
          </td>
          <td class="px-6 py-4 text-right">
            <a href="#" class="font-medium text-blue-600 dark:text-blue-500 hover:underline">Edit</a>
          </td>
        </tr>

        </tbody>
      </table>
    </div>

    <br>
    <button v-on:click="deleteProject" type="button"
            class="float-right focus:outline-none text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-900">
      Delete project
    </button>
  </div>

  <editProjectStatus v-bind:status="dataObject.status"/>
</template>

<script>
import {firstLetterUpperCase, formatDate, specialistFullName} from "@/plugins/textManipulation.js";
import {Icon} from '@iconify/vue';
import editProjectStatus from "@/components/admin/project/editProjectStatus";
import axios from "axios";
import {useToast} from "vue-toastification";

export default {
  name: "ProjectSubmissionsDetail",

  data() {
    return {
      dataObject: null,
      specialistsOfThisProject: [],
      availableSpecialists: [],
      clientOfThisProject: null,
      specialists: null,
      clients: null,
      modalObj: null,
      toast: useToast(),
      newEvents: null,
      acceptedNumber: 2,
      classObject: {
        'bg-green-100': this.dataObject === 0
      },
      event: {
        "project": null,
        "user": null,
        "title": null,
        "location": null,
        "start": null,
        "end": null,
        "description": null,
        "accepted": 0,
        "eventType": null
      },
    }
  },

  async created() {
    await this.findProjectFromRouteParam(this.$route.params.id);
    await this.getAllSpecialists()
    this.findAvailableSpecialists();
    await this.getSpecialistOfThisProject();
    this.clientOfThisProject = this.findClientFromId(this.dataObject.client);
    // this.availableSpecialists = this.findAvailableSpecialists();
  },

  methods: {
    specialistFullName,
    firstLetterUpperCase,
    formatDate,

    goToAddSpecialist() {
      this.$router.push('/projects/add-specialist/' + this.dataObject.id).then(() => {
        this.$router.go()
      })
    },

    createNewEvent() {
      axios.post(process.env.VUE_APP_API_URL + '/api/events/', this.event)
          .then((res) => {
            this.toast.success("Event is aangemaakt!");
            this.event.title = null
            this.event.user = null
            this.event.location = null
            this.event.start = null
            this.event.end = null
            this.event.eventType = null
            this.event.description = null
          })
          .catch((err) => {
            console.error(err);
            this.toast.error("Iets ging verkeerd!")
          })
    },

    getNewEvents(num) {
      if (num === 2) {
        return this.dataObject.events;
      } else {
        return this.dataObject.events.filter((event) => {
          return event.accepted === num
        })
      }
    },

    declineProject() {
      history.back()
    },

    goToEvent(event) {
      this.$router.push('/projects/event/' + event.id).then(() => {
        this.$router.go()
      })
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

    fullName(name) {
      return (String(name.first_name).charAt(0).toUpperCase() + String(name.first_name).slice(1))
          + ' '
          + String(name.last_name).charAt(0).toUpperCase() + String(name.last_name).slice(1);
    },


    async getAllSpecialists() {
      await axios.get(process.env.VUE_APP_API_URL + "/api/users/specialists")
          .then((res) => {
            this.specialists = res.data;
          })
    },

    async findProjectFromRouteParam(id) {
      await axios.get(process.env.VUE_APP_API_URL + "/api/projects/" + id)
          .then((res) => {
            this.dataObject = res.data;
            this.event.project = res.data;
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
      // const project = this.findProjectFromRouteParam(projectId);

      await axios.get(process.env.VUE_APP_API_URL + "/api/users/specialists/" + projectId)
          .then((res) => {
            console.log(res)
            this.specialistsOfThisProject = res.data
          })
          .catch((err) => {
            console.log(err);
          })

      /*      for (let i = 0; i < project.specialists.length; i++) {
              newSpecialists.push(
                  this.findSpecialistFromId(project.specialists[i])
              );
            }

            return newSpecialists;*/
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
.selected {
  background: #41c69e;
}

</style>