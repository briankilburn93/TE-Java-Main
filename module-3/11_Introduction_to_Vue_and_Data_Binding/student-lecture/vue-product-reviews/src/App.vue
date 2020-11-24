<template>  <!-- HTML for the component -->
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <!-- A Vue component is used as a a tag in your HTML -->
    <!-- Vue component names are coded in PascalCase so you can tell them apart from standard HTML -->
    <product-review></product-review> <!-- our Vue component - note: kabob-case -->
    <HelloWorld msg="Welcome to Your Vue.js App"/>  <!-- using the HelloWorld.vue component -->
  </div>
</template>

<script>  // Javascript for the component
// the src folder is considered the root folder for the project
// directory references are relative to the src folder
//import HelloWorld from './components/HelloWorld.vue'            // Go get the HelloWorld.vue stuff
import ProductReview from './components/ProductReview.vue'      // Go get the ProductReview.vue code

// Allow Vue to access the data in this Javascript code so it can use and manipulate it
export default {    // export exposes data from Javascript to outside processes - like Vue
  name: 'App',      // name fo the application
  components: {     // Javascript object with elements containing the Vue components used
    //HelloWorld,           // Tells Vue we are using the HellowWorld component - match the import name
    ProductReview         // Tells Vue we are using the ProductReview component - match the import name
  }
}
</script>

<style> /* CSS for the component */
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
