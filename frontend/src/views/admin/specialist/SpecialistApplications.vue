<template>
  <div class="relative flex justify-center">
    <router-view class="fixed top-28 w-96"
                 :selected-specialist="selectedSpecialist"
                 @approve-application="updateApplication"
                 @reject-application="updateApplication"/>

    <div class="overflow-x-auto relative shadow-md border border-gray-200 sm:rounded-lg mt-10">
      <table class="w-full text-sm rounded-md text-left text-gray-500 dark:text-gray-400">

        <thead class="text-xs border-b text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
          <tr>
            <th scope="col" class="py-3 px-6">Naam</th>
            <th scope="col" class="py-3 px-6">Leeftijd</th>
            <th scope="col" class="py-3 px-6">Email</th>
            <th scope="col" class="py-3 px-6">Telefoon</th>
            <th scope="col" class="py-3 px-6">Status</th>
          </tr>
        </thead>

        <tbody>
          <tr v-for="specialist in specialists"
              :key="specialist.id"
              @click="onSelect(specialist.id)"
              class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-orange-50 dark:hover:bg-gray-600 cursor-pointer">
            <td class="py-4 px-6">
                {{ specialist.name}}
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
export default {
  name: "SpecialistApplications",
  data() {
    return {
      counter: 0,
      selectedSpecialist: null,
      specialists: []
    }
  },
  methods: {
    onSelect(specialistId) {
      if (this.selectedSpecialist !== null && specialistId === this.selectedSpecialist.id) {this.selectedSpecialist = null;}
      this.specialists.forEach(specialist => {
        if (specialist.id === specialistId) {this.selectedSpecialist = specialist;}
      });
      this.$router.push(this.$route.matched[0].path + '/' + this.selectedSpecialist.id);
    },
    updateApplication(specialist) {
      fetch(process.env.VUE_APP_API_URL + `/api/users/specialists/applications/${specialist.id}`, {
        method: "PUT",
        mode: "cors",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({
          approvalStatus: specialist.approvalStatus
        })
      }).then(response => {
        if (response.ok) {
          return response.json();
        }
      }).then(data => {
        if (data.approvalStatus === specialist.approvalStatus) {
          this.selectedSpecialist.approvalStatus = specialist.approvalStatus;
          this.$router.go(-1);
        }
      })
    },
    gibApprovedStatus(specialist) {
      if (specialist.approvalStatus === 1) return 'florijn-checkmark.png';
      else if (specialist.approvalStatus === 0) return 'florijn-x.png';
      else return "florijn-pending.png";
    },
    calculateAge(dateOfBirth) {
      return Math.floor((Date.now() - dateOfBirth) / (31557600000));
    }
  },
  beforeCreate() {
    (() => {
      fetch(process.env.VUE_APP_API_URL + `/api/users/specialists/applications`).then(response => {
        if (response.ok) {
          return response.json();
        }
      }).then(data => {
        data.forEach(user => {
          const {
            first_name: firstName,
            second_name: secondName,
            last_name: lastName,
            email, phone, photo, specialist} = user;
          const {approvalStatus, id} = specialist;

          this.specialists.push({
            "name": `${firstName} ${secondName!=="" ? secondName:lastName} ${secondName!=="" ? lastName: ""}`,
            "email": email,
            "phone": phone,
            "photo": photo,
            "approvalStatus": approvalStatus,
            "id": id
          })
        })
      }).catch(err => {
        console.error(err);
      })
    })();
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