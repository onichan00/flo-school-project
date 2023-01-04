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
      chartData: {
        labels: [ 'Specialisten', 'Cliënten', 'Projecten' ],
        datasets: [ {
          label: ["Data"],
          data: [40, 20, 12],
          backgroundColor: [
            'rgb(255,0,54)',
            'rgb(0,17,255)',
            'rgb(255,181,0)'
          ],
        } ]
      },
      chartOptions: {
        responsive: true

      }
    }
  }
}
</script>

<style scoped>

</style>