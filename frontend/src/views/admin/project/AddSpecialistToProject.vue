<template>
  <div class="z9bg-container">
    <div class="relative overflow-x-auto shadow-md sm:rounded-lg addSpecialist-container">
      <table class="w-full text-sm text-left text-white-500 dark:text-white-400">
        <thead class="text-xs text-white uppercase bg-[#F05822]/80 ">
        <tr>
          <th scope="col" class="px-6 py-3">
            Naam
          </th>
          <th scope="col" class="px-6 py-3">
            Specialist type
          </th>
          <th scope="col" class="px-6 py-3">
            Email
          </th>
          <th scope="col" class="px-6 py-3">
            Telefoon
          </th>

        </tr>
        </thead>
        <tbody>
        <tr v-on:click="selectSpecialist(specialist.id)" v-for="specialist in specialistsOfThisProject"
            v-bind:key="specialist.id"
            class=" bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600" :class="{'bg-gray-50': this.selectedSpecialists.indexOf(specialist.id)  !== -1}">
          <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
            {{ fullName(specialist) }}
          </th>
          <td class="px-6 py-4">
            {{ specialist.specialist.specialistType }}
          </td>
          <td class="px-6 py-4">
            {{ specialist.email }}
          </td>
          <td class="px-6 py-4">
            {{ specialist.phone }}
          </td>
        </tr>
        <button v-on:click="changeTeam()"
                class="float-left p-3 bg-red-600 hover:bg-red-800 text-white font-bold rounded m-1">
          Verwijderen
        </button>
        </tbody>
      </table>
    </div>
    <br>
    <br>
    <br>
    <br>
    <div class="relative overflow-x-auto shadow-md sm:rounded-lg addSpecialist-container">
      <table class="w-full text-sm text-left text-white-500 dark:text-white-400">
        <thead class="text-xs text-white uppercase bg-[#F05822]/80 ">
        <tr>
          <th scope="col" class="px-6 py-3">
            Naam
          </th>
          <th scope="col" class="px-6 py-3">
            Specialist type
          </th>
          <th scope="col" class="px-6 py-3">
            Email
          </th>
          <th scope="col" class="px-6 py-3">
            Telefoon
          </th>

        </tr>
        </thead>
        <tbody>
        <tr v-on:click="selectSpecialist(specialist.id)" v-for="specialist in availableSpecialists"
            v-bind:key="specialist.id"
            class=" bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600" :class="{'bg-gray-50': this.selectedSpecialists.indexOf(specialist.id)  !== -1}">
          <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
            {{ fullName(specialist) }}
          </th>
          <td class="px-6 py-4">
            {{ specialist.specialist.specialistType }}
          </td>
          <td class="px-6 py-4">
            {{ specialist.email }}
          </td>
          <td class="px-6 py-4">
            {{ specialist.phone }}
          </td>
        </tr>
        <button v-on:click="changeTeam()"
                class="float-left p-3 bg-green-600 hover:bg-green-800 text-white font-bold rounded m-1">
          Toevoegen
        </button>
        </tbody>
      </table>
    </div>
    <button v-on:click="backToProject()"
            class="float-left p-3 bg-[#F05822] hover:bg-orange-700 text-white font-bold rounded ">
      Terug
    </button>
  </div>

</template>

<script>
import axios from "axios";

export default {
  name: "AddSpecialistToProject",

  data() {
    return {
      selectedSpecialists: [],
      specialistsOfThisProject: null,
      availableSpecialists: null,
      specialists: null
    }
  },

  async created() {
    await this.findAvailableSpecialists();

  },

  methods: {
    selectSpecialist(id) {
      if (!this.selectedSpecialists.includes(id)) {
        this.selectedSpecialists.push(id)
      } else {
        const index = this.selectedSpecialists.indexOf(id)
        this.selectedSpecialists.splice(index, 1)
      }
    },

    async changeTeam() {
      for (let i = 0; i < this.selectedSpecialists.length; i++) {
        await axios.post(process.env.VUE_APP_API_URL + `/api/projects/1/specialist/`, {"id": this.this.selectedSpecialists[i]})
            .then(async (res) => {
              await this.findAvailableSpecialists();
            })
      }
      this.selectedSpecialists = []
    },

    fullName(name) {
      return (String(name.first_name).charAt(0).toUpperCase() + String(name.first_name).slice(1))
          + ' '
          + String(name.last_name).charAt(0).toUpperCase() + String(name.last_name).slice(1);
    },

    backToProject() {
      this.$router.push('/projects/' + this.$route.params.id)
    },

    async findAvailableSpecialists() {
      const projectId = this.$route.params.id;
      await axios.get(process.env.VUE_APP_API_URL + "/api/users/specialists")
          .then((res) => {
            this.specialists = res.data;
          })

      await axios.get(process.env.VUE_APP_API_URL + "/api/users/specialists/" + projectId)
          .then((res) => {
            this.specialistsOfThisProject = res.data

            this.availableSpecialists = this.specialists.filter(function (other_el) {
              return res.data.filter(function (another_el) {
                return another_el.id === other_el.id;
              }).length === 0
            })
          })
          .catch((err) => {
            console.log(err);
          })
    },

  }
}
</script>

<style scoped>
.z9bg-container {
  height: 80vh;
}

.addSpecialist-container {
  width: 80%;
  margin: 0 auto;
}
</style>