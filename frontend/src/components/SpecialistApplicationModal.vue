<template>
  <div class="container rounded-lg bg-white px-4 py-5">
    <button class="absolute border border-gray-300 top-3 right-3 bg-gray-100 px-2 rounded-lg close-modal-btn"
            @click="closeModal">x</button>
    <div class="flex flex-col items-center">
      <img :src="require('@/assets/img/' + selectedSpecialist.image)"
           alt="Profile Picture"
           class="border border-gray-300 w-1/2 mb-5 profile-pic">
      <p class="name-and-age">{{firstName}} {{lastName}} ({{age}})</p>
    </div>
    <section class="info-section text-left overflow-x-hidden overflow-y-auto">
      <p class="text-lg mt-5">Skills:</p>
      <ul class="list-disc">
        <li v-for="skill in skills" :key="skill.name" class="flex justify-between">{{skill.name}}:
          <span class="skill-scores flex items-center">
            <img :src="require('@/assets/img/' + 'star.png')"
                 alt="star"
                 class="w-4 inline" :class="{'grayscale' : skill.skillLevel < 1}">
            <img :src="require('@/assets/img/' + 'star.png')"
                 alt="star"
                 class="w-4 inline" :class="{'grayscale' : skill.skillLevel < 2}">
            <img :src="require('@/assets/img/' + 'star.png')"
                 alt="star"
                 class="w-4 inline" :class="{'grayscale' : skill.skillLevel < 3}">
            <img :src="require('@/assets/img/' + 'star.png')"
                 alt="star"
                 class="w-4 inline" :class="{'grayscale' : skill.skillLevel < 4}">
            <img :src="require('@/assets/img/' + 'star.png')"
                 alt="star"
                 class="w-4 inline" :class="{'grayscale' : skill.skillLevel < 5}">
          </span>
        </li>
      </ul>

      <p class="text-lg mt-5">Preferred hours:</p>
      <p>{{preferredHours}}hrs/week</p>
      <p>
        <span class="day-cell" :class="{'unavailable' : !preferredDays.mon}">mon</span>
        <span class="day-cell" :class="{'unavailable' : !preferredDays.tue}">tue</span>
        <span class="day-cell" :class="{'unavailable' : !preferredDays.wed}">wed</span>
        <span class="day-cell" :class="{'unavailable' : !preferredDays.thu}">thu</span>
        <span class="day-cell" :class="{'unavailable' : !preferredDays.fri}">fri</span>
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
  name: "SpecialistApplicationModal",
  props: [
      'selectedSpecialist'
  ],
  emits: [
      'approve-application',
      'reject-application'
  ],
  data () {
    return {
      name: this.selectedSpecialist.name,
      photo: this.selectedSpecialist.photo,
      email: this.selectedSpecialist.email,
      phone: this.selectedSpecialist.phone,
      age: this.selectedSpecialist.age,
      skills: this.selectedSpecialist.skills,
      preferredHours: this.selectedSpecialist.preferredHours,
      preferredDays: this.selectedSpecialist.preferredDays
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
.unavailable {
  filter: opacity(.5);
  background: #eee;
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
  /*max-height: 300px;*/
}
.close-modal-btn {
  background: center no-repeat url("@/assets/img/close.png") #eee;
  background-size: contain;
  color: transparent;
}
.profile-pic {
  border-radius: 50%;
}
.day-cell {
  border: 1px solid #919194;
  padding: 5px;
  display: inline-block;
  width: 5ch;
  text-align: center;
}
.day-cell:first-of-type {border-radius: 10px 0 0 10px}
.day-cell:last-of-type {border-radius: 0 10px 10px 0}
.name-and-age {
  font-size: 1.75rem;
  overflow: hidden;
}
</style>