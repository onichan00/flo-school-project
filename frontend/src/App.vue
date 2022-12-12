<template>
  <!--  <img alt="Vue logo" src="./assets/logo.png">-->
  <!--  <LandingPage v-if="showLandingPage"/>-->
  <!--  <Login v-if="showLogin"/>-->
  <!--  <RegisterPage v-if="showRegister"/>-->
  <div v-if="this.loginStatus === false">
    <router-view/>
  </div>

  <div v-show="this.loginStatus === true">
    <Sidebar/>
    <div :style="{ 'margin-left': sidebarWidth }">
      <PageHeader/>
      <router-view/>

      <Footer></Footer>
    </div>
  </div>
</template>

<script>
import Sidebar from "@/components/miscellaneous/sidebar/Sidebar";
import {sidebarWidth} from '@/components/miscellaneous/sidebar/state.js'
import PageHeader from "@/components/PageHeader";
import Footer from "@/components/Footer";

// Models
import client from "@/models/client";
import specialist from "@/models/specialist";
import project from "@/models/project";
import availableHour from "@/models/availableHour";
import skill from "@/models/skill";
// Dummy data
import clientsData from "@/assets/data/clients.json";
import projectsData from "@/assets/data/projects.json";
import specialistsData from "@/assets/data/specialists.json";
import availableHoursData from "@/assets/data/availableHours.json";
import skillsData from "@/assets/data/skills.json";

export default {
  name: 'App',
  components: {
    // RegisterPage,
    Sidebar,
    Footer,
    PageHeader,
    // Login,
    // LandingPage
  },

  data() {
    return {
      specialists: [],
      projects: [],
      clients: [],
      availableHours: [],
      skills: [],
      loginStatus: false,
      isAdmin: false,
      isClient: false,
      isSpecialist: false,
    }
  },
  mounted() {
    if (localStorage.getItem("id") != null) {

      console.log("test")
      this.loginStatus = true;
      if (localStorage.getItem("isAdmin") === true) {
        this.isAdmin = true;
      }
      if (localStorage.getItem("isClient") === true) {
        this.isClient = true;
      }
      if (localStorage.getItem("isSpecialist") === true) {
        this.isSpecialist = true;
      }
    } else return false
  },

  computed: {

    showLandingPage() {
      if (this.$route.path == "/landing-page") {
        return true
      } else {
        return false
      }
    },

    showLogin() {
      if (this.$route.path == "/login") {
        return true
      } else {
        return false
      }
    },

    showRegister() {
      if (this.$route.path == "/register") {
        return true
      } else {
        return false
      }
    }

  },

  provide() {
    // use function syntax so that we can access `this`
    return {
      specialists: this.specialists,
      projects: this.projects,
      clients: this.clients,
      availableHours: this.availableHours,
      skills: this.skills
    }
  },

  created() {
    specialistsData.forEach((element) => {
      this.specialists.push(new specialist(element));
    });

    projectsData.forEach((element) => {
      this.projects.push(new project(element));
    });

    clientsData.forEach((element) => {
      this.clients.push(new client(element));
    })

    availableHoursData.forEach((element) => {
      this.availableHours.push(new availableHour(element));
    })

    skillsData.forEach((element) => {
      this.skills.push(new skill(element));
    })
  },

  setup() {
    return {sidebarWidth}
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
