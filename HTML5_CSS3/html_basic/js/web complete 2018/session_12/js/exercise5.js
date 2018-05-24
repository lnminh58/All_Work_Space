// Complete the below questions using this array:


const array = [{
    username: "john",
    team: "red",
    score: 5,
    items: ["ball", "book", "pen"]
  },
  {
    username: "becky",
    team: "blue",
    score: 10,
    items: ["tape", "backpack", "pen"]
  },
  {
    username: "susy",
    team: "red",
    score: 55,
    items: ["ball", "eraser", "pen"]
  },
  {
    username: "tyson",
    team: "green",
    score: 1,
    items: ["book", "pen"]
  },

];


const clone = obj => JSON.parse(JSON.stringify(obj));
//Create an array using forEach that has all the usernames with a "!" to each of the usernames
/* var arr1=[] 
array.forEach(obj => {
  obj.username += '!';
  arr1.push(obj);
}) */


//Create an array using map that has all the usernames with a "? to each of the usernames

/* const arr2 = array.map(obj=> {
  var objClone = clone(obj);
  objClone.username+="!";
  return objClone;
})
console.log(arr2);
console.log(array);
 */



 //Filter the array to only include users who are on team: red
/* const arr3 = array.filter(obj => obj.team === "red")
console.log(arr3);
console.log(array); */


//Find out the total score of all users using reduce
/* var totalScore = array.reduce((total,obj)=> total+= obj.score,0); // you can replace += with +
console.log(totalScore); */



// (1), what is the value of i?
// (2), Make this map function pure:
const arrayNum = [1, 2, 4, 5, 8, 9];
const newArray = arrayNum.map(num => num * 2);
console.log(newArray);


//BONUS: create a new list with all user information, but add "!" to the end of each items they own.