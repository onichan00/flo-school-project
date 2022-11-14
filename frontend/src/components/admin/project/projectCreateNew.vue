<template>
  <!-- Main modal -->
  <div id="projectCreate-modal" tabindex="-1" aria-hidden="true"
       class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 w-full md:inset-0 h-modal md:h-full justify-center items-center">
    <div class="relative p-4 w-full max-w-md h-full md:h-auto">
      <!-- Modal content -->
      <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
        <button type="button"
                class="absolute top-3 right-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-800 dark:hover:text-white"
                data-modal-toggle="projectCreate-modal">
          <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20"
               xmlns="http://www.w3.org/2000/svg">
            <path fill-rule="evenodd"
                  d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
                  clip-rule="evenodd"></path>
          </svg>
          <span class="sr-only">Close modal</span>
        </button>
        <div class="py-6 px-6 lg:px-8">
          <h3 class="mb-4 text-xl font-medium text-gray-900 dark:text-white">Create new project</h3>
          <form class="w-full max-w-sm">
            <div class="md:flex md:items-center mb-6">
              <div class="md:w-1/3">
                <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-full-name">
                  Project name
                </label>
              </div>
              <div class="md:w-2/3">
                <input
                    class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight outline-orange-500 focus:bg-white focus:border-orange-500"
                    id="inline-full-name" type="text" placeholder="Choose a placeholder">
              </div>
            </div>
            <div class="md:flex md:items-center mb-6">
              <div class="md:w-1/3">
                <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-password">
                  Description
                </label>
              </div>
              <div class="md:w-2/3">
                <textarea
                    class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-orange-500"
                    placeholder="Choose a Description"/>
              </div>
            </div>

            <div class="md:flex md:items-center mb-6">
              <div class="md:w-1/3">
                <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-password">
                  Project status
                </label>
              </div>
              <div class="md:w-2/3">
                <select id="availableSpecialists"
                        class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-orange-500">
                  <option selected>In review</option>
                  <option>In progress</option>
                  <option>Done</option>
                  <option>Cancled</option>
                </select>
              </div>
            </div>

            <div class="md:flex md:items-center mb-6">
              <div class="md:w-1/3">
                <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-password">
                  Specialists
                </label>
              </div>
              <div class="md:w-2/3">
                <select id="availableSpecialists"
                        class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-orange-500">
                  <option selected>Choose a specialist</option>
                  <option v-for="specialist in availableSpecialists" :key="specialist.id">{{
                      specialistFullName(specialist)
                    }}
                  </option>
                </select>
              </div>
            </div>

            <div class="md:flex md:items-center mb-6">
              <div class="md:w-1/3">
                <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-password">
                  Client
                </label>
              </div>
              <div class="md:w-2/3">
                <select id="availableSpecialists"
                        class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-orange-500">
                  <option selected>Choose a client</option>
                  <option v-for="client in clients" :key="client.id">{{
                      client.company
                    }}
                  </option>
                </select>
              </div>
            </div>
            <button class="bg-[#F05822] text-white font-bold py-2 px-4 rounded">
              Create project
            </button>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import {specialistFullName} from "@/plugins/textManipulation";

export default {
  name: "projectCreateNew",
  inject: ['specialists', 'clients'],

  data() {
    return {
      availableSpecialists: this.specialists,
      clients: this.clients

    }
  },

  methods: {
    specialistFullName,

  }
}
</script>

<style scoped>

</style>