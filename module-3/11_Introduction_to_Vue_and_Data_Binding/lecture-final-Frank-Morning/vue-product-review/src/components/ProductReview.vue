<template>  <!-- HTML for the component -->

    <div class='main'> 
        <h2>Product Reviews for {{title}}</h2>      <!-- use a mustache expression {{ variable }} to hold a place data in our html -->
        <p class='description'>{{words}} </p>  <!-- use a mustache expression {{ variable }} to hold a place data in our html -->
        <div class="well-display">  <!-- Hold all the rating boxes -->
        <div class="well">Average Rating  <!-- Average Rating Box -->
        <span class="amount">{{averageRating}}</span>    <!-- style place data in the middle of the element -->
        </div>  <!-- Average Rating Box -->
        <div class="well">  <!-- # 1-Star Rating Box -->
        <span class="amount">{{numberOfOneStarReviews}}</span>    <!-- style place data in the middle of the element -->
          1 Star Rating
          </div>  <!-- # 1-Star Rating Box -->
        <div class="well">
          <span class="amount">{{numberOfTwoStarReviews}}</span>
          2 Star Rating
          </div>  <!-- # 2-Star Rating Box -->
        <div class="well">  <!-- # 3-Star Rating Box -->
        <span class="amount">{{numberOfThreeStarReviews}}</span>    <!-- style place data in the middle of the element -->
          3 Star Rating
          </div>  <!-- # 3-Star Rating Box -->
          <div class="well">  <!-- # 4-Star Rating Box -->
        <span class="amount">{{numberOfFourStarReviews}}</span>    <!-- style place data in the middle of the element -->
          4 Star Rating
          </div>  <!-- # 4-Star Rating Box -->
          <div class="well">  <!-- # 5-Star Rating Box -->
        <span class="amount">{{numberOfFiveStarReviews}}</span>    <!-- style place data in the middle of the element -->
          5 Star Rating
          </div>  <!-- # 5-Star Rating Box -->
    </div>
    <!-- v-bind will allow you to connect a piece of data to an attribute for an element -->
    <!-- we are adding a  class="the-value from the favorite value in array element" -->
    <!-- we need to loop through the array here in the html defining elements for each review -->
    <!-- use the Vue v-for statement to loop through the array -->
    <!--  v-for=(element-name in array-name) - element-name contains the current element -->
    <!--  v-for requires a v-bind to connect a key to a value in the array -->
    <!--    the key is used to maintain sequence of the display when add.remove elements -->
    <div
        class="review"
        v-bind:class="{ favorited: reviews.favorited }"
        v-for="aReview in reviews" v-bind:key="aReview.id"
        >
        <h4>{{aReview.reviewer}}</h4>
        <div class="rating">
          <!-- add a title to the image that says # Star Review - v-bind connects data to something in html -->
          <!-- Use a v-for to tell Vue to duplicate this img element based on the value in the current review rating -->
          <!-- it doesn't matter what you call the variable - we are using 'n' -->
          <img 
              src="../assets/star.png"
              v-bind:title="aReview.rating + 'Star Review'"
              class="ratingStar"
              v-for="n in aReview.rating" v-bind:key="n" />
        </div>
        <h3>{{aReview.title}}</h3>
        <p>{{aReview.review}}</p>
        </div>
    </div>
</template>

<script>    // JavaScript for the component
export default {  // data to be shared with Vue
    name: 'product-review',  // component name in kabob-case (- between the words)
    data() {      // data() function is provided for Vue to vall when it needs data for the component
        return {  // we return an JavaScript object with the data we want to share with Vue
            title: 'Cigar Parties for Dummies',
            words: 'Host and plan the perfect cigar party for all your squirrelly friends',
            reviews: [
        {
          reviewer: "Malcolm Gladwell",
          title: "What a book!",
          review:
            "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language.",
          rating: 3,
          favorited: false
        },
        {
          reviewer: "Tim Ferriss",
          title: "Had a cigar party started in less than 4 hours.",
          review:
            "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
          rating: 4,
          favorited: false
        },
        {
          reviewer: "Ramit Sethi",
          title: "What every new entrepreneurs needs. A door stop.",
          review:
            "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
          rating: 1,
          favorited: false
        },
        {
          reviewer: "Gary Vaynerchuk",
          title: "And I thought I could write",
          review:
            "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
          rating: 3,
          favorited: false
        }
      ]
        }
    },
    computed: {   // Stuff in here will be computed everytime a value changes in the data
      averageRating() {
        let sum = this.reviews.reduce((totalRating, aReview) => {
          return totalRating+= aReview.rating;
        }, 0)
        return (sum / this.reviews.length);
      },
      numberOfOneStarReviews() {
        // go trhough the array and count the number of 1-star reviews
        // reduce the array to the number of 1-star reviews
        // call the array function reduce using the reviews array in this component
        // reduce takes one parameter which is a function that takes a variable to hold the result and an array element
        return this.reviews.reduce((currentCount, aReview) => {   // currentCount will have the # of 1-star reviews
                // add 1 to currentCount if rating is a 1
                if(aReview.rating === 1) {
                  currentCount++;
                }
                return currentCount;
        }, 0)
      },
      numberOfTwoStarReviews() {
        // go trhough the array and count the number of 1-star reviews
        // reduce the array to the number of 1-star reviews
        // call the array function reduce using the reviews array in this component
        // reduce takes one parameter which is a function that takes a variable to hold the result and an array element
        return this.reviews.reduce((currentCount, aReview) => {   // currentCount will have the # of 1-star reviews
                // add 1 to currentCount if rating is a 2
                if(aReview.rating === 2) {
                  currentCount++;
                }
                return currentCount;
        }, 0)
      },
      numberOfThreeStarReviews() {
        // go trhough the array and count the number of 1-star reviews
        // reduce the array to the number of 1-star reviews
        // call the array function reduce using the reviews array in this component
        // reduce takes one parameter which is a function that takes a variable to hold the result and an array element
        return this.reviews.reduce((currentCount, aReview) => {   // currentCount will have the # of 1-star reviews
                // add 1 to currentCount if rating is a 3
                if(aReview.rating === 3) {
                  currentCount++;
                }
                return currentCount;
        }, 0)
      },
      numberOfFourStarReviews() {
        // go trhough the array and count the number of 1-star reviews
        // reduce the array to the number of 1-star reviews
        // call the array function reduce using the reviews array in this component
        // reduce takes one parameter which is a function that takes a variable to hold the result and an array element
        return this.reviews.reduce((currentCount, aReview) => {   // currentCount will have the # of 1-star reviews
                // add 1 to currentCount if rating is a 4
                if(aReview.rating === 4) {
                  currentCount++;
                }
                return currentCount;
        }, 0)
      },
      numberOfFiveStarReviews() {
        // go trhough the array and count the number of 1-star reviews
        // reduce the array to the number of 1-star reviews
        // call the array function reduce using the reviews array in this component
        // reduce takes one parameter which is a function that takes a variable to hold the result and an array element
        return this.reviews.reduce((currentCount, aReview) => {   // currentCount will have the # of 1-star reviews
                // add 1 to currentCount if rating is a 5
                if(aReview.rating === 5) {
                  currentCount++;
                }
                return currentCount;
        }, 0)
      }
    }
}
</script>
<style scoped>  /* CSS for the component scoped indicates teh styling should be limited this component only */
                /* Becuase this component may be used with other components with similiar structure         */
                /* and/or class and id names, we domn't want to impact styling on those pages               */
                /* nor do WE want to impact styling on componets used with us                               */
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