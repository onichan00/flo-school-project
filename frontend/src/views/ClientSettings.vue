<template>
  <!--  Full Page-->
  <div style='background-image: linear-gradient(to right, #F15922 , #f17822);
  height: 400px;
  border-radius: 0% 0% 2% 2%;'>

    <!--    Two Columns-->
    <div class="max-w-6xl m-auto flex flex-row rounded-lg">

      <!--      settings Section-->
      <div class="bg-white max-h-screen w-1/4 p-3 rounded-lg m-1 shadow-lg overflow-y">

        <!--        settings Header-->
        <div class="mb-3 m-2">
          <div class="flex flex-row justify-between items-center mb-1">
            <div>
              <h1 class="text-black font-medium text-3xl mb-1text-left">Instellingen</h1>
            </div>
          </div>
        </div>

        <hr class="mb-1">

        <div class="max-h-full">
          <div
              class="text-left text-gray-800 rounded-lg p-2 cursor-pointer transition ease-in-out delay-0 bg-white-500 hover:-translate-y-1 hover:bg-gray-50 hover:shadow-sm duration-300"
              v-for="(setting) in this.settings" :key="setting"
              :class="[ selectedSettings?.id === setting.id ? selectedRowStyle : notSelectedRowStyle ]">
            <div @click="selectProject(setting)">
              <div class="flex flex-row justify-between">
                <div class="flex flex-row">
                  <svg v-if="setting.id === 1" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                       stroke-width="1.5" stroke="currentColor" class="text-gray-400 w-7 h-7 ">
                    <path stroke-linecap="round" stroke-linejoin="round"
                          d="M17.982 18.725A7.488 7.488 0 0012 15.75a7.488 7.488 0 00-5.982 2.975m11.963 0a9 9 0 10-11.963 0m11.963 0A8.966 8.966 0 0112 21a8.966 8.966 0 01-5.982-2.275M15 9.75a3 3 0 11-6 0 3 3 0 016 0z"/>
                  </svg>
                  <svg v-if="setting.id === 3" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                       stroke-width="1.5" stroke="currentColor" class="text-gray-400 w-7 h-7">
                    <path stroke-linecap="round" stroke-linejoin="round"
                          d="M15.75 5.25a3 3 0 013 3m3 0a6 6 0 01-7.029 5.912c-.563-.097-1.159.026-1.563.43L10.5 17.25H8.25v2.25H6v2.25H2.25v-2.818c0-.597.237-1.17.659-1.591l6.499-6.499c.404-.404.527-1 .43-1.563A6 6 0 1121.75 8.25z"/>
                  </svg>
                  <svg v-if="setting.id === 2" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                       stroke-width="1.5" stroke="currentColor" class="text-gray-400 w-7 h-7">
                    <path stroke-linecap="round" stroke-linejoin="round"
                          d="M4.5 12a7.5 7.5 0 0015 0m-15 0a7.5 7.5 0 1115 0m-15 0H3m16.5 0H21m-1.5 0H12m-8.457 3.077l1.41-.513m14.095-5.13l1.41-.513M5.106 17.785l1.15-.964m11.49-9.642l1.149-.964M7.501 19.795l.75-1.3m7.5-12.99l.75-1.3m-6.063 16.658l.26-1.477m2.605-14.772l.26-1.477m0 17.726l-.26-1.477M10.698 4.614l-.26-1.477M16.5 19.794l-.75-1.299M7.5 4.205L12 12m6.894 5.785l-1.149-.964M6.256 7.178l-1.15-.964m15.352 8.864l-1.41-.513M4.954 9.435l-1.41-.514M12.002 12l-3.75 6.495"/>
                  </svg>
                  <h1 class="font-medium text-lg ml-2"> {{ setting.name }}</h1>
                </div>
                <div>
                  <div id="dropdown"
                       class="hidden z-10 text-left w-44 bg-white rounded-lg divide-y divide-gray-100 shadow dark:bg-gray-700">
                    <ul class="py-1 text-sm text-gray-700 dark:text-gray-200" aria-labelledby="dropdownDefault">
                      <li>
                        <a href="#"
                           class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Edit
                          settings</a>
                      </li>
                      <li>
                        <a href="#"
                           class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Delete</a>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
              <div id="x" class="text-gray-500 pb-1">{{ settings.description }}</div>
            </div>
          </div>

        </div>
      </div>

      <div class="bg-white w-3/4 rounded-lg m-1 text-left max-h-fit shadow-lg">

        <div class="px-4 py-3 h-auto" v-if="selectedSettings" v-bind="selectedSettings">
          <div class="bg-white rounded-lg dark:bg-gray-700">
            <div class="flex flex-col text-left">
              <div class="flex items-start pt-2 mb-1 justify-between rounded-t dark:border-gray-600">
                <h3 class="text-3xl 1 font-medium text-gray-900 dark:text-white">Profiel</h3>
              </div>
              <p class="text-md font-normal text-gray-600 pb-3">Deze informatie zal publiekelijk getoond worden dus wees
                voorzichtig met wat u deelt.</p>
            </div>

            <hr>

            <form class="h-fit pt-3">
              <div class="mb-2">
                <label class="block mb-2 text-sm font-medium text-gray-900" for="file_input">Huidige Profielfoto</label>
                <img class="mb-2 w-36 h-36 rounded-lg border-2"
                     :src="require('@/assets/img/undraw_coffee_with_friends_3cbj.svg')" alt="Profielfoto">
                <label class="block mb-2 text-sm font-medium text-gray-900" for="file_input">Upload Profielfoto</label>
                <input
                    class="block w-full text-sm text-gray-900 border border-gray-300 rounded-lg cursor-pointer bg-gray-50 dark:text-gray-400 focus:outline-none dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400"
                    aria-describedby="file_input_help" id="file_input" type="file">
                <p class="mt-1 text-sm text-gray-500 dark:text-gray-300" id="file_input_help">SVG, PNG of JPG</p>
              </div>
              <div class="grid md:grid-cols-3 md:gap-6">
                <div class="relative z-0 mb-6 w-full group">
                  <label for="floating_first_name"
                         class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Voornaam
                    name</label>
                  <input @change="changeButtonToOne" v-model="this.user.first_name" type="text"
                         name="floating_first_name"
                         id="floating_first_name"
                         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                         placeholder="John" required/>
                </div>
                <div class="relative z-0 mb-6 w-full group">
                  <label for="floating_first_name"
                         class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Tussenvoegsel
                    (optioneel)</label>
                  <input @change="changeButtonToOne" v-model="this.user.second_name" type="text"
                         name="floating_first_name"
                         id="floating_first_name"
                         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                         placeholder="van" required/>
                </div>
                <div class="relative z-0 mb-6 w-full group">
                  <label for="floating_last_name"
                         class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Achternaam</label>
                  <input @change="changeButtonToOne" v-model="this.user.last_name" type="text" name="floating_last_name"
                         id="floating_last_name"
                         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                         placeholder="Doe" required/>
                </div>
              </div>
              <div class="mb-4">
                <label for="description"
                       class="block mb-2 text-md font-medium text-gray-900 dark:text-white">Bio</label>
                <textarea @change="changeButtonToOne" v-model="this.user.bio" id="description" rows="4"
                          class="block p-2.5 w-full h-24 text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-orange-500 focus:border-orange-500"
                          placeholder="Schrijf hier de beschrijving..."
                ></textarea>
              </div>
            </form>

            <hr>

            <div class="w-full mt-4">
              <div v-if="buttonType === 1" class="float-right space-x-2 border-gray-200 mb-4">
                <button @click="updateClientProfile"
                        type="button"
                        class="p-2 text-md font-medium text-white bg-gradient-to-r from-orange-400 via-orange-500 to-orange-600 hover:bg-gradient-to-br rounded-lg"
                >
                  Bewerkingen opslaan
                </button>
              </div>
              <div v-else-if="buttonType === 2" class="float-right space-x-2 border-gray-200 mb-4">
                <button disabled type="button" class="cursor-not-allowed p-2 text-md font-medium text-gray-400 bg-gray-200 rounded-lg">
                  <svg role="status" class="inline mr-3 w-5 h-5 text-gray-400 animate-spin" viewBox="0 0 100 101" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M100 50.5908C100 78.2051 77.6142 100.591 50 100.591C22.3858 100.591 0 78.2051 0 50.5908C0 22.9766 22.3858 0.59082 50 0.59082C77.6142 0.59082 100 22.9766 100 50.5908ZM9.08144 50.5908C9.08144 73.1895 27.4013 91.5094 50 91.5094C72.5987 91.5094 90.9186 73.1895 90.9186 50.5908C90.9186 27.9921 72.5987 9.67226 50 9.67226C27.4013 9.67226 9.08144 27.9921 9.08144 50.5908Z" fill="#E5E7EB"/>
                    <path d="M93.9676 39.0409C96.393 38.4038 97.8624 35.9116 97.0079 33.5539C95.2932 28.8227 92.871 24.3692 89.8167 20.348C85.8452 15.1192 80.8826 10.7238 75.2124 7.41289C69.5422 4.10194 63.2754 1.94025 56.7698 1.05124C51.7666 0.367541 46.6976 0.446843 41.7345 1.27873C39.2613 1.69328 37.813 4.19778 38.4501 6.62326C39.0873 9.04874 41.5694 10.4717 44.0505 10.1071C47.8511 9.54855 51.7191 9.52689 55.5402 10.0491C60.8642 10.7766 65.9928 12.5457 70.6331 15.2552C75.2735 17.9648 79.3347 21.5619 82.5849 25.841C84.9175 28.9121 86.7997 32.2913 88.1811 35.8758C89.083 38.2158 91.5421 39.6781 93.9676 39.0409Z" fill="currentColor"/>
                  </svg>
                  Bewerkingen aan het opslaan...
                </button>
              </div>

              <div v-else class="float-right space-x-2 border-gray-200 mb-4">
                <button
                    type="button"
                    class="cursor-not-allowed p-2 text-md font-medium text-gray-400 bg-gray-200 rounded-lg"
                    disabled
                >
                  Bewerkingen opslaan
                </button>
              </div>
            </div>
          </div>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import {useToast} from "vue-toastification";

export default {
  name: "ClientSettings",
  data() {
    return {
      userId: localStorage.getItem('id'),
      user: [],
      oldUserData: [],
      settings: [
        {name: "Profiel", id: 1},
        {name: "Account", id: 2},
        {name: "Wachtwoord", id: 3},
      ],
      selectedSettings: {name: "Profiel", id: 1},
      selectedRowStyle: "bg-gray-100 shadow-sm text-black",
      notSelectedRowStyle: "text-gray-900",
      toast: useToast(),
      buttonType: 0
    }
  },
  created() {
    this.getUserData()
  },
  methods: {
    getUserData() {
      axios.get(process.env.VUE_APP_API_URL + `/api/users/${this.userId}`)
          .then((res) => {
            this.user = res.data;
            this.oldUserData = res.data;
            console.log(res.data)
          })
          .catch((err) => {
            console.log(err);
          })
    },

    async updateClientProfile() {
      const toast = useToast()

      await axios.put(process.env.VUE_APP_API_URL + `/api/users/update`,
          {
            id: this.user.id,
            email: this.user.email,
            password: this.user.password,
            first_name: this.user.first_name,
            second_name: this.user.second_name,
            last_name: this.user.last_name,
            phone: this.user.phone,
            userType: this.user.userType,
          })
          .then((res) => {
            this.changeButtonToTwo()
            // Get the current time in seconds
            let timer = 2;

            // Set an interval to run every 1000 milliseconds (1 second)
            let interval = setInterval(function () {
              // Decrement the timer by 1
              timer--;
              // If the timer has reached 0, clear the interval and display a message
              if (timer <= 0) {
                clearInterval(interval);
                this.buttonType = 0;
                toast.success("Profiel succesvol bijgewerkt")
                location.reload()
              }
            }, 1000);
          })
          .catch((err) => {
            this.changeButtonToTwo()
            // Get the current time in seconds
            let timer = 2;

            // Set an interval to run every 1000 milliseconds (1 second)
            let interval = setInterval(function () {
              // Decrement the timer by 1
              timer--;
              // If the timer has reached 0, clear the interval and display a message
              if (timer <= 0) {
                clearInterval(interval);
                this.buttonType = 0;
                toast.error("Er is iets misgegaan, zie: " + err.message)
              }
            }, 1000);
          })
    },

    changeButtonToOne() {
      this.buttonType = 1;
    },

    changeButtonToTwo() {
      this.buttonType = 2;
    },

    changeButtonToZero() {
      this.buttonType = 0;
    },

    selectProject(element) {
      if (element === this.selectedSettings) {
        return null;
      }
      this.selectedSettings = element;
    },
  },
}
</script>

<style scoped>

</style>