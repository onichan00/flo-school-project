<template>
  <div class="text-left">
    <div class="flex flex-row justify-between mb-4">
      <p class="text-2xl">Skills</p>
      <button type="button" @click="openModal"
        class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center">
        <Icon icon="material-symbols:add" class="text-xl" />
        Add
      </button>
    </div>
    <p>{{ selectedSkillsAmount }} skills selected</p>
    <div class="overflow-x-auto relative">
      <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
        <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
          <tr>
            <th scope="col" class="p-4">
              <div class="flex items-center">
                <input id="checkbox-all" type="checkbox"
                  class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600"
                  :indeterminate="selectedSkillsAmount < this.skillsData.length && selectedSkillsAmount !== 0"
                  :checked="selectedSkillsAmount === this.skillsData.length && selectedSkillsAmount !== 0"
                  @change="setSelected($event)">
                <label for="checkbox-all" class="sr-only">checkbox</label>
              </div>
            </th>
            <th scope="col" class="py-3 px-6">
              Skill
            </th>
            <th scope="col" class="py-3 px-6">
              Level
            </th>
            <th scope="col" class="py-3 px-6">
              Action
            </th>
          </tr>
        </thead>
        <tbody>
          <SkillItem v-for="(skill, index) in skills" :key="index" :skill="skill" v-on:update:skill="skill=$event" @remove-skill="removeSkill"/>
        </tbody>
      </table>
    </div>

    <!-- Add skill modal -->
    <div id="addSkillModal" tabindex="-1" aria-hidden="true"
      class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 w-full md:inset-0 h-modal md:h-full">
      <div class="relative p-4 w-full max-w-2xl h-full md:h-auto">
        <!-- Modal content -->
        <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
          <!-- Modal header -->
          <div class="flex justify-between items-start p-4 rounded-t border-b dark:border-gray-600">
            <h3 class="text-xl font-semibold text-gray-900 dark:text-white">
              Add skill
            </h3>
            <!-- TODO CLOSE MODAL FUNCTION -->
            <button type="button" @click="closeModal"
              class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white">
              <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20"
                xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd"
                  d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
                  clip-rule="evenodd"></path>
              </svg>
              <span class="sr-only">Close modal</span>
            </button>
          </div>
          <!-- Modal body -->
          <div class="p-6 space-y-6 flex flex-col text-left">
            <div class="flex flex-col">
              <!-- Skill select -->
              <div class="mb-3">
                <label for="countries" class="text-lg font-medium text-gray-900">Please
                  select a new skill</label>
                <select id="countries" v-model="selectedSkill.name"
                  class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-florijnOrange-100 focus:border-florijnOrange-200 block w-full p-2.5">
                  <option selected value="">Choose a Skill</option>
                  <option value="python">Python</option>
                  <option value="c#">C#</option>
                  <option value="c++">C++</option>
                  <option value="rust">Rust</option>
  
                  <!-- <option v-for="(index, skill) in this.skillsData" :key="index" value="{{ skill.name }}">{{ skill.name }}</option> -->
                </select>
              </div>
              
              <!-- Level Select -->
              <label for="understanding-novice" class="text-lg font-medium text-gray-900">Rate your skill level</label>
              <ul class="grid gap-4 w-full md:grid-cols-3">
                <li>
                  <input type="radio" id="understanding-novice" name="understanding" class="hidden peer" v-model="selectedSkill.level" :value=0 required>
                  <label for="understanding-novice"
                    class="inline-flex justify-between items-center p-5 w-full text-gray-500 bg-white rounded-lg border border-gray-200 cursor-pointer peer-checked:border-florijnOrange-100 peer-checked:text-florijnOrange-100 hover:text-gray-600 hover:bg-florijnOrange-100/10 hover:border-florijnOrange-100/10">
                    <div class="block">
                      <div class="w-full text-lg font-semibold">1</div>
                      <div class="w-full">Novice</div>
                    </div>
                  </label>
                </li>
                <li>
                  <input type="radio" id="understanding-competence" name="understanding" class="hidden peer" v-model="selectedSkill.level" :value=1 required>
                  <label for="understanding-competence"
                    class="inline-flex justify-between items-center p-5 w-full text-gray-500 bg-white rounded-lg border border-gray-200 cursor-pointer peer-checked:border-florijnOrange-100 peer-checked:text-florijnOrange-100 hover:text-gray-600 hover:bg-florijnOrange-100/10 hover:border-florijnOrange-100/10">
                    <div class="block">
                      <div class="w-full text-lg font-semibold">2</div>
                      <div class="w-full">Competence</div>
                    </div>
                  </label>
                </li>
                <li>
                  <input type="radio" id="understanding-proficiency" name="understanding" class="hidden peer" v-model="selectedSkill.level" :value=2 required>
                  <label for="understanding-proficiency"
                    class="inline-flex justify-between items-center p-5 w-full text-gray-500 bg-white rounded-lg border border-gray-200 cursor-pointer peer-checked:border-florijnOrange-100 peer-checked:text-florijnOrange-100 hover:text-gray-600 hover:bg-florijnOrange-100/10 hover:border-florijnOrange-100/10">
                    <div class="block">
                      <div class="w-full text-lg font-semibold">3</div>
                      <div class="w-full">Proficiency</div>
                    </div>
                  </label>
                </li>
                <li>
                  <input type="radio" id="understanding-expert" name="understanding" class="hidden peer" v-model="selectedSkill.level" :value=3 required>
                  <label for="understanding-expert"
                    class="inline-flex justify-between items-center p-5 w-full text-gray-500 bg-white rounded-lg border border-gray-200 cursor-pointer peer-checked:border-florijnOrange-100 peer-checked:text-florijnOrange-100 hover:text-gray-600 hover:bg-florijnOrange-100/10 hover:border-florijnOrange-100/10">
                    <div class="block">
                      <div class="w-full text-lg font-semibold">4</div>
                      <div class="w-full">Expert</div>
                    </div>
                  </label>
                </li>
                <li>
                  <input type="radio" id="understanding-mastery" name="understanding" class="hidden peer" v-model="selectedSkill.level" :value=4 required>
                  <label for="understanding-mastery"
                    class="inline-flex justify-between items-center p-5 w-full text-gray-500 bg-white rounded-lg border border-gray-200 cursor-pointer peer-checked:border-florijnOrange-100 peer-checked:text-florijnOrange-100 hover:text-gray-600 hover:bg-florijnOrange-100/10 hover:border-florijnOrange-100/10">
                    <div class="block">
                      <div class="w-full text-lg font-semibold">5</div>
                      <div class="w-full">Mastery</div>
                    </div>
                  </label>
                </li>
              </ul>
            </div>
          </div>

          <!-- Modal footer -->
          <div class="flex items-center p-6 space-x-2 rounded-b border-t border-gray-200">
            <button @click="addSkill" type="button" class="text-white bg-florijnOrange hover:bg-florijnOrange-200 focus:ring-4 focus:outline-none focus:ring-florijnOrange-100 font-medium rounded-lg text-sm px-5 py-2.5 text-center">Add</button>

            <button @click="closeModal" type="button"
              class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-blue-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10">Cancel</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import SkillItem from './skillItem.vue';
import { Icon } from '@iconify/vue';
import 'flowbite/dist/flowbite.js';
import { ref } from 'vue';

export default {
  name: "profile-skills",
  inject: ['skills'],
  data() {
    return {
      modal: '',
      selectedSkill: {
        name: "",
        level: 0,
        selected: false
      },
      skillsData: ref(this.skills)
      
    };
  },
  mounted() {
    const targetEl = document.querySelector("#addSkillModal");
    // eslint-disable-next-line no-undef
    this.modal = new Modal(targetEl);

    console.log(this.modal);
  },
  methods: {
    setSelected(e) {
      console.log(e.target);

      if (this.selectedSkillsAmount === this.skillsData.length) {
        this.deselectAll();
      } else {
        this.selectAll();
      }
    },

    selectAll() {
      this.skillsData.forEach((item) => {
        item.selected = true;
      })
    },
    deselectAll() {
      this.skillsData.forEach((item) => {
        item.selected = false;
      })
    },

    openModal() {
      this.selectedSkill = {
        name: "",
        level: 0,
        selected: false
      };

      this.modal.show();
    },

    closeModal() {
      this.modal.hide();
    },

    addSkill() {
      console.log(this.selectedSkill);

      this.skillsData.push(this.selectedSkill);
      this.closeModal();
    },

    removeSkill(event) {
      // TODO - Fix the delete function
      console.log(this.skillsData.filter(element => element.name !== event));
      this.skillsData = this.skillsData.filter(element => element.name !== event);
    }
  },
  computed: {
    selectedSkillsAmount() {
      let amount = 0;

      this.skillsData.forEach((item) => {
        if (item.selected) amount++;
      })

      return amount;
    },
    getSkills() {
      const userID = this.$route.params.id;

      return this.skillsData.filter((element) => element.id === userID);
    }
  },
  components: { SkillItem }
}
</script>