import { createApp } from 'vue'
import {router} from "@/router/router";
import App from './App.vue'
import './assets/tailwind.css'
import './index.css'

import 'flowbite';

createApp(App).use(router).mount('#app')
