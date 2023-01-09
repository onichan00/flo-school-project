<template>
  <router-link :to="url" class="bg-gray-50 rounded-md p-4 cursor-pointer transition-transform hover:-translate-y-2">
    <img :src="project.bannerUrl" class="rounded-sm mb-2"/>
    <p class="font-semibold text-xl">{{ project.name }}</p>
    <p class="truncate">{{ project.description }}</p>
  </router-link>
</template>

<script>
export default {
  name: "ProjectCard",
  props: ["project"],
  data() {
    return {
      url: `/projects/${this.project.id}`
    }
  },
}
</script>

<style scoped>

</style>