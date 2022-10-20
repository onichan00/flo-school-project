<template>
  <input type="hidden" name="sort" value="<%= sort %>">
  <input type="hidden" name="order" value="<%= order %>">
  <input type="hidden" name="page" value="<%= page %>">
  <div class="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
    <div class="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
      <div class="overflow-hidden border-b border-slate-200">
        <table class="min-w-full divide-y divide-slate-200 border-t border-t-slate-200">
          <thead>
          <tr>
            <th scope="col" class="cursor-pointer px-8 py-3 text-xs font-medium text-slate-500 tracking-wider">
              <div class="flex items-center space-x-1">
                <div>Created</div>
              </div>
            </th>
            <th scope="col" class="cursor-pointer px-8 py-3 text-xs font-medium text-slate-500 tracking-wider">
              <div class="flex items-center space-x-1">
                <div>Project name</div>
              </div>
            </th>
            <th scope="col" class="cursor-pointer px-8 py-3 text-xs font-medium text-slate-500 tracking-wider">
              <div class="flex items-center space-x-1">
                <div>Project creator</div>
              </div>
            </th>
            <th scope="col" class="cursor-pointer px-8 py-3 text-xs font-medium text-slate-500 tracking-wider">
              <div class="flex items-center space-x-1">
                <div>Actions</div>
              </div>
            </th>
          </tr>
          </thead>
          <tbody class="bg-white divide-y divide-slate-200" v-for="project in projecten" :key="project.id" :value="projecten">
          <tr data-order-code="<%= order.id %>" class="text-slate-500 hover:bg-orange-200 cursor-pointer">
            <td class="px-8 py-4 whitespace-nowrap">
              <div class="flex items-center">
                <div class="text-sm font-medium text-slate-900">
                  <p> {{ project.created }}</p>
                </div>
              </div>
            </td>
            <td class="px-8 py-4 whitespace-nowrap">
              <div class="flex items-center">
                <div class="text-sm font-medium text-slate-900">
                  <p> {{ project.name }}</p>
                </div>
              </div>
            </td>
            <td class="px-8 py-4 whitespace-nowrap">
              <div class="flex items-center">
                <div class="text-sm font-medium text-slate-900">
                  <p> {{ project.createdBy }}</p>
                </div>
              </div>
            </td>
            <td class="px-8 py-4 whitespace-nowrap">
              <div class="flex items-center">
                <button type="button" data-order-edit class="p-1 hover:bg-green-400 rounded-md" >
                  <i class="fa-regular fa-circle-check text-2xl text-green-600"></i>
                </button>
                <button type="button" data-order-delete class="p-1 hover:bg-red-400 rounded-md" @click="declineProject(project.id)">
                  <i class="fa-regular fa-circle-xmark text-2xl text-red-600"></i>
                </button>
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import {project} from '@/models/project.js'
export default {
  name: "ProjectSubmissions",
  created() {
    for (let i = 0; i < 8; i++) {
      this.projecten.push(project.createSampleProject(100+i))
    }
  },
  methods: {
    declineProject(id){
      for (let i = 0; i < this.projecten.length; i++) {
        if (this.projecten[i].id === id){
          this.projecten.splice(i,1)
        }
      }
    }
  },
  data() {
    return {
      projecten: []
    }
  }
}
</script>

<style scoped>

</style>

