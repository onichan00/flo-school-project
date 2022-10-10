<template>
  <div class="flex flex-col md:flex-row h-screen">
    <div class="w-full md:w-1/4 bg-purple-300">
      <p>Hello</p>
    </div>
    <div class="w-full md:w-3/4 overflow-y-scroll">
      <PageHeader title="Specialist Profile"/>
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import PageHeader from './components/PageHeader.vue';

export default {
  name: 'App',
  components: {
    PageHeader
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
