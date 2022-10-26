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
          <tbody class="bg-white divide-y divide-slate-200" >
          <tr class="text-slate-500 hover:bg-orange-200 cursor-pointer" @click="selectProject(project.id)" v-for="project in projecten" :key="project.id" :value="projecten">
            <td class="px-8 py-4 whitespace-nowrap" @click="selectProject(project.id)">
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
                <!--        mist nog confirmation boxxes-->

                <button type="button" data-order-edit class="p-1 hover:bg-green-400 rounded-md">
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

<!--  <router-view :detail="detail"></router-view>-->
</template>

<script>
// import {project} from '@/models/project.js'
export default {
  name: "ProjectSubmissions",
  props: [
  ],
  data() {
    return {
      confirmRender: false,
      selectedData: null,
      projecten: [
        {
          "id": 100,
          "name": "Bedrijfs applicatie",
          "status": 1,
          "skills": [
            "Javascript",
            "Javascript",
            "Javascript"
          ],
          "created": "10/26/2022",
          "specialists": [
            "Frank Young",
            "Frank Young",
            "Frank Young"
          ],
          "createdBy": "illiasopdebeat@gmail.com"
        },
        {
          "id": 101,
          "name": "Yoga app",
          "status": 1,
          "skills": [
            "Java",
            "Java",
            "Java"
          ],
          "created": "10/26/2022",
          "specialists": [
            "Jan Hendrik",
            "Jan Hendrik",
            "Jan Hendrik"
          ],
          "createdBy": "dennismoes@icloud.com"
        },
        {
          "id": 102,
          "name": "Shopping site",
          "status": 1,
          "skills": [
            "Python",
            "Python",
            "Python"
          ],
          "created": "10/26/2022",
          "specialists": [
            "Dennis Moes",
            "Dennis Moes",
            "Dennis Moes"
          ],
          "createdBy": "maajidsaidy@gmail.com"
        },
        {
          "id": 103,
          "name": "Streaming site",
          "status": 1,
          "skills": [
            "C#",
            "C#",
            "C#"
          ],
          "created": "10/26/2022",
          "specialists": [
            "Maajid Saidy",
            "Maajid Saidy",
            "Maajid Saidy"
          ],
          "createdBy": "simonvriesema@hotmail.com"
        },
        {
          "id": 104,
          "name": "Bedrijfs applicatie",
          "status": 1,
          "skills": [
            "Javascript",
            "Javascript",
            "Javascript"
          ],
          "created": "10/26/2022",
          "specialists": [
            "Frank Young",
            "Frank Young",
            "Frank Young"
          ],
          "createdBy": "illiasopdebeat@gmail.com"
        },
        {
          "id": 105,
          "name": "Streaming site",
          "status": 1,
          "skills": [
            "C#",
            "C#",
            "C#"
          ],
          "created": "10/26/2022",
          "specialists": [
            "Maajid Saidy",
            "Maajid Saidy",
            "Maajid Saidy"
          ],
          "createdBy": "simonvriesema@hotmail.com"
        },
        {
          "id": 106,
          "name": "Yoga app",
          "status": 1,
          "skills": [
            "Java",
            "Java",
            "Java"
          ],
          "created": "10/26/2022",
          "specialists": [
            "Jan Hendrik",
            "Jan Hendrik",
            "Jan Hendrik"
          ],
          "createdBy": "dennismoes@icloud.com"
        },
        {
          "id": 107,
          "name": "Shopping site",
          "status": 1,
          "skills": [
            "Python",
            "Python",
            "Python"
          ],
          "created": "10/26/2022",
          "specialists": [
            "Dennis Moes",
            "Dennis Moes",
            "Dennis Moes"
          ],
          "createdBy": "maajidsaidy@gmail.com"
        },
        {
          "id": 108,
          "name": "Todolist app",
          "status": 1,
          "skills": [
            "C++",
            "C++",
            "C++"
          ],
          "created": "10/26/2022",
          "specialists": [
            "Illias Opdebeat",
            "Illias Opdebeat",
            "Illias Opdebeat"
          ],
          "createdBy": "frankoud@yahoo.com"
        },
        {
          "id": 109,
          "name": "Voorraad systeem",
          "status": 1,
          "skills": [
            "Vue",
            "Vue",
            "Vue"
          ],
          "created": "10/26/2022",
          "specialists": [
            "Simone Warmepa",
            "Simone Warmepa",
            "Simone Warmepa"
          ],
          "createdBy": "janhendrikson@florijn.nl"
        },
        {
          "id": 110,
          "name": "Bedrijfs applicatie",
          "status": 1,
          "skills": [
            "Javascript",
            "Javascript",
            "Javascript"
          ],
          "created": "10/26/2022",
          "specialists": [
            "Frank Young",
            "Frank Young",
            "Frank Young"
          ],
          "createdBy": "illiasopdebeat@gmail.com"
        },
        {
          "id": 111,
          "name": "Yoga app",
          "status": 1,
          "skills": [
            "Java",
            "Java",
            "Java"
          ],
          "created": "10/26/2022",
          "specialists": [
            "Jan Hendrik",
            "Jan Hendrik",
            "Jan Hendrik"
          ],
          "createdBy": "dennismoes@icloud.com"
        }

      ]

    }
  },
  created() {
    // for (let i = 0; i < 10; i++) {
    //   this.projecten.push(project.createSampleProject(100+i))
    //   console.log(project.createSampleProject(100+i))
    // }
  },

  methods: {
    selectProject(projectId){
      // this.selectedData = projectId
      if (this.selectedData !== null && projectId === this.selectedData.id) {this.selectedData = null;}

      for (let i = 0; i < this.projecten.length; i++) {
        if (this.projecten[i].id === projectId) {this.selectedData = this.projecten[i]}
      }

      this.$router.push("projects/" + this.selectedData.id);

    },
    declineProject(id){
      for (let i = 0; i < this.projecten.length; i++) {
        if (this.projecten[i].id === id){
          this.projecten.splice(i,1)
        }
      }
    }
  }

}
</script>

<style scoped>

</style>

