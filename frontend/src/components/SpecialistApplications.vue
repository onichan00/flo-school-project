<template>
  <div class="relative flex justify-center">
    <router-view class="fixed top-28 w-96"
                 :selected-specialist="selectedSpecialist"
                 @approve-application="approveApplication"
                 @reject-application="rejectApplication"/>
    <div class="main-area grid grid-cols-2 gap-5">
      <div
          class="application-card mb-4 border-gray-400 border-2 rounded-lg cursor-pointer relative"
          :class="gibApprovedStatus(specialist)"
          v-for="specialist in specialistDummyData"
          :key="specialist.id"
          @click="onSelect(specialist.id)">
        <img class="absolute top-3 right-1"
             :class="{hidden : specialist.approved !== true}"
             :src="require('@/assets/img/' + 'florijn-checkmark.png')"
             alt="checkmark">
        <img class="absolute top-3 right-1"
             :class="{hidden : specialist.approved !== false}"
             :src="require('@/assets/img/' + 'florijn-x.png')"
             alt="x icon">
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
          approved: 'pending',
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
          approved: 'pending',
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
          approved: 'pending',
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
          approved: 'pending',
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
          approved: 'pending',
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
          approved: 'pending',
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
          approved: 'pending',
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
          approved: 'pending',
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
          approved: 'pending',
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
          approved: 'pending',
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
          approved: 'pending',
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
          approved: 'pending',
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
          approved: 'pending',
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
    onSelect(specialistId) {
      if (this.selectedSpecialist !== null && specialistId === this.selectedSpecialist.email) {this.selectedSpecialist = null;}
      this.specialistDummyData.forEach(specialist => {
        if (specialist.id === specialistId) {this.selectedSpecialist = specialist;}
      });
      this.$router.push(this.$route.matched[0].path + '/' + this.selectedSpecialist.id);
    },
    approveApplication(specialist) {
      specialist.approved = true;
      this.$router.go(-1);
    },
    rejectApplication(specialist) {
      specialist.approved = false;
      this.$router.go(-1);
    },
    gibApprovedStatus(specialist) {
      if (specialist.approved === true) return 'approved';
      else if (specialist.approved === false) return 'faded';
      else return null;
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
  /*width: 450px;*/
  padding: 20px;
  transition: .15s;
}
.application-card:hover {
  box-shadow: 0 0 10px #EC5A29;
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
.approved {
  border-color: #EC5A29;
}
.faded {
  opacity: 50%;
  filter: grayscale(100);
}
</style>