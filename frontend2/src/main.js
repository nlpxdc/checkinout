import Vue from 'vue'
import Mint from 'mint-ui'
import 'mint-ui/lib/style.css'
import App from './App.vue'
import router from './router'
import VConsole from 'vconsole';

Vue.config.productionTip = false
Vue.use(Mint);
new VConsole();

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
