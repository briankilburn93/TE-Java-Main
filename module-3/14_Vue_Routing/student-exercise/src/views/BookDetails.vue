<template>
    
<div>
    <book-details />
</div>

</template>

<script>
import BookDetails from '@/components/BookDetails.vue';

export default {
    components: {
        BookDetails
    },
    created() {
        const currentProductId = this.$route.params.isbn;
        this.$store.commit("SET_ACTIVE_PRODUCT", currentISBN);
    },
    computed: {
        product() {
            return this.$store.state.books.find(
                (aProduct) => { return aProduct.isbn == this.$store.state.activeProduct;})
        }
    }
    
}
</script>

<style scoped> /* CSS */

</style>