<template>
  <div class="flex flex-col md:flex-row h-screen w-screen m-sm:flex-column">
    <section class="md:w-1/2" style='background-image: linear-gradient(to right, #F15922 , #f17822)'>
      <div class="flex flex-col items-center md:mt-0 sm:max-w-xl xl:p-0 text-left justify-center text-white
       mx-auto md:h-screen  lg:py-0">
        <div>
          <h3 class="text-2xl font-bold text-left mb-7">FLORIJN</h3>
          <h1 class="text-5xl font-semibold mb-5">Thank you for choosing Florijn!</h1>
        </div>
        <div>
          <p class="text-md font-light">We at Florijn are very pleased to have you as a new user. We are sure that we
            will not disappoint you.</p>
          <img :src="require('@/assets/img/undraw_hello_re_3evm.svg')"
               class="mb-6 justify-center m-auto"
               style="max-height: 400px">
          <p class="text-md font-medium mb-3">If you already have an account you don't need to sign up</p>
          <button @click="this.$router.push('/login')" type="submit"
                  class="w-full rounded-lg font-medium bg-white px-4 py-1.5 text-black"> Sign in
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
            Welcome to Florijn
          </a>
          <div class="mt-10 space-y-5">
            <h1 class="text-xl text-left font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white">
              Fill out the form to sign up
            </h1>
            <form class="space-y-4 md:space-y-6" action="#">
              <div>
                <div class="grid md:grid-cols-3 md:gap-6">
                  <div class="relative z-0 mb-6 w-full group">
                    <label for="floating_first_name"
                           class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">First
                      name</label>
                    <input v-model="first_name" type="text" name="floating_first_name" id="floating_first_name"
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                           placeholder="John" required/>
                  </div>
                  <div class="relative z-0 mb-6 w-full group">
                    <label for="floating_first_name"
                           class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Preposition
                      (optional)</label>
                    <input v-model="preposition" type="text" name="floating_first_name" id="floating_first_name"
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                           placeholder="van" required/>
                  </div>
                  <div class="relative z-0 mb-6 w-full group">
                    <label for="floating_last_name"
                           class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Last
                      name</label>
                    <input v-model="last_name" type="text" name="floating_last_name" id="floating_last_name"
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                           placeholder="Doe" required/>
                  </div>
                </div>
                <div class="grid md:grid-cols-2 md:gap-6">
                  <div>
                    <label for="email" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Your
                      email</label>
                    <input v-model="email" type="email" name="email" id="email" class="bg-gray-50 border border-gray-300 text-gray-900
                sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5
                dark:focus:border-blue-500" placeholder="name@company.com" required="">
                  </div>
                  <div>
                    <label for="phone" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Phonenumber</label>
                    <input v-model="phonenumber" type="phone" name="phone" id="phone" class="bg-gray-50 border border-gray-300 text-gray-900
                sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5
                dark:focus:border-blue-500" placeholder="06 12 34 56 78" required="">
                  </div>
                </div>
              </div>
              <div class="grid md:grid-cols-2 md:gap-6">

                <div>
                  <label for="password" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Password</label>
                  <input v-model="password" type="password" name="password" id="password" placeholder="••••••••"
                         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                         required="">
                </div>
                <div>
                  <label for="password" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Repeat
                    password</label>
                  <input v-model="repeatPassword" type="password" name="password" id="password" placeholder="••••••••"
                         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                         required="">
                </div>

              </div>

              <div class="flex items-center justify-between grid md:grid-cols-2 md:gap-6">
                <div>
                  <label for="countries"
                         class="block mb-2 text-left text-sm font-medium text-gray-900 dark:text-gray-400">Select
                    an option</label>
                  <select v-model="userType" id="countries"
                          class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                    <option selected>Choose an account type</option>
                    <option value="1">Client</option>
                    <option value="2">Specialist</option>
                  </select>
                </div>
                <div>
                  <label for="countries"
                         class="block mb-2 text-left text-sm font-medium text-gray-900 dark:text-gray-400">Select
                    an option</label>
                  <select v-model="gender" id="countries"
                          class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                    <option selected>Choose a gender</option>
                    <option value="1">Male</option>
                    <option value="2">Female</option>
                    <option value="3">I'd rather not say</option>
                    <option value="4">Other</option>
                  </select>
                </div>
              </div>
              <div class="flex items-start">
                <div class="flex items-center h-5">
                  <input id="remember" aria-describedby="remember" type="checkbox"
                         class="w-4 h-4 text-orange-500 border border-gray-300 focus:ring-orange-500 rounded bg-gray-50"
                         required="">
                </div>
                <div class="ml-3 text-sm">
                  <label for="remember" class="text-gray-500 dark:text-gray-300">I agree to the Terms and
                    Conditions</label>
                </div>
              </div>


            </form>
            <button @click="registerRequest" class="w-full rounded-lg font-medium bg-white px-4 py-1.5 text-white"
                    style="background-color:#F15922 "> Sign up
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
  name: "RegisterPage"


  //TODO hier nog de data uit de fe plukken en sturen naar db
  ,
  data() {
    return {
      email: null,
      password: null,
      repeatPassword: null,
      first_name: null,
      preposition: null,
      last_name: null,
      phonenumber: null,
      userType: null,
      gender: null,
      toast: useToast(),
    }
  },

  methods: {
    async registerRequest() {
      console.log("test")
      let request = await axios.post(process.env.VUE_APP_API_URL + "/api/users/register", {
        email: this.email,
        password: this.password,
        first_name: this.first_name,
        second_name: this.preposition,
        last_name: this.last_name,
        phone: this.phonenumber,
        userType: this.userType
      }).catch((err) => {
        console.log(err)
        this.toast.error("check gegevens na")
      })

      if (request.status === 200) {

        let response = request.data

        localStorage.setItem("id", response.id)

        if (response.isAdmin === true) {
          localStorage.setItem("isAdmin", "true")

          this.$router.push("/admin")
        }
        if (response.isClient === true) {
          localStorage.setItem("isClient", "true")

          this.$router.push("/notfound")
        }

        if (response.isSpecialist === true) {
          localStorage.setItem("isSpecialist", "true")

          this.$router.push("/notfound")
        }
      }
    }
  }
}
</script>

<style scoped>

</style>