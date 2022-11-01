<template>
  <div class="container py-10 px-10">
    <!--    border-b-4 border-[#F15922]-->
    <div class="grid grid-cols-2 gap-2 text-justify py-5 px-5 divide-y divide-y-reverse">
      <p></p>
      <p></p>

      <p class="py-3 px-3 font-medium text-slate-500">Applicatie naam </p>
      <p class="py-3 px-3 font-medium text-slate-900">{{ dataObject.name }}</p>
      <p class="py-3 px-3 font-medium text-slate-500">Status</p>
      <p class="py-3 px-3 font-medium text-slate-900">{{ dataObject.status }}</p>
      <p class="py-3 px-3 font-medium text-slate-500">Client</p>
      <p class="py-3 px-3 font-medium text-slate-900">{{ dataObject.client }}</p>
      <p class="py-3 px-3 font-medium text-slate-500">Datum </p>
      <p class="py-3 px-3 font-medium text-slate-900">{{ dataObject.created }}</p>
      <p class="py-3 px-3 font-medium text-slate-500">Goed of afkeuren</p>
      <div class="py-3 px-3 font-medium text-slate-900">
        <!--        mist nog confirmation boxxes-->
        <button type="button" data-order-edit class="p-1 hover:bg-green-400 rounded-md" @click="declineProject()">
          <i class="fa-regular fa-circle-check text-2xl text-green-600"></i>
        </button>
        <button type="button" data-order-delete class="p-1 hover:bg-red-400 rounded-md" @click="declineProject()">
          <i class="fa-regular fa-circle-xmark text-2xl text-red-600"></i>
        </button>
      </div>

    </div>

  </div>

</template>

<script>
export default {
  name: "ProjectSubmissionsDetail",
  inject: ['projects'],

  data() {
    return {
      dataObject: null,

    }
  },

  created() {
    this.dataObject = this.findProjectFromRouteParam(this.$route.params.id);
  },

  methods: {
    declineProject() {
      history.back()
    },

    findProjectFromRouteParam(id) {
      return this.projects.find(element => element.id === parseInt(id));
    },
  },
  watch: {
    '$route'() {
      this.dataObject = this.findProjectFromRouteParam(this.$route.params.id);
    }
  },


}
</script>


<style scoped>

</style>