<template>
  <div style='background-image: linear-gradient(to right, #F15922 , #f17822);
  height: 400px;
  border-radius: 0% 0% 2% 2%;'>

    <div class="max-w-6xl m-auto rounded-lg">

      <div class="flex flex-col bg-white w-full rounded-lg shadow-lg overflow-y">
        <div class="">
          <div class="sm:h-64 overflow-hidden">
            <img class="w-full rounded-t-lg"
                 :src="require('@/assets/img/photo-1614850715649-1d0106293bd1.png')"
                 style="display:block; max-height:300px; width: 100%; object-fit: cover">
          </div>
          <div class="flex justify-start px-5 -mt-12 mb-5">
              <span class="block relative h-40 w-40">
                <img class='mx-auto object-cover rounded-full h-40 w-40 bg-white p-2'
                     :src="require('@/assets/img/undraw_female_avatar_re_l6cx-2.svg')">
              </span>
            <div class="ml-2 grid place-items-center h-36">
              <div class="text-left max-h-10">
                <h1 class="font-medium text-2xl text-black"> {{ this.user.first_name + " " +  this.user.last_name}} </h1>
                <h1 class="text-md text-gray-500"><i class="fa-solid fa-envelope"></i> {{ this.user.email }}</h1>
                <h1 class="text-md text-gray-500"><i class="fa-solid fa-phone"></i> {{ this.user.phone }}</h1>
                <h1 class="text-md text-gray-500 mb-3"><i class="fa-solid fa-location-dot"></i> {{ this.user.city }}</h1>
              </div>

            </div>
          </div>

          <div class="p-4">

            <hr>

            <div class="text-left mt-5">
              <h1 class="text-xl text-black">Biografie</h1>
              <p>{{ this.user.bio }}</p>
            </div>
            <div class="text-left mt-5">
              <h1 class="text-xl text-black">Projecten</h1>
              <div v-if="this.projects.length === 0" class="">
                <p>U heeft nog geen projecten aangemaakt</p>
              </div>
              <div v-else>
                <div v-for="(project) in this.projects" :key="project">
                  <a @click="this.$route.push('/client/projects-overview')"
                     class="flex flex-col cursor-pointer items-center bg-white border rounded-lg shadow-md md:flex-row md:max-w-xl hover:bg-gray-100">
                    <img class="object-cover w-full rounded-t-lg h-96 md:h-auto md:w-48 md:rounded-none md:rounded-l-lg"
                         :src="project.bannerUrl" alt="Banner">
                    <div class="flex flex-col justify-between p-4 leading-normal">
                      <h5 class="mb-2 text-2xl font-medium tracking-tight text-gray-900">{{ project.name }}></h5>
                      <p class="mb-3 font-normal text-gray-700">{{ project.description }}.</p>
                    </div>
                  </a>
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
import axios from "axios";

export default {
  name: "ClientProfile",
  data() {
    return {
      userId: localStorage.getItem('id'),
      user: [],
      projects: []
    }
  },

  created() {
    this.getUserData();
    this.getProjectData()
  },

  methods: {
    getUserData() {
      axios.get(process.env.VUE_APP_API_URL + `/api/users/client/${this.userId}`)
          .then((res) => {
            this.user = res.data;
            console.log(this.user)
          })
          .catch((err) => {
            console.log(err);
          })
    },
    getProjectData() {
      const id = localStorage.getItem("id");

      axios.get(process.env.VUE_APP_API_URL + `/api/projects/client/${id}`)
          .then((res) => {
            for (let i = 0; i < res.data.length; i++) {
              this.projects.push(res.data[i])
            }
          })
          .catch((err) => {
            console.log(err);
          })
    },
  }
}
</script>

<style scoped>

</style>