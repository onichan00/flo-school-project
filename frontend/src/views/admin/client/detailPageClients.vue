<template>
  <div class="p-4 mb-10">
    <div class="flex flex-col xl:flex-row gap-6">
      <div class="w-full xl:w-1/3 p-4 rounded-md shadow-md">
        <img
            :src="selectedClient.photo"
            class="max-w-full rounded-lg w-full profileImage"
        />
        <div class="mt-4">
          <p class="text-2xl">{{ selectedClient.first_name }} {{ selectedClient.second_name.charAt(0) }} {{ selectedClient.last_name }}</p>
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
      <div class="w-full xl:w-2/3 rounded-md shadow-md p-4">
        <div class="mb-4 border-b border-gray-200 dark:border-gray-700">
          <ul class="flex flex-wrap -mb-px text-sm font-medium text-center" id="myTab" data-tabs-toggle="#myTabContent" role="tablist">
            <li class="mr-2" role="presentation">
              <button class="inline-block p-4 rounded-t-lg border-b-2" id="profile-tab" data-tabs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">Projects</button>
            </li>
          </ul>
        </div>
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