<template>
  <div class="relative">
    <router-view class="fixed left-1/2 top-1/2 w-96" :selected-specialist="selectedSpecialist"/>
    <div class="main-area">
      <div
          class="mb-4 border-gray-400 border-2 rounded-lg application-card"
          v-for="specialist in specialistDummyData"
          :key="specialist.email"
          @click="onSelect(specialist.id)">
        <img :src="require('@/assets/img/' + specialist.image)"
             alt="Profile Picture" class="w-32 border-2 border-gray-300">
        <ul class="bio-info list-none pl-2 border-l-2 border-gray-300 p-3">
          <li class="text-lg mb-3">{{ specialist.firstName }} {{ specialist.lastName }}</li>
          <li class="text-sm">{{ specialist.age }} years old</li>
          <li class="text-sm">phone: <span class="contact-link">{{ specialist.phone }}</span></li>
          <li class="text-sm">mail: <span class="contact-link">{{ specialist.email }}</span></li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import SpecialistApplicationModal from "@/components/SpecialistApplicationModal";

export default {
  name: "SpecialistApplications",
  props: [
  ],
  components: [
    SpecialistApplicationModal
  ],
  data() {
    return {
      counter: 0,
      selectedSpecialist: null,
      specialistDummyData: [
        {
          id: 1,
          approved: false,
          firstName: 'Gregory',
          lastName: 'Gnomes',
          age: 34,
          email: 'gregorygnomes@gmail.com',
          phone: '+31612345678',
          image: 'profile.png',
          skills: [
            {name: 'JavaScript', skillLevel: 4},
            {name: 'Microsoft Azure', skillLevel : 4},
            {name: 'MongoDB', skillLevel : 3},
            {name: 'HTML', skillLevel : 1}
          ],
          preferredHours: 32,
          preferredDays: {
            mon : true,
            tue : false,
            wed : true,
            thu : true,
            fri : true,
            sat : false,
            sun : false
          }
        },
        {
          id: 2,
          approved: false,
          firstName: 'Karel',
          lastName: 'Aasplank',
          age: 75,
          email: 'k.aasplank@gmail.com',
          phone: '+31612345678',
          image: 'profile.png',
          skills: [
            {name: 'JavaScript', skillLevel: 4},
            {name: 'Microsoft Azure', skillLevel : 4},
            {name: 'MongoDB', skillLevel : 3},
            {name: 'HTML', skillLevel : 1}
          ],
          preferredHours: 32,
          preferredDays: {
            mon : true,
            tue : false,
            wed : true,
            thu : true,
            fri : true,
            sat : false,
            sun : false
          }
        },
        {
          id: 3,
          approved: false,
          firstName: 'Frederik',
          lastName: 'Rietjes',
          age: 42,
          email: 'f.rietjes@gmail.com',
          phone: '+31612345678',
          image: 'profile.png',
          skills: [
            {name: 'JavaScript', skillLevel: 4},
            {name: 'Microsoft Azure', skillLevel : 4},
            {name: 'MongoDB', skillLevel : 3},
            {name: 'HTML', skillLevel : 1}
          ],
          preferredHours: 32,
          preferredDays: {
            mon : true,
            tue : false,
            wed : true,
            thu : true,
            fri : true,
            sat : false,
            sun : false
          }
        },
        {
          id: 4,
          approved: false,
          firstName: 'Peter',
          lastName: 'Plantje',
          age: 32,
          email: 'pppplantje@gmail.com',
          phone: '+31612345678',
          image: 'profile.png',
          skills: [
            {name: 'JavaScript', skillLevel: 4},
            {name: 'Microsoft Azure', skillLevel : 4},
            {name: 'MongoDB', skillLevel : 3},
            {name: 'HTML', skillLevel : 1}
          ],
          preferredHours: 32,
          preferredDays: {
            mon : true,
            tue : false,
            wed : true,
            thu : true,
            fri : true,
            sat : false,
            sun : false
          }
        },
        {
          id: 5,
          approved: false,
          firstName: 'Sanne',
          lastName: 'Schommel',
          age: 21,
          email: 'sanne.s@gmail.com',
          phone: '+31612345678',
          image: 'profile.png',
          skills: [
            {name: 'JavaScript', skillLevel: 4},
            {name: 'Microsoft Azure', skillLevel : 4},
            {name: 'MongoDB', skillLevel : 3},
            {name: 'HTML', skillLevel : 1}
          ],
          preferredHours: 32,
          preferredDays: {
            mon : true,
            tue : false,
            wed : true,
            thu : true,
            fri : true,
            sat : false,
            sun : false
          }
        },
        {
          id: 6,
          approved: false,
          firstName: 'Eef',
          lastName: 'Wentel',
          age: 29,
          email: 'wentel.eef@gmail.com',
          phone: '+31612345678',
          image: 'profile.png',
          skills: [
            {name: 'JavaScript', skillLevel: 4},
            {name: 'Microsoft Azure', skillLevel : 4},
            {name: 'MongoDB', skillLevel : 3},
            {name: 'HTML', skillLevel : 1}
          ],
          preferredHours: 32,
          preferredDays: {
            mon : true,
            tue : false,
            wed : true,
            thu : true,
            fri : true,
            sat : false,
            sun : false
          }
        },
        {
          id: 7,
          approved: false,
          firstName: 'Bas',
          lastName: 'Bos',
          age: 53,
          email: 'basbos@gmail.com',
          phone: '+31612345678',
          image: 'profile.png',
          skills: [
            {name: 'JavaScript', skillLevel: 4},
            {name: 'Microsoft Azure', skillLevel : 4},
            {name: 'MongoDB', skillLevel : 3},
            {name: 'HTML', skillLevel : 1}
          ],
          preferredHours: 32,
          preferredDays: {
            mon : true,
            tue : false,
            wed : true,
            thu : true,
            fri : true,
            sat : false,
            sun : false
          }
        },
        {
          id: 8,
          approved: false,
          firstName: 'Rico',
          lastName: 'Uitenwisser',
          age: 25,
          email: 'r.uitenwisser@gmail.com',
          phone: '+31612345678',
          image: 'profile.png',
          skills: [
            {name: 'JavaScript', skillLevel: 4},
            {name: 'Microsoft Azure', skillLevel : 4},
            {name: 'MongoDB', skillLevel : 3},
            {name: 'HTML', skillLevel : 1}
          ],
          preferredHours: 32,
          preferredDays: {
            mon : true,
            tue : false,
            wed : true,
            thu : true,
            fri : true,
            sat : false,
            sun : false
          }
        },
        {
          id: 9,
          approved: false,
          firstName: 'Vito',
          lastName: 'Vogel',
          age: 41,
          email: 'vitooovogel@gmail.com',
          phone: '+31612345678',
          image: 'profile.png',
          skills: [
            {name: 'JavaScript', skillLevel: 4},
            {name: 'Microsoft Azure', skillLevel : 4},
            {name: 'MongoDB', skillLevel : 3},
            {name: 'HTML', skillLevel : 1}
          ],
          preferredHours: 32,
          preferredDays: {
            mon : true,
            tue : false,
            wed : true,
            thu : true,
            fri : true,
            sat : false,
            sun : false
          }
        },
        {
          id: 10,
          approved: false,
          firstName: 'Fons',
          lastName: 'Fledderbak',
          age: 19,
          email: 'fledderdekledder@gmail.com',
          phone: '+31612345678',
          image: 'profile.png',
          skills: [
            {name: 'JavaScript', skillLevel: 4},
            {name: 'Microsoft Azure', skillLevel : 4},
            {name: 'MongoDB', skillLevel : 3},
            {name: 'HTML', skillLevel : 1}
          ],
          preferredHours: 32,
          preferredDays: {
            mon : true,
            tue : false,
            wed : true,
            thu : true,
            fri : true,
            sat : false,
            sun : false
          }
        },
        {
          id: 11,
          approved: false,
          firstName: 'Jan',
          lastName: 'de Man',
          age: 33,
          email: 'deman.jan@gmail.com',
          phone: '+31612345678',
          image: 'profile.png',
          skills: [
            {name: 'JavaScript', skillLevel: 4},
            {name: 'Microsoft Azure', skillLevel : 4},
            {name: 'MongoDB', skillLevel : 3},
            {name: 'HTML', skillLevel : 1}
          ],
          preferredHours: 32,
          preferredDays: {
            mon : true,
            tue : false,
            wed : true,
            thu : true,
            fri : true,
            sat : false,
            sun : false
          }
        },
        {
          id: 12,
          approved: false,
          firstName: 'Lisa',
          lastName: 'Epel',
          age: 29,
          email: 'lisa.thebest@gmail.com',
          phone: '+31612345678',
          image: 'profile.png',
          skills: [
            {name: 'JavaScript', skillLevel: 4},
            {name: 'Microsoft Azure', skillLevel : 4},
            {name: 'MongoDB', skillLevel : 3},
            {name: 'HTML', skillLevel : 1}
          ],
          preferredHours: 32,
          preferredDays: {
            mon : true,
            tue : false,
            wed : true,
            thu : true,
            fri : true,
            sat : false,
            sun : false
          }
        },
        {
          id: 13,
          approved: false,
          firstName: 'Bella',
          lastName: 'Bolle',
          age: 49,
          email: 'bollebella@gmail.com',
          phone: '+31612345678',
          image: 'profile.png',
          skills: [
            {name: 'JavaScript', skillLevel: 4},
            {name: 'Microsoft Azure', skillLevel : 4},
            {name: 'MongoDB', skillLevel : 3},
            {name: 'HTML', skillLevel : 1}
          ],
          preferredHours: 32,
          preferredDays: {
            mon : true,
            tue : false,
            wed : true,
            thu : true,
            fri : true,
            sat : false,
            sun : false
          }
        }
      ]
    }
  },
  methods: {
    openModal() {
      this.$router.push(`/specialists/applications/${this.counter++}`)
    },
    onSelect(specialistId) {
      if (this.selectedSpecialist !== null && specialistId === this.selectedSpecialist.email) {this.selectedSpecialist = null;}
      this.specialistDummyData.forEach(specialist => {
        if (specialist.id === specialistId) {this.selectedSpecialist = specialist;}
      });
      this.$router.push(this.$route.matched[0].path + '/' + this.selectedSpecialist.id);
    }
  }
}
</script>

<style scoped>
.main-area {
  margin-left: 200px;
}
.application-card {
  display: flex;
  align-items: center;
  width: 500px;
  padding: 20px;
}
.application-card img {
  border-radius: 50%;
  margin-right: 10px;
}
.contact-link {
  color: blue;
  text-decoration: underline;
}
.contact-link:hover {cursor: pointer}
.bio-info {
  text-align: left;
}
</style>