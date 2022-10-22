<template>
  <div class="bg-gray-100 rounded-md shadow-sm p-4 transition-transform duration-200 cursor-pointer hover:-translate-y-2 text-left">
    <img src="https://images.unsplash.com/photo-1518770660439-4636190af475?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80" class="rounded-md mb-3"/>
    <p class="text-lg font-medium">{{ project.title }}</p>
    <p class="text-sm text-gray-400">{{ project.status }}</p>
  </div>
</template>

<script>
export default {
  name: 'ProjectCard',
  props: ['project']
}
</script>

<style scoped></style>