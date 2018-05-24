// Advanced arrays

const array = [1,2,10,16];
/* const double=[]
const newArr = array.forEach((num)=>{
    double.push(num*2);
})
console.log(double);
 */
// Map
// const mapArray = array.map((num) => {
//     return num*2;
// });
const mapArray = array.map( num => num*2 );
console.log('map', mapArray);

// filter 
const filterArray = array.filter(num => num>5);
console.log('filter',filterArray);


// reduce

const reduceArray = array.reduce((accumulator,num) => accumulator+num, 0);

 console.log(reduceArray);
 