<template>

  <section>
    <div class="flex flex-col items-center justify-center mx-auto  lg:py-0">
      <div class="w-full bg-white rounded-lg md:mt-0 sm:max-w-xl xl:p-0">
        <div class="mt-10 space-y-5">
          <form class="space-y-4 md:space-y-6" action="#">
            <div>
              <div class="grid md:grid-cols-3 md:gap-6">
                <div class="relative z-0 mb-6 w-full group">
                  <label for="floating_first_name"
                         class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Voornaam</label>
                  <input v-model="first_name" type="text" name="floating_first_name" id="floating_first_name"
                         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                         placeholder="John" required/>
                </div>
                <div class="relative z-0 mb-6 w-full group">
                  <label for="floating_first_name"
                         class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Tussenvoegsel
                    (optioneel)</label>
                  <input v-model="preposition" type="text" name="floating_first_name" id="floating_first_name"
                         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                         placeholder="van" required/>
                </div>
                <div class="relative z-0 mb-6 w-full group">
                  <label for="floating_last_name"
                         class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Achternaam</label>
                  <input v-model="last_name" type="text" name="floating_last_name" id="floating_last_name"
                         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                         placeholder="Doe" required/>
                </div>
              </div>
              <div class="grid md:grid-cols-2 md:gap-6">
                <div>
                  <label for="email" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Email
                    adres</label>
                  <input v-model="email" type="email" name="email" id="email" class="bg-gray-50 border border-gray-300 text-gray-900
                sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5
                dark:focus:border-blue-500" placeholder="name@company.com" required="">
                </div>
                <div>
                  <label for="phone" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Telefoonnummer</label>
                  <input v-model="phone" type="phone" name="phone" id="phone" class="bg-gray-50 border border-gray-300 text-gray-900
                sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5
                dark:focus:border-blue-500" placeholder="06 12 34 56 78" required="">
                </div>
              </div>
            </div>
            <div class="grid md:grid-cols-2 md:gap-6">

              <div>
                <label for="password" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Wachtwoord</label>
                <input v-model="password" type="password" name="password" id="password" placeholder="••••••••"
                       class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                       required="">
              </div>
              <div>
                <label for="password" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Herhaal
                  Wachtwoord</label>
                <input v-model="repeatPassword" type="password" name="password" id="password" placeholder="••••••••"
                       class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                       required="">
              </div>

            </div>

            <div class="flex items-center justify-between grid md:grid-cols-2 md:gap-6">
              <div>
                <label for="countries"
                       class="block mb-2 text-left text-sm font-medium text-gray-900 dark:text-gray-400">Kies een
                  item</label>
                <select v-model="gender" id="countries"
                        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                  <option selected>Choose a gender</option>
                  <option value="1">Male</option>
                  <option value="2">Female</option>
                  <option value="3">I'd rather not say</option>
                  <option value="4">Other</option>
                </select>
              </div>
            </div>


          </form>
          <button @click="createRequest" id="AanmakenKnop" class="w-full rounded-lg font-medium bg-white px-4 py-1.5 text-white"
                  style="background-color:#F15922 "> Aanmaken
          </button>
          <button @click="this.$router.push('/admin/admins')"
                  class="w-full rounded-lg font-medium bg-white px-4 py-1.5 text-white"
                  style="background-color:red "> Annuleren
          </button>

        </div>
      </div>
    </div>
  </section>
</template>

<script>

import {useToast} from "vue-toastification";
import axios from "axios";

export default {
  name: "CreateAdmins.vue",
  data() {
    return {
      email: null,
      password: null,
      repeatPassword: null,
      first_name: null,
      preposition: null,
      last_name: null,
      phone: null,
      userType: 0,
      gender: null,
      toast: useToast(),
    }
  },

  methods: {
    //TODO: make it so the button cant be pressed after succesfull creation
    async createRequest() {
      console.log("test")
      let request = await axios.post(process.env.VUE_APP_API_URL + "/api/authorization/register", {
        email: this.email,
        password: this.password,
        first_name: this.first_name,
        second_name: this.preposition,
        last_name: this.last_name,
        phone: this.phone,
        userType: this.userType,
        admin_id: null,
        client_id: null,
        specialist: null
      }).catch((err) => {
        console.log(err)
        this.toast.error("check gegevens na")
      })

      if (request.status == 200){
        this.toast.success("Admin succesvol gecreeerd")
      }
    }
  }
}
</script>

<style scoped>

</style>