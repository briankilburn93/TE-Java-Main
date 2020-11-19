// add pageTitle
const pageTitle = 'My Shopping List';

// add groceries
const groceries = [
  "bananas",
  "apples",
  "grapes",
  "water",
  "coffee",
  "tee",
  "chicken",
  "beef",
  "turkey",
  "ham"
];

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  document.getElementById('title').innerText=pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  
  groceries.forEach( (anItem) => {
    const newItem = document.createElement('li');
    newItem.setAttribute('class', 'item');
    newItem.innerText = anItem;

    document.getElementById('groceries').appendChild(newItem);
  });
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  let theList = document.getElementById('groceries');
  let itemList = Array.from(theList.children);

itemList.forEach((listItems) => {
  listItems.setAttribute('class', 'completed');
});
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
