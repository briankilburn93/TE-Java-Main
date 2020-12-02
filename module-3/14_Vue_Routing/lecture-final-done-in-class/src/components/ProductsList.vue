<template>
  <table>
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th># Reviews</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="product in $store.state.products" v-bind:key="product.id">
        <td>{{ product.id }}</td>
        <!-- We want display a new page when the product is clicked                     -->
        <!-- to do that we need to add a router link to the line                        -->
        <!-- <router-link> defines a link to the router                                 -->
        <!-- v-bind:to indicates where you want to go when the link is clicked          -->
        <!-- name: "name-of-a-path-in-index.js-for-router"                              -->
        <!-- if the path requires a variable, use params: {param-name: data-source}     -->
        <td>
        <!-- create a link for a path named product-detail in the router index.js       -->
        <!-- include a path variable called id with the value of the current product id -->
        <router-link
            v-bind:to="{ name: 'product-detail', params: {id : product.id} }">
        {{ product.name }}
        </router-link>
        </td>
        <td>{{ product.reviews.length }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: "products-list"
};
</script>

<style style="scoped">
th,
td {
  text-align: left;
}
td {
  padding-right: 10px;
  vertical-align: top;
}
tr:nth-child(even) {
  background-color: rgb(238, 238, 238);
}
</style>
