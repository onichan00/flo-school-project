<template>
  <div class="text-left">
    <div class="flex flex-row justify-between mb-4">
      <p class="text-2xl">Skills</p>
      <button type="button"
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
                <input 
                  id="checkbox-all" 
                  type="checkbox"
                  class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600"
                  :indeterminate="selectedSkillsAmount < this.skills.length && selectedSkillsAmount !== 0"
                  :checked="selectedSkillsAmount === this.skills.length && selectedSkillsAmount !== 0"
                  @change="setSelected($event)"
                >
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
          <SkillItem v-for="(skill, index) in skills" :key="index" :skill="skill" v-on:update:skill="skill = $event"/>
        </tbody>
      </table>
    </div>
  </div>
</template>
<script>
import SkillItem from './skillItem.vue';
import { Icon } from '@iconify/vue';

export default {
  name: "profile-skills",
  data() {
    return {
      skills: [
        {
          name: "javaScript",
          level: 1,
          selected: true

        },
        {
          name: "dart",
          level: 3,
          selected: false

        },
        {
          name: "java",
          level: 2,
          selected: false
        }
      ]
    };
  },
  methods: {
    setSelected(e) {
      console.log(e.target);

      if (this.selectedSkillsAmount === this.skills.length) {
        this.deselectAll();
      } else {
        this.selectAll();
      }
    },

    selectAll() {
      this.skills.forEach((item) => {
        item.selected = true;
      })
    },
    deselectAll() {
      this.skills.forEach((item) => {
        item.selected = false;
      })
    }
  },
  computed: {
    selectedSkillsAmount() {
      let amount = 0;

      this.skills.forEach((item) => {
        if (item.selected) amount++;
      })

      return amount;
    }
  },
  components: { SkillItem }
}
</script>