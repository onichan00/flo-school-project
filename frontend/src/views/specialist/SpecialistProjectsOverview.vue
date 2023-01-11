<template>
  <!--  Full Page-->
  <div style='background-image: linear-gradient(to right, #F15922 , #f17822);
  height: 400px;
  border-radius: 0% 0% 2% 2%;'>

    <!--    Two Columns-->
    <div class="max-w-6xl m-auto flex flex-row rounded-lg">

      <!--      Projects Section-->
      <div class="bg-white max-h-screen w-1/4 p-2 rounded-lg m-1 shadow-lg overflow-y">

        <!--        Project Header-->
        <div class="mb-3 m-2">
          <div class="flex flex-row justify-between items-center mb-1">
            <div>
              <h1 class="text-black font-medium text-3xl text-left">Projecten</h1>
            </div>
            <div>
              <button
                  class="p-2.5 ml-2 text-sm font-medium text-gray-500 rounded-3xl hover:bg-gray-200"
                  data-dropdown-toggle="dropdown1">
                <svg class="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24"
                     xmlns="http://www.w3.org/2000/svg">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                        d="M3 4a1 1 0 011-1h16a1 1 0 011 1v2.586a1 1 0 01-.293.707l-6.414 6.414a1 1 0 00-.293.707V17l-4 4v-6.586a1 1 0 00-.293-.707L3.293 7.293A1 1 0 013 6.586V4z"></path>
                </svg>
                <span class="sr-only">Search</span>
              </button>
              <div id="dropdown1"
                   class="hidden z-10 text-left w-44 bg-white rounded-lg divide-y divide-gray-100 shadow dark:bg-gray-700">
                <ul class="py-1 text-sm text-gray-700 dark:text-gray-200" aria-labelledby="dropdownDefault">
                  <li>
                    <a @click="sortStatus()"
                       class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Status</a>
                  </li>
                  <li>
                    <a @click="sortAlphabetically()"
                       class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Alphabetical
                      A-Z</a>
                  </li>
                  <li>
                    <a @click="sortAlphabeticallyReverse()"
                       class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Alphabetical
                      Z-A</a>
                  </li>
                  <li>
                    <a @click="sortNewToOld()"
                       class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Newest</a>
                  </li>
                  <li>
                    <a @click="sortOldToNew()"
                       class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Oldest</a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
          <div>
            <h6 class="text-gray-600 mb-4 font-light text-left">U heeft {{ activeProjects }} actieve projecten
            </h6>
          </div>
          <form class="flex items-center">
            <label for="simple-search" class="sr-only">Zoeken...</label>
            <div class="w-full">
              <input type="text" id="simple-search"
                     class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                     placeholder="Zoeken..." required>
            </div>
          </form>
        </div>

        <div class="overflow-visible max-h-full">
          <div
              class="text-left rounded-lg p-2 m-2 cursor-pointer transition ease-in-out delay-0 bg-white-500 hover:-translate-y-1 hover:scale-110 hover:bg-gray-100 hover:shadow-md duration-300"
              v-for="(project) in this.projects" :key="project"
              :class="[ selectedProject?.id === project.id ? selectedRowStyle : notSelectedRowStyle ]">
            <div @click="selectProject(project)">
              <div class="flex flex-row justify-between">
                <div class="flex flex-row mr-2">
                  <div v-if="project.status === -1"><i class="text-red-500 fa-solid fa-circle fa-2xs mx-1 mr-2"></i>
                  </div>
                  <div v-else-if="project.status === 0"><i
                      class="text-gray-300 fa-solid fa-2xs fa-circle mx-1 mr-2"></i></div>
                  <div v-else-if="project.status === 1"><i
                      class="text-green-400 fa-solid fa-2xs fa-circle mx-1 mr-2"></i></div>
                  <div v-else-if="project.status === 2"><i
                      class="text-green-500 fa-solid fa-2xs fa-circle mx-1 mr-2"></i></div>
                  <div v-else-if="project.status === 3"><i
                      class="text-green-600 fa-solid fa-2xs fa-circle mx-1 mr-2"></i></div>
                  <h1 class="font-medium text-lg">{{ project.name }}</h1>
                </div>
                <div>
                  <div id="dropdown"
                       class="hidden z-10 text-left w-44 bg-white rounded-lg divide-y divide-gray-100 shadow dark:bg-gray-700">
                    <ul class="py-1 text-sm text-gray-700 dark:text-gray-200" aria-labelledby="dropdownDefault">
                      <li>
                        <a href="#"
                           class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Edit
                          Project</a>
                      </li>
                      <li>
                        <a href="#"
                           class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Delete</a>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
              <div id="x" class="text-gray-500 pb-1">{{ project.description }}</div>
            </div>
          </div>

        </div>

      </div>

      <div class="bg-white w-3/4 rounded-lg m-1 text-left max-h-fit shadow-lg">

        <div class="overflow-y-scroll m-auto m-3 p-2" v-if="selectedProject" v-bind="selectedProject">
          <div>
            <div class="flex flex-row justify-between">
              <h1 class="text-black text-3xl font-medium">
                {{ selectedProject.name }}
              </h1>
            </div>

            <div class="text-m font-normal mb-3">
              <h1>
                Aangemaakt op: {{ this.dateFormatter(selectedProject.created) }}
              </h1>
              <h1>
                Projecteigenaar:
                {{ this.selectedProject.user.first_name[0].toUpperCase() + ". " + this.selectedProject.user.last_name }}
              </h1>
              <h1>
                Email: {{ this.selectedProject.user.email }}
              </h1>


              <div class="flex flex-row mr-2">
                <div v-if="selectedProject.status === -1"><h1>Status: <a
                    class="py-0.0 px-1.5 bg-gradient-to-r from-red-500 to-orange-600 text-white font-medium rounded-2xl">
                  Geannuleerd</a></h1></div>
                <div v-else-if="selectedProject.status === 0"><h1>Status: <a
                    class="py-0.0 px-1.5 bg-gradient-to-r from-gray-400 to-gray-500 text-white font-medium rounded-2xl">
                  Concept</a></h1></div>
                <div v-else-if="selectedProject.status === 1"><h1>Status: <a
                    class="py-0.0 px-1.5 bg-gradient-to-r from-green-300 to-green-400 text-white font-medium rounded-2xl">
                  Geaccepteerd</a></h1>
                </div>
                <div v-else-if="selectedProject.status === 2"><h1>Status: <a
                    class="py-0.0 px-1.5 bg-gradient-to-r from-green-400 to-green-400 text-white font-medium rounded-2xl">
                  Bezig</a></h1>
                </div>
                <div v-else-if="selectedProject.status === 3"><h1>Status: <a
                    class="py-0.0 px-1.5 bg-gradient-to-r from-green-500 to-green-600 text-white font-medium rounded-2xl">
                  Afgerond</a></h1>
                </div>
              </div>
            </div>
            <hr>
            <div>
              <div v-if='!hasBanner(selectedProject.bannerUrl)'>
                <img class="rounded-lg mt-3 m-auto" :src="require('@/assets/img/tianyi-ma-WiONHd_zYI4-unsplash.jpg')"
                     style="display:block; max-height:200px; width: 100%; object-fit: cover">
              </div>
              <div v-else>
                <img class="rounded-lg mt-3 m-auto" :src="selectedProject.bannerUrl"
                     style="display:block; max-height:200px; width: 100%; object-fit: cover">
              </div>
              <h1 class="mt-3 font-medium text-xl text-gray-700">Project beschrijving
              </h1>
              <p class="mb-3 font-normal text-gray-600 dark:text-gray-400">
                {{ selectedProject.description }}
              </p>
            </div>
            <div>
              <h1 class="mt-3 font-medium mb-1 text-xl text-gray-700">Skills
              </h1>
              <div class="flex flex-row flex-wrap">
                <div v-for="skill in selectedProject.skills" :key="skill.id">
                  <a class="bg-gray-200 border border-2 border-gray-300 px-2 py-1 mr-1 rounded-lg">{{ skill.name }}</a>
                </div>
              </div>
            </div>

            <div v-if="selectedProject != null" class="flex items-center justify-center">
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
                <button v-on:click="this.createNewEvent()"
                        class="float-right p-3 bg-[#F05822] text-white font-bold rounded ">
                  Opslaan
                </button>
              </form>
            </div>

            <div>
              <h1 class="mt-3 font-medium text-xl text-gray-700">
                Aankondigingen
              </h1>
              <div class="bg-gray-50 border border-1 rounded-lg">
                <div class="overflow-y-scroll h-72">
                  <div v-if="this.announcements.length < 1">
                  </div>
                  <div v-else>
                    <div v-for="(announcement, index) of this.announcements" v-bind:key="index">
                      <div class="text-left rounded-lg p-2 m-2 bg-white shadow-sm w-fit">
                        <div class="flex flex-row justify-between text-gray-400 text-sm space-x-4">
                          <div>
                            <a>{{ announcement.user.first_name + " " + announcement.user.last_name }}</a>
                          </div>
                          <div>
                            <a>{{ announcement.dateAndTime }}</a>
                          </div>
                        </div>

                        <div class="text-black text-lg">
                          <a>{{ announcement.message }}</a>
                        </div>
                      </div>
                    </div>
                    <div v-for="(announcement, index) of this.webSocketAnnouncements" v-bind:key="index">
                      <div v-if="announcement.project == this.selectedProject.id">
                        <div class="text-left rounded-lg p-2 m-2 bg-white shadow-sm w-fit">
                          <div class="flex flex-row justify-between text-gray-400 text-sm space-x-4">
                            <div>
                              <a>{{ announcement.user }}</a>
                            </div>
                            <div>
                              <a>{{ announcement.date }}</a>
                            </div>
                          </div>

                          <div class="text-black text-lg">
                            <a>{{ announcement.message }}</a>
                          </div>
                        </div>
                      </div>
                      <div v-else>

                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

        </div>
        <div class="place-items-center content-center text-center" v-else>
          <div class="flex flex-row min-h-screen justify-center rounded-lg items-center">
            <div>
              <img class="h-48 m-auto content-center" :src="require('@/assets/img/undraw_void_-3-ggu.svg')">
              <div>
                <h1 class="text-2xl font-semibold mt-3">Geen project geselecteerd</h1>
                <h3 class="text-lg">Een project selecteren om alle details te bekijken</h3>
              </div>
            </div>
          </div>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import {AnnouncementsAdaptor} from "@/models/AnnouncementsAdaptor";
import {useToast} from "vue-toastification";

export default {
  name: "ProjectsOverview",

  data() {
    return {
      userId: localStorage.getItem('id'),
      projects: [],
      user: [],
      options: {year: 'numeric', month: 'long', day: 'numeric'},
      selectedProject: null,
      toggleEdit: false,
      statusses: [
        {id: 0, name: 'Geannuleerd'},
        {id: 1, name: 'Gepauzeerd'},
        {id: 2, name: 'Actief'}
      ],
      selectedStatus: null,
      selectedRowStyle: "bg-gray-100 shadow-sm text-black",
      notSelectedRowStyle: "text-gray-900",
      announcements: [],
      toast: useToast(),
      specialists: [],
      webSocketAnnouncements: [],
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

  computed: {
    activeProjects() {
      let count = 0;
      this.projects.forEach((project) => {
        if (project.status === 2) count++;
      })
      return count;
    }
  },

  beforeUnmount() {
    // close down the service with the web socket
    this.announcementsService.close();
  },

  async created() {
    this.announcementsService = new AnnouncementsAdaptor(process.env.VUE_APP_API_URL + `/api/announcements`, this.onReceiveAnnouncement)
    await this.getProjectData();
    console.log(process.env.VUE_APP_API_URL + `/api/announcements`);
    await this.getUserData();
  },

  methods: {
    async getAnnouncements(id) {
      await axios.get(process.env.VUE_APP_API_URL + `/api/announcements/${id}`)
          .then(response => {
            console.log(response);
            this.announcements = response.data
            console.log(this.announcements)
          })
          .catch((err) => {
            console.log(err);
          })
    },

    sendMessageAndEmail(event) {
      this.sendEmail(event);
      this.onNewAnnouncement(event);
    },

    createNewEvent() {
      axios.post(process.env.VUE_APP_API_URL + '/api/events/', this.event)
          .then((res) => {
            this.toast.success("Event is aangemaakt!");
            this.event.title = null
            this.event.start = null
            this.event.end = null
            this.event.location = null
            this.event.description = null
            this.event.eventType = null
          })
          .catch((err) => {
            console.error(err);
            this.toast.error("Iets ging verkeerd!")
          })
    },

    getUserData() {
      axios.get(process.env.VUE_APP_API_URL + `/api/users/${this.userId}`)
          .then((res) => {
            this.user = res.data;
            this.event.user = res.data
          })
          .catch((err) => {
            console.log(err);
          })
    },

    onReceiveAnnouncement(message) {
      // this method is called when an announcement is distributed
      console.log("Received announcement:", message);
      message = JSON.parse(message)
      this.webSocketAnnouncements.push(message);
    },

    onNewAnnouncement(event) {
      // for demo purpose of a simple web socket
      this.announcementsService.sendMessage(event.target.value, this.user.first_name + " " + this.user.last_name, this.selectedProject.id);
      // a persistent announcement system would save the announcement here via the REST api
      // and let the rest controller issue the websocket notification to inform all clients about the update

      // reset the input in the text area
      event.target.value = "";
    },

    sortAlphabetically() {
      this.projects.sort((p1, p2) => p1.name.localeCompare(p2.name))
    },

    sortAlphabeticallyReverse() {
      this.projects.sort((p1, p2) => p1.name.localeCompare(p2.name)).reverse()
    },

    sortNewToOld() {
      this.projects.sort((p1, p2) => p1.created.localeCompare(p2.created))
    },

    sortOldToNew() {
      this.projects.sort((p1, p2) => p1.created.localeCompare(p2.created)).reverse()
    },

    sortStatus() {
      this.projects.sort((p1, p2) => p1.status - p2.status)
    },

    dateFormatter(date) {
      const formatDate = new Date(date)
      const yyyy = formatDate.getFullYear();
      let mm = formatDate.toLocaleString('default', {month: 'long'}); // Months start at 0!
      let dd = formatDate.getDate();

      const formattedDate = dd + ' ' + mm + ' ' + yyyy;
      return formattedDate;
    },

    selectProject(element) {
      if (element === this.selectedProject) {
        return null;
      }
      this.event.project = element;
      this.selectedProject = element;
      this.getAnnouncements(this.selectedProject.id);
    },

    getProjectData() {
      axios.get(process.env.VUE_APP_API_URL + `/api/projects/specialist/${this.userId}`)
          .then((res) => {
            for (let i = 0; i < res.data.length; i++) {
              this.projects.push(res.data[i])
            }

            for (let i = 0; i < this.projects.length; i++) {
              axios.get(process.env.VUE_APP_API_URL + `/api/users/specialists/${this.projects[i].id}`)
                  .then((res) => {
                    // Add the specialists to the current project
                    this.projects[i].specialists = res.data;
                  })
                  .catch((err) => {
                    console.log(err)
                  })
            }
          })
          .catch((err) => {
            console.log(err);
          })
    },

    hasBanner(bannerUrl) {
      let regexp = "/^https://images.unsplash.com/";
      if (bannerUrl != null){
        return (bannerUrl !== "" | bannerUrl != null | !bannerUrl.startsWith(regexp));
      }
      return false;
    },

    getProjects() {
      const id = localStorage.getItem("id");

      axios.get(process.env.VUE_APP_API_URL + "/api/projects" + id)
          .then((res) => {
            this.projects = res.data;
            console.log(res.data)
          })
          .catch((err) => {
            console.log(err);
          })
    },
  }
}

</script>

<style scoped>
::-webkit-scrollbar {
  width: 7px;
}

::-webkit-scrollbar-track {
  background-color: transparent;
}

::-webkit-scrollbar-thumb {
  background-color: #d6dee1;
  border-radius: 20px;
  border: 6px solid transparent;
}

::-webkit-scrollbar-thumb:hover {
  background-color: #a8bbbf;
}

#x {
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
}
</style>