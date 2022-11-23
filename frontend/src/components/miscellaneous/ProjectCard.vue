<template>
  <div class="bg-gray-100 rounded-md shadow-sm p-4 transition-transform duration-200 cursor-pointer hover:-translate-y-2 text-left" @click="navigateToProject">
    <img src="https://images.unsplash.com/photo-1518770660439-4636190af475?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80" class="rounded-md mb-3 pointer-events-none"/>
    <p class="text-lg font-medium">{{ project.name }}</p>
    <p class="text-sm text-gray-400">{{ getStatus() }}</p>
  </div>
</template>

<script>
export default {
  name: 'ProjectCard',
  props: ['project'],
  methods: {
    navigateToProject() {
      this.$router.push('/projects/' + this.project.id)
    },
    getStatus() {
      let statusStr = ""

      switch (this.project.status) {
        case 0:
          statusStr = "Not started";
          break;
        case 1:
          statusStr = "Working";
          break;
        case 2:
          statusStr = "Finished";
          break;
        default:
          statusStr = "Error";
      }

      return statusStr;
    }
  }
}
</script>

<style scoped></style>