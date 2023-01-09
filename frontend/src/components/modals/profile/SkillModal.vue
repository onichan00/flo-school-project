<template>
  <div>
    <CustomModal v-model="isOpen" @close="close">
      <template v-slot:title>Vaardigheid</template>
      <template v-slot:body>
        <div class="p-6 space-y-6 text-left">
          <div>
            <label for="skillSelect" class="text-lg font-medium text-gray-900">Selecteer een nieuwe vaardigheid</label>
            <select id="skillSelect" v-model="getSelectedSkill.skill" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-florijnOrange-100 focus:border-florijnOrange-200 block w-full p-2.5">
              <option selected disabled :value="{ id: 0 }">Selecteer een vaardigheid</option>
              <option v-for="skill in skills" :key="skill.id" :value="skill">{{ JSON.stringify(skill) }}</option>
            </select>
          </div>
          <div>
            <label for="understanding-novice" class="text-lg font-medium text-gray-900">Beoordeel uw vaardigheidsniveau</label>
            <ul class="grid gap-4 w-full md:grid-cols-3">
              <li>
                <input type="radio" id="understanding-novice" name="understanding" class="hidden peer" v-model="getSelectedSkill.level" :value=0 required>
                <label for="understanding-novice" class="inline-flex justify-between items-center p-5 w-full text-gray-500 bg-white rounded-lg border border-gray-200 cursor-pointer peer-checked:border-florijnOrange-100 peer-checked:text-florijnOrange-100 hover:text-gray-600 hover:bg-florijnOrange-100/10 hover:border-florijnOrange-100/10">
                  <div class="block">
                    <div class="w-full text-lg font-semibold">1</div>
                    <div class="w-full">Beginnende</div> <!-- Novice -->
                  </div>
                </label>
              </li>
              <li>
                <input type="radio" id="understanding-competence" name="understanding" class="hidden peer" v-model="getSelectedSkill.level" :value=1 required>
                <label for="understanding-competence" class="inline-flex justify-between items-center p-5 w-full text-gray-500 bg-white rounded-lg border border-gray-200 cursor-pointer peer-checked:border-florijnOrange-100 peer-checked:text-florijnOrange-100 hover:text-gray-600 hover:bg-florijnOrange-100/10 hover:border-florijnOrange-100/10">
                  <div class="block">
                    <div class="w-full text-lg font-semibold">2</div>
                    <div class="w-full">Semi Beginnende</div> <!-- Competence -->
                  </div>
                </label>
              </li>
              <li>
                <input type="radio" id="understanding-proficiency" name="understanding" class="hidden peer" v-model="getSelectedSkill.level" :value=2 required>
                <label for="understanding-proficiency" class="inline-flex justify-between items-center p-5 w-full text-gray-500 bg-white rounded-lg border border-gray-200 cursor-pointer peer-checked:border-florijnOrange-100 peer-checked:text-florijnOrange-100 hover:text-gray-600 hover:bg-florijnOrange-100/10 hover:border-florijnOrange-100/10">
                  <div class="block">
                    <div class="w-full text-lg font-semibold">3</div>
                    <div class="w-full">Bekwaamd</div> <!-- Proficiency -->
                  </div>
                </label>
              </li>
              <li>
                <input type="radio" id="understanding-expert" name="understanding" class="hidden peer" v-model="getSelectedSkill.level" :value=3 required>
                <label for="understanding-expert" class="inline-flex justify-between items-center p-5 w-full text-gray-500 bg-white rounded-lg border border-gray-200 cursor-pointer peer-checked:border-florijnOrange-100 peer-checked:text-florijnOrange-100 hover:text-gray-600 hover:bg-florijnOrange-100/10 hover:border-florijnOrange-100/10">
                  <div class="block">
                    <div class="w-full text-lg font-semibold">4</div>
                    <div class="w-full">Expert</div> <!-- Expert -->
                  </div>
                </label>
              </li>
              <li>
                <input type="radio" id="understanding-mastery" name="understanding" class="hidden peer" v-model="getSelectedSkill.level" :value=4 required>
                <label for="understanding-mastery" class="inline-flex justify-between items-center p-5 w-full text-gray-500 bg-white rounded-lg border border-gray-200 cursor-pointer peer-checked:border-florijnOrange-100 peer-checked:text-florijnOrange-100 hover:text-gray-600 hover:bg-florijnOrange-100/10 hover:border-florijnOrange-100/10">
                  <div class="block">
                    <div class="w-full text-lg font-semibold">5</div>
                    <div class="w-full">Meester</div> <!-- Mastery -->
                  </div>
                </label>
              </li>
            </ul>
          </div>
        </div>
      </template>
      <template v-slot:footer>
        <button @click="save" type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">Save</button>
        <button @click="deleteUserSkill" type="button" class="focus:outline-none text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5">Delete</button>
        <button @click="close" type="button" class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-blue-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10">Cancel</button>
      </template>
    </CustomModal>
  </div>
</template>

<script>
import CustomModal from "@/components/modals/CustomModal.vue";
import { proxyObjToJson } from "@/plugins/objectManipulation";
import axios from "axios";
import {useToast} from "vue-toastification";

export default {
  name: "SkillModal",
  props: ["open", "skills", "user", "selectedSkill"],
  computed: {
    isOpen() {
      return this.open;
    },
    getSelectedSkill() {
      return this.selectedSkill;
    },
    getSkills() {
      return this.skills;
    },
    getUser() {
      return this.user;
    }
  },
  methods: {
    /**
     * This method save or creates a skill to the server.
     *
     * @emits updated - Emits the updated user skills array after the skill is saved or deleted
     * @emits close - Emits a close event when the save or delete action is complete
     */
    save() {
      const userSkill = { ...this.selectedSkill };
      const userID = this.$route.params.id;
      const URL = `${process.env.VUE_APP_API_URL}/api/users/specialist/${userID}/skill`

      let protocol = "PATCH";
      let toastMsg = "Succesvol bijgewerkt";

      userSkill.skill = proxyObjToJson(userSkill.skill);

      delete userSkill.specialist;

      // If a new skill is made
      if (this.selectedSkill.id === 0) {
        delete userSkill.id;

        protocol = "POST";
        toastMsg = "Succesvol aangemaakt";
      }

      axios({ method: protocol, url: URL, data: userSkill })
        .then((res) => {
          useToast().success(toastMsg);
          console.log(res.data);
          this.$emit("updated", res.data);

          this.close();
        })
        .catch((err) => {
          console.log(err);
        })
    },
    /**
     * This method emits a close event.
     *
     * @emits close
     */
    close() {
      this.$emit("close");
    },
    /**
     * This method deletes a skill from the server/
     *
     * @emits updated - Emits the updated user skills array after the skill is saved or deleted
     * @emits close - Emits a close event when the save or delete action is complete
     */
    deleteUserSkill() {
      const userID = this.$route.params.id;
      const userSkill = { ...this.selectedSkill };

      axios.delete(`${process.env.VUE_APP_API_URL}/api/users/specialist/${userID}/skill/${userSkill.id}`)
        .then((res) => {
          useToast().success("Succesvol verwijderd");
          console.log(res.data);
          this.$emit("updated", res.data);

          this.close();
        })
        .catch((err) => {
          console.log(err);
        })
    },
  },
  components: { CustomModal },
  watch: {
    selectedSkill() {
      console.log(this.selectedSkill);
    }
  }
}
</script>

<style scoped>

</style>