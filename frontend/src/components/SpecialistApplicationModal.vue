<template>
  <div class="container border-2 rounded-lg bg-white pt-5 pl-5 pr-5">
    <div class="flex justify-center">
      <img :src="require('@/assets/img/' + selectedSpecialist.image)"
           alt="Profile Picture"
           class="rounded-full border-2 border-gray-300 w-1/2 mb-5">
    </div>
    <section class="text-left border-2 border-gray-300 rounded-l overflow-x-hidden overflow-y-auto">
      <p class="text-lg">{{firstName}} {{lastName}}</p>
      <p>{{age}} years old</p>

      <p class="text-lg mt-5">Skills:</p>
      <ul class="list-disc">
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
    <div class="h-12 flex justify-around items-center">
      <div class="text-orange-500 text-lg approve-application-btn">Approve</div>
      <div @click="closeModal" class="text-lg border-l-2 border-gray-300 decline-application-btn">Decline</div>
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
  },
  methods: {
    closeModal() {
      this.$router.go(-1);
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
.approve-application-btn,
.decline-application-btn {
  width: 100%;
  cursor: pointer;
}
</style>