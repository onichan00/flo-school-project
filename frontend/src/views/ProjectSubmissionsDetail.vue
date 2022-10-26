<template>
  <div class="container py-10 px-10">
    <!--    border-b-4 border-[#F15922]-->
    <div class="grid grid-cols-2 gap-2 text-justify py-5 px-5 divide-y divide-y-reverse">
      <p></p>
      <p></p>
      <p class="py-3 px-3 font-medium text-slate-500">Applicatie naam </p><p class="py-3 px-3 font-medium text-slate-900">{{dataObject.name}}</p>
      <p class="py-3 px-3 font-medium text-slate-500">Required Skills </p><p class="py-3 px-3 font-medium text-slate-900">{{dataObject.skills[0] + dataObject.skills[1] + dataObject.skills[2]}}</p>
      <p class="py-3 px-3 font-medium text-slate-500">Datum </p><p class="py-3 px-3 font-medium text-slate-900">{{dataObject.created}}</p>
      <p class="py-3 px-3 font-medium text-slate-500">Gemaakt door </p><p class="py-3 px-3 font-medium text-slate-900">{{dataObject.createdBy}}</p>
      <p class="py-3 px-3 font-medium text-slate-500">Goed of afkeuren</p>
      <div class="py-3 px-3 font-medium text-slate-900">
<!--        mist nog confirmation boxxes-->
        <button type="button" data-order-edit class="p-1 hover:bg-green-400 rounded-md" @click="declineProject()" >
          <i class="fa-regular fa-circle-check text-2xl text-green-600"></i>
        </button>
        <button type="button" data-order-delete class="p-1 hover:bg-red-400 rounded-md" @click="declineProject()">
          <i class="fa-regular fa-circle-xmark text-2xl text-red-600"></i>
        </button>
      </div>

    </div>



  </div>

</template>

<script>
export default {
  name: "ProjectSubmissionsDetail",

  data(){
    return{
      dataObject: null,
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
            "Jan Hendrik"
          ],
          "createdBy": "illiasopdebeat@gmail.com"
        },
        {
          "id": 101,
          "name": "Yoga app",
          "status": 1,
          "skills": [
            "Python",
            "Java",
            "Javascript"
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
    for (let i = 0; i < this.projecten.length; i++) {
      let paramId = this.$route.params.id
      let arrayId = this.projecten[i].id
      if (arrayId == paramId) {
        this.dataObject = this.projecten[i]
      }
    }
  },
  methods: {
    declineProject(){
      history.back()
      }
    }
}
</script>


<style scoped>

</style>