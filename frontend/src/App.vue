<template>
  <!--  <img alt="Vue logo" src="./assets/logo.png">-->
  <!--  <LandingPage v-if="showLandingPage"/>-->
  <!--  <Login v-if="showLogin"/>-->
  <!--  <RegisterPage v-if="showRegister"/>-->
  <div v-if="userType == -1">
    <router-view/>
  </div>

  <div v-if="userType == 1">
    <div v-if="this.$route.path !== '/create-project'">
      <client-navbar></client-navbar>
    </div>
    <router-view/>
  </div>

  <div v-if="userType == 2 && approvalStatus == 2">
    <router-view/>
  </div>

  <div v-if="userType == 2 && approvalStatus != 2">
    <div  v-if="this.$route.path !== '/specialist/pending'">
      <specialist-navbar></specialist-navbar>
    </div>
    <router-view/>
  </div>



  <div v-show="this.userType == 0">
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
import ClientNavbar from "@/components/ClientNavbar";
import SpecialistNavbar from "@/components/SpecialistNavbar";

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
    ClientNavbar,
    SpecialistNavbar,
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
      loginStatus: null,
      userType: -1,
      approvalStatus: -1
    }
  },
  mounted() {
    if (localStorage.getItem("id") != null) {
      this.loginStatus = true;
      this.userType = localStorage.getItem("userType")
      this.approvalStatus = localStorage.getItem("approvalStatus")

      console.log("usertype is: "+this.userType)

      // if (localStorage.getItem("isAdmin") === true) {
      //   this.isAdmin = true;
      // }
      // if (localStorage.getItem("isClient") === true) {
      //   this.isClient = true;
      // }
      // if (localStorage.getItem("isSpecialist") === true) {
      //   this.isSpecialist = true;
      // }
    } else return false
  },

  computed: {
    // isAdmin(){
    //   if (localStorage.getItem("isAdmin")){
    //     console.log("dit is een admin")
    //
    //     return true
    //   }
    //   return false;
    // },
    // isClient(){
    //   if (localStorage.getItem("isClient")){
    //     console.log("dit is een client")
    //
    //     return true
    //   }
    //   return false;
    // },
    // isSpecialist(){
    //   if (localStorage.getItem("isClient")){
    //     console.log("dit is een specialist")
    //
    //     return true
    //   }
    //   return false;
    // },

    // showLandingPage() {
    //   if (this.$route.path == "/landing-page") {
    //     return true
    //   } else {
    //     return false
    //   }
    // },
    //
    // showLogin() {
    //   if (this.$route.path == "/login") {
    //     return true
    //   } else {
    //     return false
    //   }
    // },
    //
    // showRegister() {
    //   if (this.$route.path == "/register") {
    //     return true
    //   } else {
    //     return false
    //   }
    // }

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
  },
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
