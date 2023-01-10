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
                <i class="fa-solid fa-right-to-bracket"></i> uitloggen
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
                  Het is nog even wachten!

                </h1>
                <p class="text-lg mt-4 text-lg text-gray-100">
                  Je bent succesvol aangemeld en je aanvraag is in behandeling!
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

          </div>
          <div class="flex flex-wrap items-center mt-32">
            <div class="w-full md:w-5/12 px-4 mr-auto ml-auto">
              <div
                  class="text-gray-600 p-3 text-center inline-flex items-center justify-center w-16 h-16 mb-6 shadow-lg rounded-full bg-gray-100"
              >
                <i class="fas fa-user-friends text-xl"></i>
              </div>
              <h3 class="text-2xl mb-2 font-semibold leading-normal">
                Een heel team als dat nodig is
              </h3>
              <p
                  class="text-lg font-light leading-relaxed mt-4 mb-4 text-gray-700"
              >
                Soms blijkt een klus groter dan gepland en er zijn meer mensen nodig om de digitale oplossing te bouwen,
                die jij voor ogen hebt. Of je start in Access en wilt dat laten opvolgen door een traject in Power BI.
                Dan kan dat. Wij hebben individuele programmeurs, maar ook een heel team voor je klaar staan als dat nodig is.
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
                  Tijdens onze uitgebreide intake denken wij al na over de digitale oplossing voor jouw probleem.
                  En omdat we altijd de juiste persoon for the job hebben, kan jij achterover leunen, met je voeten
                  op je bureau, want het komt sowieso goed. Of het nu gaat om Power BI, Excel, Access, Power Apps of
                  maatsoftware: consider IT done.
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
              <h2 class="text-2xl font-semibold">Waarom je voor Florijn zou kiezen?</h2>
              <p class="text-lg leading-relaxed mt-4 mb-4 text-gray-500">
                Florijn AWS is zeker niet de enige IT-dienstverlener. Er is genoeg keuze. Waarom Floris dan? Want
                bij Florijn weet je zeker dat alles goed komt. Wat je vraag ook is. We zijn vooral goed in het
                bouwen van Business Tools, van groot tot klein, van eenvoudig tot complex. Als uw bedrijfsproces
                er maar baat bij heeft. Want daar gaan we eerst naar kijken. Of we je probleem echt gaan oplossen.
                Of dat er misschien een andere vraag onder zit waar we eerst naar moeten kijken.
              </p>
            </div>
          </div>

          <button
              class="bg-white text-gray-800 active:bg-gray-100 text-2xl font-bold mt-16 px-4 py-2 rounded-md shadow hover:shadow-md outline-none focus:outline-none lg:mr-1 lg:mb-0 ml-3 mb-3"
              type="button"
              style="transition: all 0.15s ease 0s;"
              @click="goToLogin">
            <i  class="fa-solid fa-right-to-bracket"></i> uitloggen
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
      localStorage.clear()
      this.$router.push("/")
      // this.$router.go()
    }
  }
}
</script>

<style scoped>

</style>