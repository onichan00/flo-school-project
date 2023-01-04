<template>
  <footer id="footer" class="p-4 bg-white rounded-lg">
    <div class="sm:flex sm:items-center sm:justify-between">
      <a href="#" class="flex items-center mb-4 sm:mb-0">
        <h1 style="font-weight: 900; font-size: 30px; color: #F15922;">FLORIJN</h1>
      </a>
      <ul class="flex flex-wrap items-center mb-6 text-sm text-gray-500 sm:mb-0 dark:text-gray-400">
        <li>
          <a href="https://florijn.com/aws/dit-zijn-wij/" class="mr-4 hover:underline md:mr-6 ">Over Ons</a>
        </li>
        <li>
          <a href="https://florijn.com/aws/contact/" class="hover:underline">Contact</a>
        </li>
      </ul>
    </div>
    <hr class="my-6 border-gray-200 sm:mx-auto dark:border-gray-700 lg:my-8" />
    <span class="block text-sm text-gray-500 sm:text-center dark:text-gray-400">© 2022 Florijn. Alle Rechten voorbehouden
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
  margin: auto;
  max-width: 1340px;
}

</style>