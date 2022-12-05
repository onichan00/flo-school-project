<template>
  <div class="bottom-rounded" style='
  background-image: url("https://images.unsplash.com/photo-1557682260-96773eb01377?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2258&q=80");
  height: 400px;
  border-radius: 0% 0% 2% 2%;'>
    <div class="max-w-6xl m-auto flex flex-row rounded-lg">
      <div class="bg-white h-screen w-1/3 p-3 rounded-lg m-1 shadow-xl">
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
            <h6 class="text-gray-500 mb-4 font-light text-left">{{ projects.length }} projecten, waaronder
              {{ activeProjects }} actieve projecten
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
                class="p-2.5 ml-2 text-sm font-medium text-white bg-gradient-to-r from-orange-400 via-orange-500 to-orange-600 hover:bg-gradient-to-br rounded-lg">
              <svg class="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24"
                   xmlns="http://www.w3.org/2000/svg">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                      d="M12 6v6m0 0v6m0-6h6m-6 0H6"></path>
              </svg>
              <span class="sr-only">Search</span>
            </button>
          </form>
        </div>

        <hr>

        <div
            class="text-left rounded-lg p-2 m-3 transition ease-in-out delay-0 bg-white-500 hover:-translate-y-1 hover:scale-110 hover:bg-gray-100 hover:shadow-sm duration-300"
            v-for="project in projects" :key="project">
          <div>
            <div class="flex flex-row justify-between">
              <div class="flex flex-row mr-2">

                <div v-if="project.status === 0"><i class="text-red-500 fa-solid fa-circle fa-2xs mx-1 mr-2"></i></div>
                <div v-else-if="project.status === 1"><i
                    class="text-yellow-300 fa-solid fa-2xs fa-circle mx-1 mr-2"></i></div>
                <div v-else><i class="text-green-500 fa-solid fa-circle fa-2xs mx-1 mr-2"></i></div>
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
            <div class="text-gray-500 pb-2" v-if="project.description.length<80"> project.description</div>
            <div class="text-gray-500 pb-2" v-else>{{ project.description.substring(0, 80) + ".." }}</div>
          </div>
        </div>
      </div>
      <div class="bg-white w-2/3 rounded-lg m-1 shadow-xl text-left h-screen">
        <div class="m-auto m-3 p-2" v-if="true">
          <div>
            <div class="flex flex-row justify-between">
              <h1 class="text-black text-2xl font-medium">
                {{ projects[0].name }}
              </h1>
              <div>
                <button
                    class="p-2.5 ml-2 text-sm font-medium text-gray-500 rounded-3xl hover:bg-gray-200"
                    data-dropdown-toggle="dropdown2">
                  <svg class="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24"
                       xmlns="http://www.w3.org/2000/svg">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                          d="M12 5v.01M12 12v.01M12 19v.01M12 6a1 1 0 110-2 1 1 0 010 2zm0 7a1 1 0 110-2 1 1 0 010 2zm0 7a1 1 0 110-2 1 1 0 010 2z"></path>
                  </svg>
                  <span class="sr-only">Search</span>
                </button>
              </div>

              <div id="dropdown2"
                   class="hidden z-10 text-left w-44 bg-white rounded-lg divide-y divide-gray-100 shadow dark:bg-gray-700">
                <ul class="py-1 text-sm text-gray-700 dark:text-gray-200" aria-labelledby="dropdownDefault">
                  <li>
                    <a href="#" class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Edit
                      Project</a>
                  </li>
                  <li>
                    <a href="#" class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Delete</a>
                  </li>
                </ul>
              </div>
            </div>

            <div class="text-m font-normal mb-3">
              <h1>
                Aangemaakt op: {{ projects[0].created.toLocaleDateString("nl", this.options) }}
              </h1>
              <h1>
                Projecteigenaar: U
              </h1>
            </div>

            <hr>
            <div>
              <img class="rounded-lg mt-3 m-auto" :src="require('../assets/img/FlorijnBanner.jpeg')"
                   style="display:block; max-height:200px; width: 100%; object-fit: cover">
              <p class="mb-3 mt-3 font-normal text-gray-600 dark:text-gray-400">
                {{ projects[0].description }}
              </p>
            </div>
          </div>
        </div>
        <div class="m-auto place-items-center" v-else>
          <div>
            <img class="h-48 m-auto" :src="require('../assets/img/undraw_void_-3-ggu.svg')">
          </div>
          <div>
            <h1 class="text-2xl font-semibold">Geen project geselecteerd</h1>
            <h3 class="text-lg">Een project selecteren om alle details te bekijken</h3>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ProjectsOverview",
  data() {
    return {
      projects: [
        {
          id: 1,
          name: "Project Dennis",
          description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer elementum, odio id commodo tempor, est velit rhoncus orci, eget dictum magna diam sit amet enim. Phasellus ac ex ullamcorper, condimentum purus vitae, rhoncus sem. Sed imperdiet imperdiet ornare. Nunc sit amet imperdiet erat. Vestibulum eleifend lectus lacinia faucibus pretium. Sed eu tellus ac ex tincidunt ornare. Vivamus non fermentum velit. Donec imperdiet consequat risus, quis vestibulum quam imperdiet ut. Maecenas tempus convallis erat, a suscipit quam condimentum scelerisque. Suspendisse nec nibh pharetra, scelerisque metus eget, eleifend mauris. Phasellus ut neque sed orci rhoncus vehicula. Morbi ipsum mi, suscipit vulputate libero vitae, mattis tempor lorem.",
          status: 0,
          created: new Date(),
          skills: [null]
        },
        {
          id: 1,
          name: "Project Simon",
          description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer elementum, odio id commodo tempor, est velit rhoncus orci, eget dictum magna diam sit amet enim. Phasellus ac ex ullamcorper, condimentum purus vitae, rhoncus sem. Sed imperdiet imperdiet ornare. Nunc sit amet imperdiet erat. Vestibulum eleifend lectus lacinia faucibus pretium. Sed eu tellus ac ex tincidunt ornare. Vivamus non fermentum velit. Donec imperdiet consequat risus, quis vestibulum quam imperdiet ut. Maecenas tempus convallis erat, a suscipit quam condimentum scelerisque. Suspendisse nec nibh pharetra, scelerisque metus eget, eleifend mauris. Phasellus ut neque sed orci rhoncus vehicula. Morbi ipsum mi, suscipit vulputate libero vitae, mattis tempor lorem.",
          status: 1,
          created: new Date(),
          skills: [null]
        },
        {
          id: 1,
          name: "Project Maajid",
          description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer elementum, odio id commodo tempor, est velit rhoncus orci, eget dictum magna diam sit amet enim. Phasellus ac ex ullamcorper, condimentum purus vitae, rhoncus sem. Sed imperdiet imperdiet ornare. Nunc sit amet imperdiet erat. Vestibulum eleifend lectus lacinia faucibus pretium. Sed eu tellus ac ex tincidunt ornare. Vivamus non fermentum velit. Donec imperdiet consequat risus, quis vestibulum quam imperdiet ut. Maecenas tempus convallis erat, a suscipit quam condimentum scelerisque. Suspendisse nec nibh pharetra, scelerisque metus eget, eleifend mauris. Phasellus ut neque sed orci rhoncus vehicula. Morbi ipsum mi, suscipit vulputate libero vitae, mattis tempor lorem.",
          status: 2,
          created: new Date(),
          skills: [null]
        },
        {
          id: 1,
          name: "Project Frank",
          description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer elementum, odio id commodo tempor, est velit rhoncus orci, eget dictum magna diam sit amet enim. Phasellus ac ex ullamcorper, condimentum purus vitae, rhoncus sem. Sed imperdiet imperdiet ornare. Nunc sit amet imperdiet erat. Vestibulum eleifend lectus lacinia faucibus pretium. Sed eu tellus ac ex tincidunt ornare. Vivamus non fermentum velit. Donec imperdiet consequat risus, quis vestibulum quam imperdiet ut. Maecenas tempus convallis erat, a suscipit quam condimentum scelerisque. Suspendisse nec nibh pharetra, scelerisque metus eget, eleifend mauris. Phasellus ut neque sed orci rhoncus vehicula. Morbi ipsum mi, suscipit vulputate libero vitae, mattis tempor lorem.",
          status: 2,
          created: new Date(),
          skills: [null]
        },
        {
          id: 1,
          name: "Project Ilias",
          description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer elementum, odio id commodo tempor, est velit rhoncus orci, eget dictum magna diam sit amet enim. Phasellus ac ex ullamcorper, condimentum purus vitae, rhoncus sem. Sed imperdiet imperdiet ornare. Nunc sit amet imperdiet erat. Vestibulum eleifend lectus lacinia faucibus pretium. Sed eu tellus ac ex tincidunt ornare. Vivamus non fermentum velit. Donec imperdiet consequat risus, quis vestibulum quam imperdiet ut. Maecenas tempus convallis erat, a suscipit quam condimentum scelerisque. Suspendisse nec nibh pharetra, scelerisque metus eget, eleifend mauris. Phasellus ut neque sed orci rhoncus vehicula. Morbi ipsum mi, suscipit vulputate libero vitae, mattis tempor lorem.",
          status: 0,
          created: new Date(),
          skills: [null]
        }
      ],
      options: { year: 'numeric', month: 'long', day: 'numeric' }
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
  methods: {
    dateFormatter(date){

    }
  }
}
</script>

<style scoped>

</style>