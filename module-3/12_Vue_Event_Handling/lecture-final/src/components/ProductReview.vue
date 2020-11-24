<template>
  <div class="main">
    <h2>Product Reviews for {{ name }}</h2>

    <p class="description">{{ description }}</p>

    <div class="well-display">
      <div class="well">
        <!-- if AverageRating is clicked set the filter to value that is not a valid rating -->
        <!-- so all reviews will be displayed                                               -->
        <span class="amount" v-on:click="filter=0">{{ averageRating }}</span>
        Average Rating
      </div>

      <div class="well">
        <!-- add an event to the span so it's clickable                         -->
        <!-- when it's clicked we will set a variable to the number of stars    -->
        <!-- that variable will be used to filter the ratings displayed         -->
        <span class="amount" v-on:click="filter=1" >{{ numberOfOneStarReviews }}</span>
        <!-- if the numbers of stars is not 1 add an 's' to the words           -->
        <!-- use the conditional operator - ?                                   -->
        <!-- conditional operator:   condition ? value-if-true : value-if-false -->
        <!-- if the number of stars is 1, don't add an 's', if not add an 's    -->
        1 Star Review{{ numberOfOneStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="filter=2">{{ numberOfTwoStarReviews }}</span>
        2 Star Review{{ numberOfTwoStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="filter=3">{{ numberOfThreeStarReviews }}</span>
        3 Star Review{{ numberOfThreeStarReviews=== 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="filter=4">{{ numberOfFourStarReviews }}</span>
        4 Star Review{{ numberOfFourStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="filter=5">{{ numberOfFiveStarReviews }}</span>
        5 Star Review{{ numberOfFiveStarReviews === 1 ? '' : 's' }}
      </div>
    </div>

    <!-- Only display the 'ShowForm' link if the variable showForm is false    -->
    <!-- showForm is a variable defined in the <script> part of this component -->
    <!-- v-if controls the display of am element                               -->
    <!--     if condition is true the element is display, if false, it's not   -->

    <a
      id="show-form-button"
      href="#"
      v-on:click.prevent="showForm = !showForm">{{ showForm ? "Hide Form" : "Show Form"}}</a>
    <!-- show the form to add a new review if showForm is true                     -->
    <!-- if the event that the submit is clicked, run the method addNewReview      -->
    <!-- v-on adds an event handler to an element                                  -->
    <!-- prevent the default behavior of the submit button                         -->
    <!--     normally clicking a submit button causes an HTTP request to a URL     -->
    <!--     we don't want that to happen as we will handle it here on client side -->
    <form v-if="showForm === true" v-on:submit.prevent="addNewReview">
      <div class="form-element">
        <label for="reviewer">Name:</label>
        <input id="reviewer" type="text" v-model="newReview.reviewer" /> <!-- / close input tag -->
      </div>
      <div class="form-element">
        <label for="title">Title:</label>
        <input id="title" type="text" v-model="newReview.title" />
      </div>
      <div class="form-element">
        <label for="rating">Rating:</label>
        <select id="rating" v-model.number="newReview.rating">
          <option value="1">1 Star</option>
          <option value="2">2 Stars</option>
          <option value="3">3 Stars</option>
          <option value="4">4 Stars</option>
          <option value="5">5 Stars</option>
        </select>
      </div>
      <div class="form-element">
        <label for="review">Review</label>
        <textarea id="review" v-model="newReview.review"></textarea>
      </div>
      <!-- Disable submit button if form is not valid            -->
      <button v-bind:disabled ="!isFormValid">Submit</button>
      <button v-on:click.prevent="resetForm" type="cancel">Cancel</button>
    </form>
    <!-- Generate one of the following div for each element in               -->
    <!--     array returned by the filterReviews function (in computed)      -->
    <!-- Add a v-for to the div to loop through the reviews array            -->
    <!-- v-for requires a v-bind to assign a variable in order to keep track -->
    <!--    of where each array element appears on the screen                -->
    <!-- add the class favorited to the div when review.favorited is true    -->
    <!--       using v-bind:class={ classname : variable }                   -->
    <div
      class="review"
      v-bind:class="{ favorited: review.favorited }"
      v-for="review in filterReviews"  
      v-bind:key="review.id"
    >
      <h4>{{ review.reviewer }}</h4>
      <div class="rating">
        <img
          src="../assets/cigar.png"
          v-bind:title="review.rating + ' Star Review'"
          class="ratingStar"
          v-for="n in review.rating"
          v-bind:key="n"
        />
      </div>
      <h3>{{ review.title }}</h3>

      <p>{{ review.review }}</p>

      <p>
        Favorite?
        <!-- add  a checkbox for the review                                           -->
        <!-- if the checkbox is checked store that value in review.favorited variable --> 
        <!-- a checkbox return true if checked false if not                           -->
       <input type="checkbox" v-model="review.favorited" />
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "product-review",
  data() {
    return {
      name: "Cigar Parties for Dummies",
      description:
        "Host and plan the perfect cigar party for all of your squirrelly friends.",
      showForm: false,  // control whether or not the form for a new review is displayed
      filter: 0,        // Used to filter the ratings that are displayed - default to vallue to display all reviews
      newReview: {},
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
    };
  },
  computed: { // computed properties are generated whenever data changes on screen
    averageRating() {
      let sum = this.reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      return (sum / this.reviews.length).toFixed(1); // calculate the average and round to 1 decimal place
    },
    numberOfOneStarReviews() {
      // call the numberOfReviews method passing it the array to search 
      //          and the number of stars we want it to count
      return this.numberOfReviews(this.reviews, 1);  
    },
    numberOfTwoStarReviews() {
      // call the numberOfReviews method passing it the array to search 
      //          and the number of stars we want it to count
      return this.numberOfReviews(this.reviews, 2);
    },
    numberOfThreeStarReviews() {
      return this.numberOfReviews(this.reviews, 3);
    },
    numberOfFourStarReviews() {
      return this.numberOfReviews(this.reviews, 4);
    },
    numberOfFiveStarReviews() {
      return this.numberOfReviews(this.reviews, 5);
    },
    isFormValid() {  // Determine is all fields for a new review have been entered - return true if they are
      return   this.newReview.reviewer  // true if reviewer is not empty, false if it is
            && this.newReview.title     // true if title is not empty, false if it is
            && this.newReview.rating    // true if rating is not empty, false if it is
            && this.newReview.review;   // true if review is not empty, false if it is
    },
    filterReviews() {  // Filter reviews based on the value in the variable
    // use an anon-func with filter to get elements - send each element one at a time
    // .filter return true if the element its given should be result, flase if not
    // This will return an array of reviews that match the filter variable
    return this.reviews.filter((aReview) => {  
      // return true if rating === filter or filter === 0, false if not
        return aReview.rating === this.filter || this.filter === 0; 
    // alternate:
    // if (aReview.rating === filter) {
    //   return true;
    // }
    // else {
    //      return false;
    //      }
        })    
    }
 },
 
  methods: {  // methods are run when they are called/referenced
    // method to receive and array and a rating number
    //   return the number of elements in the array with the rating number
    //   (reduce the array to a count of ratings with the value passed)
    // reduce takes one parameter which is a function that takes
    //  two parameters a value to hold the result and an element
    //  an initial value for the result is optional (but recommended)
    //  each time the function is called the result is updated and returned based
    //  on the elment
 
    numberOfReviews(reviews, starType) {
      return reviews.reduce((currentCount, review) => {
        // if the rating in the current element equals the startype (rating)
        //     add 1 to cuurent count, otherwise add 0 to current count
         return currentCount + (review.rating === starType ? 1 : 0);
        // alternate code:
        // truthy / falsy - true=1, false=0
        // if a condition is true it returns a 1, if it's false, it returns a 0
        // if rating === starType add 1, if not add 0
        //return currentCount + (review.rating === starType); 
      }, 0);
    },
    addNewReview() {
      this.reviews.unshift(this.newReview);
      this.resetForm();
    },
    resetForm() {
      this.showForm = false;
      this.newReview = {};
    }
  }
};
</script>

<style scoped>
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

