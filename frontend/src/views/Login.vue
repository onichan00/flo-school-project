<template>

  <div class="flex flex-col md:flex-row h-screen w-screen m-sm:flex-column">
    <section class="md:w-1/2" style='background-image: linear-gradient(to right, #F15922 , #f17822)'>
      <div class="flex flex-col items-center md:mt-0 sm:max-w-xl xl:p-0 text-left justify-center text-white
       mx-auto md:h-screen  lg:py-0">
        <div>
          <h3 class="text-2xl font-bold text-left mb-7">FLORIJN</h3>
          <h1 class="text-5xl font-semibold mb-5">Why you should choose Florijn?</h1>
        </div>
        <div>
          <p class="text-md font-light">Because with Florijn, you can be sure you'll get it right. Whatever your
            question is. We are especially good at building Business Tools, which can be large or small, simple or
            complex. As long as your business process benefits from it. Because that's what we look at first.</p>
          <img src="../assets/img/undraw_sign_in_re_o58h-2.svg"
               class="mb-6">
          <p class="text-md font-medium mb-3">Wait, don't have an account yet? What are you waiting for? Sign up!</p>
          <button type="submit" class="w-full rounded-lg font-medium bg-white px-4 py-1.5 text-black"> Sign up</button>
          <br>
          <br>
        </div>
      </div>
    </section>

    <section class="md:w-1/2 m-2">
      <div class="flex flex-col items-center justify-center mx-auto md:h-screen lg:py-0">
        <div class="w-full bg-white rounded-lg md:mt-0 sm:max-w-xl xl:p-0">
          <a href="#" class="flex text-left items-center mb-6 text-3xl font-semibold text-gray-900 dark:text-white">
            Hello, Welcome Back!
          </a>
          <div class="mt-10 space-y-5">
            <h1 class="text-xl text-left font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white">
              Sign in to your account
            </h1>
            <form class="space-y-4 md:space-y-6" action="#">
              <div>
                <label for="email" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Your
                  email</label>
                <input type="email" name="email" id="email" class="bg-gray-50 border border-gray-300 text-gray-900
                sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5
                dark:focus:border-blue-500" placeholder="name@company.com" required="">
              </div>
              <div>
                <label for="password" class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Password</label>
                <input type="password" name="password" id="password" placeholder="••••••••"
                       class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                       required="">
              </div>
              <div class="flex items-center justify-between">
                <div class="flex items-start">
                  <div class="flex items-center h-5">
                    <input id="remember" aria-describedby="remember" type="checkbox"
                           class="w-4 h-4 text-orange-500 border border-gray-300 focus:ring-orange-500 rounded bg-gray-50"
                           required="">
                  </div>
                  <div class="ml-3 text-sm">
                    <label for="remember" class="text-gray-500 dark:text-gray-300">Remember me</label>
                  </div>
                </div>
                <a href="#" class="text-sm font-semibold hover:underline" style="color: #F15922">Forgot
                  password?</a>
              </div>
              <button type="submit" class="w-full rounded-lg font-medium bg-white px-4 py-1.5 text-white"
                      style="background-color:#F15922 "> Sign in
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
  name: "ViewLogin"
}
</script>

<style scoped>

</style>