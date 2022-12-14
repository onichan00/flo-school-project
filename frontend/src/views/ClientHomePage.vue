<template>
  <section class="rounded-b-lg text-left" style='background-image: linear-gradient(to right, #F15922 , #f17822)'>
    <div class="grid py-8 px-4 mx-auto max-w-screen-xl lg:gap-8 xl:gap-0 lg:py-16 lg:grid-cols-12">
      <div class="place-self-center mr-auto lg:col-span-7">
        <h1 class="mb-4 max-w-2xl text-4xl font-extrabold leading-none md:text-5xl xl:text-6xl text-white">Welkom {{ fullName }}</h1>
        <p class="mb-6 max-w-2xl font-light text-gray-500 lg:mb-8 md:text-lg lg:text-xl text-gray-100">Beheren van projecten en nog veel meer!</p>
        <a @click="this.$router.push('/client/projects-overview')" class="bg-white inline-flex justify-center items-center py-3 px-5 text-base font-medium text-center text-gray-900 rounded-lg border border-gray-300 hover:bg-gray-100 focus:ring-4 focus:ring-gray-100 ">
          Overzicht Projecten
          <svg class="ml-1 w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M14 5l7 7m0 0l-7 7m7-7H3"></path></svg>
        </a>
      </div>
      <div class="hidden lg:mt-0 lg:col-span-5 lg:flex">
        <img :src="require('@/assets/img/undraw_organizing_projects_re_9p1k.svg')" alt="mockup">
      </div>
    </div>
  </section>

  <section class="bg-white dark:bg-gray-800 text-left ">
    <div class="py-8 px-4 mx-auto max-w-screen-xl sm:py-16 lg:px-6">
      <div class="mb-8 max-w-screen-md lg:mb-16">
        <h2 class="mb-4 text-4xl font-extrabold text-gray-900 dark:text-white">Hoe werkt het?</h2>
        <p class="text-gray-500 sm:text-xl dark:text-gray-400">Hier kunt u (heel) gemakkelijk projecten aanmaken, beheren en in contact blijven met uw team. Zo werkt het:</p>
      </div>
      <div class="space-y-8 md:grid md:grid-cols-2 lg:grid-cols-3 md:gap-12 md:space-y-0">
        <div>
          <div class="flex justify-center items-center mb-4 w-10 h-10 rounded-full bg-primary-100 lg:h-12 lg:w-12 dark:bg-primary-900">
            <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M13 9l3 3m0 0l-3 3m3-3H8m13 0a9 9 0 11-18 0 9 9 0 0118 0z"></path></svg>
          </div>
          <h3 class="mb-2 text-xl font-bold dark:text-white">Beginnen</h3>
          <p class="text-gray-500 dark:text-gray-400">Ga naar de "Projecten" pagina, klik op "+" om een nieuw project aan te maken.</p>
        </div>
        <div>
          <div class="flex justify-center items-center mb-4 w-10 h-10 rounded-full bg-primary-100 lg:h-12 lg:w-12 dark:bg-primary-900">
            <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 13h6m-3-3v6m5 5H7a2 2 0 01-2-2V5a2 2 0 012-2h5.586a1 1 0 01.707.293l5.414 5.414a1 1 0 01.293.707V19a2 2 0 01-2 2z"></path></svg>
          </div>
          <h3 class="mb-2 text-xl font-bold dark:text-white">Creëren</h3>
          <p class="text-gray-500 dark:text-gray-400">Vul het formulier in om een project aan te maken, druk vervolgens op "Sla dit Project op".</p>
        </div>
        <div>
          <div class="flex justify-center items-center mb-4 w-10 h-10 rounded-full bg-primary-100 lg:h-12 lg:w-12 dark:bg-primary-900">
            <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 8v4l3 3m6-3a9 9 0 11-18 0 9 9 0 0118 0z"></path></svg>
          </div>
          <h3 class="mb-2 text-xl font-bold dark:text-white">Afwachten</h3>
          <p class="text-gray-500 dark:text-gray-400">Wij gaan hard aan de slag met het vinden van specialisten voor uw project.</p>
        </div>
        <div>
          <div class="flex justify-center items-center mb-4 w-10 h-10 rounded-full bg-primary-100 lg:h-12 lg:w-12 dark:bg-primary-900">
            <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M11 3.055A9.001 9.001 0 1020.945 13H11V3.055z"></path><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M20.488 9H15V3.512A9.025 9.025 0 0120.488 9z"></path></svg>
          </div>
          <h3 class="mb-2 text-xl font-bold dark:text-white">Beheren</h3>
          <p class="text-gray-500 dark:text-gray-400">U kunt uw project beheren d.m.v. mededelingen te delen met het team en de beschrijving en de status aan te passen.</p>
        </div>
        <div>
          <div class="flex justify-center items-center mb-4 w-10 h-10 rounded-full bg-primary-100 lg:h-12 lg:w-12 dark:bg-primary-900">
            <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 4.354a4 4 0 110 5.292M15 21H3v-1a6 6 0 0112 0v1zm0 0h6v-1a6 6 0 00-9-5.197M13 7a4 4 0 11-8 0 4 4 0 018 0z"></path></svg>
          </div>
          <h3 class="mb-2 text-xl font-bold dark:text-white">Specialisten</h3>
          <p class="text-gray-500 dark:text-gray-400">Ook kunt u gemakkelijk in contact komen met de specialisten, zo kunt u gemakkelijk de gegevens vinden van elke specialist bij "Specialisten".</p>
        </div>
        <div>
          <div class="flex justify-center items-center mb-4 w-10 h-10 rounded-full bg-primary-100 lg:h-12 lg:w-12 dark:bg-primary-900">
            <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 12l2 2 4-4M7.835 4.697a3.42 3.42 0 001.946-.806 3.42 3.42 0 014.438 0 3.42 3.42 0 001.946.806 3.42 3.42 0 013.138 3.138 3.42 3.42 0 00.806 1.946 3.42 3.42 0 010 4.438 3.42 3.42 0 00-.806 1.946 3.42 3.42 0 01-3.138 3.138 3.42 3.42 0 00-1.946.806 3.42 3.42 0 01-4.438 0 3.42 3.42 0 00-1.946-.806 3.42 3.42 0 01-3.138-3.138 3.42 3.42 0 00-.806-1.946 3.42 3.42 0 010-4.438 3.42 3.42 0 00.806-1.946 3.42 3.42 0 013.138-3.138z"></path></svg>
          </div>
          <h3 class="mb-2 text-xl font-bold dark:text-white">Afronden</h3>
          <p class="text-gray-500 dark:text-gray-400">Als u klaar bent met het project kunt u gemakkelijk het project afronden door de status te veranderen van het project.</p>
        </div>
      </div>
    </div>
  </section>

  <section class="bg-gray-50 dark:bg-gray-900 text-left">
    <div class="gap-16 items-center py-8 px-4 mx-auto max-w-screen-xl flex flex-row">
      <div class="font-light text-gray-500 sm:text-lg dark:text-gray-400 w-2/3">
        <h2 class="mb-4 text-4xl font-extrabold text-gray-900 dark:text-white">Voordelen van Florijn</h2>
        <p class="mb-4">Bij ons kunt u genieten van veel voordelen, denk aan: nooit meer handmatig projecten beheren,
          nooit meer externe partijen gebruiken om specialisten te vinden en genieten terwijl uw ideeën tot leven worden gebracht.</p>
      </div>
      <div class="w-1/3">
        <img class="w-full rounded-lg" :src="require('@/assets/img/undraw_project_complete_lwss.svg')" alt="office content 1">
      </div>
    </div>
  </section>

</template>

<script>
import axios from "axios";

export default {
  name: "ClientHomePage",
  data() {
    return {
      userId: localStorage.getItem('id'),
      user: [],
    }
  },
  created() {
    this.getUserData()
  },
  methods: {
    getUserData() {
      axios.get(process.env.VUE_APP_API_URL + `/api/users/${this.userId}`)
          .then((res) => {
            this.user = res.data;
          })
          .catch((err) => {
            console.log(err);
          })
    },
  },
  computed: {
    fullName() {
      return (String(this.user.first_name).charAt(0).toUpperCase() + String(this.user.first_name).slice(1))
          + ' '
          + String(this.user.last_name).charAt(0).toUpperCase() + String(this.user.last_name).slice(1);
    }
  }
}
</script>

<style scoped>

</style>