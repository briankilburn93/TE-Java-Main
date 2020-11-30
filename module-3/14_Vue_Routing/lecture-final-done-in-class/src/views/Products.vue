<!-- Products view                                               -->
<!-- this view will be managed by the Vue Router                 -->
<!-- we need to tell router it is managing this view             -->
<!-- update the paths in @/router/index.js to include this view -->
<!-- Vue COMPONENTS are included here instead of App.vue         -->
<!-- this view will cause ProductsList.vue to be displayed       -->

<template>   <!-- html -->
    <div class="products">
        <h1>Products</h1>
        <products-list /> <!-- include the ProductsList.vue component --> 
    </div>
</template>
<script>     // JavaScript
//                        @ is a short-hand for the root folder of the app
import ProductsList from '@/components/ProductsList';  // Go get the ProductsList.vue code

export default {      // Expose data to external processes
    components: {     // List of Vue components used in this one
        ProductsList
    }
}
</script>
<style scoped> /* CSS */
</style>