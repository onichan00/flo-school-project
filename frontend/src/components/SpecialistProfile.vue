<template>
  <div class="p-4 mb-10">
    <div class="flex flex-row justify-between">
      <img
        src="https://images.unsplash.com/photo-1633332755192-727a05c4013d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1480&q=80"
        width="300" height="300" class="rounded-md"/>
      <div>
        <!-- <p>Edit</p> -->
        <button type="button"
          class="text-white bg-florijnOrange hover:bg-florijnOrange/75 font-medium rounded-lg text-sm pl-4 pr-5 py-2.5 mr-2 mb-2 flex flex-row items-center">
          <Icon icon="mdi:pencil-outline" class="mr-1" />
          Edit
        </button>
      </div>
    </div>
    <form class="mt-10 text-left">
      <div class="grid gap-6 mb-6 grid-cols-3">
        <div>
          <label for="first_name" class="block text-sm font-medium text-gray-900 dark:text-gray-300">Voornaam</label>
          <input type="text" id="first_name"
            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            placeholder="John" required="">
        </div>
        <div>
          <label for="second_name" class="block text-sm font-medium text-gray-900 dark:text-gray-300">Tussenvoegsel
            (optioneel)</label>
          <input type="text" id="second_name"
            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            placeholder="Michael" required="">
        </div>
        <div>
          <label for="last_name" class="block text-sm font-medium text-gray-900 dark:text-gray-300">Achternaam</label>
          <input type="text" id="last_name"
            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            placeholder="Doe" required="">
        </div>
      </div>
      <div class="grid gap-6 mb-6 md:grid-cols-2">
        <div>
          <label for="email" class="block text-sm font-medium text-gray-900 dark:text-gray-300">Email</label>
          <input type="text" id="email"
            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            placeholder="johndoe@example.com" required="">
        </div>
        <div>
          <label for="phone" class="block text-sm font-medium text-gray-900 dark:text-gray-300">Telefoonnummer</label>
          <input type="tel" id="phone"
            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            placeholder="020 595 4955" pattern="[0-9]{3}-[0-9]{2}-[0-9]{3}" required="">
        </div>
      </div>
      <div>
        <div class="grid gap-6 mb-6 grid-cols-3">
          <div>
            <label for="first_name" class="block text-sm font-medium text-gray-900 dark:text-gray-300">Adres</label>
            <input type="text" id="first_name"
              class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              placeholder="Wibautstraat 3b" required="">
          </div>
          <div>
            <label for="second_name" class="block text-sm font-medium text-gray-900 dark:text-gray-300">Postcode</label>
            <input type="text" id="second_name"
              class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              placeholder="1091 GH" required="">
          </div>
          <div>
            <label for="last_name" class="block text-sm font-medium text-gray-900 dark:text-gray-300">Woonplaats</label>
            <input type="text" id="last_name"
              class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              placeholder="Amsterdam" required="">
          </div>
        </div>
        <div class="mb-6">
          <label for="message" class="block text-sm font-medium text-gray-900 dark:text-gray-400">Bio</label>
          <textarea id="message" rows="6"
            class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            placeholder="Your bio..."></textarea>
        </div>
      </div>


      <!-- <button type="submit"
        class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Submit</button> -->
    </form>

  </div>
</template>
<script>
import { Icon } from '@iconify/vue';
export default {
  name: 'SpecialistProfile',
  data() {
    return {
      isEditing: true
    }
  },
  components: {
    Icon
  }
}
</script>

<style scoped>

</style>