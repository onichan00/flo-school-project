<template>
  <div class="p-4 mb-10">
    <div class="flex flex-col xl:flex-row gap-6">
      <div class="w-full xl:w-1/3 p-4 rounded-md shadow-md">
        <img
          :src="user.photo"
          class="max-w-full rounded-lg w-full profileImage"
        />
        <div class="mt-4">
          <div v-if="isEditing" class="flex flex-col gap-2 text-left mb-2">
            <div class="flex flex-row">
              <p kmm="w-1/3">First Name</p>
              <input v-model="user.first_name" class="border-b-2 border-florijnOrange" />
            </div>
            <div class="flex flex-row">
              <p class="w-1/3">Second Name</p>
              <input v-model="user.second_name" class="border-b-2 border-florijnOrange" />
            </div>
            <div class="flex flex-row">
              <p class="w-1/3">Last Name</p>
              <input v-model="user.last_name" class="border-b-2 border-florijnOrange" />
            </div>
          </div>
          <p v-else class="text-2xl">{{ user.first_name }} {{ user.second_name.charAt(0) }} {{ user.last_name }}</p>
          <div v-if="isEditing" class="flex flex-row text-left items-center">
            <p class="w-1/3">Specialist Type</p>
            <select v-model="user.specialistType" class="w-2/3 rounded-md">
              <option :selected="user.specialistType === 'mobile'" value="mobile">Mobile</option>
              <option :selected="user.specialistType === 'security'" value="security">Security</option>
            </select>
          </div>
          <p v-else class="opacity-70">{{ setFirstLetterUppercase(user.specialistType) }}</p>
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
            <p class="w-2/3">{{ projects.length }}</p>
          </div>
        </div>
      </div>
      <div class="w-full xl:w-2/3 rounded-md shadow-md p-4">
        <div class="mb-4 border-b border-gray-200 dark:border-gray-700">
          <ul class="flex flex-wrap -mb-px text-sm font-medium text-center" id="myTab" data-tabs-toggle="#myTabContent" role="tablist">
            <li class="mr-2" role="presentation">
              <button class="inline-block p-4 rounded-t-lg border-b-2" id="profile-tab" data-tabs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">Projects</button>
            </li>
            <li class="mr-2" role="presentation">
              <button class="inline-block p-4 rounded-t-lg border-b-2 border-transparent hover:text-gray-600 hover:border-gray-300 dark:hover:text-gray-300" id="dashboard-tab" data-tabs-target="#dashboard" type="button" role="tab" aria-controls="dashboard" aria-selected="false">Available Hours</button>
            </li>
            <li class="mr-2" role="presentation">
              <button class="inline-block p-4 rounded-t-lg border-b-2 border-transparent hover:text-gray-600 hover:border-gray-300 dark:hover:text-gray-300" id="settings-tab" data-tabs-target="#settings" type="button" role="tab" aria-controls="settings" aria-selected="false">Skills</button>
            </li>
            <li role="presentation">
              <button class="inline-block p-4 rounded-t-lg border-b-2 border-transparent hover:text-gray-600 hover:border-gray-300 dark:hover:text-gray-300" id="contacts-tab" data-tabs-target="#contacts" type="button" role="tab" aria-controls="contacts" aria-selected="false">Calendar</button>
            </li>
          </ul>
        </div>
        <div id="myTabContent">
          <div class="hidden" id="profile" role="tabpanel" aria-labelledby="profile-tab">
            <ProjectCalendar :masks="masks" :dates="attributes"/>
          </div>
          <div class="hidden" id="dashboard" role="tabpanel" aria-labelledby="dashboard-tab">
            <p class="text-sm text-gray-500 dark:text-gray-400">This is some placeholder content the <strong class="font-medium text-gray-800 dark:text-white">Contacts tab's associated content</strong>. Clicking another tab will toggle the visibility of this one for the next. The tab JavaScript swaps classes to control the content visibility and styling.</p>
          </div>
          <div class="hidden p-4 bg-gray-50 rounded-lg dark:bg-gray-800" id="settings" role="tabpanel" aria-labelledby="settings-tab">
            <p class="text-sm text-gray-500 dark:text-gray-400">This is some placeholder content the <strong class="font-medium text-gray-800 dark:text-white">Settings tab's associated content</strong>. Clicking another tab will toggle the visibility of this one for the next. The tab JavaScript swaps classes to control the content visibility and styling.</p>
          </div>
          <div class="hidden p-4 bg-gray-50 rounded-lg dark:bg-gray-800" id="contacts" role="tabpanel" aria-labelledby="contacts-tab">
            <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-4">
              <ProjectCard v-for="(item, index) in projectList" :key="index" :project="item" />
            </div>
<!--            <ProjectCalendar />-->
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import ProjectCard from '../../components/miscellaneous/ProjectCard.vue';
import ProjectCalendar from "@/components/admin/profile/calendar";

export default {
  name: 'SpecialistProfile',
  inject: ['specialists', 'projects'],
  data() {
    const month = new Date().getMonth();
    const year = new Date().getFullYear();

    return {
      isEditing: false,
      projectList: [],
      masks: {
        weekdays: 'WWW',
      },
      attributes: [
        {
          key: 1,
          customData: {
            title: 'Lunch with mom.',
            class: 'bg-red-600 text-white',
          },
          dates: new Date(year, month, 1),
        },
        {
          key: 2,
          customData: {
            title: 'Take Noah to basketball practice',
            class: 'bg-blue-500 text-white',
          },
          dates: new Date(year, month, 2),
        },
        {
          key: 3,
          customData: {
            title: "Noah's basketball game.",
            class: 'bg-blue-500 text-white',
          },
          dates: new Date(year, month, 5),
        },
        {
          key: 4,
          customData: {
            title: 'Take car to the shop',
            class: 'bg-indigo-500 text-white',
          },
          dates: new Date(year, month, 5),
        },
        {
          key: 4,
          customData: {
            title: 'Meeting with new client.',
            class: 'bg-teal-500 text-white',
          },
          dates: new Date(year, month, 7),
        },
        {
          key: 5,
          customData: {
            title: "Mia's gymnastics practice.",
            class: 'bg-pink-500 text-white',
          },
          dates: new Date(year, month, 11),
        },
        {
          key: 6,
          customData: {
            title: 'Cookout with friends.',
            class: 'bg-orange-500 text-white',
          },
          dates: { months: 5, ordinalWeekdays: { 2: 1 } },
        },
        {
          key: 7,
          customData: {
            title: "Mia's gymnastics recital.",
            class: 'bg-pink-500 text-white',
          },
          dates: new Date(year, month, 22),
        },
        {
          key: 8,
          customData: {
            title: 'Visit great grandma.',
            class: 'bg-red-600 text-white',
          },
          dates: new Date(year, month, 25),
        },
      ],
    }
  },
  methods: {
    findSpecialistFromRouteParam(id) {
      return this.specialists.find(element => element.id === parseInt(id));
    },
    findProjectsTiedToUser(id) {
      return this.projects.filter(element => element.specialists.includes(parseInt(id)));
    },
    setFirstLetterUppercase(str) {
      if (str) str = str.charAt(0).toUpperCase() + str.slice(1);

      return str;
    },
  },
  created() {
    const id = this.$route.params.id;

    this.user = this.findSpecialistFromRouteParam(id);
    this.projectList = this.findProjectsTiedToUser(id);
  },
  watch: {
    '$route'() {
      const id = this.$route.params.id;

      this.user = this.findSpecialistFromRouteParam(id);
      this.projectList = this.findProjectsTiedToUser(id);
    }
  },
  components: {
    ProjectCalendar,
    ProjectCard
  }
}
</script>

<style scoped>
.profileImage {
  aspect-ratio: 4 / 3;
  object-fit: cover;
  width: 100%;
  object-position: top;
}
</style>