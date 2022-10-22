<template>
  <div class="p-4 mb-10">
    <div class="flex flex-col xl:flex-row gap-6">
      <!-- Design -->
      <!-- https://dribbble.com/shots/14482483-Profile-Page -->
      <!-- https://dribbble.com/shots/6514009-Topic-User-Profile -->
      <div class="w-full xl:w-1/3 p-4 rounded-md shadow-md">
        <div v-if="isEditing" class="flex flex-row gap-2 mb-4">
          <button type="button"
            class="text-white bg-green-400 hover:bg-green-500 focus:ring-4 focus:outline-none focus:ring-green-300 font-medium rounded-lg text-sm pl-3 pr-4 py-2.5 text-center inline-flex items-center"
            @click="saveChanges">
            <Icon icon="ic:baseline-save" class="text-lg mr-1" />
            Save
          </button>
          <button type="button"
            class="text-white bg-red-500 hover:bg-red-600 focus:ring-4 focus:outline-none focus:ring-red-300 font-medium rounded-lg text-sm pl-3 pr-4 py-2.5 text-center inline-flex items-center"
            @click="cancelChanges">
            <Icon icon="mdi:close-box-outline" class="text-lg mr-1" />
            Cancel
          </button>
        </div>
        <div v-else class="flex flex-row justify-between mb-4">
          <button type="button"
            class="text-white bg-florijnOrange-100 hover:bg-florijnOrange-200 focus:ring-4 focus:outline-none focus:ring-florijnOrange-200 font-medium rounded-lg text-sm pl-3 pr-4 py-2.5 text-center inline-flex items-center"
            @click="changeIsEditing">
            <Icon icon="mdi:pencil" class="text-lg mr-1" />
            Edit
          </button>
          <div class="text-white bg-green-500 inline-flex items-center font-medium rounded-lg text-sm px-3">
            <Icon icon="akar-icons:circle-fill" class="mr-1" />
            <p>Available</p>
          </div>
        </div>
        <img
          src="https://images.unsplash.com/photo-1633332755192-727a05c4013d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1480&q=80"
          class="max-w-full rounded-lg" />
        <div class="mt-4">
          <div v-if="isEditing" class="flex flex-col gap-2 text-left mb-2">
            <div class="flex flex-row">
              <p class="w-1/3">First Name</p>
              <input v-model="user.firstName" class="border-b-2 border-florijnOrange" />
            </div>
            <div class="flex flex-row">
              <p class="w-1/3">Second Name</p>
              <input v-model="user.secondName" class="border-b-2 border-florijnOrange" />
            </div>
            <div class="flex flex-row">
              <p class="w-1/3">Last Name</p>
              <input v-model="user.lastName" class="border-b-2 border-florijnOrange" />
            </div>
          </div>
          <p v-else class="text-2xl">{{ user.firstName }} {{ user.secondName.charAt(0) }}. {{ user.lastName }}</p>
          <div v-if="isEditing" class="flex flex-row text-left">
            <p class="w-1/3">Specialist Type</p>
            <input v-model="user.specialistType" class="border-b-2 border-florijnOrange" />
          </div>
          <p v-else class="opacity-70">{{ user.specialistType }}</p>
          <!-- <p>Available</p> -->
        </div>
        <hr class="mb-2 mt-4" />
        <div class="flex flex-col text-left gap-4 pt-2">
          <div class="flex flex-row">
            <p class="w-1/3">Email</p>
            <input v-if="isEditing" v-model="user.email" class="border-b-2 border-florijnOrange" />
            <p v-else class="w-2/3 border-b-2 border-black/0">{{ user.email }}</p>
          </div>
          <div class="flex flex-row">
            <p class="w-1/3">Phone</p>
            <input v-if="isEditing" v-model="user.phone" class="border-b-2 border-florijnOrange" />
            <p v-else class="w-2/3 border-b-2 border-black/0">{{ user.phone }}</p>
          </div>
          <div class="flex flex-row">
            <p class="w-1/3">Address</p>
            <input v-if="isEditing" v-model="user.address" class="border-b-2 border-florijnOrange" />
            <p v-else class="w-2/3 border-b-2 border-black/0">{{ user.address }}</p>
          </div>
          <div class="flex flex-row">
            <p class="w-1/3">Zipcode</p>
            <input v-if="isEditing" v-model="user.zipCode" class="border-b-2 border-florijnOrange" />
            <p v-else class="w-2/3 border-b-2 border-black/0">{{ user.zipCode }}</p>
          </div>
          <div class="flex flex-row">
            <p class="w-1/3">City</p>
            <input v-if="isEditing" v-model="user.city" class="border-b-2 border-florijnOrange" />
            <p v-else class="w-2/3 border-b-2 border-black/0">{{ user.city }}</p>
          </div>
          <hr />
          <div class="flex flex-row">
            <p class="w-1/3">Projects</p>
            <p class="w-2/3">4</p>
          </div>
          <div class="flex flex-row">
            <p class="w-1/3">Days</p>
            <p class="w-2/3">mon/tue/thu/fri</p>
          </div>
          <div class="flex flex-row">
            <p class="w-1/3">Hours</p>
            <p class="w-2/3">32</p>
          </div>
          <hr />
          <div v-for="(item, index) in user.languages" class="flex flex-row" :key="index">
            <p class="w-1/3">{{ item.name }}</p>
            <p class="w-2/3">{{ item.level }}</p>
          </div>
          <!-- <div class="flex flex-row">
            <p class="w-1/3">Javascript</p>
            <p class="w-2/3">Goed</p>
          </div>
          <div class="flex flex-row">
            <p class="w-1/3">Java</p>
            <p class="w-2/3">Goed</p>
          </div>
          <div class="flex flex-row">
            <p class="w-1/3">Flutter</p>
            <p class="w-2/3">Goed</p>
          </div> -->
        </div>
      </div>
      <div class="w-full xl:w-2/3 rounded-md shadow-md p-4">
        <p class="text-left text-3xl font-medium">Projects</p>
        <hr class="mt-2 mb-4" />
        <div v-if="projects" class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-4">
          <ProjectCard v-for="(item, index) in projects" :key="index" :project="item" />
        </div>
        <div v-else class="pt-2">
          <p class="text-2xl font-semibold text-left">This user had no projects yet</p>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { Icon } from '@iconify/vue';
import ProjectCard from './Specialist/ProjectCard.vue';

export default {
  name: 'SpecialistProfile',
  data() {
    return {
      isEditing: false,
      user: {
        firstName: "John",
        secondName: "Michiel",
        lastName: "Doe",
        email: "johndoe@example.com",
        phone: "020 595 4955",
        address: "Wibautstraat 3b",
        zipCode: "1091 GH",
        city: "Amsterdam",
        available: true,
        specialistType: "Mobile",
        languages: [
          {
            "name": "Javascript",
            "level": 3,
          },
          {
            "name": "Java",
            "level": 3,
          },
          {
            "name": "Flutter",
            "level": 3,
          }
        ],
        bio: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque elit ipsum, malesuada quis urna id, feugiat imperdiet nisi. Etiam eu felis eu mauris porta molestie non non arcu. Cras fermentum arcu quis convallis rutrum. Nam dignissim eget libero non convallis. Nullam consequat tincidunt imperdiet. Donec vel venenatis dui. Vivamus ac ex porttitor, rhoncus nisi non, dignissim arcu. Maecenas sed porttitor nibh, non euismod urna. Mauris gravida tempor augue, et tristique ante pulvinar non. Proin id eros at urna ultrices rutrum eu a turpis. Quisque rutrum neque odio, id ullamcorper massa dictum a. Sed volutpat eu odio et maximus. Phasellus tempus volutpat ultrices."
      },
      projects: [
        {
          title: "Project 1",
          status: "Finished"
        },
        {
          title: "Project 2",
          status: "In progress"
        },
        {
          title: "Project 3",
          status: "Finished"
        },
        {
          title: "Project 4",
          status: "Finished"
        },
        {
          title: "Project 5",
          status: "Finished"
        },
      ]
    }
  },
  methods: {
    changeIsEditing() {
      this.isEditing = !this.isEditing;
    },
    saveChanges() {
      console.log("Saving...");
      this.isEditing = false;
    },
    cancelChanges() {
      console.log("Cancel...");
      this.isEditing = false;
    }
  },
  components: {
    Icon,
    ProjectCard
  }
}
</script>

<style scoped>

</style>