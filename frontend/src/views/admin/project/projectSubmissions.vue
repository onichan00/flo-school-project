<template>
  <input type="hidden" name="sort" value="<%= sort %>">
  <input type="hidden" name="order" value="<%= order %>">
  <input type="hidden" name="page" value="<%= page %>">
  <div class="-my-2 overflow-x-auto">
    <div class="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
      <div class="overflow-hidden border-b border-slate-200">

        <div class="w-full">
          <div class="w-full mb-4">
            <div class="flex flex-row justify-between mt-4">
              <p class="text-left text-1xl font-medium mb-4">New submissions</p>
              <button data-modal-toggle="projectCreate-modal" class="bg-[#F05822] text-white font-bold rounded px-3">
                New project
              </button>
            </div>
            <div v-if="projecten" class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-6 gap-4">
              <ProjectCard v-on:click="selectProject(project)" v-for="(project, index) in projecten" :key="index"
                           :project="project"/>
            </div>
            <div v-else class="pt-2">
              <p class="text-2xl font-semibold text-left">This user had no projects yet</p>
            </div>
          </div>

          <hr class="mt-2 mb-4"/>
          <p class="text-left text-1xl font-medium mb-4">All projects</p>
          <div v-if="projecten" class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4 mb-5">
            <ProjectCard v-on:click="selectProject(project)" v-for="(project, index) in projecten" :key="index"
                         :project="project"/>
            <div
                data-modal-toggle="projectCreate-modal"
                class="flex justify-center items-center bg-gray-100 rounded-md shadow-sm p-4 transition-transform duration-200 cursor-pointer hover:-translate-y-2 text-left"
                @click="show = !show">
              <Icon class="text-4xl inline-flex items-center" icon="ant-design:plus-outlined"/>
            </div>
          </div>
          <div v-else class="pt-2">
            <p class="text-2xl font-semibold text-left">This user had no projects yet</p>
          </div>
        </div>

      </div>
    </div>
  </div>

  <createProject v-bind:projecten="projecten"/>
  <!--  <router-view :detail="detail"></router-view>-->
</template>

<script>
import ProjectCard from "@/components/miscellaneous/ProjectCard";
import {Icon} from '@iconify/vue';
import createProject from '@/components/admin/project/projectCreateNew';
import axios from "axios";

export default {
  name: "ProjectSubmissions",
  inject: ['projects'],
  components: {
    Icon,
    ProjectCard,
    createProject
  },

  data() {
    return {
      confirmRender: false,
      selectedData: null,
      projecten: null,
      show: false,
      newProjectData: null
    }
  },

  created() {
    this.getProjects()
  },

  methods: {
    getProjects() {
      const id = this.$route.params.id;

      axios.get(`http://localhost:8080/api/projects`)
          .then((res) => {
            this.projecten = res.data;
            console.log(this.projecten)
          })
          .catch((err) => {
            console.log(err);
          })
    },

    selectProject(project) {
      this.$router.push("projects/" + project.id);
    },

    newProject() {
      this.$router.push("projects-create");
    },

    declineProject(id) {
      for (let i = 0; i < this.projecten.length; i++) {
        if (this.projecten[i].id === id) {
          this.projecten.splice(i, 1)
        }
      }
    }
  }

}
</script>

<style scoped>

</style>

