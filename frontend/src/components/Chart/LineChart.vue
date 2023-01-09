<template>
  <Line
      :chart-options="chartOptions"
      :chart-data="chartData"
      :chart-id="chartId"
      :dataset-id-key="datasetIdKey"
      :plugins="plugins"
      :css-classes="cssClasses"
      :styles="styles"
      :width="width"
      :height="height"
      :backgroundColor="backgroundColor"
  />
</template>

<script>

import {Line} from "vue-chartjs";
import {
  Chart as ChartJS,
  Title,
  Tooltip,
  Legend,
  BarElement,
  CategoryScale,
  LinearScale,
  LineElement,
  PointElement,
} from "chart.js";

ChartJS.register(Title, Tooltip, Legend, PointElement, BarElement, CategoryScale, LinearScale, LineElement);

export default {
  name: "LineChart",
  components: {Line},
  props: {
    data: {
      type: Array,
      required: true
    },
    chartId: {
      type: String,
      default: 'bar-chart'
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
      default: 186
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
      type: Object,
      default: () => {
      }
    },
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
      return {
        datasets: [{
          label: ["Aantal projecten"],
          data: this.data,
          backgroundColor: ['rgb(241,89,34)',],
          borderColor: ['rgb(241,89,34)',],
        }]
      }
    }
  }
}
</script>
