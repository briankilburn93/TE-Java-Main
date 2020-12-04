<template>
  <div id="sideNav">
    <h1>My Kanban Boards</h1>
    <div class="boards">
      <!-- show this div when errorMsg is not empty (if there is an error message) -->
      <!-- Alternate code: v-show=!error -->
      <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
      <div class="loading" v-if="isLoading">
        <img src="../assets/ping_pong_loader.gif" />
      </div>
      <!-- Define a link to the router path named 'Board' passing it the board id of the board -->
      <!-- for each board of the boards array in the Vuex data store -->
      <router-link :to="{ name: 'Board', params: { id: board.id } }"
        class="board"
        v-for="board in this.$store.state.boards"
        v-bind:key="board.id"
        v-bind:style="{ 'background-color': board.backgroundColor }"
        v-else
        tag="div"
      >
        {{ board.title }}
      </router-link>
      <button class="btn addBoard" v-if="!isLoading && !showAddBoard" v-on:click="showAddBoard = !showAddBoard">Add Board</button>
      <form v-if="showAddBoard">
        Board Title:
        <input type="text" class="form-control" v-model="newBoard.title" />
        Background Color:
        <input type="text" class="form-control" v-model="newBoard.backgroundColor" />
        <button class="btn btn-submit" v-on:click="saveNewBoard">Save</button>
        <button class="btn btn-cancel" v-on:click="showAddBoard = !showAddBoard">Cancel</button>
      </form>
    </div>
  </div>
</template>

<script>
import boardsService from '../services/BoardService';

export default {
  data() {
    return {
      isLoading: true,
      showAddBoard: false,
      newBoard: {
        title: '',
        backgroundColor: this.randomBackgroundColor()
      },
      errorMsg: ''
    };
  },
  created() {
    this.retrieveBoards();
  },
  methods: {
    retrieveBoards() {
      // call the getBoards() in boardServices, wait for it to complete (.then)
      // when the call completes it calls the SET_BOARDS mutation in the data store to store the
      //    the response data is what the call to getBoards() returned
      //    AND indicate loading is complete (isLoading=false)
      boardsService.getBoards().then(response => {
        this.$store.commit("SET_BOARDS", response.data);
        this.isLoading = false;

        // Check to be sure there was no error in the call to getBoards()
        // if the path we are in is "Home" AND the http status code was 200 (OK) AND there was response data
        //    push the path /board/id-of-first-element-in-response to the browser - tell router/browser to go to this path/page
        if (this.$route.name == "Home" && response.status === 200 && response.data.length > 0) {    // if call was good
          this.$router.push(`/board/${response.data[0].id}`);     // go to the /board with the 1st element in the array
        }
      });
    },
    saveNewBoard() {

    },
    randomBackgroundColor() {
      return "#" + this.generateHexCode();
    },
    generateHexCode() {
      var bg = Math.floor(Math.random()*16777215).toString(16);
      if (bg.length !== 6) bg = this.generateHexCode();
      return bg;
    }
  }
};
</script>

<style scoped>
div#sideNav {
  height: 100%;
  width: 20%;
  position: fixed;
  z-index: 1;
  left: 0;
  top: 0;
  padding-top: 20px;
  padding-bottom: 20px;
  overflow-x: hidden;
  border-right: solid lightgrey 1px;
}

h1 {
  text-align: center;
}

.boards {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
}
.board {
  color: #f7fafc;
  border-radius: 10px;
  padding: 40px;
  flex: 1;
  margin: 10px;
  text-align: center;
  cursor: pointer;
  width: 60%;
}
.addBoard {
  color: #f7fafc;
  border-radius: 10px;
  background-color: #28a745;
  font-size: 16px;
  width: 60%;
  margin: 10px;
  padding: 20px;
  cursor: pointer;
}
.form-control {
  margin-bottom: 10px;
}
.btn {margin-bottom: 35px;}
.loading {
  flex: 3;
}
.board:hover:not(.router-link-active), .addBoard:hover {
  font-weight: bold;
}
.router-link-active {
  font-weight: bold;
  border: solid blue 5px;
}
</style>
