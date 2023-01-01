<template>
  <div>
    <CustomModal v-model="isOpen" @close="close">
      <template v-slot:title>Pas gebruikers info aan</template>
      <template v-slot:body>
        <div class="text-left space-y-4">
          <div class="flex items-center justify-center w-full mb-2">
            <label for="dropzone-file" class="flex flex-col items-center justify-center w-full h-64 border-2 border-gray-300 border-dashed rounded-lg cursor-pointer bg-gray-50 dark:hover:bg-bray-800 dark:bg-gray-700 hover:bg-gray-100 dark:border-gray-600 dark:hover:border-gray-500 dark:hover:bg-gray-600">
              <div class="flex flex-col items-center justify-center pt-5 pb-6">
                <svg aria-hidden="true" class="w-10 h-10 mb-3 text-gray-400" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M7 16a4 4 0 01-.88-7.903A5 5 0 1115.9 6L16 6a5 5 0 011 9.9M15 13l-3-3m0 0l-3 3m3-3v12"></path></svg>
                <p class="mb-2 text-sm text-gray-500 dark:text-gray-400"><span class="font-semibold">Klik om een profielfoto te uploaden</span></p>
                <p class="text-xs text-gray-500 dark:text-gray-400">PNG or JPG (MAX. 800x400px)</p>
              </div>
              <input id="dropzone-file" type="file" class="hidden" />
            </label>
          </div>
          <div>
            <label for="email" class="block mb-1 text-sm font-medium text-gray-900">E-mail adres</label>
            <input type="email" id="email" v-model="getUser.email" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="john.doe@company.com" required>
          </div>
          <div class="grid gap-4 md:grid-cols-3">
            <div>
              <label for="first_name" class="block mb-1 text-sm font-medium text-gray-900">Voornaam</label>
              <input type="text" id="first_name" v-model="getUser.first_name" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="John" required>
            </div>
            <div>
              <label for="second_name" class="block mb-1 text-sm font-medium text-gray-900">Tweede naam (optioneel)</label>
              <input type="text" id="second_name" v-model="getUser.second_name" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="Cornelis" required>
            </div>
            <div>
              <label for="last_name" class="block mb-1 text-sm font-medium text-gray-900">Achternaam</label>
              <input type="text" id="last_name" v-model="getUser.last_name" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="Doe" required>
            </div>
          </div>
          <div class="grid gap-4 md:grid-cols-2">
            <div>
              <label for="city" class="block mb-1 text-sm font-medium text-gray-900">Stad</label>
              <input type="text" id="city" v-model="getUser.city" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="Amsterdam" required>
            </div>
            <div>
              <label for="zipcode" class="block mb-1 text-sm font-medium text-gray-900">Postcode</label>
              <input type="text" id="zipcode" v-model="getUser.zipCode" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="1000AA" required>
            </div>
          </div>
          <div>
            <label for="address" class="block mb-1 text-sm font-medium text-gray-900">Adres</label>
            <input type="email" id="address" v-model="getUser.address" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="Wibautstraat 4B" required>
          </div>
          <div>
            <label for="bio" class="block mb-1 text-sm font-medium text-gray-900 dark:text-white">Bio</label>
            <textarea id="bio" v-model="getUser.bio" rows="4" class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500" placeholder="Schrijf hier uw bio..."></textarea>
          </div>
        </div>
      </template>
      <template v-slot:footer>
        <button @click="saveUser" type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">Save</button>
        <button @click="close" type="button" class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-blue-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10">Cancel</button>
      </template>
    </CustomModal>
  </div>
</template>

<script>
import CustomModal from "@/components/modals/CustomModal.vue";
import axios from "axios";

import { useToast } from "vue-toastification";

export default {
  name: "EditUserInfoModal",
  components: {CustomModal},
  props: ["open", "user"],
  computed: {
    isOpen() {
      return this.open;
    },
    getUser() {
      return this.user;
    }
  },
  methods: {
    saveUser() {
      console.log("SAVING USER", this.user);

      axios.put("http://localhost:8080/api/users/update", this.user)
        .then((res) => {
          console.log(res);
          useToast().success("Succesvol bijgewerkt");
        })
        .catch((err) => {
          console.log(err);
        })
    },
    close() {
      this.$emit("close");
    }
  }
}
</script>

<style scoped>

</style>