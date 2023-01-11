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
            <button
                @click="this.$router.push('/create-project')"
                class="p-2.5 ml-2 text-sm font-medium text-white bg-gradient-to-r from-orange-400 via-orange-500 to-orange-600 hover:bg-gradient-to-br rounded-lg">
              <svg class="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24"
                   xmlns="http://www.w3.org/2000/svg">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                      d="M12 6v6m0 0v6m0-6h6m-6 0H6"></path>
              </svg>
            </button>
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
                Projecteigenaar: U
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
            <div>
              <h1 class="mt-3 font-medium text-xl text-gray-700">
                Specialisten
              </h1>
              <div>
                <div v-if="this.selectedProject.specialists.length < 1">
                  <p>Er zijn nog geen specialisten voor dit project gevonden...</p>
                </div>
                <div v-else class="relative overflow-x-auto rounded-lg border border-gray-300">
                  <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
                    <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                    <tr>
                      <th scope="col" class="px-3 py-3">
                        Naam
                      </th>
                      <th scope="col" class="px-6 py-3">
                        Email
                      </th>
                      <th scope="col" class="px-6 py-3">
                        Telefoonnummer
                      </th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr v-for="specialist in this.selectedProject.specialists" :key="specialist.id"
                        class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                      <th scope="row" class="px-3 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                        {{ specialist.first_name + " " + specialist.last_name }}
                      </th>
                      <td class="px-6 py-4">
                        {{ specialist.email }}
                      </td>
                      <td class="px-6 py-4">
                        {{ specialist.phone }}
                      </td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>

            <div>
              <div class="flex flex-row justify-between">
                <div>
                  <h1 class="mt-3 font-medium text-xl text-gray-700">
                    Aankondigingen
                  </h1>
                </div>
              </div>
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

                <form>
                  <label for="chat" class="sr-only">Uw aankondiging</label>
                  <div class="flex items-center px-2 py-2 rounded-lg bg-gray-50 dark:bg-gray-700">
                    <textarea v-on:keyup.enter="sendMessageAndEmail($event)" id="chat" rows="1"
                              class="block p-2.5 w-full text-sm text-gray-900 bg-white rounded-lg border border-gray-300 focus:ring-orange-500 focus:border-orange-500"
                              placeholder="Uw aankondiging..."></textarea>

                    <button @click="sendMessageAndEmail($event)"
                            class="inline-flex justify-center ml-1 p-2 text-orange-500 rounded-full cursor-pointer hover:bg-orange-100 dark:text-orange-500 dark:hover:bg-gray-600">
                      <svg aria-hidden="true" class="w-6 h-6 rotate-90" fill="currentColor" viewBox="0 0 20 20"
                           xmlns="http://www.w3.org/2000/svg">
                        <path
                            d="M10.894 2.553a1 1 0 00-1.788 0l-7 14a1 1 0 001.169 1.409l5-1.429A1 1 0 009 15.571V11a1 1 0 112 0v4.571a1 1 0 00.725.962l5 1.428a1 1 0 001.17-1.408l-7-14z"></path>
                      </svg>
                      <span class="sr-only">Stuur aankondiging</span>
                    </button>
                  </div>
                </form>

              </div>
            </div>
          </div>

        </div>
        <div class="place-items-center content-center text-center" v-else>
          <div class="flex flex-row min-h-screen justify-center rounded-lg items-center">
            <div>
              <img class="h-48 m-auto content-center" :src="require('../assets/img/undraw_void_-3-ggu.svg')">
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
import specialists from "@/views/admin/specialist/Specialists";

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
      specialists: [],
      webSocketAnnouncements: [],
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
  },

  async created() {
    this.announcementsService = new AnnouncementsAdaptor(process.env.VUE_APP_API_URL + `/api/announcements`, this.onReceiveAnnouncement)
    await this.getProjectData();
    await this.getUserData();
  },

  methods: {
    sendMessageAndEmail(event) {
      // this.sendEmail(event);
      this.onNewAnnouncement(event);
    },

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

    async sendEmail(event) {
      const specialists = this.selectedProject.specialists
      console.log(specialists)
      const currentTimeInMilliseconds = new Date().getTime();
      const currentTime = new Date(currentTimeInMilliseconds);
      const time = currentTime.toLocaleString('nl-NL', {hour: '2-digit', minute: '2-digit'})

      for (let i = 0; i < specialists.length; i++) {
        const emailData = {
          to: specialists[i].email,
          name: specialists[i].first_name + " " + specialists[i].last_name,
          from: this.user.first_name + " " + this.user.last_name,
          subject: this.selectedProject.name,
          time: time,
          body: event.target.value
        }

        await axios.get(process.env.VUE_APP_API_URL + '/api/send-email', {params: emailData})
            .then(response => {
              console.log(response);
            })
            .catch((err) => {
              console.log(err);
            })
      }
    },

    getUserData() {
      axios.get(process.env.VUE_APP_API_URL + `/api/users/${this.userId}`)
          .then((res) => {
            this.user = res.data;
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

    async onNewAnnouncement(event) {
      // for demo purpose of a simple web socket
      this.announcementsService.sendMessage(event.target.value, this.user.first_name + " " + this.user.last_name, this.selectedProject.id);
      // a persistent announcement system would save the announcement here via the REST api
      // and let the rest controller issue the websocket notification to inform all clients about the update
      await axios.post(process.env.VUE_APP_API_URL + `/api/announcements/add/${this.userId}/${this.selectedProject.id}`, {
        message: event.target.value,
        dateAndTime: new Date,
        clientId: this.userId,
        projectId: this.selectedProject.id
      }).then(response => {
        console.log(response)
      }).catch(error => {
        console.log(error)
      });

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

      this.selectedProject = element;
      this.getAnnouncements(this.selectedProject.id);
    },

    getProjectData() {
      axios.get(process.env.VUE_APP_API_URL + `/api/projects/client/${this.userId}`)
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