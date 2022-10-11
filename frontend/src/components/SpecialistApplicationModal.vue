<template>
  <div>
    Lorem Ipsum {{this.counter}}
  </div>
</template>

<script>
export default {
  name: "ApplicationModal",
  props: [
      'selected-specialist',
      'counter'
  ]
}
</script>

<style scoped>

</style>