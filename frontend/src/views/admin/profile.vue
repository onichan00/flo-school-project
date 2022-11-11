<template>
  <div class="p-4 mb-10">
    <div class="flex flex-col xl:flex-row gap-6">
      <div class="w-full xl:w-1/3 p-4 rounded-md shadow-md">
        <img
          :src="user.photo"
          class="max-w-full rounded-lg w-full profileImage"
        />
        <div class="mt-4">
          <p class="text-2xl">{{ specialistFullName(user) }}</p>
          <p class="opacity-70">{{ firstLetterUpperCase(user.specialistType) }}</p>
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
            <p class="w-2/3">{{ projectList.length }}</p>
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
          <div class="hidden p-4" id="profile" role="tabpanel" aria-labelledby="profile-tab">
            <!-- <Skills /> -->
            <Calendar />
          </div>
          <div class="hidden" id="dashboard" role="tabpanel" aria-labelledby="dashboard-tab">
            <AvailableHours />
          </div>
          <div class="hidden" id="settings" role="tabpanel" aria-labelledby="settings-tab">
            <!-- <p>Skills</p> -->
            <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-4">
              <ProjectCard v-for="(item, index) in projectList" :key="index" :project="item" />
            </div>
          </div>
          <div class="hidden p-4" id="contacts" role="tabpanel" aria-labelledby="contacts-tab">
            <!-- <Calendar /> -->
            <Skills />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import AvailableHours from '@/components/admin/profile/availableHours.vue';
import ProjectCard from '@/components/miscellaneous/ProjectCard.vue';
import Calendar from '@/components/admin/profile/calendar.vue';

import { specialistFullName, firstLetterUpperCase, formatDate } from '@/plugins/textManipulation';
import Skills from '@/components/admin/profile/skills.vue';

export default {
  // Calendar and shit: https://code.daypilot.org/tutorials/vuejs

  // FIXME: When the page is reloaded every project of the user is shown, but when i navigate to another page
  //  and then back to this project, the projects are gone.

  name: 'SpecialistProfile',
  inject: ['specialists', 'projects'],
  data() {
    return {
      isEditing: false,
      projectList: [],
    }
  },
  methods: {
    specialistFullName,
    firstLetterUpperCase,
    formatDate,

    findSpecialistFromRouteParam(id) {
      return this.specialists.find(element => element.id === parseInt(id));
    },
    findProjectsTiedToUser(id) {
      return this.projects.filter(element => element.specialists.includes(parseInt(id)));
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
    ProjectCard,
    AvailableHours,
    Calendar,
    Skills
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