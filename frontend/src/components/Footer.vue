<template>
  <footer id="footer" class="p-4 bg-white rounded-lg  md:px-6 md:py-8 dark:bg-gray-900">
    <div class="sm:flex sm:items-center sm:justify-between">
      <a href="#" class="flex items-center mb-4 sm:mb-0">
        <h1 style="font-weight: 900; font-size: 30px; color: #F15922;">FLORIJN</h1>
      </a>
      <ul class="flex flex-wrap items-center mb-6 text-sm text-gray-500 sm:mb-0 dark:text-gray-400">
        <li>
          <a href="#" class="mr-4 hover:underline md:mr-6 ">About</a>
        </li>
        <li>
          <a href="#" class="mr-4 hover:underline md:mr-6">Privacy Policy</a>
        </li>
        <li>
          <a href="#" class="hover:underline">Contact</a>
        </li>
      </ul>
    </div>
    <hr class="my-6 border-gray-200 sm:mx-auto dark:border-gray-700 lg:my-8" />
    <span class="block text-sm text-gray-500 sm:text-center dark:text-gray-400">© 2022 Florijn. All Rights Reserved.
    </span>
  </footer>

</template>

<script>
export default {
  name: "ComponentsFooter"
}
</script>

<style scoped>

#footer {
  max-width: 1140px;
  margin: auto;
}

</style>