<template>
  <div class="flex flex-col md:flex-row h-screen w-screen m-sm:flex-column">

    <section class="md:w-1/2 m-2 object-left">
      <div class="flex flex-col items-center justify-center mx-auto md:h-screen lg:py-0">
        <div class="w-full bg-white rounded-lg md:mt-0 sm:max-w-xl xl:p-0">
          <h1 href="#" class="text-3xl text-orange-500 font-bold text-left mb-7"> FLORIJN</h1>
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
                <label for="description" class="block text-left mb-2 text-m font-medium text-gray-900 dark:text-white">Project
                  beschrijving</label>
                <p class="block text-left mb-2 text-sm  text-gray-600">Nuttig voor teams of om onderscheid te maken
                  tussen projecten met vergelijkbare namen</p>
                <textarea id="description" rows="4" v-model="this.description"
                          placeholder="Schrijf hier de beschrijving van uw project.."
                          class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5"
                ></textarea>
              </div>
              <div>
                <label for="search" class="block text-left mb-2 text-m font-medium text-gray-900 dark:text-white">
                  Type de naam van een skill
                </label>
                <p class="block text-left mb-2 text-sm  text-gray-600">Nuttig voor specialisten</p>
                <input type="text" id="search" placeholder="Zoek hier de skills" v-model="searchTerm" class="w-full bg-gray-50 border border-gray-300 text-gray-900
                sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500">
                <ul v-if="searchCountries.length"
                    class="w-1/4 rounded-lg bg-white border border-gray-300 px-4 py-2 space-y-1 absolute z-10">
                  <li v-for="country in searchCountries" :key="country.name" @click="selectCountry(country.name)"
                      class="cursor-pointer hover:bg-orange-100 p-1">
                    {{ country.name }}
                  </li>
                </ul>
                <p v-if="selectedCountry" class="text-lg pt-2 absolute">
                  You have selected: <span class="font-semibold">{{ selectedCountry }}</span>
                </p>
                <div id="selectedCountries" class="flex flex-row flex-wrap">
                  <div @click="deleteCountry(country)"
                       v-for="country in selectedCountries" :key="country.id"
                       class="cursor-pointer bg-gray-100 border border-gray-300 px-2 py-1 mt-1 mr-1 rounded-lg">
                    <div class="flex items-center space-x-1">
                      <span>
                        {{ country }}
                      </span>
                      <i class="fa-solid fa-xmark"></i>
                    </div>
                  </div>
                </div>
              </div>
              <div class="flex justify-end">
                <button
                    class="w-full object-right rounded-lg font-medium bg-white px-4 py-1.5 text-white disabled:opacity-25 disabled:cursor-not-allowed"
                    style="background-color:#F15922"
                    @click="submitProject"
                    :disabled="allFilledIn || this.clicked"
                > Sla dit project op
                </button>
              </div>
            </form>
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
import {ref, computed} from 'vue'
import countries from '../assets/data/countries.json'
import axios from 'axios';
import skills from "@/components/admin/profile/skills";
import Toast from "vue-toastification";
import {useToast} from "vue-toastification";

export default {
  name: "createProjects",
  methods: {
    submitProject() {
      this.clicked = true;

      const requestBody = {
        name: this.name,
        status: this.status,
        created: this.date,
        description: this.description,
        // TODO Add skills instead of countries
        skills: this.skills
      }

      axios.post('http://localhost:8080/api/projects/', requestBody)
          .then((res) => {
            this.toast.success("Project genaamd: \"" + this.name + "\", is met succes aangemaakt", {
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
            // TODO Redirect to home page
          })
          .catch((error) => {
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
  data() {
    return {
      name: "",
      description: "",
      skills: [],
      date: new Date(),
      status: 0,
      clicked: false
    }
  },
  computed: {
    getName() {
      return this.name
    },
    allFilledIn() {
      // Checks if the name and description are filled in
      const name = this.name;
      const description = this.description;

      // Return if both are filled in or not
      return !(name && description);
    }
  },
  setup() {
    const toast = useToast();

    let selectedCountries = []
    let searchTerm = ref('')
    const searchCountries = computed(() => {
      if (searchTerm.value === '') {
        return []
      }
      let matches = 0
      return countries.filter(country => {
        if (country.name.toLowerCase().includes(searchTerm.value.toLowerCase()) && matches < 5) {
          matches++
          return country
        }
      })
    });

    const selectCountry = (country) => {
      selectedCountries.push(country)
      searchTerm.value = ''
      console.log(selectedCountries)
    }

    let selectedCountry = ref('')

    return {
      countries,
      searchTerm,
      searchCountries,
      selectCountry,
      selectedCountry,
      selectedCountries,
      toast
    }
  }
}
</script>

<style scoped>

</style>