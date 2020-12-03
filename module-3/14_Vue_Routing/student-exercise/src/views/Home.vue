<template>
    
<div>
    <best-seller-list />
    <new-releases-list />

    <div id="nav">
        <router-link to="/addBook">Add Book to Reading List</router-link>
    </div>
</div>

</template>

<script>
import BestSellerList from '@/components/BestSellerList.vue';
import NewReleasesList from '@/components/NewReleasesList.vue';

export default {
    components: {
        BestSellerList,
        NewReleasesList
    }
    
}
</script>

<style scoped> /* CSS */

</style>