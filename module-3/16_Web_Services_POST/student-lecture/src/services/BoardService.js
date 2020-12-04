import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  getBoards() {
    return http.get('/boards');
  },

  getCards(boardID) {
    return http.get(`/boards/${boardID}`)
  },

  getCard(cardID) {
    return http.get(`/cards/${cardID}`)
  },

  // We need to do an HTTP Post to add data to the data source
  // an axios post wants the path and the data to be sent
  // axios automatically creates the headers and puts the data in the body of response
  // the data we send to post can either be a json object name or the json itself
  //                  .post('/somepath', {name: 'Frank', job: 'Instructor'})
  addCard(card) {
    return http.post('/cards', card); // call the API with POST request with the card object passed as data
  },

  // We need to do an HTTP PUT to update data in the data source
  // an axios .put wants the path and the data tobe sent for updating
  // axios automatically creates the headers and puts the data in the body of response
  // the data we send to post can either be a json object name or the json itself
  //                  .put('/somepath', {name: 'Frank', job: 'Instructor'})
  // An entire object is usually passed to an HTTP PUT request, not just the values to be updated
  updateCard(card) {
    return http.put(`/cards/${card.id}`, card);   // Update the card with the id passed in the data source
  },

  // We need to do an HTTP DELETE to delete data from the data source
  // Since not data is expected/sent in the body of an HTTP DELETE request, no parameter specify data is used
  //    in the axios .delete()
  deleteCard(cardID) {
    return http.delete(`/cards/${cardID}`);   // Delete the card with the id passed
  }

}
