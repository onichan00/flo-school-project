<template>
  <!--  <img alt="Vue logo" src="./assets/logo.png">-->
<!--  <Sidebar/>-->
<!--  <div :style="{ 'margin-left': sidebarWidth }">-->
<!--    <PageHeader/>-->
<!--    <router-view/>-->
<!--    <Footer></Footer>-->
<!--  </div>-->
<!--  <LandingPage></LandingPage>-->
  <Dashboard></Dashboard>
  <!--  <Login></Login>-->
  <!--  <HelloWorld class="bg-red-500" msg="Welcome to Your Vue.js App"/>-->
<!--  <Footer></Footer>-->


</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'
// import Sidebar from "@/components/sidebar/Sidebar.vue";
// import PageHeader from "@/components/PageHeader";
import {sidebarWidth} from '@/components/sidebar/state.js'
// import Footer from "@/components/Footer.vue";
// import LandingPage from '@/views/LandingPage.vue'
import Dashboard from '@/views/Dashboard.vue';
// import Login from "@/views/Login.vue";

export default {
  name: 'App',
  components: {
    // Sidebar,
    // Footer,
    // PageHeader,
    // LandingPage,
    Dashboard
    // Login
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
