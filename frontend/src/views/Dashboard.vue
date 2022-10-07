<template>
  <h1 class="animate__animated animate__fadeIn">Dashboard</h1>
</template>

<script>
import { collapsed, toggleSidebar } from '@/components/sidebar/state.js'

export default {
  name: "ViewsDashboard",
  setup() {
    return { collapsed, toggleSidebar },
        console.log("kak")
  }
}
</script>

<style scoped>

</style>