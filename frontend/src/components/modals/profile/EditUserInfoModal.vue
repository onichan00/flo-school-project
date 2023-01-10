<template>
  <div>
    <CustomModal v-model="isOpen" @close="close">
      <template v-slot:title>Pas gebruikers info aan</template>
      <template v-slot:body>
        <div class="text-left space-y-4">
          <div class="flex flex-col md:flex-row items-center justify-center w-full space-y-2 md:space-y-0 md:space-x-2">
            <div class="w-full md:w-1/3 h-64 bg-gray-50 rounded-lg overflow-hidden">
              <img v-if="image" :src="image.data" class="object-cover h-full w-full"/>
              <div v-else class="h-full w-full flex justify-center items-center">
                <svg class="w-12 h-12" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 16l4.586-4.586a2 2 0 012.828 0L16 16m-2-2l1.586-1.586a2 2 0 012.828 0L20 14m-6-6h.01M6 20h12a2 2 0 002-2V6a2 2 0 00-2-2H6a2 2 0 00-2 2v12a2 2 0 002 2z"></path></svg>
              </div>
            </div>
            <div class="w-full md:w-2/3">
              <label for="dropzone-file" class="flex flex-col items-center justify-center h-64 w-full border-2 border-gray-300 border-dashed rounded-lg cursor-pointer bg-gray-50 hover:bg-gray-100">
                <div class="flex flex-col items-center justify-center pt-5 pb-6">
                  <svg aria-hidden="true" class="w-10 h-10 mb-3 text-gray-400" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M7 16a4 4 0 01-.88-7.903A5 5 0 1115.9 6L16 6a5 5 0 011 9.9M15 13l-3-3m0 0l-3 3m3-3v12"></path></svg>
                  <p class="mb-2 text-sm text-gray-500 dark:text-gray-400"><span class="font-semibold">Klik om een profielfoto te uploaden</span></p>
                  <p class="text-xs text-gray-500 dark:text-gray-400">PNG or JPG (MAX. 800x400px)</p>
                </div>
                <input id="dropzone-file" type="file" accept="image/jpeg, image/jpg, image/png" class="hidden" @change="selectImage"/>
              </label>
            </div>
          </div>
          <div>
            <label for="email" class="block mb-1 text-sm font-medium text-gray-900">E-mail adres</label>
            <input type="email" id="email" v-model="userObj.email" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="john.doe@company.com" required>
          </div>
          <div class="grid gap-4 md:grid-cols-3">
            <div>
              <label for="first_name" class="block mb-1 text-sm font-medium text-gray-900">Voornaam</label>
              <input type="text" id="first_name" v-model="userObj.first_name" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="John" required>
            </div>
            <div>
              <label for="second_name" class="block mb-1 text-sm font-medium text-gray-900">Tweede naam (optioneel)</label>
              <input type="text" id="second_name" v-model="userObj.second_name" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="Cornelis" required>
            </div>
            <div>
              <label for="last_name" class="block mb-1 text-sm font-medium text-gray-900">Achternaam</label>
              <input type="text" id="last_name" v-model="userObj.last_name" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="Doe" required>
            </div>
          </div>
          <div class="grid gap-4 md:grid-cols-2">
            <div>
              <label for="city" class="block mb-1 text-sm font-medium text-gray-900">Stad</label>
              <input type="text" id="city" v-model="userObj.city" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="Amsterdam" required>
            </div>
            <div>
              <label for="zipcode" class="block mb-1 text-sm font-medium text-gray-900">Postcode</label>
              <input type="text" id="zipcode" v-model="userObj.zipCode" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="1000AA" required>
            </div>
          </div>
          <div>
            <label for="address" class="block mb-1 text-sm font-medium text-gray-900">Adres</label>
            <input type="email" id="address" v-model="userObj.address" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="Wibautstraat 4B" required>
          </div>
          <div>
            <label for="bio" class="block mb-1 text-sm font-medium text-gray-900 dark:text-white">Bio</label>
            <textarea id="bio" v-model="userObj.bio" rows="4" class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500" placeholder="Schrijf hier uw bio..."></textarea>
          </div>
        </div>
      </template>
      <template v-slot:footer>
        <button @click="saveUser" type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">Sla op</button>
        <button @click="close" type="button" class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-blue-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10">Annuleer</button>
      </template>
    </CustomModal>
  </div>
</template>

<script>
import CustomModal from "@/components/modals/CustomModal.vue";
import {proxyObjToJson} from "@/plugins/objectManipulation";
import axios from "axios";

import {useToast} from "vue-toastification";

export default {
  name: "EditUserInfoModal",
  components: { CustomModal },
  props: ["open", "user", "profileImage"],
  computed: {
    isOpen() {
      return this.open;
    },
    getUser() {
      return this.user;
    },
  },
  data() {
    return {
      userObj: null,
      image: null
    }
  },
  created() {
    this.userObj = this.user;
  },
  watch: {
    profileImage() {
      this.image = { data: this.profileImage };
    }
  },
  methods: {
    /**
     * Uploads a profile image to the server.
     *
     * @returns {Promise<String>} - A promise that resolves the ID of the uploaded image
     */
    uploadProfileImage() {
      return new Promise((resolve, reject) => {
        // Get the base URL for the files API and the ID of the user
        const BASE_URL = `${process.env.VUE_APP_API_URL}/api/files`;
        const USER_ID = this.$route.params.id;
        const FILE_ID = this.userObj.photo;

        // Creates a new form data object to store the images in
        const FORM_DATA = new FormData();

        // Create the URLs to delete the old image and upload the new image
        const DELETE_URL = `${BASE_URL}/${FILE_ID}`;
        const UPLOAD_URL = `${BASE_URL}/upload/${USER_ID}`;

        // Add the image to the form data
        FORM_DATA.append("file", this.image.file);

        if(FILE_ID == null){
          axios({ url: UPLOAD_URL, method: "POST", data: FORM_DATA })
              .then((res) => {
                // Resolve the promise with the ID of the new image
                resolve(res.data.id);
              })
              .catch((err) => {
                reject(err);
              })
        } else {
          // Try deleting the old file
          axios({ url: DELETE_URL, method: "DELETE" })
              .then((res) => {
                if (res.status)
                  axios({ url: UPLOAD_URL, method: "POST", data: FORM_DATA })
                      .then((res) => {
                        // Resolve the promise with the ID of the new image
                        resolve(res.data.id);
                      })
                      .catch((err) => {
                        reject(err);
                      })
              }).catch((err) => {
            reject(err);
          })
      }})
    },
    /**
     * Saves the user object to the API.
     *
     * @async
     */
    async saveUser() {
      const URL = `${process.env.VUE_APP_API_URL}/api/users/update`;
      const PROTOCOL = "PUT";

      // Upload the profile image and set the new ID in the user object
      this.uploadProfileImage()
        .then((res) => {
          this.userObj.photo = res;
        })
        .catch((err) => {
          console.log(err);
          useToast().error("Iets ging mis tijdens het opslaan van de profiel foto")
        })
        .finally(() => { // Put this in finally so that the user can still update their user info without updating their profile image
          axios({ url: URL, method: PROTOCOL, data: this.userObj })
            .then((res) => {
              console.log(res);
              useToast().success("Profielinfo succesvol opgeslagen")
            })
            .catch((err) => {
              console.log(err);
              useToast().error("Iets ging mis tijdens het opslaan van de gebruikersdata");
            })
        })
    },
    close() {
      this.$emit("close");
    },
    selectImage(e) {
      const image = e.target.files[0];
      console.log("IMAGE", image)
      const reader = new FileReader();
      reader.readAsDataURL(image);
      reader.onload = (evt) => {
        this.image = {
          file: e.target.files[0],
          data: evt.target.result
        }
      }
    }
  },
}
</script>
<style scoped>

</style>