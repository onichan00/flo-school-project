<template>
  <button
      @click="$emit('skillClicked', this.skill)"
      class="bg-orange-200 hover:bg-orange-300 text-orange-700 hover:text-orange-800 p-4 rounded-md"
  >
    {{ getSkill.skill.name }}
  </button>
</template>

<script>
export default {
  name: "SkillBadge",
  props: ["skill"],
  emits: ["skillClicked"],
  computed: {
    getSkill() {
      return this.skill;
    }
  }
}
</script>

<style scoped>

</style>