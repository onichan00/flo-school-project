<template>
  <h1>Event</h1>
  <div class="event-container">
    <p><strong>Titel: </strong>{{ this.eventData.title }}</p>
    <p><strong>Locatie: </strong>{{ this.eventData.location }}</p>
    <p><strong>Aantal minuten: </strong>{{ this.calculateMinutes(eventData.start, eventData.end) }}</p>
    <p><strong>Beschrijving: </strong><br>{{ this.eventData.description }}</p>
    <div class="flex items-center p-4 space-x-2 border-t border-gray-200">
      <button v-on:click="reject" class="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded">
        Afwijzen
      </button>
      <button v-on:click="accept" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
        Accepteren
      </button>

    </div>
  </div>

</template>

<script>
import axios from "axios";

export default {
  name: "projectEvent",

  data() {
    return {
      title: "hallo",
      eventData: null,
      params: {}
    }
  },

  async created() {
    await this.getEvent();
  },

  methods: {
    calculateMinutes(start, end) {
      var totalHours = NaN;
      var first = Date.parse(start)
      var second = Date.parse(end)
      if (start < end) {
        totalHours = (second - first) / 1000 / 60; //milliseconds: /1000 / 60 / 60
      }
      return totalHours
    },

    reject() {
      this.params = {"id": this.eventData.id, "accepted": -1}

      // this.eventData.project = null;

      axios.patch(process.env.VUE_APP_API_URL + "/api/events/" + this.eventData.id + "/accepted", this.params)
          .then((res) => {
            console.log(res);
            this.$router.push('/projects/' + this.eventData.project.id)
          })
          .catch((err) => {
            console.log(err);
          })
    },

    accept() {
      this.params = {"id": this.eventData.id, "accepted": 1}

      // this.eventData.project = null;

      axios.patch(process.env.VUE_APP_API_URL + "/api/events/" + this.eventData.id + "/accepted", this.params)
          .then((res) => {
            console.log(res);
            this.$router.push('/projects/' + this.eventData.project.id)
          })
          .catch((err) => {
            console.log(err);
          })
    },

    async getEvent() {
      const id = this.$route.params.id

      await axios.get(process.env.VUE_APP_API_URL + "/api/events/" + id)
          .then((res) => {
            console.log(res.data)
            this.eventData = res.data;
          })
          .catch((err) => {
            console.log(err);
          })
    },
  }
}
</script>

<style scoped>
.event-container {
  height: 70vh;
}
</style>