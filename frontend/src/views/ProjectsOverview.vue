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
                    <a href="#" class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Status</a>
                  </li>
                  <li>
                    <a href="#" class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Alphabetical
                      A-Z</a>
                  </li>
                  <li>
                    <a href="#" class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Alphabetical
                      Z-A</a>
                  </li>
                  <li>
                    <a href="#" class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Newest</a>
                  </li>
                  <li>
                    <a href="#" class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Oldest</a>
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
            <div class="relative w-full">
              <div class="absolute inset-y-0 left-0 flex items-center pl-3 pointer-events-none">
                <svg aria-hidden="true" class="w-5 h-5 text-gray-500" fill="currentColor" viewBox="0 0 20 20"
                     xmlns="http://www.w3.org/2000/svg">
                  <path fill-rule="evenodd"
                        d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z"
                        clip-rule="evenodd"></path>
                </svg>
              </div>
              <input type="text" id="simple-search"
                     class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full pl-10 p-2.5 "
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

        <div class="overflow-y-scroll max-h-full">
          <div
              class="text-left rounded-lg p-2 m-3 cursor-pointer transition ease-in-out delay-0 bg-white-500 hover:-translate-y-1 hover:scale-110 hover:bg-gray-100 hover:shadow-sm duration-300"
              v-for="(project) in projects" :key="project"
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
                  <button
                      class="p-1.5 text-sm font-medium text-gray-500 rounded-3xl hover:bg-gray-200"
                      data-dropdown-toggle="dropdown">
                    <svg class="w-4 h-4" fill="none" stroke="currentColor" viewBox="0 0 24 24"
                         xmlns="http://www.w3.org/2000/svg">
                      <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                            d="M12 5v.01M12 12v.01M12 19v.01M12 6a1 1 0 110-2 1 1 0 010 2zm0 7a1 1 0 110-2 1 1 0 010 2zm0 7a1 1 0 110-2 1 1 0 010 2z"></path>
                    </svg>
                    <span class="sr-only">Search</span>
                  </button>
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

        <div class="px-4 py-3 h-auto" v-show='toggleEdit' v-if="selectedProject" v-bind="selectedProject">
          <div class="relative  bg-white rounded-lg dark:bg-gray-700">
            <div class="flex flex-col text-left">
              <div class="flex items-start pt-2 mb-1 justify-between rounded-t dark:border-gray-600">
                <h3 class="text-3xl 1 font-medium text-gray-900 dark:text-white">Bewerk dit project</h3>
                <button @click='toggleEdit = !toggleEdit' type="button"
                        class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-3xl text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white">
                  <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24"
                       xmlns="http://www.w3.org/2000/svg">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                          d="M6 18L18 6M6 6l12 12"></path>
                  </svg>
                </button>
              </div>
              <p class="mb-1 text-md font-normal text-gray-600">Druk op "Enter" om veranderingen op te slaan</p>
            </div>

            <hr>

            <div class="pt-3 pb-3 flex items-center justify-center w-full">
              <label for="dropzone-file"
                     class="flex flex-col items-center justify-center w-full h-64 border-2 border-gray-300 border-dashed rounded-lg cursor-pointer bg-gray-50 dark:hover:bg-bray-800 dark:bg-gray-700 hover:bg-gray-100 dark:border-gray-600 dark:hover:border-gray-500 dark:hover:bg-gray-600">
                <div class="flex flex-col items-center justify-center pt-5 pb-6">
                  <svg aria-hidden="true" class="w-10 h-10 mb-3 text-gray-400" fill="none" stroke="currentColor"
                       viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                          d="M7 16a4 4 0 01-.88-7.903A5 5 0 1115.9 6L16 6a5 5 0 011 9.9M15 13l-3-3m0 0l-3 3m3-3v12"></path>
                  </svg>
                  <p class="mb-2 text-sm text-gray-500 dark:text-gray-400"><span class="font-semibold">Klik om een nieuwe project banner up te uploaden</span>
                    of drag and drop</p>
                  <p class="mb-2 text-sm text-gray-500 dark:text-gray-400">(Dit zal de huidige banner verwijderen)</p>
                  <p class="text-xs text-gray-500 dark:text-gray-400">SVG, PNG of JPG</p>
                </div>
                <input id="dropzone-file" type="file" class="hidden"/>
              </label>
            </div>

            <form class="h-fit">
              <div class="mb-6">
                <label for="name" class="block mb-2 text-md font-medium text-gray-900 dark:text-white">Project
                  naam</label>
                <input type="text" id="name"
                       class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5k:bg-gray-700"
                       placeholder="Schrijf hier de naam" v-model.lazy="selectedProject.name">
              </div>
              <div class="mb-6">
                <label for="description" class="block mb-2 text-md font-medium text-gray-900 dark:text-white">Beschrijving</label>
                <textarea id="description" rows="4"
                          class="block p-2.5 w-full h-96 text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-orange-500 focus:border-orange-500"
                          placeholder="Schrijf hier de beschrijving..."
                          v-model.lazy="selectedProject.description"></textarea>
              </div>
              <div class="flex flex-row w-full">
                <div class="w-1/2 mr-1">

                  <h1 class="text-md font-medium text-gray-900 mb-2">Skills</h1>
                  <form class="flex items-center mb-4">
                    <label for="simple-search" class="sr-only"></label>
                    <div class="relative w-full">
                      <div class="absolute inset-y-0 left-0 flex items-center pl-3 pointer-events-none">
                        <svg aria-hidden="true" class="w-5 h-5 text-gray-500 dark:text-gray-400" fill="currentColor"
                             viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                          <path fill-rule="evenodd"
                                d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z"
                                clip-rule="evenodd"></path>
                        </svg>
                      </div>
                      <input type="text" id="simple-search"
                             class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full pl-10 p-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-orange-500 dark:focus:border-orange-500"
                             placeholder="Zoek skill">
                    </div>
                  </form>

                </div>

                <div class="w-1/2 ml-1">

                  <label for="countries" class="block mb-2 text-md font-medium text-gray-900 dark:text-white">Selecteer
                    de status van dit project</label>
                  <select v-model="selectedStatus" id="countries"
                          class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-orange-500 dark:focus:border-orange-500">
                    <option selected>Kies de huidige status</option>
                    <option v-for="status in statusses" :key="{ id: status.id, text: status.name }"
                            @click="changeStatus(selectedProject, status.id)">{{ status.name }}
                    </option>
                  </select>
                </div>
              </div>
            </form>
          </div>
        </div>

        <div class="overflow-y-scroll m-auto m-3 p-2" v-if="selectedProject" v-bind="selectedProject"
             v-show='!toggleEdit'>
          <div>
            <div class="flex flex-row justify-between">
              <h1 class="text-black text-3xl font-medium">
                {{ selectedProject.name }}
              </h1>
              <div>
                <button
                    @click='toggleEdit = !toggleEdit'
                    class="p-2.5 ml-2 text-sm font-medium text-gray-500 rounded-3xl hover:bg-gray-200">
                  <svg class="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24"
                       xmlns="http://www.w3.org/2000/svg">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                          d="M11 5H6a2 2 0 00-2 2v11a2 2 0 002 2h11a2 2 0 002-2v-5m-1.414-9.414a2 2 0 112.828 2.828L11.828 15H9v-2.828l8.586-8.586z"></path>
                  </svg>
                  <span class="sr-only">Search</span>
                </button>
              </div>
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
                  Actief</a></h1>
                </div>
                <div v-else-if="selectedProject.status === 2"><h1>Status: <a
                    class="py-0.0 px-1.5 bg-gradient-to-r from-green-400 to-green-400 text-white font-medium rounded-2xl">
                  Actief</a></h1>
                </div>
                <div v-else-if="selectedProject.status === 3"><h1>Status: <a
                    class="py-0.0 px-1.5 bg-gradient-to-r from-green-500 to-green-600 text-white font-medium rounded-2xl">
                  Actief</a></h1>
                </div>
              </div>
            </div>
            <hr>
            <div>
              <img class="rounded-lg mt-3 m-auto" :src="selectedProject.bannerUrl"
                   style="display:block; max-height:200px; width: 100%; object-fit: cover">
              <h1 class="mt-3 font-medium text-xl text-gray-700">Project beschrijving
              </h1>
              <p class="mb-3 font-normal text-gray-600 dark:text-gray-400">
                {{ selectedProject.description }}
              </p>
            </div>
            <div>
              <h1 class="mt-3 font-medium mb-1 text-xl text-gray-700">Skills
              </h1>

              <p>
                Er zijn nog geen skills toegevoegd voor dit project helaas
              </p>
              <!--              <div>-->
              <!--                <a class="bg-gray-200 border border-2 border-gray-300 px-2 py-1 rounded-lg">Frikandel Speciaal</a>-->
              <!--              </div>-->
            </div>
            <div>
              <h1 class="mt-3 font-medium text-xl text-gray-700">
                Specialists
              </h1>
              <div
                  class="rounded-lg p-1 flex flex-row w-full cursor-pointer transition ease-in-out delay-0 bg-white-500 hover:-translate-y-1 hover:scale-105 hover:bg-gray-100 hover:shadow-sm duration-300">
                <div class="flex flex row">
                  <!--                  <img class="h-12 rounded-3xl" :src="require('@/assets/img/undraw_male_avatar_re_y880.svg')">-->
                  <!--                  <div class="ml-2">-->
                  <!--                    <div>-->
                  <!--                      <h1 class="text-lg font-medium">Dennis Kanker</h1>-->
                  <!--                    </div>-->
                  <!--                    <div>-->
                  <!--                      <h2 class="text-sm text-black font-thin text-gray-400">Piemelsaus@kanker.aids</h2>-->
                  <!--                    </div>-->
                  <!--                  </div>-->
                </div>
                <p>
                  Er zijn nog geen specialisten toegevoegd voor dit project helaas
                </p>
              </div>
            </div>
            <div>
              <h1 class="mt-3 font-medium text-xl text-gray-700">
                Aankondigingen
              </h1>
              <div class="pt-3 pb-3 flex items-center flex-column justify-center w-full">
                <div
                    class="flex flex-col items-center justify-center w-full h-64 border-1 border-gray-300 rounded-lg  bg-gray-50 dark:hover:bg-bray-800 dark:bg-gray-700 hover:bg-gray-100 dark:border-gray-600 dark:hover:border-gray-500 dark:hover:bg-gray-600">
                  <div class="flex flex-col items-center justify-center pt-5 pb-6">
                  </div>
                </div>
              </div>
            </div>
            <form>
              <label class="mb-2 text-sm font-medium text-gray-900 sr-only dark:text-white">Plaats aankondiging</label>
              <div class="relative">
                <div class="absolute inset-y-0 left-0 flex items-center pl-3 pointer-events-none">
                  <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24"
                       xmlns="http://www.w3.org/2000/svg">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                          d="M7 8h10M7 12h4m1 8l-4-4H5a2 2 0 01-2-2V6a2 2 0 012-2h14a2 2 0 012 2v8a2 2 0 01-2 2h-3l-4 4z"></path>
                  </svg>
                </div>
                <input type="search" id="default-search"
                       class="block w-full p-4 pl-10 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-orange-500 focus:border-orange-500 "
                       placeholder="Plaats een aankondiging voor de specialisten van dit project">
                <button type="submit"
                        class="text-white absolute right-2.5 bottom-2.5 bg-gradient-to-r from-orange-400 via-orange-500 to-orange-600 hover:bg-gradient-to-br rounded-lg text-sm px-4 py-2 ">
                  Plaats
                </button>
              </div>
            </form>
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

export default {
  name: "ProjectsOverview",
  data() {
    return {
      projects: [],
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
  created() {
    this.getProjectData();
  },
  methods: {
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
    },

    changeStatus(project, statusId) {
      project.status = statusId;
    },

    getProjectData() {
      const id = localStorage.getItem("id");

      axios.get(process.env.VUE_APP_API_URL + `/api/projects/client/${id}`)
          .then((res) => {
            for (let i = 0; i < res.data.length; i++) {
              this.projects.push(res.data[i])
            }
          })
          .catch((err) => {
            console.log(err);
          })
    },

    getProjects() {
      const id = localStorage.getItem("id");

      axios.get(process.env.VUE_APP_API_URL + "/api/projects" + id)
          .then((res) => {
            this.projects = res.data;

            console.log(res.data)
            console.log(this.projects)
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