<template>
  <div class="main">
    <h2>Product Reviews for {{ name }}</h2>

    <p class="description">{{ description }}</p>

    <div class="well-display">
      <div class="well">
        <!-- if AverageRating is clicked, set the filter to value that is not a valid rating -->
        <!-- so all reviews will be displayed -->
        <span class="amount" v-on:click="filter=0">{{ averageRating }}</span>
        Average Rating
      </div>

      <div class="well">
        <!-- add an event to the span so it's clickable -->
        <!-- when clicked, we will set a variable to the number of stars for the review -->
        <!-- that variable will be used to filter the ratings displayed -->
        <span class="amount" v-on:click="filter=1">{{ numberOfOneStarReviews }}</span>
        1 Star Review{{ numberOfOneStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="filter=2">{{ numberOfTwoStarReviews }}</span>
        2 Star Review{{ numberOfTwoStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="filter=3">{{ numberOfThreeStarReviews }}</span>
        3 Star Review{{ numberOfThreeStarReviews === 1 ? '' : 's' }}
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

    <a
      id="show-form-button"
      href="#"
      v-on:click.prevent="showForm = true"
      v-if="!showForm"
    >Show Form</a>

    <form v-if="showForm === true" v-on:submit.prevent="addNewReview">
      <div class="form-element">
        <label for="reviewer">Name:</label>
        <input id="reviewer" type="text" v-model="newReview.reviewer" />
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
      <button>Submit</button>
      <button v-on:click.prevent="resetForm" type="cancel">Cancel</button>
    </form>

    <!-- Generate one of the following div for each element in
    array returned by the filterReviews function(in computed)
    Add a v-for to the div to loop through the reviews array
    v-for required a v-bind to assign a variable in order to keep track
    of where each array element appears on the screen
    add the class favorited to the div when review.favorited is true
    using v-bind:class={classname:variable} -->

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
      showForm: false,    // control whether or not the form for a new review is displayed
      filter: 0,          // Used to filter the ratings that are displayed
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
  computed: {
    averageRating() {
      let sum = this.reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      return (sum / this.reviews.length).toFixed(2);        // .toFixed(#) to round to # decimal places
    },
    numberOfOneStarReviews() {
      return this.numberOfReviews(this.reviews, 1);
    },
    numberOfTwoStarReviews() {
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
    filterReviews() {         // Filter reviews based on the value in the variable filter
    // use an anon-func with filter to get element - send each element one at a time
    //    .filter return true if the element its given should be result, false if not
      return this.reviews.filter((aReview) => {
        // return true if         rating === filter or  false if not
        return aReview.rating === this.filter || this.filter === 0;   
        // alternate: if(aReview.rating === filter) { return true; else return false;}
      })
      }
  },
  methods: {
    numberOfReviews(reviews, starType) {
      return reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === starType ? 1 : 0);
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

