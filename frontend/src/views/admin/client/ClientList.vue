<template>
  <div class="grid grid-cols-3 gap-4">
    <div class="p-6 bg-white rounded-lg text-left border border-gray-200">
      <p class="mb-3 font-normal text-gray-500 dark:text-gray-400">
        <i class="fa-solid fa-code bg-orange"></i> Aantal Cliënten</p>
      <h5 class="mb-2 text-2xl font-semibold tracking-tight text-gray-900 dark:text-white">{{ clients.length }}</h5>
    </div>
    <div class="p-6 bg-white rounded-lg text-left border border-gray-200 hover:bg-orange-50" @click="this.$router.push('/client/create')" id="aanmakenKnop">
      <p class="mb-3 font-normal text-gray-500 dark:text-gray-400">
        <i ></i>Cliënt Aanmaken</p>
      <h5 class="mb-2 text-2xl font-semibold tracking-tight text-gray-900 dark:text-white">+</h5>
    </div>
  </div>
  <br>
  <div class="overflow-x-auto relative">
    <div class="overflow-x-auto relative shadow-md border border-gray-200 sm:rounded-lg">

      <table class="w-full text-sm rounded-md text-left text-gray-500 dark:text-gray-400">
        <thead class="text-xs border-b text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
        <tr>
          <th scope="col" class="py-3 px-6">
            Naam
          </th>
          <th scope="col" class="py-3 px-6">
            E-mail
          </th>
          <th scope="col" class="py-3 px-6">

          </th>
        </tr>
        </thead>

        <tbody>
        <tr v-for="client in clients" :key="client.id"
            class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-orange-50 dark:hover:bg-gray-600"
            @click="this.$router.push('/client/' + client.id)">

          <th scope="row" class="flex items-center py-4 px-6 text-gray-900 whitespace-nowrap dark:text-white">
            <div class="pl-3">
              <div class="font-normal text-gray-500">{{ client.first_name.charAt(0).toUpperCase() + "." + client.last_name}}</div>
            </div>
          </th>
          <td class="py-4 px-6">
            {{ client.email }}
          </td>
          <td class="py-4 px-6">
            <a class="font-medium text-orange-500 hover:underline"
               data-modal-toggle="defaultModal" @click="this.$router.push('/client/' + client.id)">Bekijk cliënt</a>
          </td>
        </tr>
        </tbody>
      </table>

    </div>
  </div>
</template>

<script>
export default {
  name: "ClientList",
  data() {
    return {
      clients: []
    }
  },
  created() {
    this.getClients()
  },
  methods: {
    getClients() {
      fetch(process.env.VUE_APP_API_URL + "/api/users/clients")
          .then(response => {
            if (response.ok) {
              return response.json();
            }
          })
          .then(data => {
            data.forEach(client => {
              this.clients.push(client);
            })
          })
    }
  }
}
</script>

<style scoped>

</style>