<template>
  <div class="container py-10 px-10">
    <div class=" overflow-hidden relative w-36 h-36 bg-gray-100 rounded-full dark:bg-gray-600">
      <svg class=" py-5 px-5absolute  w-36 h-36 text-gray-400" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M10 9a3 3 0 100-6 3 3 0 000 6zm-7 9a7 7 0 1114 0H3z" clip-rule="evenodd"></path></svg>
    </div>
<!--    border-b-4 border-[#F15922]-->
    <div class="grid grid-cols-2 gap-0 text-justify py-5 px-5 divide-y divide-y-reverse ">
      <p></p>
      <p></p>
      <p class="py-3 px-3 font-medium text-slate-500">Firstname </p><p class="py-3 px-3 font-medium text-slate-900">{{ this.clientDummyData[currentId - 1].firstName }}</p>
      <p class="py-3 px-3 font-medium text-slate-500">lastName </p><p class="py-3 px-3 font-medium text-slate-900">{{ this.clientDummyData[currentId - 1].lastName }}</p>
      <p class="py-3 px-3 font-medium text-slate-500">Age </p><p class="py-3 px-3 font-medium text-slate-900">{{ this.clientDummyData[currentId - 1].age }}</p>
      <p class="py-3 px-3 font-medium text-slate-500">Email </p><p class="py-3 px-3 font-medium text-slate-900">{{ this.clientDummyData[currentId - 1].email }}</p>
      <p class="py-3 px-3 font-medium text-slate-500">Phone </p><p class="py-3 px-3 font-medium text-slate-900">{{ this.clientDummyData[currentId - 1].phone }}</p>
    </div>


  </div>

</template>

<script>
export default {
  name: "detailPageClients",
  props: ['selectedClient'],

  data() {
    return {
      currentId: 0,
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

  created() {
    this.currentId = this.$route.params.id.replace(':', '');
  }
}
</script>

<style scoped>

</style>