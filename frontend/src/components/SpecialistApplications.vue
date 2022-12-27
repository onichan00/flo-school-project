<template>
  <FileUpload/>
  <FileList/>
  <div class="relative flex justify-center">
    <router-view class="fixed top-28 w-96"
                 :selected-specialist="selectedSpecialist"
                 @approve-application="approveApplication"
                 @reject-application="rejectApplication"/>

    <div class="overflow-x-auto relative shadow-md border border-gray-200 sm:rounded-lg mt-10">
      <table class="w-full text-sm rounded-md text-left text-gray-500 dark:text-gray-400">

        <thead class="text-xs border-b text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
          <tr>
            <th scope="col" class="py-3 px-6">Name</th>
            <th scope="col" class="py-3 px-6">Age</th>
            <th scope="col" class="py-3 px-6">Email</th>
            <th scope="col" class="py-3 px-6">Phone</th>
            <th scope="col" class="py-3 px-6">Status</th>
          </tr>
        </thead>

        <tbody>
          <tr v-for="specialist in specialists"
              :key="specialist.id"
              @click="onSelect(specialist.id)"
              class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-orange-50 dark:hover:bg-gray-600 cursor-pointer">
            <td class="py-4 px-6">
                {{ specialist.firstName }} {{specialist.lastName}}
            </td>
            <td class="py-4 px-6">
              {{ specialist.age }}
            </td>
            <td class="py-4 px-6">
              <div class="flex items-center text-blue-600 underline cursor-pointer">
                {{ specialist.email }}
              </div>
            </td>
            <td class="py-4 px-6">
              <div class="flex items-center text-blue-600 underline cursor-pointer">
                {{ specialist.phone }}
              </div>
            </td>
            <td class="py-4 px-6">
              <div class="flex items-center justify-center">
                <img :src="require('@/assets/img/' + gibApprovedStatus(specialist))"
                     alt="approval status"
                     class="approval-status-icon">
              </div>
            </td>
          </tr>
        </tbody>

      </table>

    </div>
  </div>
</template>

<script>

import FileUpload from "@/components/fileHandling/FileUpload.vue";
import FileList from "@/components/fileHandling/FileList.vue";

export default {
  name: "SpecialistApplications",
  components: {FileList, FileUpload},
  data() {
    return {
      counter: 0,
      selectedSpecialist: null,
      specialists: [
        {
          id: 1,
          approved: 'pending',
          firstName: 'Gregory',
          lastName: 'Gnomes',
          age: this.calculateAge(new Date('10/25/1992')),
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
            fri : true
          }
        },
        {
          id: 2,
          approved: 'pending',
          firstName: 'Karel',
          lastName: 'Aasplank',
          age: this.calculateAge(new Date('10/24/1992')),
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
            fri : true
          }
        },
        {
          id: 3,
          approved: 'pending',
          firstName: 'Frederik',
          lastName: 'Rietjes',
          age: this.calculateAge(new Date('10/24/1992')),
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
            fri : true
          }
        },
        {
          id: 4,
          approved: 'pending',
          firstName: 'Peter',
          lastName: 'Plantje',
          age: this.calculateAge(new Date('10/24/1992')),
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
            fri : true
          }
        },
        {
          id: 5,
          approved: 'pending',
          firstName: 'Sanne',
          lastName: 'Schommel',
          age: this.calculateAge(new Date('10/24/1992')),
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
            fri : true
          }
        },
        {
          id: 6,
          approved: 'pending',
          firstName: 'Eef',
          lastName: 'Wentel',
          age: this.calculateAge(new Date('10/24/1992')),
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
            fri : true
          }
        },
        {
          id: 7,
          approved: 'pending',
          firstName: 'Bas',
          lastName: 'Bos',
          age: this.calculateAge(new Date('10/24/1992')),
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
            fri : true
          }
        },
        {
          id: 8,
          approved: 'pending',
          firstName: 'Rico',
          lastName: 'Uitenwisser',
          age: this.calculateAge(new Date('10/24/1992')),
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
            fri : true
          }
        },
        {
          id: 9,
          approved: 'pending',
          firstName: 'Vito',
          lastName: 'Vogel',
          age: this.calculateAge(new Date('10/24/1992')),
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
            fri : true
          }
        },
        {
          id: 10,
          approved: 'pending',
          firstName: 'Fons',
          lastName: 'Fledderbak',
          age: this.calculateAge(new Date('10/24/1992')),
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
            fri : true
          }
        },
        {
          id: 11,
          approved: 'pending',
          firstName: 'Jan',
          lastName: 'de Man',
          age: this.calculateAge(new Date('10/24/1992')),
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
            fri : true
          }
        },
        {
          id: 12,
          approved: 'pending',
          firstName: 'Lisa',
          lastName: 'Epel',
          age: this.calculateAge(new Date('10/24/1992')),
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
            fri : true
          }
        },
        {
          id: 13,
          approved: 'pending',
          firstName: 'Bella',
          lastName: 'Bolle',
          age: this.calculateAge(new Date('10/24/1992')),
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
            fri : true
          }
        }
      ]
    }
  },
  methods: {
    onSelect(specialistId) {
      if (this.selectedSpecialist !== null && specialistId === this.selectedSpecialist.email) {this.selectedSpecialist = null;}
      this.specialists.forEach(specialist => {
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
      if (specialist.approved === true) return 'florijn-checkmark.png';
      else if (specialist.approved === false) return 'florijn-x.png';
      else return "florijn-pending.png";
    },
    calculateAge(dateOfBirth) {
      return Math.floor((Date.now() - dateOfBirth) / (31557600000));
    }
  }
}
</script>

<style scoped>
.application-card img {
  border-radius: 50%;
  margin-right: 10px;
}
.approval-status-icon {
  width: 30px;
}
</style>