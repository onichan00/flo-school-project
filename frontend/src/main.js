import Vue, { createApp } from 'vue'
import { router } from "@/router/router";
import App from './App.vue';
import VCalendar from 'v-calendar';

// CSS
import './assets/tailwind.css'
import './index.css'
import 'v-calendar/dist/style.css';

// Third Party
import 'flowbite';
import 'flowbite/dist/flowbite.js'
import '@fortawesome/fontawesome-free/js/all'
import 'animate.css';

const app = createApp(App);

app.use(VCalendar);
app.use(router).mount('#app')
