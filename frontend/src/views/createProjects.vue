<template>
  <div class="flex flex-col md:flex-row h-screen w-screen m-sm:flex-column">

    <section class="md:w-1/2 m-2 object-left">
      <div class="flex flex-col items-center justify-center mx-auto md:h-screen lg:py-0">
        <div class="w-full bg-white rounded-lg md:mt-0 sm:max-w-xl xl:p-0">
          <h1 href="#" class="text-3xl text-orange-500 font-bold text-left mb-7"> FLORIJN</h1>
          <h1 class="flex text-left items-center mb-6 text-4xl font-semibold text-gray-900 dark:text-white">
            Creeër Project
          </h1>
          <div class="mt-10 space-y-5">
            <form class="space-y-4 md:space-y-6" action="#">
              <div>
                <label for="name" class="block text-left mb-2 text-m font-medium text-gray-900 dark:text-white">Geef
                  je project een naam</label>
                <input type="text" name="name" id="name" v-model="this.name" class="bg-gray-50 border border-gray-300 text-gray-900
                sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5
                dark:focus:border-blue-500" placeholder="Project naam">
              </div>
              <div>
                <label for="description" class="block text-left mb-2 text-m font-medium text-gray-900 dark:text-white">Project
                  beschrijving</label>
                <p class="block text-left mb-2 text-sm  text-gray-600">Nuttig voor teams of om onderscheid te maken
                  tussen projecten met vergelijkbare namen</p>
                <textarea id="description" rows="4" v-model="this.description"
                          class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-orange-500 focus:border-orange-500"
                          placeholder="Schrijf hier uw beschrijving.."></textarea>
              </div>
              <div>
                <label for="search" class="block text-left mb-2 text-m font-medium text-gray-900 dark:text-white">
                  Type de naam van een skill
                </label>
                <p class="block text-left mb-2 text-sm  text-gray-600">Nuttig voor specialisten</p>
                <input type="text" id="search" placeholder="Zoek hier de skills" class="w-full bg-gray-50 border border-gray-300 text-gray-900
                sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500">
                <ul v-if="searchCountries.length"
                    class="w-1/4 rounded-lg bg-white border border-gray-300 px-4 py-2 space-y-1 absolute z-10">
                  <li class="px-1 pt-1 pb-2 font-bold border-b border-gray-200"> Showing {{ searchCountries.length }} of
                    {{ countries.length }} results
                  </li>
                  <li v-for="country in searchCountries" :key="country.name" @click="selectCountry(country.name)"
                      class="cursor-pointer hover:bg-orange-100 p-1">
                    {{ country.name }}
                  </li>
                </ul>
                <p v-if="selectedCountry" class="text-lg pt-2 absolute">
                  You have selected: <span class="font-semibold">{{ selectedCountry }}</span>
                </p>
                <div id="selectedCountries" class="flex flex-row" v-for="country in selectedCountries" :key="country.id">
                  <div @click="deleteCountry(country)" class="cursor-pointer bg-gray-100 border border-gray-300 p-1 mt-1 mr-1 rounded-lg">
                    <a>{{ country }} <i class="fa-solid fa-xmark"> </i></a>
                  </div>
                </div>
              </div>
              <div class="flex justify-end">
                <button class="w-full object-right rounded-lg font-medium bg-white px-4 py-1.5 text-white"
                        style="background-color:#F15922"
                        data-modal-toggle="staticModal" @click="submitProject"> Save this project
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>

    <section class="md:w-1/2" style='background-image: linear-gradient(to right, #F15922 , #f17822)'>
      <div class="flex flex-col md:mt-0 sm:max-w-xl xl:p-0 text-left justify-center text-white
       mx-auto md:h-screen  lg:py-0">
        <div class="text-left">
          <h1 class="text-5xl font-semibold mb-5">Projecten</h1>
        </div>
        <div>
          <p class="text-md font-light">Op deze pagina kunt u uw eigen project aanmaken. U kunt het project een naam
            en een beschrijving geven, ook kunt u skills opzoeken die specialisten moeten hebben om aan dit project mee
            te kunnen doen. Als u een project heeft aangemaakt kunt u specialisten vinden die overeenkomen met de skills</p>
          <img src="require(../assets/img/undraw_add_to_cart_re_wrdo-2.svg)" class="mb-6" alt="Project Image">
          <br>
          <br>
        </div>
      </div>
    </section>
  </div>

</template>

<script>
import {ref, computed} from 'vue'
import countries from '../assets/data/countries.json'
import axios from "axios";

export default {
  name: "createProjects",
  methods: {
    submitProject() {
    },
  },
  data() {
    return {
      name: "",
      description: "",
      skills: []
    }
  },
  computed: {
    getName(){
      return this.name
    },
  },
  setup() {
    let selectedCountries = []
    let searchTerm = ref('')
    const searchCountries = computed(() => {
      if (searchTerm.value === '') {
        return []
      }
      let matches = 0
      return countries.filter(country => {
        if (country.name.toLowerCase().includes(searchTerm.value.toLowerCase()) && matches < 4) {
          matches++
          return country
        }
      })
    });

    const deleteCountry = (country, x) => {
      for (let i = 0; i <selectedCountries.length; i++) {
        if (country == selectedCountries[i]) {
          selectedCountries.splice(i, 1)
          console.log(x)
        }
      }
    }

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
      deleteCountry,
    }
  }
}
</script>

<style scoped>

</style>