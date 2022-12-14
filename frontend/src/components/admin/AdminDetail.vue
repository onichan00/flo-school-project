<template>

  <section>
    <div class="flex flex-col items-center justify-center mx-auto  lg:py-0">
      <div class="w-full bg-white rounded-lg md:mt-0 sm:max-w-xl xl:p-0">
        <div class="mt-10 space-y-5">
          <form class="space-y-4 md:space-y-6" action="#">
            <div>
              <div class="grid md:grid-cols-3 md:gap-6">
                <div class="relative z-0 mb-6 w-full group">
                  <label
                      class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Voornaam</label>
                  <input type="text" name="floating_first_name" id="first_name"
                         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                         placeholder="John" required/>
                </div>
                <div class="relative z-0 mb-6 w-full group">
                  <label
                      class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Tussenvoegsel
                    (optional)</label>
                  <input type="text" name="second_name" id="second_name"
                         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                         placeholder="van" required/>
                </div>
                <div class="relative z-0 mb-6 w-full group">
                  <label for="floating_last_name"
                         class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Achternaam</label>
                  <input type="text" name="floating_last_name" id="last_name"
                         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                         placeholder="Doe" required/>
                </div>
              </div>
              <div class="grid md:grid-cols-2 md:gap-6">
                <div>
                  <label for="email" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Email
                    adress</label>
                  <input type="email" name="email" id="email" class="bg-gray-50 border border-gray-300 text-gray-900
                sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5
                dark:focus:border-blue-500" placeholder="name@company.com" required="">
                </div>
                <div>
                  <label for="phone" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Telefoonnummer</label>
                  <input type="phone" name="phone" id="phone" class="bg-gray-50 border border-gray-300 text-gray-900
                sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5
                dark:focus:border-blue-500" placeholder="06 12 34 56 78" required="">
                </div>
              </div>
            </div>
            <div class="grid md:grid-cols-2 md:gap-6">

              <div>
                <label for="password" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Wachtwoord</label>
                <input type="password" name="password" id="password" placeholder="••••••••"
                       class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                       required="">
              </div>
              <div>
                <label for="password" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Wachtwoord
                  herhalen</label>
                <input type="password" name="password" id="password2" placeholder="••••••••"
                       class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                       required="">
              </div>

            </div>


          </form>
          <button @click="this.$router.push('/admin/admins')" class=" w-full rounded-lg font-medium bg-white px-4 py-1.5
                  text-white
          "
          style="background-color:#F15922 "> Bijwerken
          </button>
          <button @click="this.$router.push('/admin/admins')"
                  class="w-full rounded-lg font-medium bg-white px-4 py-1.5 text-white"
                  style="background-color:red"> Verwijderen
          </button>

        </div>
      </div>
    </div>
  </section>
</template>


<script>
import axios from "axios";

export default {
  name: "AdminDetail",

  data() {
    return {
      admin: null
    }
  },

  async created() {
    await this.getAdmin();

    document.querySelector("#first_name").value = this.admin.first_name
    document.querySelector("#second_name").value = this.admin.second_name
    document.querySelector("#last_name").value = this.admin.last_name
    document.querySelector("#email").value = this.admin.email
    document.querySelector("#phone").value = this.admin.phone
    document.querySelector("#password").value = this.admin.password
    document.querySelector("#password2").value = this.admin.password
  },

  methods: {
    async getAdmin() {

      let id = this.$route.params.id
      await axios.get(process.env.VUE_APP_API_URL + `/api/users/` + id)
          .then((res) => {
            this.admin = res.data;
            console.log(this.admin = res.data)

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

</style>