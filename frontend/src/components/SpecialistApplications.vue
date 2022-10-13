<template>
  <div>
    Lorem ipsum
  </div>
  <router-view :counter="counter" />
  <div class="d-flex flex-col">
    <div
        class="shadow mb-4 w-80 bg-gray-50"
        v-for="specialist in specialistDummyData"
        :key="specialist.email"
        @click="openModal">
      <ul class="list-disc">
        <li>Name: {{ specialist.firstName }} {{ specialist.lastName }}</li>
        <li>Age: {{ specialist.age }}</li>
        <li>Email: {{ specialist.email }}</li>
        <li>Phone number: {{ specialist.phone }}</li>
      </ul>
    </div>
  </div>
  <ul>
  <li
        class="border shadow mb-2 w-80"
        v-for="specialist in specialistDummyData"
        :key="specialist.email"
        @click="openModal">
      <ul>
        <li>Name: {{specialist.firstName }} {{ specialist.lastName }}</li>
        <li>Age: {{specialist.age}} </li>
        <li>Email: {{specialist.email}}</li>
        <li>Phone number: {{specialist.phone}}</li>
      </ul>
    </li>
  </ul>
</template>

<script>
import SpecialistApplicationModal from "@/components/SpecialistApplicationModal";

export default {
  name: "SpecialistApplications",
  props: [
    'selected-specialist'
  ],
  components: [
    SpecialistApplicationModal
  ],
  data() {
    return {
      counter: 0,
      specialistDummyData: [
        {
          firstName: 'Gregory',
          lastName: 'Gnomes',
          age: 34,
          email: 'gregorygnomes@gmail.com',
          phone: '+31612345678',
          image: '@/assets/img/profile.png'
        },
        {
          firstName: 'Karel',
          lastName: 'Aasplank',
          age: 75,
          email: 'k.aasplank@gmail.com',
          phone: '+31612345678',
          image: '@/assets/img/profile.png'
        },
        {
          firstName: 'Frederik',
          lastName: 'Rietjes',
          age: 42,
          email: 'f.rietjes@gmail.com',
          phone: '+31612345678',
          image: '@/assets/img/profile.png'
        },
        {
          firstName: 'Peter',
          lastName: 'Plantje',
          age: 32,
          email: 'pppplantje@gmail.com',
          phone: '+31612345678',
          image: '@/assets/img/profile.png'
        },
        {
          firstName: 'Sanne',
          lastName: 'Schommel',
          age: 21,
          email: 'sanne.s@gmail.com',
          phone: '+31612345678',
          image: '@/assets/img/profile.png'
        },
        {
          firstName: 'Eef',
          lastName: 'Wentel',
          age: 29,
          email: 'wentel.eef@gmail.com',
          phone: '+31612345678',
          image: '@/assets/img/profile.png'
        },
        {
          firstName: 'Bas',
          lastName: 'Bos',
          age: 53,
          email: 'basbos@gmail.com',
          phone: '+31612345678',
          image: '@/assets/img/profile.png'
        },
        {
          firstName: 'Rico',
          lastName: 'Uitenwisser',
          age: 25,
          email: 'r.uitenwisser@gmail.com',
          phone: '+31612345678',
          image: '@/assets/img/profile.png'
        },
        {
          firstName: 'Vito',
          lastName: 'Vogel',
          age: 41,
          email: 'vitooovogel@gmail.com',
          phone: '+31612345678',
          image: '@/assets/img/profile.png'
        },
        {
          firstName: 'Fons',
          lastName: 'Fledderbak',
          age: 19,
          email: 'fledderdekledder@gmail.com',
          phone: '+31612345678',
          image: '@/assets/img/profile.png'
        },
        {
          firstName: 'Jan',
          lastName: 'de Man',
          age: 33,
          email: 'deman.jan@gmail.com',
          phone: '+31612345678',
          image: '@/assets/img/profile.png'
        },
        {
          firstName: 'Lisa',
          lastName: 'Epel',
          age: 29,
          email: 'lisa.thebest@gmail.com',
          phone: '+31612345678',
          image: '@/assets/img/profile.png'
        },
        {
          firstName: 'Bella',
          lastName: 'Bolle',
          age: 49,
          email: 'bollebella@gmail.com',
          phone: '+31612345678',
          image: '@/assets/img/profile.png'
        }
      ]
    }
  },
  methods: {
    openModal() {
      this.$router.push(`/specialists/applications/${this.counter++}`)
    }
  }
}
</script>

<style scoped>

</style>