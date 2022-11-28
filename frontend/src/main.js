import Vue, { createApp } from 'vue'
import { router } from "@/router/router";
import App from './App.vue';

// CSS
import './assets/tailwind.css'
import './index.css'

// Third Party
import 'flowbite';
import 'flowbite/dist/flowbite.js'
import '@fortawesome/fontawesome-free/js/all'

// CSS
import 'animate.css';
import "vue-toastification/dist/index.css";

import VCalendar from 'v-calendar';
import Toast from "vue-toastification";

const app = createApp(App);

const toastOptions = {
    position: "bottom-right"
}

app.use(router).mount('#app')
app.use(VCalendar, {})
app.use(Toast, toastOptions);
