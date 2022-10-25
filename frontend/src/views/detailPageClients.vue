<template>
  <p>{{ this.clientDummyData[currentId-1] }}</p>
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
    console.log(this.clientDummyData[this.currentId-1])
  }
}
</script>

<style scoped>

</style>