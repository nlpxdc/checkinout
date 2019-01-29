import Vue from 'vue'
import Mint from 'mint-ui'
import 'mint-ui/lib/style.css'
import App from './App.vue'
import router from './router'
import VConsole from 'vconsole';
import axios from 'axios';

Vue.config.productionTip = false
Vue.use(Mint);
new VConsole();
axios.defaults.baseURL = 'http://localhost:8080';

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
