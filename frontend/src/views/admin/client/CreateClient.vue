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
                         class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Tussenvoegsel (optioneel)</label>
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
                  <label for="email" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Email adres</label>
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
                <label for="password" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Herhaal Wachtwoord</label>
                <input v-model="repeatPassword" type="password" name="password" id="password" placeholder="••••••••"
                       class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                       required="">
              </div>
            </div>
          </form>

          <button @click="null" class="w-full rounded-lg font-medium bg-white px-4 py-1.5 text-white"
                  style="background-color:#F15922 "> Aanmaken
          </button>
          <button @click="this.$router.push('/clients')"
                  class="w-full rounded-lg font-medium bg-white px-4 py-1.5 text-white"
                  style="background-color:red "> Annuleren
          </button>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: "CreateClient",
  data() {
    return {
      selectedClient: null
    }
  },

  methods: {
  }
}
</script>

<style scoped>

</style>