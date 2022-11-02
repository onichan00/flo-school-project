<template>
  <div class="p-4 mb-10">
    <div class="flex flex-col xl:flex-row gap-6">
      <div class="w-full xl:w-1/3 p-4 rounded-md shadow-md">
        <img
            :src="selectedClient.photo"
            class="max-w-full rounded-lg w-full profileImage"
        />
        <div class="mt-4">
          <p class="text-2xl">{{ selectedClient.fName }} {{ selectedClient.sName.charAt(0) }} {{ selectedClient.lName }}</p>
        </div>
        <hr class="mb-2 mt-4" />
        <div class="flex flex-col text-left gap-4 pt-2">
          <div class="flex flex-row">
            <p class="w-1/3">Email</p>
            <p  class="w-2/3 border-b-2 border-black/0">{{ selectedClient.id }}</p>
          </div>
          <div class="flex flex-row">
            <p class="w-1/3">Phone</p>
            <p class="w-2/3 border-b-2 border-black/0">{{ selectedClient.phone }}</p>
          </div>
          <div class="flex flex-row">
            <p class="w-1/3">Website</p>
            <p class="w-2/3 border-b-2 border-black/0">{{ selectedClient.website }}</p>
          </div>
          <hr />
          <div class="flex flex-row">
            <p class="w-1/3">Projects</p>
            <p class="w-2/3">{{ selectedClient.length }}</p>
          </div>
        </div>
      </div>
<!--      this.fName = object.first_name;
      this.sName = object.second_name;
      this.lName = object.last_name;
      this.photo = object.photo;
      this.bio = object.bio;
      this.company = object.company;
      this.phone = object.phone;
      this.projects = object.projects;
      this.website = object.website;-->
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
<!--        <div id="myTabContent">-->
<!--          <div class="hidden" id="profile" role="tabpanel" aria-labelledby="profile-tab">-->
<!--            <ProjectCalendar :masks="masks" :dates="attributes"/>-->
<!--          </div>-->
<!--          <div class="hidden" id="dashboard" role="tabpanel" aria-labelledby="dashboard-tab">-->
<!--            <p class="text-sm text-gray-500 dark:text-gray-400">This is some placeholder content the <strong class="font-medium text-gray-800 dark:text-white">Contacts tab's associated content</strong>. Clicking another tab will toggle the visibility of this one for the next. The tab JavaScript swaps classes to control the content visibility and styling.</p>-->
<!--          </div>-->
<!--          <div class="hidden p-4 bg-gray-50 rounded-lg dark:bg-gray-800" id="settings" role="tabpanel" aria-labelledby="settings-tab">-->
<!--            <p class="text-sm text-gray-500 dark:text-gray-400">This is some placeholder content the <strong class="font-medium text-gray-800 dark:text-white">Settings tab's associated content</strong>. Clicking another tab will toggle the visibility of this one for the next. The tab JavaScript swaps classes to control the content visibility and styling.</p>-->
<!--          </div>-->
<!--          <div class="hidden p-4 bg-gray-50 rounded-lg dark:bg-gray-800" id="contacts" role="tabpanel" aria-labelledby="contacts-tab">-->
<!--            <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-4">-->
<!--              <ProjectCard v-for="(item, index) in projectList" :key="index" :project="item" />-->
<!--            </div>-->
<!--            &lt;!&ndash;            <ProjectCalendar />&ndash;&gt;-->
<!--          </div>-->
<!--        </div>-->
      </div>
    </div>
  </div>

</template>

<script>
export default {
  name: "detailPageClients",
  inject: ['clients'],

  data() {
    return {
      selectedClient: null,
    }
  },

  created() {
    this.selectedClient = this.findClientFromRouteParam(this.$route.params.id);
  },

  methods: {
    setFirstLetterUppercase(str) {
      if (str) str = str.charAt(0).toUpperCase() + str.slice(1);

      return str;
    },

    declineProject() {
      history.back()
    },

    findClientFromRouteParam(id) {
      return this.clients.find(element => element.id === parseInt(id));
    },
  },
  watch: {
    '$route'() {
      this.selectedClient = this.findClientFromRouteParam(this.$route.params.id);
    }
  },
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