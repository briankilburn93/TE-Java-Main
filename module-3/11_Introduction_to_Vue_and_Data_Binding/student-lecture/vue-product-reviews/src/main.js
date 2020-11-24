import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

new Vue({                   // instantiate a Vue application
  render: h => h(App),      // render tells Vue what the main component is called - must match name of an import
}).$mount('#app')           // $mount - tells Vue where in the index html the Vue components should be added
                            // #app - the element with id="app" will have all the Vue components added to it