/* function  first() {
    var greet = "hi";
    function second() {
        alert(greet);
    }
    return second;
  }

  var newFunc = first();
  newFunc(); */

  const first = () =>{
      const greet='Hi';
      const second = () => {
          alert(greet);
      }
      return second;
  }
 const newFunc = first();


const multiply = (a,b) => a*b;
const curriedMultiply = (a) => (b) =>a*b;
curriedMultiply(3);
const multiplyByFive =curriedMultiply(5);

//Compose

const compose = (f,g) => (a) => f(g(a)); 
const sum = (num) => num+1;

