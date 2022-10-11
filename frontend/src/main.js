import { createApp } from 'vue'
import {router} from "@/router/router";
import App from './App.vue'
import './assets/tailwind.css'
import './index.css'

import 'flowbite';
import '@fortawesome/fontawesome-free/js/all'
import 'animate.css';

createApp(App).use(router).mount('#app')
