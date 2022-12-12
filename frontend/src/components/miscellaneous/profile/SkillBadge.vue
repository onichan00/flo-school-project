<template>
  <button
      @click="$emit('skillClicked', this.skill)"
      class="bg-blue-100 text-blue-900 p-4 rounded-md"
  >
    {{ skill.name }}
  </button>
</template>

<script>
export default {
  name: "SkillBadge",
  props: ["skill"]
}
</script>

<style scoped>

</style>