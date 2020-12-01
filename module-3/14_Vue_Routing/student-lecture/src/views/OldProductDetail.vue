<template> <!-- html -->
    <div id='app' class='main'>
        <h1>Product Name:</h1>

        <products-list />   <!-- include the ProductsList.vue component -->



    </div>
</template>

<script> // JavaScript
// We need to get the product id to be displayed in this page
// We need to get the product data from the Vuex data store for the id we are given in the path
// The product id is coming from the url path: product/:id
// Remember: Vue router creates the page when it gets a path it knows about
//      Since we need the data before the page is created in order to place the data in the page
//      a way to intercept the page create process and get the data is needed


export default {        
    created() {     // Define code to be run for the created hook in the Vue processing
                    //      this code will run BEFORE Vue compiles the template which generates the HTML for the page
            // we need to get the id from the URL and set the activeProductID in the data store to it
    const currentProductId = this.$route.params.id;     // Get the value of id form the URL
    this.$store.commit("SET_ACTIVE_PRODUCT", currentProductId);     // Tell data store to set the active project to the id we just got
    },
    computed: {
        product() {     // this function will get the current product's data from the data store
            //      go to the data store products array and get the current product's data from the data store



            // Loop through the array of products in the data store and find the one that matches the active product id
            const theProducts = this.$store.state.products.find(aProduct => aProduct.id === this.$store.state.activeProduct);
    
            return theProducts;
        }
    }
}
</script>


<style scoped> /* CSS */

</style>