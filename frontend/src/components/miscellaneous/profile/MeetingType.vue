<template>
  <!-- Fix the conditional class -->
  <div class="w-full text-center">
    <p class="py-2">{{ title }}</p>
    <div class="w-full h-2" :class="color"/>
  </div>
</template>

<script>
export default {
  name: "MeetingType",
  props: ["title", "color", "type", "value"],
  computed: {
    selected() {
      console.log("HALLO");
      return parseInt(this.type) === parseInt(this.value);
    },
    getLowOpacityColor() {
      console.log(this.color + "/20");
      return this.selected ? this.color + "/20" : "";
    },
  },
}
</script>

<style scoped>

</style>