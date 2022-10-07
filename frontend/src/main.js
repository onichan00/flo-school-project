import { createApp } from 'vue'
import App from './App.vue'
import './assets/tailwind.css'
import './index.css'
import router from './router'

import 'flowbite';
import '@fortawesome/fontawesome-free/js/all'
import 'animate.css';

createApp(App).use(router).mount('#app')
