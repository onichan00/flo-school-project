<template>
  <!--  <img alt="Vue logo" src="./assets/logo.png">-->
  <Sidebar/>
  <PageHeader/>
  <div :style="{ 'margin-left': sidebarWidth }">
    <router-view/>
  </div>
  <!--  <HelloWorld class="bg-red-500" msg="Welcome to Your Vue.js App"/>-->

</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'
import Sidebar from "@/components/sidebar/Sidebar.vue";
import PageHeader from "@/components/PageHeader";
import {sidebarWidth} from '@/components/sidebar/state.js'

export default {
  name: 'App',
  components: {
    // HelloWorld
    Sidebar,
    PageHeader
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
