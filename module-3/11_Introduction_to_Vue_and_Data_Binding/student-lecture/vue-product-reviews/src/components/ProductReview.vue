<template> <!-- HTML -->

<div id='main'>
    <h2>Product Reviews for {{ title }}</h2>    <!-- use a mustache expression {{ variable }} to hold a place data in out html -->
    <p class='description'>{{ words }}</p>      <!-- tldr: calls data() to grab title and words -->
</div>

</template>



<script> // Javascript
export default {        // Data to be shared with Vue
    name: 'product-review',     // component name in kabob-case (- between the words)
    data() {        // data() function is provided for Vue to vall when it needs data for the component
        return {        // we return a Javascript object with the data we want to share with Vue
            title: 'Cigar Parties for Dummies',
            words: 'Host and plan the perfect cigar party all for your squirrelly friends'
        }
    }
}
 </script>

 <style scoped> /* CSS - scoped indicates for this component only*/
div.main {
  margin: 1rem 0;
}
div.main div.well-display {
  display: flex;
  justify-content: space-around;
}
div.main div.well-display div.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
}
div.main div.well-display div.well span.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
}
div.main div.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}
div.main div.review.favorited {
  background-color: lightyellow;
}
div.main div.review div.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}
div.main div.review div.rating img {
  height: 100%;
}
div.main div.review p {
  margin: 20px;
}
div.main div.review h3 {
  display: inline-block;
}
div.main div.review h4 {
  font-size: 1rem;
}
 </style>
