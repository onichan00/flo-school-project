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
                  <label for="floating_preposition"
                         class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Tussenvoegsel
                    (optioneel)</label>
                  <input v-model="preposition" type="text" name="floating_preposition" id="floating_preposition"
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
          <button @click="setAdmin" class="w-full rounded-lg font-medium bg-white px-4 py-1.5 text-white"
                  style="background-color:#F15922 "> Bijwerken
          </button>
          <button @click="deleteAdmin"
                  class="w-full rounded-lg font-medium bg-white px-4 py-1.5 text-white"
                  style="background-color:red "> Verwijderen
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
import axios from "axios";
import {useToast} from "vue-toastification";

export default {
  name: "AdminDetail",

  data() {
    return {
      // admin: null,
      id: null,
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

  async created() {
    await this.getAdmin();

    // document.querySelector("#first_name").value = this.first_name
    // document.querySelector("#second_name").value = this.second_name
    // document.querySelector("#last_name").value = this.last_name
    // document.querySelector("#email").value = this.email
    // document.querySelector("#phone").value = this.phone
    // document.querySelector("#password").value = this.password
    // document.querySelector("#password2").value = this.password
  },

  methods: {
    //TODO: make it so the update and delete button cant be pressed after succesful update/deletion
    async getAdmin() {

      if (this.$route.params.id !== undefined){
        this.id = this.$route.params.id
      }
      await axios.get(process.env.VUE_APP_API_URL + `/api/users/` + this.id)
          .then((res) => {
            let adminData = res.data

            console.log(adminData)
            this.first_name = adminData.first_name
            this.second_name = adminData.second_name
            this.last_name = adminData.last_name
            this.email = adminData.email
            this.phone = adminData.phone
            this.password = adminData.password
            this.repeatPassword = adminData.password

          })
          .catch((err) => {
            this.toast.error("Er is iets misgegaan, zie: " + err.message)
            console.log(err);
          })
    },

    async deleteAdmin() {

      await axios.delete(process.env.VUE_APP_API_URL + `/api/users/delete/` + this.id)
          .then((res) => {
            if (res.status == 200) {
              this.toast.success("Admin succesvol verwijderd")
            }
          })
          .catch((err) => {
            this.toast.error("Er is iets misgegaan, zie: " + err.message)
            console.log(err);
          })
    },

    async setAdmin() {

      // let id = this.$route.params.id || 1

      // console.log(this.admin.id)
      await axios.put(process.env.VUE_APP_API_URL + `/api/users/update`, {
        id: this.id,
        email: this.email,
        password: this.password,
        first_name: this.first_name,
        second_name: this.preposition,
        last_name: this.last_name,
        phone: this.phone,
        userType: this.userType,
      })
          .then((res) => {
            if (res.status == 200) {
              this.toast.success("Admin succesvol bijgewerkt")
            }
          })
          .catch((err) => {
            this.toast.error("Er is iets misgegaan, zie: " + err.message)
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

</style>