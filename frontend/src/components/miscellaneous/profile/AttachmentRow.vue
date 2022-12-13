<template>
  <li class="py-2 px-4 w-full flex flex-col md:flex-row justify-between items-center">
    <span class="flex flex-row gap-2 text-ellipsis">
      <svg class="w-5 h-5 text-gray-400" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15.172 7l-6.586 6.586a2 2 0 102.828 2.828l6.414-6.586a4 4 0 00-5.656-5.656l-6.415 6.585a6 6 0 108.486 8.486L20.5 13"></path></svg>
      {{ attachment.name }}
    </span>
    <a href="#" class="font-medium text-blue-600 hover:underline">Download</a>
  </li>
</template>

<script>
export default {
  name: "AttachmentRow",
  props: ['attachment']
}
</script>

<style scoped>

</style>