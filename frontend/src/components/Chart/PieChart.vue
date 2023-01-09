<template>
  <Pie
      :chart-options="chartOptions"
      :chart-data="chartData"
      :chart-id="chartId"
      :dataset-id-key="datasetIdKey"
      :plugins="plugins"
      :css-classes="cssClasses"
      :styles="styles"
      :width="width"
      :height="height"
  />
</template>

<script>

import { Pie } from 'vue-chartjs'
import {Chart as ChartJS, Title, Tooltip, Legend, ArcElement, CategoryScale} from 'chart.js'
ChartJS.register(Title, Tooltip, Legend, ArcElement, CategoryScale)

export default {
  name: "PieChart",
  components: {
    Pie
  },
  props: {
    data: {
      type: Array,
      required: true
    },
    chartId: {
      type: String,
      default: 'pie-chart'
    },
    datasetIdKey: {
      type: String,
      default: 'label'
    },
    width: {
      type: Number,
      default: 400
    },
    height: {
      type: Number,
      default: 400
    },
    cssClasses: {
      default: '',
      type: String
    },
    styles: {
      type: Object,
      default: () => {
      }
    },
    plugins: {
      type: Array,
      default: () => []
    }
  },

  data() {
    return {
      chartOptions: {
        responsive: true
      }
    }
  },

  computed: {
    chartData() {
      // const labels = [];
      // const data = [];
      // Object.values(this.data).reduce((acc, entry) => {
      //   labels.push(entry.label);
      //   data.push(entry.count);
      // }, 0);
      return {
        labels: ["Cliënten", "Admins", "Projecten", "Specialisten"],
        datasets: [{
          label: ["Data"],
          data: [this.data.numOfClients, this.data.numOfAdmins, this.data.numOfProjects, this.data.numOfSpecialists],
          backgroundColor: [
            'rgb(241,138,34)',
            'rgb(240,90,34)',
            'rgb(209,209,212)',
            'rgb(79,79,79)'
          ],
        }]
      }
    }
  }
}
</script>

<style scoped>

</style>