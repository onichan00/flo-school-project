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
      chartData: {
        labels: ['Today', 'Yesterday', '2 days ago', '3 days ago', '4 days ago', '5 dags ago'].reverse(),
        datasets: [{
          label: ["Data"],
          data: [40, 20, 12, 76, 65, 34],
          backgroundColor: [
            'rgb(255,2,2)',
          ],
          borderColor: [            'rgb(255,0,55)',
          ],
        }]
      },
      chartOptions: {
        responsive: true

      }
    }
  }
}
</script>
