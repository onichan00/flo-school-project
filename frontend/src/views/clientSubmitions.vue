<template>
    <input type="hidden" name="sort" value="<%= sort %>">
    <input type="hidden" name="order" value="<%= order %>">
    <input type="hidden" name="page" value="<%= page %>">
    <div class="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
      <div class="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
        <div class="overflow-hidden border-b border-slate-200">
          <table class="min-w-full divide-y divide-slate-200 border-t border-t-slate-200">
            <thead>
            <tr>
              <th scope="col"
                  class="cursor-pointer px-8 py-3 text-xs font-medium text-slate-500 tracking-wider">
                <div class="flex items-center space-x-1">
                  <div>Naam</div>
                </div>
              </th>
              <th scope="col"
                  class="cursor-pointer px-8 py-3 text-xs font-medium text-slate-500 tracking-wider">
                <div class="flex items-center space-x-1">
                  <div>Telefoon</div>
                </div>
              </th>
              <th scope="col"
                  class="cursor-pointer px-8 py-3 text-xs font-medium text-slate-500 tracking-wider">
                <div class="flex items-center space-x-1">
                  <div>Email</div>
                </div>
              </th>
              <th scope="col"
                  class="cursor-pointer px-8 py-3 text-xs font-medium text-slate-500 tracking-wider">
                <div class="flex items-center space-x-1">
                  <div>Date</div>
                </div>
              </th>
              <th scope="col"
                  class="cursor-pointer px-8 py-3 text-xs font-medium text-slate-500 tracking-wider">
                <div class="flex items-center space-x-1">
                  <div>Actions</div>
                </div>
              </th>
            </tr>
            </thead>
            <tbody class="bg-white divide-y divide-slate-200">
            <tr v-on:click="selectClient(client)" v-for="client in clientDummyData" :key="client.email" data-order-code="<%= order.id %>" class="text-slate-500 hover:bg-slate-100 cursor-pointer">
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>{{client.firstName }} {{ client.lastName }}</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>{{client.phone}}</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>{{ client.email }}</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p> {{client.age}}</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <button type="button" data-order-edit class="p-1 hover:bg-slate-200 rounded-md">
                    <i class="fa-regular fa-circle-check text-2xl text-green-600"></i>
                  </button>
                  <button type="button" data-order-delete class="p-1 hover:bg-slate-200 rounded-md">
                    <i class="fa-regular fa-circle-xmark text-2xl text-red-600"></i>
                  </button>
                </div>

              </td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    <router-view :selectedDetail="selectedClient"></router-view>
</template>

<script>

export default {
  name: "ClientSubmitions",

  data() {
    return{
      selectedClient: null,
      clientDummyData: [
        {
          id: 1,
          firstName: 'Gregory',
          lastName: 'Gnomes',
          age: 34,
          email: 'gregorygnomes@gmail.com',
          phone: '+31612345678'
        },
        {
          id: 2,
          firstName: 'Karel',
          lastName: 'Aasplank',
          age: 75,
          email: 'k.aasplank@gmail.com',
          phone: '+31612345678'
        },
        {
          id: 3,
          firstName: 'Frederik',
          lastName: 'Rietjes',
          age: 42,
          email: 'f.rietjes@gmail.com',
          phone: '+31612345678'
        },
        {
          id: 4,
          firstName: 'Peter',
          lastName: 'Plantje',
          age: 32,
          email: 'pppplantje@gmail.com',
          phone: '+31612345678'
        },
        {
          id: 5,
          firstName: 'Sanne',
          lastName: 'Schommel',
          age: 21,
          email: 'sanne.s@gmail.com',
          phone: '+31612345678'
        },
        {
          id: 6,
          firstName: 'Eef',
          lastName: 'Wentel',
          age: 29,
          email: 'wentel.eef@gmail.com',
          phone: '+31612345678'
        },
        {
          id: 7,
          firstName: 'Bas',
          lastName: 'Bos',
          age: 53,
          email: 'basbos@gmail.com',
          phone: '+31612345678'
        },
        {
          id: 8,
          firstName: 'Rico',
          lastName: 'Uitenwisser',
          age: 25,
          email: 'r.uitenwisser@gmail.com',
          phone: '+31612345678'
        },
        {
          id: 9,
          firstName: 'Vito',
          lastName: 'Vogel',
          age: 41,
          email: 'vitooovogel@gmail.com',
          phone: '+31612345678'
        },
        {
          id: 10,
          firstName: 'Fons',
          lastName: 'Fledderbak',
          age: 19,
          email: 'fledderdekledder@gmail.com',
          phone: '+31612345678'
        },
        {
          id: 11,
          firstName: 'Jan',
          lastName: 'de Man',
          age: 33,
          email: 'deman.jan@gmail.com',
          phone: '+31612345678'
        },
        {
          id: 12,
          firstName: 'Lisa',
          lastName: 'Epel',
          age: 29,
          email: 'lisa.thebest@gmail.com',
          phone: '+31612345678'
        },
        {
          id: 13,
          firstName: 'Bella',
          lastName: 'Bolle',
          age: 49,
          email: 'bollebella@gmail.com',
          phone: '+31612345678'
        }
      ]
    }
  },

  methods: {
    selectClient: function (client){
      this.selectedClient = client;
      this.$router.push("client-details:" + client.id)

    }
  }

}
</script>

<style scoped>

</style>