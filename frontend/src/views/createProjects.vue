<template>
  <div class="flex flex-col md:flex-row h-screen w-screen m-sm:flex-column">

    <section class="md:w-1/2 m-2 object-left">
      <div class="flex flex-col items-center justify-center mx-auto md:h-screen lg:py-0">
        <div class="w-full bg-white rounded-lg md:mt-0 sm:max-w-xl xl:p-0">
          <h1 href="#" class="text-3xl text-orange-500 font-bold text-left mb-7"><a
              @click="this.$router.push('/client/projects-overview')" class="hover:text-orange-600 rounded-3xl"><i
              class="fa-solid fa-arrow-left"></i></a> FLORIJN</h1>
          <h1 class="flex text-left items-center mb-6 text-4xl font-semibold text-gray-900 dark:text-white">
            Vraag een project aan
          </h1>
          <div class="mt-10 space-y-5">
            <form class="space-y-4 md:space-y-6" action="#">
              <div>
                <label for="name" class="block text-left mb-2 text-m font-medium text-gray-900 dark:text-white">Geef
                  je project een naam</label>
                <input type="text" name="name" id="name" v-model="this.name"
                       class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5"
                       placeholder="Project naam">
              </div>
              <div>
                <label for="name" class="block text-left mb-2 text-m font-medium text-gray-900 dark:text-white">Geef je
                  project een banner (optioneel)</label>
                <p class="block text-left mb-2 text-sm  text-gray-600">Vind banner afbeeldingen op <a
                    href="https://unsplash.com" class="text-orange-500 hover">Unsplash.com</a>, en kopieer en plak de
                  URL van de afbeelding</p>
                <input type="text" name="bannerUrl" id="name" v-model="this.bannerUrl"
                       class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5"
                       placeholder="Plak hier de URL van de afbeelding">
              </div>
              <div>
                <label for="description" class="block text-left mb-2 text-m font-medium text-gray-900 dark:text-white">Geef
                  je project een beschrijving</label>
                <p class="block text-left mb-2 text-sm  text-gray-600">Nuttig voor teams of om onderscheid te maken
                  tussen projecten met vergelijkbare namen</p>
                <textarea id="description" name="description"  rows="4" v-model="this.description"
                          placeholder="Schrijf hier de beschrijving van uw project.."
                          class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5"
                ></textarea>
              </div>
              <!--TODO Weg klikken van skills implementeren-->
              <div>
                <label for="search" class="block text-left mb-2 text-m font-medium text-gray-900 dark:text-white">
                  Type de naam van een skill
                </label>
                <p class="block text-left mb-2 text-sm  text-gray-600">Nuttig voor specialisten</p>
                <input type="text" id="search" placeholder="Zoek hier de skills" v-model="searchTerm" class="w-full bg-gray-50 border border-gray-300 text-gray-900
                sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500">
                <ul v-if="searchSkills.length"
                    class="w-1/4 rounded-lg bg-white border border-gray-300 px-4 text-left py-2 space-y-1 absolute z-10">
                  <li v-for="skill in searchSkills" :key="skill.name" @click="selectSkill(skill), addSkill(skill)"
                      class="cursor-pointer hover:bg-orange-100 p-1">
                    {{ skill.name }}
                  </li>
                </ul>
                <div id="selectedCountries" class="flex flex-row flex-wrap">
                  <div @click="deleteCountry(skill)"
                       v-for="skill in this.projectSkills" :key="skill.id"
                       class="cursor-pointer bg-gray-100 border border-gray-300 px-2 py-1 mt-1 mr-1 rounded-lg">
                    <div class="flex items-center space-x-1">
                      <span>
                        {{ skill.name }}
                      </span>
                      <i class="fa-solid fa-xmark"></i>
                    </div>
                  </div>
                </div>
              </div>
            </form>
            <div class="flex justify-end">
              <button
                  class="w-full object-right rounded-lg font-medium bg-white px-4 py-1.5 text-white disabled:opacity-25 disabled:cursor-not-allowed"
                  style="background-color:#F15922"
                  @click="submitProject"
                  :disabled="allFilledIn || this.clicked"
              > Sla dit project op
              </button>
            </div>
          </div>
        </div>
      </div>
    </section>

    <section class="md:w-1/2" style='background-image: linear-gradient(to right, #F15922 , #f17822)'>
      <div class="flex flex-col md:mt-0 sm:max-w-xl xl:p-0 text-left justify-center text-white
       mx-auto md:h-screen lg:py-0 space-y-4">
        <div class="text-left">
          <h1 class="text-5xl font-semibold">Projecten</h1>
        </div>
        <p class="text-md font-light">Op deze pagina kunt u uw eigen project aanmaken. U kunt het project een naam
          en een beschrijving geven, ook kunt u skills opzoeken die specialisten moeten hebben om aan dit project mee
          te kunnen doen. Als u een project heeft aangemaakt kunt u specialisten vinden die overeenkomen met de
          skills</p>
        <img :src="require('../assets/img/undraw_organizing_projects_re_9p1k.svg')" class="mb-6" alt="Project Image">
      </div>
    </section>
  </div>

</template>

<script>
import {computed, ref} from 'vue'
import axios from 'axios';
import {useToast} from "vue-toastification";

export default {
  name: "createProjects",
  data() {
    return {
      userId: localStorage.getItem('id'),
      name: "",
      description: "",
      bannerUrl: "",
      status: 0,
      clicked: false,
      skills: [],
      projectSkills: [],
      client: null
    }
  },
  methods: {
    addSkill(skill) {
      this.projectSkills.push(skill)
    },

    getUser() {
      axios.get(process.env.VUE_APP_API_URL + `/api/users/client/${this.userId}`)
          .then((res) => {
            this.client = res.data;
            console.log(this.client)
          })
          .catch((err) => {
            console.log(err);
          })
    },

    submitProject() {
      this.clicked = true;

      const requestBody = {
        name: this.name,
        status: this.status,
        created: null,
        description: this.description,
        bannerUrl: this.bannerUrl,
        skills: this.projectSkills,
      }

      // user id wordt meegestuurd als @RequestParam voor backend onder de naam van clientId
      axios.post(process.env.VUE_APP_API_URL + '/api/projects/?clientId=' + this.userId, requestBody)
          .then((res) => {
            this.toast.success(`Project genaamd: "${this.name}", is met success aangemaakt`, {
              position: "bottom-center",
              timeout: 4000,
              closeOnClick: true,
              pauseOnFocusLoss: true,
              pauseOnHover: true,
              draggable: true,
              draggablePercent: 0.6,
              showCloseButtonOnHover: false,
              hideProgressBar: true,
              closeButton: "button",
              icon: true,
              rtl: false
            });
          })
          .catch((error) => {
            console.log(error)
            this.toast.error("Er ging wat mis met het aanmaken van dit project", {
              position: "bottom-center",
              timeout: 4000,
              closeOnClick: true,
              pauseOnFocusLoss: true,
              pauseOnHover: true,
              draggable: true,
              draggablePercent: 0.6,
              showCloseButtonOnHover: false,
              hideProgressBar: true,
              closeButton: "button",
              icon: true,
              rtl: false
            });
          })
    },
    deleteCountry(country) {
      this.skills.filter(skill => skill.id !== ref(country.id));
    },
  },
  computed: {
    allFilledIn() {
      // Checks if the name and description are filled in
      const name = this.name;
      const description = this.description;

      // Return if both are filled in or not
      return !(name && description);
    },
  },
  setup() {
    let theSkills = []
    axios.get(`http://localhost:8080/api/skills`)
        .then((res) => {
          theSkills = res.data;
          console.log(theSkills)
        })
        .catch((err) => {
          console.log(err);
        })

    const toast = useToast();

    let searchTerm = ref('')

    const selectSkill = (skill) => {
      selectedSkill.value = skill
      searchTerm.value = ''
    }

    const searchSkills = computed(() => {
      if (searchTerm.value === '') {
        return []
      }

      let matches = 0

      return theSkills.filter(skill => {
        if (
            skill.name.toLowerCase().includes(searchTerm.value.toLowerCase())
            && matches < 10
        ) {
          matches++
          return skill
        }
      })
    });

    let selectedSkill = ref('')

    return {
      toast,
      theSkills,
      searchTerm,
      searchSkills,
      selectSkill,
      selectedSkill
    }
  },

  created() {
    this.getUser()
  }
}
</script>

<style scoped>
.v-enter-active,
.v-leave-active {
  transition: opacity 0.5s ease;
}

.v-enter-from,
.v-leave-to {
  opacity: 0;
}
</style>