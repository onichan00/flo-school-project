<template>
  <input type="hidden" name="sort" value="<%= sort %>">
  <input type="hidden" name="order" value="<%= order %>">
  <input type="hidden" name="page" value="<%= page %>">
  <div class="-my-2 overflow-x-auto">
    <div class="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
      <div class="overflow-hidden border-b border-slate-200">

        <p class="text-left text-1xl font-medium my-4">New clients</p>
        <div id="specialistsTable" class="overflow-x-auto relative mt-4">
          <div class="overflow-x-auto relative shadow-md border border-gray-200 sm:rounded-lg">
            <table class="w-full text-sm rounded-md text-left text-gray-500 dark:text-gray-400">
              <thead class="text-xs border-b text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
              <tr>

                <th scope="col" class="py-3 px-6">
                  Name
                </th>
                <th scope="col" class="py-3 px-6">
                  Position
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

              <tr v-for="client in clients" :key="client.id" @click="selectClient(client)"
                  class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-orange-50 dark:hover:bg-gray-600">

                <th scope="row" class="flex items-center py-4 px-6 text-gray-900 whitespace-nowrap dark:text-white">
                  <div class="pl-3">
                    <div class="text-base font-semibold">{{ client.first_name }}</div>
                    <div class="font-normal text-gray-500">{{ client.last_name }}</div>
                  </div>
                </th>
                <td class="py-4 px-6">
                  {{ client.bio }}
                </td>
                <td class="py-4 px-6">
                  <div class="flex items-center">
                    <div class="h-2.5 w-2.5 rounded-full bg-green-400 mr-2"></div>
                    {{ client.company }}
                  </div>
                </td>
                <td class="py-4 px-6">
                  <a href="#" class="font-medium text-orange-500 hover:underline" data-modal-toggle="defaultModal">Edit
                    user</a>
                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </div>

        <p class="text-left text-1xl font-medium my-4">Clients</p>
        <div id="specialistsTable" class="overflow-x-auto relative mt-4">
          <div class="overflow-x-auto relative shadow-md border border-gray-200 sm:rounded-lg">
            <table class="w-full text-sm rounded-md text-left text-gray-500 dark:text-gray-400">
              <thead class="text-xs border-b text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
              <tr>

                <th scope="col" class="py-3 px-6">
                  Name
                </th>
                <th scope="col" class="py-3 px-6">
                  Position
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

              <tr v-for="client in clients" :key="client.id" @click="selectClient(client)"
                  class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-orange-50 dark:hover:bg-gray-600">

                <th scope="row" class="flex items-center py-4 px-6 text-gray-900 whitespace-nowrap dark:text-white">
                  <div class="pl-3">
                    <div class="text-base font-semibold">{{ client.first_name }}</div>
                    <div class="font-normal text-gray-500">{{ client.last_name }}</div>
                  </div>
                </th>
                <td class="py-4 px-6">
                  {{ client.bio }}
                </td>
                <td class="py-4 px-6">
                  <div class="flex items-center">
                    <div class="h-2.5 w-2.5 rounded-full bg-green-400 mr-2"></div>
                    {{ client.company }}
                  </div>
                </td>
                <td class="py-4 px-6">
                  <a href="#" class="font-medium text-orange-500 hover:underline" data-modal-toggle="defaultModal">Edit
                    user</a>
                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: "ClientSubmitions",
  inject: ['clients'],
  data() {
    return {
      selectedClient: null,
      clients: this.clients
    }
  },

  methods: {
    selectClient: function (client) {
      console.log(client)
      this.selectedClient = client;
      this.$router.push("client/" + client.id)
    }
  }

}
</script>

<style scoped>

</style>