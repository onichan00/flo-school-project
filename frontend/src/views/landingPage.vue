<template>
  <div>

    <nav
        class="top-0 absolute z-50 w-full flex flex-wrap items-center justify-between px-2 py-3 "
    >
      <div
          class="container px-4 mx-auto flex flex-wrap items-center justify-between"
      >
        <div
            class="w-full relative flex justify-between lg:w-auto lg:static lg:block lg:justify-start"
        >
          <a
              class="text-3xl font-bold leading-relaxed inline-block mr-4 py-2 whitespace-nowrap uppercase text-white"
              href="#"
          >FLORIJN</a
          >
          <button
              class="cursor-pointer text-xl leading-none px-3 py-1 border border-solid border-transparent rounded bg-transparent block lg:hidden outline-none focus:outline-none"
              type="button"
              v-on:click="toggleNavbar()"
          >
            <i class="text-white fas fa-bars"></i>
          </button>
        </div>
        <div
            class="lg:flex flex-grow items-center bg-white lg:bg-transparent lg:shadow-none"
            v-bind:class="{'hidden': !showMenu, 'block': showMenu}"
        >
          <ul class="flex flex-col lg:flex-row list-none mr-auto">
          </ul>
          <ul class="flex flex-col lg:flex-row list-none lg:ml-auto">
            <li class="flex items-center">
              <button
                  @click="goToLogin"
                  to="/login"
                  class="bg-white text-gray-800 active:bg-gray-100 text-md font-bold px-4 py-2 rounded-md shadow hover:shadow-md outline-none focus:outline-none lg:mr-1 lg:mb-0 ml-3 mb-3"
                  type="button"
                  style="transition: all 0.15s ease 0s;">
                <i class="fa-solid fa-right-to-bracket"></i> Sign Up or Login
              </button>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <main>
      <div
          class="relative pt-16 pb-32 flex content-center items-center justify-center"
          style="min-height: 75vh;"
      >
        <div
            class="absolute top-0 w-full h-full bg-center bg-cover"
            style='background-image: linear-gradient(to right, #F15922 , #f19022)'
        >

        </div>
        <div class="container relative mx-auto">
          <div class="items-center flex flex-wrap">
            <div class="w-full lg:w-6/12 px-4 ml-auto mr-auto text-center">
              <div class="pr-12">
                <h1 class="text-white font-semibold text-5xl">
                  Smart Business Tooling

                </h1>
                <p class="text-lg mt-4 text-lg text-gray-100">
                  Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore
                  et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
                  aliquip ex ea commodo consequat.
                </p>
              </div>
            </div>
          </div>
        </div>
        <div>
          <svg
              class="absolute bottom-0 overflow-hidden"
              xmlns="http://www.w3.org/2000/svg"
              preserveAspectRatio="none"
              version="1.1"
              viewBox="0 0 2560 100"
              x="0"
              y="0"
          >
            <polygon
                class="text-gray-200 fill-current"
                points="2560 0 2560 100 0 100"
            ></polygon>
          </svg>
        </div>
      </div>
      <section class="pb-20 bg-gray-200 -mt-24">
        <div class="container mx-auto px-4">
          <div class="flex flex-wrap">
            <div class="w-full md:w-4/12 px-4 text-center">
              <div
                  class="relative flex flex-col min-w-0 break-words bg-white w-full mb-8 shadow-lg rounded-lg"
              >
                <div class="px-4 py-5 flex-auto">
                  <div
                      class="text-white p-3 text-center inline-flex items-center justify-center w-12 h-12 mb-5 shadow-lg rounded-full bg-orange-500"
                  >
                    <i class="fa-solid fa-database"></i>
                  </div>
                  <h6 class="text-lg font-semibold">Never search for information again</h6>
                  <p class="text-md mt-2 mb-4 text-gray-600">
                    Data (lots of it), documents, forms, spreadsheets, corporate identity, it all needs to be stored.
                    And safe and findable too. This is only possible if there is a system behind it.
                  </p>
                </div>
              </div>
            </div>

            <div class="md:w-4/12 px-4 text-center">
              <div
                  class="relative flex flex-col min-w-0 break-words bg-white w-full mb-8 shadow-lg rounded-lg"
              >
                <div class="px-4 py-5 flex-auto">
                  <div
                      class="text-white p-3 text-center inline-flex items-center justify-center w-12 h-12 mb-5 shadow-lg rounded-full bg-orange-500"
                  >
                    <i class="fa-solid fa-square-root-variable"></i>
                  </div>
                  <h6 class="text-lg font-semibold">Making decisions reliably</h6>
                  <p class="text-md mt-2 mb-4 text-gray-600">
                    Plans, budgets, forecasts, all arranged and shaped so that decisions are made based on the right
                    information. Not insignificant after all.
                  </p>
                </div>
              </div>
            </div>

            <div class="w-full md:w-4/12 px-4 text-center">
              <div
                  class="relative flex flex-col min-w-0 break-words bg-white w-full mb-8 shadow-lg rounded-lg"
              >
                <div class="px-4 py-5 flex-auto">
                  <div
                      class="text-white p-3 text-center inline-flex items-center justify-center w-12 h-12 mb-5 shadow-lg rounded-full bg-orange-500"
                  >
                    <i class="fas fa-retweet"></i>
                  </div>
                  <h6 class="text-lg font-semibold">Always up-to-date</h6>
                  <p class="text-md mt-2 mb-4 text-gray-600">
                    Exchange data automatically and without fuss, that is what we strive for. Sharing documents quickly
                    and easily with your colleagues in a way that suits you and does justice to your business.
                  </p>
                </div>
              </div>
            </div>
          </div>
          <div class="flex flex-wrap items-center mt-32">
            <div class="w-full md:w-5/12 px-4 mr-auto ml-auto">
              <div
                  class="text-gray-600 p-3 text-center inline-flex items-center justify-center w-16 h-16 mb-6 shadow-lg rounded-full bg-gray-100"
              >
                <i class="fas fa-user-friends text-xl"></i>
              </div>
              <h3 class="text-2xl mb-2 font-semibold leading-normal">
                A whole team if needed
              </h3>
              <p
                  class="text-lg font-light leading-relaxed mt-4 mb-4 text-gray-700"
              >
                Or several people. Because if the job is bigger than planned and more people are needed or you start in
                Access and want to follow that up with a course in Power BI, that's possible. We have a whole team
                ready for you if needed.
              </p>

            </div>
            <div class="w-full md:w-4/12 px-4 mr-auto ml-auto">

              <img :src="require('@/assets/img/undraw_team_re_0bfe.svg')"
                   size="150px" alt="Afbeelding">


            </div>
          </div>
        </div>
        <br>
        <br>
        <br>
      </section>
      <section class="relative py-20">
        <div>
          <svg
              class="absolute bottom-0 overflow-hidden"
              xmlns="http://www.w3.org/2000/svg"
              preserveAspectRatio="none"
              version="1.1"
              viewBox="0 0 2560 100"
              x="0"
              y="0"
          >
            <polygon
                class="text-white fill-current"
                points="2560 0 2560 100 0 100"
            ></polygon>
          </svg>
        </div>
        <div class="container mx-auto px-4">
          <div class="items-center flex flex-wrap">
            <div class="w-full md:w-4/12 ml-auto mr-auto px-4">
              <img :src="require('@/assets/img/undraw_developer_activity_re_39tg.svg')">
            </div>
            <div class="w-full md:w-5/12 ml-auto mr-auto px-4">
              <div class="md:pr-12">
                <div
                    class="text-orange-600 p-3 text-center inline-flex items-center justify-center w-16 h-16 mb-6 shadow-lg rounded-full bg-orange-200"
                >
                  <i class="fas fa-rocket text-xl"></i>
                </div>
                <h3 class="text-2xl font-semibold">Consider "IT" done</h3>
                <p class="mt-4 text-lg leading-relaxed text-gray-600">
                  And because our comprehensive intake means we've already thought through the solution to your problem
                  and we always have the right person for the job, you can sit back, with your feet on your desk,
                  because it's going to get done anyway. Whether it's Power BI, Excel, Access, Power Apps or custom
                  software: consider IT done.
                </p>
              </div>
            </div>
          </div>
        </div>
      </section>

      <br>
      <br>
      <br>

      <section class="pb-20 relative bg-orange-200">
        <div class="container mx-auto px-4 lg:pt-20">
          <div class="flex flex-wrap text-center justify-center">
            <div class="w-full lg:w-6/12 px-4">
              <h2 class="text-2xl font-semibold">Why you should be at Florijn for this? </h2>
              <p class="text-lg leading-relaxed mt-4 mb-4 text-gray-500">
                Florin AWS is certainly not the only IT service provider. There are plenty to choose from. So why
                Florijn anyway? Because with Florijn, you can be sure you'll get it right. No matter what your
                question is. We are especially good at building Business Tools, which can be large or small, simple or
                complex.
              </p>
            </div>
          </div>

          <button
              class="bg-white text-gray-800 active:bg-gray-100 text-2xl font-bold mt-16 px-4 py-2 rounded-md shadow hover:shadow-md outline-none focus:outline-none lg:mr-1 lg:mb-0 ml-3 mb-3"
              type="button"
              style="transition: all 0.15s ease 0s;"
              @click="goToLogin">
            <i  class="fa-solid fa-right-to-bracket"></i> Sign Up or Login
          </button>
        </div>
      </section>
    </main>
  </div>
</template>

<script>
export default {
  name: "ViewLandingPage",

  methods: {
    goToLogin(){
      this.$router.push("/login")
    }
  }
}
</script>

<style scoped>

</style>