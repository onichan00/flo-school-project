<template>
  <div>
    <p class="text-gray-400 italic">{{ availableHours }} uren</p>
    <div class="flex flex-col md:flex-row mt-4 justify-between gap-2 mb-2">
      <AvailabilityCard v-for="day in days" :key="day.id" :day="day"/>
    </div>
    <button @click="save" type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-1.5 text-center">Sla op</button>

  </div>
</template>

<script>
import AvailabilityCard from "@/components/miscellaneous/profile/AvailabilityCard.vue";
import {proxyObjToJson} from "@/plugins/objectManipulation";
import axios from "axios";
import {useToast} from "vue-toastification";

export default {
  name: "AvailabilityRow",
  components: { AvailabilityCard },
  props: ["hours"],
  data() {
    return {
      days: null,
      copy: null
    }
  },
  created() {
    const weekOrder = { 'Maandag': 0, 'Dinsdag': 1, 'Woensdag': 2, 'Donderdag': 3, 'Vrijdag': 4, 'Zaterdag': 5, 'Zondag': 6 };

    const unsortedDays = Array(7);
    console.log(this.hours);

    for (const day in this.hours.days) {
      const obj = this.hours.days[day];

      // Define the minutes variables
      const minutes = 15;
      const ms = 1000 * 60 * minutes;

      const start = new Date(obj.hourStart).getTime();
      const end = new Date(obj.hourEnd).getTime();

      obj.hourStart = new Date(Math.round(start / ms) * ms);
      obj.hourEnd = new Date(Math.round(end / ms) * ms);

      const index = weekOrder[obj.label];

      unsortedDays[index] = obj;
    }

    this.days = unsortedDays;
    this.copy = unsortedDays;
  },
  computed: {
    availableHours() {
      let calculatedTotalHours = 0;
      const formatter = new Intl.RelativeTimeFormat("nl", {
        style: "long",
        numeric: "auto",
      })

      this.days.forEach(day => {
        let start = new Date(day.hourStart);
        let end = new Date(day.hourEnd);

        const difference = end.getHours() - start.getHours();

        const diff = Math.abs(end - start);
        const minutes = Math.floor((diff / 1000) / 60);

        if (day.available) {
          calculatedTotalHours += difference;
        }
      })

      return calculatedTotalHours
    }
  },
  methods: {
    reset() {
      this.days = this.copy;
    },
    save() {
      const days = { ...proxyObjToJson(this.hours)};
      const URL = `${process.env.VUE_APP_API_URL}/api/hours/${this.hours.id}`;
      const PROTOCOL = "PUT"

      axios({ url: URL, method: PROTOCOL, data: days })
        .then((res) => {
          console.log(res);
          useToast().success("Beschikbaarheid succesvol bijgewerkt");
        })
        .catch((err) => {
          console.log(err);
        })
    },
    getTranslatedLabel() {
      const labels = {
        "zondag": "sunday",
        "zaterdag": "saturday",
        "vrijdag": "friday",
        "donderdag": "thursday",
        "woensdag": "wednesday",
        "dinsdag": "tuesday",
        "maandag": "monday"
      }

      return labels[this.label];
    }
  }
}
</script>

<style scoped>

</style>