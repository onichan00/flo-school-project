<template>
  <!--  <img alt="Vue logo" src="./assets/logo.png">-->
  <Sidebar/>
  <div :style="{ 'margin-left': sidebarWidth }">
    <PageHeader/>
    <router-view/>
    <Footer></Footer>
  </div>
</template>

<script>
import Sidebar from "@/components/miscellaneous/sidebar/Sidebar.vue";
import {sidebarWidth} from '@/components/miscellaneous/sidebar/state.js'
import PageHeader from "@/components/PageHeader";
import Footer from "@/components/Footer.vue";

// Models
import client from "@/models/client";
import specialist from "@/models/specialist";
import project from "@/models/project";

// Dummy data
import clientsData from "@/assets/data/clients.json";
import projectsData from "@/assets/data/projects.json";
import specialistsData from "@/assets/data/specialists.json";

export default {
  name: 'App',
  components: {
    Sidebar,
    Footer,
    PageHeader
  },

  data() {
    return {
      specialists: [],
      projects: [],
      clients: []
    }
  },
  provide() {
    // use function syntax so that we can access `this`
    return {
      specialists: this.specialists,
      projects: this.projects,
      clients: this.clients
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
