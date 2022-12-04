<template>
  <div class="bottom-rounded" style='
  background-image: url("https://images.unsplash.com/photo-1557682260-96773eb01377?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2258&q=80");
  height: 300px'>
    <div class="max-w-6xl m-auto flex flex-row rounded-lg">
      <div class="bg-white h-screen w-1/3 p-3 rounded-lg m-1 shadow-xl">
        <div class="mb-3">
          <div class="flex flex-row justify-between items-center mb-4">
            <div>
              <h1 class="text-black font-medium text-3xl text-left">Projects</h1>
            </div>
            <div>
              <a href="#" class="p-2 bg-orange-500 text-white rounded-lg">
                <i class="fa-solid fa-plus"></i> New Project
              </a>
            </div>

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
                     placeholder="Zoeken" required>
            </div>
            <button type="submit"
                    class="p-2.5 ml-2 text-sm font-medium text-white bg-orange-500 rounded-lg border border-orange-600 hover:bg-orange-600 focus:ring-4 focus:outline-none focus:ring-orange-300 ">
              <svg class="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24"
                   xmlns="http://www.w3.org/2000/svg">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                      d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"></path>
              </svg>
              <span class="sr-only">Zoeken</span>
            </button>
          </form>

        </div>
        <div class="text-left mt-1 p-1" v-for="project in projects" :key="project">
          <div>
            <div class="flex flex-row">
              <div v-if="project.status === 0"><i class="text-red-500 fa-solid fa-circle fa-2xs mx-1"></i></div>
              <div v-else-if="project.status === 1"><i class="text-yellow-400 fa-solid fa-2xs fa-circle mx-1"></i></div>
              <div v-else><i class="text-green-500 fa-solid fa-circle fa-2xs mx-1"></i></div>
              <h1 class="font-medium text-l">{{ project.name }}</h1>
            </div>
            <div v-if="project.description.length<80"> project.description</div>
            <div v-else>{{ project.description.substring(0, 80) + ".." }}</div>
          </div>
        </div>
      </div>
      <div class="bg-white h-screen w-2/3 rounded-lg m-1 shadow-xl text-left content-center">
        <div v-if="true">
          <img class="" :src="required('.../assets/img/undraw_void_-3-ggu.svg')">
          <h1>Geen project geselecteerd</h1>
          <h3>Een project selecteren om alle details te bekijken</h3>
        </div>
        <div v-else>
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
      ]
    }

  }
}
</script>

<style scoped>

</style>