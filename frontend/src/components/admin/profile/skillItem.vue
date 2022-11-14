<template>
  <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">
    <td class="p-4 w-4">
      <div class="flex items-center">
        <input id="checkbox-table-1" type="checkbox" :checked="this.skillData.selected" v-model="skillData"
          class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500">
        <label for="checkbox-table-1" class="sr-only">checkbox</label>
      </div>
    </td>
    <th scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap dark:text-white">
      {{ firstLetterUpperCase(skillData.name) }}
    </th>
    <td class="py-4 px-6">
      {{ firstLetterUpperCase(skillLevel) }}
    </td>
    <td class="py-4 px-6">
      <!-- TODO - Change the name to id when the database is running-->
      <button class="font-medium text-blue-600 dark:text-blue-500 hover:underline" @click="$emit('remove-skill', this.skill.name)">
        Remove
      </button>
    </td>
  </tr>
</template>
<script>
import { firstLetterUpperCase } from '@/plugins/textManipulation';

export default {
  name: "skillItem",
  props: ["skill"],
  data() {
    return {
      skillData: this.skill
    }
  },
  methods: {
    firstLetterUpperCase
  },
  computed: {
    skillLevel() {
      let level = "none"

      switch (this.skill.level) {
        case 0:
          level = "Novice"
          break;
        case 1:
          level = "Competence"
          break;
        case 2:
          level = "Proficiency"
          break;
        case 3:
          level = "Expert"
          break;
        case 4:
          level = "Mastery"
          break;
        default:
          level = "not defined"
      }

      return level
    },
  },
  watch: {
    skillData: {
      handler(val) {
        this.$emit('update:skill', val)
      }
    }
  }
}
</script>