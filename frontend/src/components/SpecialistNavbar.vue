<template>


  <nav class="sticky top-0 p-2 dark:bg-gray-900 "
       style='background-image: linear-gradient(to right, #F15922 , #f17822)'>
    <div class="container flex flex-wrap items-center justify-between mx-auto">
      <div class="flex flex-row">
        <a @click="this.$router.push('/specialist/dashboard')" class="flex items-center mr-20">
          <span class="cursor-pointer self-center text-2xl text-white font-bold whitespace-nowrap dark:text-white">FLORIJN</span>
        </a>

        <div class="items-center justify-between hidden w-full md:flex md:w-auto md:order-1" id="mobile-menu-2">
          <ul class="flex flex-col text-white border border-gray-100 md:flex-row md:space-x-8 md:mt-0 md:text-sm md:font-medium md:border-0">
            <li>
              <a class="cursor-pointer block py-2 pl-3 pr-4 text-m font-bold hover:bg-gray-100 border-b-2 md:hover:bg-transparent md:hover:text-gray-500 md:p-0"
                 @click="this.$router.push('/specialist/projects-overview')">Projecten</a>
            </li>
            <li>
              <a href="https://florijn.com/aws/dit-zijn-wij/"
                 class="block py-2 pl-3 pr-4 text-m hover:bg-gray-100 md:hover:bg-transparent md:hover:text-gray-500 md:p-0">Over
                ons</a>
            </li>
            <li>¡
              <a href="https://florijn.com/aws/contact/"
                 class="block py-2 pl-3 pr-4 text-m hover:bg-gray-100 md:hover:bg-transparent md:hover:text-gray-500 md:p-0">Contact</a>
            </li>
            <!--            <li>-->
            <!--              <a href="#" class="block py-2 pl-3 pr-4 text-m hover:bg-gray-100 md:hover:bg-transparent md:hover:text-gray-500 md:p-0" @click="logout">Log uit</a>-->
            <!--            </li>-->
          </ul>
        </div>
      </div>
      <div class="flex items-center md:order-2">
        <button type="button"
                class="flex mr-3 text-sm bg-gray-800 rounded-full md:mr-0 focus:ring-4 focus:ring-gray-300 dark:focus:ring-gray-600"
                id="user-menu-button" aria-expanded="false" data-dropdown-toggle="user-dropdown"
                data-dropdown-placement="bottom">
          <span class="sr-only">Open user menu</span>
          <img class="w-8 h-8 rounded-full" alt="user photo" :src="this.profilePicture">
        </button>
        <!-- Dropdown menu -->
        <div
            class="z-50 hidden my-4 text-base list-none bg-white divide-y divide-gray-100 rounded shadow dark:bg-gray-700 dark:divide-gray-600 text-left"
            id="user-dropdown">
          <div class="px-4 py-3">
            <span class="block text-sm text-gray-900 dark:text-white">{{
                this.user.first_name + ' ' + this.user.last_name
              }}</span>
            <span class="block text-sm font-medium text-gray-500 truncate dark:text-gray-400">{{
                this.user.email
              }}</span>
          </div>
          <ul class="py-1" aria-labelledby="user-menu-button">
            <li>
              <a @click="this.$router.push('/specialist/profile')"
                 class="block px-4 py-2 cursor-pointer text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">Profiel</a>
            </li>
            <li>
              <a @click="this.$router.push('/specialist/settings/'+ this.userId)"
                 class="block px-4 py-2 cursor-pointer text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">Instellingen</a>
            </li>
            <li>
              <a href="#"
                 class="block px-4 py-2 cursor-pointer text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white"
                 @click="logout">Log Uit</a>
            </li>
          </ul>
        </div>
        <button data-collapse-toggle="mobile-menu-2" type="button"
                class="inline-flex items-center p-2 ml-1 text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600"
                aria-controls="mobile-menu-2" aria-expanded="false">
          <span class="sr-only">Open main menu</span>
          <svg class="w-6 h-6" aria-hidden="true" fill="currentColor" viewBox="0 0 20 20"
               xmlns="http://www.w3.org/2000/svg">
            <path fill-rule="evenodd"
                  d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z"
                  clip-rule="evenodd"></path>
          </svg>
        </button>
      </div>
    </div>
  </nav>


</template>

<script>
import axios from "axios";

export default {
  name: "ClientNavbar",
  data() {
    return {
      userId: localStorage.getItem('id'),
      user: [],
      profilePicture: ""
    }
  },
  created() {
    this.getUserData()
    this.getProfilePicture()
  },
  methods: {
    async getProfilePicture() {
      await axios.get(process.env.VUE_APP_API_URL + `/api/files/list/${this.userId}`)
          .then((res) => {
            if (res.data.length > 0) {
              fetch(process.env.VUE_APP_API_URL + `/api/files/${res.data[0].id}`)
                  .then(response => {
                    if (response.ok) return response.blob();
                  })
                  .then(blob => {
                    this.profilePicture = URL.createObjectURL(blob)
                  })
            }
          })
          .catch((err) => {
            console.log(err);
          })
    },

    logout() {
      localStorage.clear()
      this.$router.go()
    },

    getUserData() {
      axios.get(process.env.VUE_APP_API_URL + `/api/users/${this.userId}`)
          .then((res) => {
            this.user = res.data;
            console.log(res.data)
          })
          .catch((err) => {
            console.log(err);
          })

      console.log(this.user)
    },
  },
  computed: {}
}
</script>

<style scoped>

nav {
  z-index: 1000;
}
</style>