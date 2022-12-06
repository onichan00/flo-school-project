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
          <img src="../assets/img/undraw_welcome_re_h3d9-2.svg"
               class="mb-6 justify-center m-auto"
               style="max-height: 400px">
          <p class="text-md font-medium mb-3">If you already have an account you don't need to sign up</p>
          <button type="submit" class="w-full rounded-lg font-medium bg-white px-4 py-1.5 text-black"> Sign in</button>
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
                    <input type="text" name="floating_first_name" id="floating_first_name"
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                           placeholder="John" required/>
                  </div>
                  <div class="relative z-0 mb-6 w-full group">
                    <label for="floating_first_name"
                           class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Preposition
                      (optional)</label>
                    <input type="text" name="floating_first_name" id="floating_first_name"
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                           placeholder="van" required/>
                  </div>
                  <div class="relative z-0 mb-6 w-full group">
                    <label for="floating_last_name"
                           class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Last
                      name</label>
                    <input type="text" name="floating_last_name" id="floating_last_name"
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                           placeholder="Doe" required/>
                  </div>
                </div>
                <div class="grid md:grid-cols-2 md:gap-6">
                  <div>
                    <label for="email" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Your
                      email</label>
                    <input type="email" name="email" id="email" class="bg-gray-50 border border-gray-300 text-gray-900
                sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5
                dark:focus:border-blue-500" placeholder="name@company.com" required="">
                  </div>
                  <div>
                    <label for="email" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Phonenumber</label>
                    <input type="email" name="email" id="email" class="bg-gray-50 border border-gray-300 text-gray-900
                sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5
                dark:focus:border-blue-500" placeholder="06 12 34 56 78" required="">
                  </div>
                </div>
              </div>
              <div class="grid md:grid-cols-2 md:gap-6">

                <div>
                  <label for="password" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Password</label>
                  <input type="password" name="password" id="password" placeholder="••••••••"
                         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                         required="">
                </div>
                <div>
                  <label for="password" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Repeat
                    password</label>
                  <input type="password" name="password" id="password" placeholder="••••••••"
                         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                         required="">
                </div>

              </div>

              <div class="flex items-center justify-between grid md:grid-cols-2 md:gap-6">
                <div>
                  <label for="countries" class="block mb-2 text-left text-sm font-medium text-gray-900 dark:text-gray-400">Select
                    an option</label>
                  <select id="countries"
                          class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                    <option selected>Choose an account type</option>
                    <option value="1">Client</option>
                    <option value="2">Specialist</option>
                  </select>
                </div>
                <div>
                  <label for="countries" class="block mb-2 text-left text-sm font-medium text-gray-900 dark:text-gray-400">Select
                    an option</label>
                  <select id="countries"
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

              <button type="submit" class="w-full rounded-lg font-medium bg-white px-4 py-1.5 text-white"
                      style="background-color:#F15922 "> Sign up
              </button>
            </form>
          </div>
        </div>
      </div>
    </section>

  </div>

</template>

<script>
export default {
  name: "RegisterPage"


  //TODO hier nog de data uit de fe plukken en sturen naar db
  /*
  ,
  data() {
    return {
      email: null,
      password: null,
      toast: useToast(),

    }
  },

  methods: {
    async loginRequest(){
      let request = await axios.post("http://localhost:8080/api/users/login", {
        email: this.email,
        password: this.password,
      }).catch((err) => {
        console.log(err)
        this.toast.error("email or password are not correct")
      })

      if (request.status == 200){

        let response = request.data
        // this.$session.start()
        // this.$session.set("userId", response.id)

        if (response.admin === true){
          // this.$session.set("admin", true)

          this.$router.push("/dashboard")
        }
        if (response.client === true){
          // this.$session.set("client", true)

          this.$router.push("/notfound")
        }

        if (response.specialist === true){
          // this.$session.set("specialist", true)

          this.$router.push("/notfound")
        }
      }
    }
  }
   */
}
</script>

<style scoped>

</style>