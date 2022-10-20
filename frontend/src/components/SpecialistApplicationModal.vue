<template>
  <div class="container border-2 rounded-lg">
    <img :src="require('@/assets/img/' + selectedSpecialist.image)" alt="Profile Picture">
    <section class="border-2 border-gray-300 rounded-l overflow-x-hidden overflow-y-auto">
      <p class="text-lg">{{firstName}} {{lastName}}</p>
      <p>{{age}} years old</p>

      <p class="text-lg mt-5">Skills:</p>
      <ul>
        <li v-for="skill in skills" :key="skill.name">{{skill.name}}: ({{skill.skillLevel}}/5)</li>
      </ul>

      <p class="text-lg mt-5">Preferred hours:</p>
      <p>{{preferredHours}}hrs/week</p>
      <p>
        <span :class="{'strike-thru' : !preferredDays.mon}">mon/</span>
        <span :class="{'strike-thru' : !preferredDays.tue}">tue/</span>
        <span :class="{'strike-thru' : !preferredDays.wed}">wed/</span>
        <span :class="{'strike-thru' : !preferredDays.thu}">thu/</span>
        <span :class="{'strike-thru' : !preferredDays.fri}">fri/</span>
        <span :class="{'strike-thru' : !preferredDays.sat}">sat/</span>
        <span :class="{'strike-thru' : !preferredDays.sun}">sun</span>
      </p>

      <p class="text-lg mt-5">Contact info:</p>
      <p>phone: <span class="contact-link">{{phone}}</span></p>
      <p>mail: <span class="contact-link">{{email}}</span></p>
    </section>
    <div>
      <button>Approve</button>
      <button>Decline</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "ApplicationModal",
  props: [
      'selectedSpecialist'
  ],
  data () {
    return {
      firstName: this.selectedSpecialist.firstName,
      lastName: this.selectedSpecialist.lastName,
      age: this.selectedSpecialist.age,
      skills: this.selectedSpecialist.skills,
      preferredHours: this.selectedSpecialist.preferredHours,
      preferredDays: this.selectedSpecialist.preferredDays,
      image: this.selectedSpecialist.image,
      email: this.selectedSpecialist.email,
      phone: this.selectedSpecialist.phone
    }
  }
}
</script>

<style scoped>
.container {
  z-index: 5;
}
.strike-thru {
  text-decoration: line-through;
}
.contact-link {
  color: blue;
  text-decoration: underline;
}
</style>