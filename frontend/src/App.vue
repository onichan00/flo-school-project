<template>
  <Sidebar></Sidebar>
<!--  <PageHeader></PageHeader>-->
<!--  <img alt="Vue logo" src="./assets/logo.png">-->
<!--  <HelloWorld class="bg-red-500" msg="Welcome to Your Vue.js App"/>-->

<!--  <ul class="divide-y divide-gray-200">-->
<!--    <li class="py-4 flex">-->
<!--      <img class="h-10 w-10 rounded-full" src="" alt="" />-->
<!--      <div class="ml-3">-->
<!--        <p class="text-sm font-medium text-gray-900">person.name1</p>-->
<!--        <p class="text-sm text-gray-500">person.email </p>-->
<!--      </div>-->
<!--    </li>-->
<!--    <li class="py-4 flex">-->
<!--      <img  src="" alt="" class="h-10 w-10 rounded-full"/>-->
<!--      <div class="ml-3">-->
<!--        <p class="text-sm font-medium text-gray-900">person.name2</p>-->
<!--        <p class="text-sm text-gray-500">person.email </p>-->
<!--      </div>-->
<!--    </li>-->
<!--    <li class="py-4 flex">-->
<!--      <img class="h-10 w-10 rounded-full" src="" alt="" />-->
<!--      <div class="ml-3">-->
<!--        <p class="text-sm font-medium text-gray-900">person.name1</p>-->
<!--        <p class="text-sm text-gray-500">person.email </p>-->
<!--      </div>-->
<!--    </li>-->
<!--    <li class="py-4 flex">-->
<!--      <img  src="" alt="" class="h-10 w-10 rounded-full"/>-->
<!--      <div class="ml-3">-->
<!--        <p class="text-sm font-medium text-gray-900">person.name2</p>-->
<!--        <p class="text-sm text-gray-500">person.email </p>-->
<!--      </div>-->
<!--    </li>-->
<!--    <li class="py-4 flex">-->
<!--      <img class="h-10 w-10 rounded-full" src="" alt="" />-->
<!--      <div class="ml-3">-->
<!--        <p class="text-sm font-medium text-gray-900">person.name1</p>-->
<!--        <p class="text-sm text-gray-500">person.email </p>-->
<!--      </div>-->
<!--    </li>-->
<!--    <li class="py-4 flex">-->
<!--      <img  src="" alt="" class="h-10 w-10 rounded-full"/>-->
<!--      <div class="ml-3">-->
<!--        <p class="text-sm font-medium text-gray-900">person.name2</p>-->
<!--        <p class="text-sm text-gray-500">person.email </p>-->
<!--      </div>-->
<!--    </li>-->
    <router-view></router-view>
<!--  </ul>-->
  <Footer></Footer>

</template>

<script>
import Sidebar from "@/components/sidebar/Sidebar.vue";
// import PageHeader from "@/components/PageHeader.vue";
import Footer from "@/components/Footer.vue";

export default {
  name: 'App',
  components: {
    // PageHeader,
    Sidebar,
    Footer
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
  margin-top: 60px;
}
</style>
