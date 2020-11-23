/* Steps to solving the problem */

// 0. Define initial variables/values
//      Define a variable to hold the number of problems in a set (Global/ Shared)

const PROBLEMS_IN_A_SET = 10;
let problemSet = [];        // Hold the problems to be displayed
let currentProblem = 1;
let score = 0;

// 1. Start-up processing: 

document.addEventListener('DOMContentLoaded', () => {
    generateProblemSet();       // Randomly generate the problems and answers
    displayProblemSet();        // Display a set of problems
}); // End of DOMContentLoaded event listener

function generateProblemSet() {
    for(let i = 0; i < PROBLEMS_IN_A_SET; i++) {
 //         i. generate the problem - a problem has an operator, left value, right value, answer
        const problem = {
        leftValue: getRandomNumber(10),
        rightValue: getRandomNumber(10),
        answer: null                        // this will hold the correct answer with 3 wrong answers
                        }
    const correctAnswer = problem.leftValue * problem.rightValue;
//          iii. generate 3 wrong answers
    const answerChoices = shuffleArray([correctAnswer, getRandomNumber(82), getRandomNumber(82), getRandomNumber(82)])
//        From above, we now have 3 fake answers and a correct answer stored in an array
//        Now, let's add the array of answer choices to the problem
        problem.answer = answerChoices;    // Put the answers in the problem object
        problemSet.push(problem);           // Add the problem to the problem set
    }
}

//      a. Randomly generate the problems + create the problem set. For each problem in the problem set: 
//         i. generate the problem - a problem has an operator, left value, right value, answer
//         ii. determine the right answer
//        iii. generate 3 wrong answers
//      b. Set the score to 0
//      c. Set the starting problem number to 1
//      d. Set the greeting text/ description

// 2. Display the problem one at a time

function displayProblemSet() {
    displayProblem();
    displayAnswers();
}


//      a. Display first problem to the user

function displayProblem() {
    const problemContainer = document.getElementById('problem');          // Find the element in the html that holds the problem

    const expression = `${problemSet[currentProblem-1].leftValue} * ${problemSet[currentProblem-1].rightValue}`;    // expression to display in the page
    problemContainer.querySelector('div.expression').innerText = expression;
}

//      b. Provide clickable boxes with the right answer and 3 wrong answers
function displayAnswers() {
    const answerContainer = document.getElementById('answers'); // Get a reference to the answers in the html
    const listOfAnswers = answerContainer.querySelector('ul');  // Get a reference to the ul that holds the answers
    const theListItems = listOfAnswers.querySelectorAll('li');  // Get an array of the list items to hold each answer
    const theAnswers = problemSet[currentProblem-1].answer;     // Copy the answers out of the problem for coding convenience

    for (let i=0; i < theAnswers.length; i++) {
        theListItems[i].innerText = theAnswers[i];
    }
}


//      c. When they click answer:
//          i. determine if answer is right or wrong
//         ii. if right, score it as right
//        iii. Add 1 to the problem number they are on
//         iv. Advance to the next problem
//              a. if it was the last problem, then hide intro text, the problem, and answers

// 3. Provide a start over process that resets to the start condition of the app





/**
 * Utility function to generate a random number based on max
 * @param {number} max
 */
function getRandomNumber(max) {
    return Math.floor(Math.random() * Math.floor(max));
   }


   /**
 * Utility function to shuffle the items in an array
 * @param {object} arr
 */
function shuffleArray(arr) {
    return arr.sort(function (a, b) { return Math.random() - 0.5 })
   }
   