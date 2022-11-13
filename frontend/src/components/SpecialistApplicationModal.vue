<template>
  <div class="container rounded-lg bg-white pt-5 pl-5 pr-5">
    <button class="absolute border border-gray-300 top-3 right-3 bg-gray-100 px-2 rounded-lg close-modal-btn"
            @click="closeModal">x</button>
    <div class="flex justify-center">
      <img :src="require('@/assets/img/' + selectedSpecialist.image)"
           alt="Profile Picture"
           class="border border-gray-300 w-1/2 mb-5 profile-pic">
    </div>
    <section class="info-section text-left overflow-x-hidden overflow-y-auto">
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
      </p>

      <p class="text-lg mt-5">Contact info:</p>
      <p>phone: <span class="contact-link">{{phone}}</span></p>
      <p>mail: <span class="contact-link">{{email}}</span></p>
    </section>
    <div class="h-12 flex justify-between items-center">
      <div class="decline-application-btn text-left"
           @click="rejectApplication">Reject</div>
      <div class="text-lg approve-application-btn"
           @click="approveApplication">Approve</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ApplicationModal",
  props: [
      'selectedSpecialist'
  ],
  emits: [
      'approve-application',
      'reject-application'
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
    approveApplication() {
      this.$emit('approve-application', this.selectedSpecialist);
    },
    rejectApplication() {
      this.$emit('reject-application', this.selectedSpecialist);
    },
    closeModal() {
      this.$router.go(-1);
    }
  }
}
</script>

<style scoped>
.container {
  z-index: 5;
  box-shadow: 0 100px 300px #ccc;
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
  border-radius: 25px;
  padding: 3px 10px;
}
.approve-application-btn {
  background-color: #ec5a29;
  color: white;
  width: 80%;
}
.info-section {
  max-height: 300px;
}
.close-modal-btn {
  background: center no-repeat url("../assets/img/close.png") #eee;
  background-size: contain;
  color: transparent;
}
.profile-pic {
  border-radius: 50%;
}
</style>