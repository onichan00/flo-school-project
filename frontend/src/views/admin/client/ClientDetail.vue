<template>
  <section>
    <div class="flex flex-col items-center justify-center mx-auto  lg:py-0">
      <div class="w-full bg-white rounded-lg md:mt-0 sm:max-w-xl xl:p-0">
        <div class="mt-10 space-y-5">
          <form class="space-y-4 md:space-y-6" action="#">
            <div>
              <div class="grid md:grid-cols-3 md:gap-6">
                <div class="relative z-0 mb-6 w-full group">
                  <label for="first_name"
                         class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Voornaam</label>
                  <input v-model="client.first_name" type="text" name="first_name" id="first_name"
                         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                         placeholder="John" required/>
                </div>
                <div class="relative z-0 mb-6 w-full group">
                  <label for="preposition"
                         class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Tussenvoegsel (optioneel)</label>
                  <input v-model="client.second_name" type="text" name="preposition" id="preposition"
                         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                         placeholder="van" required/>
                </div>
                <div class="relative z-0 mb-6 w-full group">
                  <label for="last_name"
                         class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Achternaam</label>
                  <input v-model="client.last_name" type="text" name="last_name" id="last_name"
                         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                         placeholder="Doe" required/>
                </div>
              </div>
              <div class="grid md:grid-cols-2 md:gap-6">
                <div>
                  <label for="email" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Email adres</label>
                  <input v-model="client.email" type="email" name="email" id="email" class="bg-gray-50 border border-gray-300 text-gray-900
                sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5
                dark:focus:border-blue-500" placeholder="name@company.com" required>
                </div>
                <div>
                  <label for="phone" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Telefoonnummer</label>
                  <input v-model="client.phone" type="phone" name="phone" id="phone" class="bg-gray-50 border border-gray-300 text-gray-900
                sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5
                dark:focus:border-blue-500" placeholder="06 12 34 56 78" required>
                </div>
              </div>
            </div>
            <div class="grid md:grid-cols-2 md:gap-6">
              <div>
                <label for="password" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Wachtwoord</label>
                <input v-model="client.password" type="password" name="password" id="password" placeholder="••••••••"
                       class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                       required>
              </div>
              <div>
                <label for="repeat-password" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Herhaal Wachtwoord</label>
                <input v-model="client.password" type="password" name="password" id="repeat-password" placeholder="••••••••"
                       class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                       required>
              </div>
            </div>
          </form>

          <button @click="updateClient" class="w-full rounded-lg font-medium bg-white px-4 py-1.5 text-white"
                  style="background-color:#F15922 "> Bijwerken
          </button>
          <button @click="deleteClient"
                  class="w-full rounded-lg font-medium bg-white px-4 py-1.5 text-white"
                  style="background-color:red "> Verwijderen
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
  name: "ClientDetail",
  data() {
    return {
      id: this.$route.params.id,
      client: {}
    }
  },
  created() {
    this.getClient();
  },
  methods: {
    getClient() {
      fetch(process.env.VUE_APP_API_URL + `/api/users/clients/${this.id}`)
          .then(response => {
            if (response.ok) {
              return response.json();
            }
          })
          .then(data => {
            const {first_name, second_name, last_name, address, zip_code, city, bio, email, phone} = data;
            this.client.id = this.id;
            this.client.userType = 1;
            this.client.first_name = first_name;
            this.client.second_name = second_name;
            this.client.last_name = last_name;
            this.client.address = address;
            this.client.zip_code = zip_code;
            this.client.city = city;
            this.client.bio = bio;
            this.client.email = email;
            this.client.phone = phone;
          });
    },
    updateClient() {
      fetch(process.env.VUE_APP_API_URL + `/api/users/update`,{
        method: 'PUT',
        body: JSON.stringify(this.client),
        headers: {
          "Content-Type": "application/json"
        }
      }).then(response => {
        if (response.ok) {
          this.$router.push("/clients");
        }
      })
    },
    //TODO decide what to do with 'deleted' clients
    // deleteClient() {
    //   fetch(process.env.VUE_APP_API_URL + `/api/users/delete/${this.id}`, {
    //     method: 'DELETE'
    //   }).then(response => {
    //     if (response.ok) {
    //       return response.json();
    //     }
    //   });
    // }
  }
}
</script>

<style scoped>

</style>