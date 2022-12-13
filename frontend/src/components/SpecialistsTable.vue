<template>
  <br>
  <div id="specialistsTable" class="overflow-x-auto relative">
    <div class="flex justify-between items-center pb-4  dark:bg-gray-900">
      <button id="dropdownDefault" data-dropdown-toggle="dropdown"
              class="bg-gray-50 border border-gray-300 text-gray-900 hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2.5 text-center inline-flex items-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
              type="button">Filter
        <svg class="ml-2 w-4 h-4" aria-hidden="true" fill="none" stroke="currentColor" viewBox="0 0 24 24"
             xmlns="http://www.w3.org/2000/svg">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 9l-7 7-7-7"></path>
        </svg>
      </button>
      <!-- Dropdown menu -->
      <div id="dropdown"
           class="hidden z-10 w-44 bg-white rounded text-left divide-y divide-gray-100 shadow dark:bg-gray-700">
        <ul class="py-1 text-sm text-gray-700 dark:text-gray-200" aria-labelledby="dropdownDefault">
          <li>
            <a href="#" class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Name</a>
          </li>
          <li>
            <a href="#" class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Email</a>
          </li>
          <li>
            <a href="#"
               class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Position</a>
          </li>
          <li>
            <a href="#"
               class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Available</a>
          </li>
        </ul>
      </div>
      <label for="table-search" class="sr-only">Search</label>
      <div class="relative">
        <div class="flex absolute inset-y-0 left-0 items-center pl-3 pointer-events-none">
          <svg class="w-5 h-5 text-gray-500 dark:text-gray-400" aria-hidden="true" fill="currentColor"
               viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
            <path fill-rule="evenodd"
                  d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z"
                  clip-rule="evenodd"></path>
          </svg>
        </div>
        <input type="text" id="table-search-users"
               class="block p-2 pl-10 w-80 text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-200 focus:ring-orange-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
               placeholder="Search for Specialists">
      </div>
    </div>
    <div class="overflow-x-auto relative shadow-md border border-gray-200 sm:rounded-lg">
      <table class="w-full text-sm rounded-md text-left text-gray-500 dark:text-gray-400">
        <thead class="text-xs border-b text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
        <tr>

          <th scope="col" class="py-3 px-6">
            Name
          </th>
          <th scope="col" class="py-3 px-6">
            <!--              Position-->
          </th>
          <th scope="col" class="py-3 px-6">
            Status
          </th>
          <th scope="col" class="py-3 px-6">
            Action
          </th>
        </tr>
        </thead>
        <tbody>

        <tr v-for="specialist in specialists" :key="specialist.id" @click="selectItem(specialist)"
            class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-orange-50 dark:hover:bg-gray-600">

          <th scope="row" class="flex items-center py-4 px-6 text-gray-900 whitespace-nowrap dark:text-white">
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
            <a v-on:click="toUser(specialist.id)" class="font-medium text-orange-500 hover:underline"
               data-modal-toggle="defaultModal">Edit
              user</a>
          </td>
        </tr>

        </tbody>

      </table>

    </div>

  </div>

  <div id="defaultModal" tabindex="-1" aria-hidden="true"
       class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 justify-center items-center p-4 w-full md:inset-0 h-modal md:h-full">
    <div class="relative w-full max-w-2xl h-full md:h-auto">
      <!-- Modal content -->
      <form action="#" class="relative bg-white rounded-lg shadow dark:bg-gray-700">
        <!-- Modal header -->
        <div class="flex justify-between items-start p-4 rounded-t border-b dark:border-gray-600">
          <h3 class="text-xl font-semibold text-gray-900 dark:text-white">
            Edit user (id = {{ specialists.id }})
          </h3>
          <button type="button"
                  class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white"
                  data-modal-toggle="defaultModal">
            <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd"
                    d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
                    clip-rule="evenodd"></path>
            </svg>
          </button>
        </div>
        <!-- Modal body -->
        <div class="p-6 space-y-6">
          <div class="text-left grid grid-cols-6 gap-6">
            <div class="col-span-6 sm:col-span-3">
              <label for="first-name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">First
                Name</label>
              <input type="text" name="first-name" id="first-name"
                     class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-blue-600 focus:border-blue-600 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                     placeholder="Dennis">
            </div>
            <div class="col-span-6 sm:col-span-3">
              <label for="last-name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Last
                Name</label>
              <input type="text" name="last-name" id="last-name"
                     class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-blue-600 focus:border-blue-600 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                     placeholder="Moes">
            </div>
            <div class="col-span-6 sm:col-span-3">
              <label for="email" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Email</label>
              <input type="email" name="email" id="email"
                     class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-blue-600 focus:border-blue-600 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                     placeholder="denniscmoes@gmail.com">
            </div>
            <div class="col-span-6 sm:col-span-3">
              <label for="phone-number" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Phone
                Number</label>
              <input type="text" name="phone-number" id="phone-number"
                     class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-blue-600 focus:border-blue-600 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                     placeholder="+31 6 12345678">
            </div>
            <div class="col-span-6 sm:col-span-3">
              <label for="department"
                     class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Position</label>
              <input type="text" name="department" id="department"
                     class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-blue-600 focus:border-blue-600 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                     placeholder="React Developer">
            </div>
            <div class="col-span-6 sm:col-span-3">
              <label for="company" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Company</label>
              <input type="text" name="company" id="company"
                     class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-blue-600 focus:border-blue-600 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                     placeholder="Meta">
            </div>
            <div class="col-span-6 sm:col-span-3">
              <label for="current-password" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Current
                Password</label>
              <input type="password" name="current-password" id="current-password"
                     class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-blue-600 focus:border-blue-600 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                     placeholder="••••••••">
            </div>
            <div class="col-span-6 sm:col-span-3">
              <label for="new-password" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">New
                Password</label>
              <input type="password" name="new-password" id="new-password"
                     class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-blue-600 focus:border-blue-600 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                     placeholder="••••••••">
            </div>
          </div>
        </div>
        <!-- Modal footer -->
        <div class="flex items-center p-6 space-x-2 rounded-b border-t border-gray-200 dark:border-gray-600">
          <button type="submit"
                  class="text-white bg-orange-500 hover:bg-orange-600 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">
            Save all
          </button>
        </div>
      </form>
    </div>
  </div>

  <br>

</template>

<script>
import axios from "axios";

export default {
  name: "ComponentsSpecialistsTable",

  data() {
    return {
      // specialists: [
      //   {
      //     'id': 1,
      //     'firstName': "Dennis Moes",
      //     'email': "denniscmoes@gmail.com",
      //     'position': "React Developer",
      //     'status': "Online",
      //     'phoneNumber': '+31612345678',
      //   }, {
      //     'id': 1,
      //     'firstName': "Dennis Moes",
      //     'email': "denniscmoes@gmail.com",
      //     'position': "React Developer",
      //     'status': "Online",
      //     'phoneNumber': '+31612345678',
      //   }, {
      //     'id': 1,
      //     'firstName': "Dennis Moes",
      //     'email': "denniscmoes@gmail.com",
      //     'position': "React Developer",
      //     'status': "Online",
      //     'phoneNumber': '+31612345678',
      //   }, {
      //     'id': 1,
      //     'firstName': "Dennis Moes",
      //     'email': "denniscmoes@gmail.com",
      //     'position': "React Developer",
      //     'status': "Online",
      //     'phoneNumber': '+31612345678',
      //   }, {
      //     'id': 1,
      //     'firstName': "Dennis Moes",
      //     'email': "denniscmoes@gmail.com",
      //     'position': "React Developer",
      //     'status': "Online",
      //     'phoneNumber': '+31612345678',
      //   }, {
      //     'id': 1,
      //     'firstName': "Dennis Moes",
      //     'email': "denniscmoes@gmail.com",
      //     'position': "React Developer",
      //     'status': "Online",
      //     'phoneNumber': '+31612345678',
      //   }, {
      //     'id': 1,
      //     'firstName': "Dennis Moes",
      //     'email': "denniscmoes@gmail.com",
      //     'position': "React Developer",
      //     'status': "Online",
      //     'phoneNumber': '+31612345678',
      //   }, {
      //     'id': 1,
      //     'firstName': "Dennis Moes",
      //     'email': "denniscmoes@gmail.com",
      //     'position': "React Developer",
      //     'status': "Online",
      //     'phoneNumber': '+31612345678',
      //   }, {
      //     'id': 1,
      //     'firstName': "Dennis Moes",
      //     'email': "denniscmoes@gmail.com",
      //     'position': "React Developer",
      //     'status': "Online",
      //     'phoneNumber': '+31612345678',
      //   }, {
      //     'id': 1,
      //     'firstName': "Dennis Moes",
      //     'email': "denniscmoes@gmail.com",
      //     'position': "React Developer",
      //     'status': "Online",
      //     'phoneNumber': '+31612345678',
      //   }, {
      //     'id': 1,
      //     'firstName': "Dennis Moes",
      //     'email': "denniscmoes@gmail.com",
      //     'position': "React Developer",
      //     'status': "Online",
      //     'phoneNumber': '+31612345678',
      //   }, {
      //     'id': 1,
      //     'firstName': "Dennis Moes",
      //     'email': "denniscmoes@gmail.com",
      //     'position': "React Developer",
      //     'status': "Online",
      //     'phoneNumber': '+31612345678',
      //   }
      // ]

      specialists: null
    }
  },

  created() {
    this.getSpecialists();
  },

  methods: {
    toUser(id) {
      this.$router.push(`/profile/${id}`).then((e) => {
        this.$router.go()
      })
    },

    async getSpecialists() {
      const id = this.$route.params.id;

      await axios.get(process.env.VUE_APP_API_URL + `/api/users/specialist`)
          .then((res) => {
            this.specialists = res.data;
          })
          .catch((err) => {
            console.log(err);
          })
    },

    selectItem(element) {
      if (element === this.selectedOffer) {
        return null;
      }

      this.selectedOffer = element;
    },
  }
}
</script>

<style scoped>
#specialistsTable {
  margin: auto;
  max-width: 1140px;
}
</style>