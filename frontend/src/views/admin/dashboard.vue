<template>
  <div class="dashboard-section">
    <div class="relative"
         style='background-image: linear-gradient(to right, #F15922 , #f18a22); height: 300px'>
      <!-- Header -->
      <div class="relative mx-auto max-w-6xl pb-32 pt-12">
        <div class="px-4 md:px-10 mx-auto w-full">
          <div>
            <!-- Card stats -->
            <div class="flex flex-wrap text-left">
              <div class="w-full lg:w-6/12 xl:w-4/12 px-4">
                <div class="relative flex flex-col min-w-0 break-words bg-white rounded-lg mb-6 xl:mb-0 shadow-lg">
                  <div class="flex-auto p-4">
                    <div class="flex flex-wrap">
                      <div class="relative w-full hpr-4 max-w-full flex-grow flex-1">
                        <h5 class="uppercase hover:text-orange-500 font-bold text-xs">
                          <a href="#">Projecten</a>
                        </h5>
                        <span class="font-semibold text-xl text-blueGray-700">
                          {{ this.projects.length }}
                        </span>
                      </div>
                      <div class="relative w-auto pl-4 flex-initial">
                        <div
                            class="p-3 text-center inline-flex items-center justify-center w-12 h-12 rounded-lg hover:bg-orange-200">
                          <a href="#"><i class="fa-solid fa-diagram-project"></i></a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="w-full lg:w-/12 xl:w-4/12 px-4">
                <div class="relative flex flex-col min-w-0 break-words bg-white rounded-lg mb-6 xl:mb-0 shadow-lg">
                  <div class="flex-auto p-4">
                    <div class="flex flex-wrap">
                      <div class="relative w-full pr-4 max-w-full flex-grow flex-1">
                        <h5 class="text-blueGray-400 uppercase hover:text-orange-500 font-bold text-xs">
                          <a href="#"> Specialisten</a>
                        </h5>
                        <span class="font-semibold text-xl text-blueGray-700">
                          {{ this.specialists.length }}
                        </span>
                      </div>
                      <div class="relative w-auto pl-4 flex-initial">
                        <div
                            class="p-3 text-center inline-flex items-center justify-center w-12 h-12 rounded-lg hover:bg-orange-200">
                          <a href="#"><i class="fa-solid fa-code"></i></a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="w-full lg:w-6/12 xl:w-4/12 px-4">
                <div class="relative flex flex-col min-w-0 break-words bg-white rounded-lg mb-6 xl:mb-0 shadow-lg">
                  <div class="flex-auto p-4">
                    <div class="flex flex-wrap">
                      <div class="relative w-full pr-4 max-w-full flex-grow flex-1">
                        <h5 class="text-blueGray-400 uppercase hover:text-orange-500 font-bold text-xs">
                          <a href="#"> Cliënten</a>
                        </h5>
                        <span class="font-semibold text-xl text-blueGray-700">
                          {{ this.clients.length }}
                        </span>
                      </div>
                      <div class="relative w-auto pl-4 flex-initial">
                        <div
                            class="p-3 text-center inline-flex items-center justify-center w-12 h-12 rounded-lg hover:bg-orange-200">
                          <a href="#"><i class="fas fa-users"></i></a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="w-full lg:w-6/12 xl:w-3/12 px-4">
                <div class="relative flex flex-col min-w-0 break-words bg-white rounded-lg mb-6 xl:mb-0 shadow-lg">
                  <div class="flex-auto p-4">
                    <div class="flex flex-wrap">
                      <div class="relative w-full pr-4 max-w-full flex-grow flex-1">
                        <h5 class="text-blueGray-400 uppercase hover:text-orange-500 font-bold text-xs">
                          <a href="#">DATA</a>
                        </h5>
                        <span class="font-semibold text-xl text-blueGray-700">
                          NUMBERS
                        </span>
                      </div>
                      <div class="relative w-auto pl-4 flex-initial">
                        <div class="p-3 text-center inline-flex items-center justify-center w-12 h-12 rounded-lg hover:bg-orange-200">
                          <a href="#"><i class="fas fa-percent"></i></a>
                        </div>
                      </div>
                    </div>
                    <p class="text-sm text-blueGray-400 mt-4">
                      <span class="text-emerald-500 mr-2">
                        <i class="fas fa-arrow-up"></i> NUM
                      </span>
                      <span class="whitespace-nowrap">
                        Since WHENEVER
                      </span>
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="px-4 md:px-10 max-w-6xl mx-auto w-full -m-24">
        <div class="flex flex-wrap">
          <div class="w-full xl:w-8/12 mb-12 xl:mb-0 px-4 ">
            <div
                class="relative flex flex-col min-w-0 break-words text-white bg-white w-full mb-6 shadow-lg rounded-lg">
              <div class="rounded-t mb-0 px-4 py-3 bg-transparent">
                <div class="flex flex-wrap items-center">
                  <div class="relative w-full max-w-full flex-grow flex-1">
                    <h2 class=" text-left text-black text-xl font-semibold">
                      Totale projecten
                    </h2>
                  </div>
                </div>
              </div>
              <div class="p-2 flex-auto">
                <!-- Chart -->
                <div class="relative bg-white">
                  <LineChart></LineChart>
                </div>
              </div>
            </div>
          </div>
          <div class="w-full xl:w-4/12 px-4">
            <div class="relative flex flex-col min-w-0 break-words bg-white w-full mb-6 shadow-lg rounded-lg">
              <div class="rounded-t mb-0 px-4 py-3 bg-transparent">
                <div class="flex flex-wrap items-center">
                  <div class="relative w-full max-w-full flex-grow flex-1">
                    <h2 class="text-blueGray-700 text-left text-xl font-semibold">
                      Projecten
                    </h2>
                  </div>
                </div>
              </div>
              <div class="p-4 flex-auto">
                <div class="relative">
                  <PieChart></PieChart>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="flex flex-wrap mt-4">
          <div class="w-full xl:w-8/12 mb-12 xl:mb-0 px-4">
            <div class="relative flex flex-col min-w-0 break-words bg-white w-full mb-6 shadow-lg rounded-lg">
              <div class="rounded-t mb-0 px-4 py-3 border-0">
                <div class="flex flex-wrap items-center">
                  <div class="relative w-full max-w-full flex-grow flex-1">
                    <h3  class="font-semibold text-left text-base  text-blueGray-700">
                      New Specialists (not yet accepted)
                    </h3>
                  </div>

                </div>
              </div>
              <div class="block w-full overflow-x-auto">
                <!-- Projects table -->
                <div class="overflow-x-auto relative">
                  <table class="w-full text-sm text-left text-gray-500 ">
                    <thead class="text-xs text-gray-700 uppercase bg-gray-100 dark:bg-gray-700 dark:text-gray-400">
                    <tr>
                      <th scope="col" class="py-3 px-6 ">
                        Volledige naam
                      </th>
                      <th scope="col" class="py-3 px-6">
                        Email
                      </th>
                      <th scope="col" class="py-3 px-6 ">
                        Telefoonnummer
                      </th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr v-for="user in this.users" :key="user.id" class="bg-white dark:bg-gray-800">
                      <th scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                        {{ user.name }}
                      </th>
                      <td class="py-4 px-6">
                        {{ user.email }}}
                      </td>
                      <td class="py-4 px-6">
                        Meta
                      </td>
                    </tr>                    <tr class="bg-white dark:bg-gray-800">
                      <th scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                        Dennis Moes
                      </th>
                      <td class="py-4 px-6">
                        denniscmoes@gmail.com
                      </td>
                      <td class="py-4 px-6">
                        Meta
                      </td>
                    </tr>                    <tr class="bg-white dark:bg-gray-800">
                      <th scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                        Dennis Moes
                      </th>
                      <td class="py-4 px-6">
                        denniscmoes@gmail.com
                      </td>
                      <td class="py-4 px-6">
                        Meta
                      </td>
                    </tr>                    <tr class="bg-white dark:bg-gray-800">
                      <th scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                        Dennis Moes
                      </th>
                      <td class="py-4 px-6">
                        denniscmoes@gmail.com
                      </td>
                      <td class="py-4 px-6">
                        Meta
                      </td>
                    </tr>                    <tr class="bg-white dark:bg-gray-800">
                      <th scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                        Dennis Moes
                      </th>
                      <td class="py-4 px-6">
                        denniscmoes@gmail.com
                      </td>
                      <td class="py-4 px-6">
                        Meta
                      </td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
          <div class="w-full xl:w-4/12 px-4">
            <div class="relative flex flex-col min-w-0 break-words bg-white w-full mb-6 shadow-lg rounded-lg">
              <div class="rounded-t mb-0 px-4 py-3 border-0">
                <div class="flex flex-wrap items-center">
                  <div class="relative w-full max-w-full flex-grow flex-1">
                    <h3 class="font-semibold text-left text-base text-blueGray-700">
                      Meest recente projecten
                    </h3>
                  </div>
                </div>
              </div>
              <div class="block w-full overflow-x-auto">
                <!-- Projects table -->
                <div class="overflow-x-auto relative">
                  <table class="w-full text-sm text-left text-gray-500 ">
                    <thead class="text-xs text-gray-700 uppercase bg-gray-100 dark:bg-gray-700 dark:text-gray-400">
                    <tr>
                      <th scope="col" class="py-3 px-6 ">
                        Naam
                      </th>
                      <th scope="col" class="py-3 px-6 ">
                        Beschrijving
                      </th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr v-for="project in this.projects" :key="project.id" class="bg-white dark:bg-gray-800 rounded-lg">
                      <th scope="row"
                          class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap rounded-lg dark:text-white">
                        {{ project.name }}
                      </th>
                      <td class="py-4 px-6">
                        Florijn
                      </td>
                    </tr>                    <tr class="bg-white dark:bg-gray-800">
                      <th scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                        New App
                      </th>
                      <td class="py-4 px-6">
                        Florijn
                      </td>
                    </tr>                    <tr class="bg-white dark:bg-gray-800">
                      <th scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                        New App
                      </th>
                      <td class="py-4 px-6">
                        Florijn
                      </td>
                    </tr>                    <tr class="bg-white dark:bg-gray-800">
                      <th scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                        New App
                      </th>
                      <td class="py-4 px-6">
                        Florijn
                      </td>
                    </tr>
                    <tr class="bg-white dark:bg-gray-800">
                      <th scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                        New App
                      </th>
                      <td class="py-4 px-6">
                        Florijn
                      </td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>

import LineChart from '@/components/Chart/LineChart.vue'
import PieChart from '@/components/Chart/PieChart.vue'
import axios from "axios";

export default {
  name: "DashboardView",

  components: {
    LineChart,
    PieChart
  },

  data() {
    return {
      date: new Date().getFullYear(),
    }
  }
}
</script>

<style>
.dashboard-section {
  height: 100vh;
}
</style>