<template>

  <div class="flex flex-col md:flex-row h-screen w-screen m-sm:flex-column">
    <section class="md:w-1/2" style='background-image: linear-gradient(to right, #F15922 , #f17822)'>
      <div class="flex flex-col items-center md:mt-0 sm:max-w-xl xl:p-0 text-left justify-center text-white
       mx-auto md:h-screen  lg:py-0">
        <div>
          <h3 class="text-2xl font-bold text-left mb-7">FLORIJN</h3>
          <h1 class="text-5xl font-semibold mb-5">Waarom je voor Florijn zou kiezen?</h1>
        </div>
        <div>
          <p class="text-md font-light">Want met Florijn weet je zeker dat het goed komt. Wat uw vraag ook is. Wij zijn vooral goed in het bouwen van Business Tools,
            die groot of klein, eenvoudig of complex kunnen zijn. Zolang uw bedrijfsproces er maar baat bij heeft. Want daar kijken we als eerste naar.</p>
          <img :src="require('../assets/img/undraw_sign_in_re_o58h-2.svg')"
               class="mb-6">
          <p class="text-md font-medium mb-3">Wacht, heb je nog geen account? Waar wacht je nog op? Schrijf je in!</p>
          <button @click="this.$router.push('/register')" type="submit"
                  class="w-full rounded-lg font-medium bg-white px-4 py-1.5 text-black"> Registreer
          </button>
          <br>
          <br>
        </div>
      </div>
    </section>

    <section class="md:w-1/2 m-2">
      <div class="flex flex-col items-center justify-center mx-auto md:h-screen lg:py-0">
        <div class="w-full bg-white rounded-lg md:mt-0 sm:max-w-xl xl:p-0">
          <a href="#" class="flex text-left items-center mb-6 text-3xl font-semibold text-gray-900 dark:text-white">
            Hallo, welkom terug!
          </a>
          <div class="mt-10 space-y-5">
            <h1 class="text-xl text-left font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white">
              Aanmelden bij uw account
            </h1>
            <form class="space-y-4 md:space-y-6" action="#">
              <div>
                <label for="email" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Uw
                  emailadres</label>
                <input type="email" name="email" id="email" class="bg-gray-50 border border-gray-300 text-gray-900
                sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5
                dark:focus:border-blue-500" placeholder="name@company.com" required="" v-model="email">
              </div>
              <div>
                <label for="password" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Wachtwoord</label>
                <input type="password" name="password" id="password" placeholder="••••••••"
                       class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                       required="" v-model="password">
              </div>
              <div class="flex items-center justify-between">
                <div class="flex items-start">
                  <div class="flex items-center h-5">
                    <input id="remember" aria-describedby="remember" type="checkbox"
                           class="w-4 h-4 text-orange-500 border border-gray-300 focus:ring-orange-500 rounded bg-gray-50"
                           required="">
                  </div>
                  <div class="ml-3 text-sm">
                    <label for="remember" class="text-gray-500 dark:text-gray-300">Onthoud mij</label>
                  </div>
                </div>
              </div>

            </form>
            <button class="w-full rounded-lg font-medium bg-white px-4 py-1.5 text-white"
                    style="background-color:#F15922 " @click="loginRequest"> Inloggen
            </button>
          </div>
        </div>
      </div>
    </section>

  </div>

</template>

<script>
import axios from "axios";
import {useToast} from "vue-toastification";


export default {
  name: "ViewLogin",
  data() {
    return {
      email: null,
      password: null,
      toast: useToast(),

    }
  },

  methods: {
    async loginRequest() {
      console.log("wtkkf")
      let request = await axios.post(process.env.VUE_APP_API_URL + "/api/users/login", {
        email: this.email,
        password: this.password,
      }).catch((err) => {
        console.log(err)
        this.toast.error("email or password are not correct")
      })

      if (request.status === 200) {

        let response = request.data
        let userType = response.userType
        localStorage.setItem("id", response.id)
        localStorage.setItem("userType", response.userType)


        if (userType === 0) {
          this.$router.push("/admin").then( () => {
            this.$router.go()
          })
        }
        if (userType === 1) {

          this.$router.push("/client/dashboard").then( () => {
            this.$router.go().then( () => {
              this.$router.go()
            })
          })
        }

        if (userType === 2) {

          this.$router.push("/specialist/dashboard").then( () => {
            this.$router.go()
          })
        }
        // location.reload()
      }
    }
  }
}

</script>

<style scoped>

</style>