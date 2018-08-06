/* const obj = {
    player : "bobby",
    experience: 100, 
    wizardLevel: false
} */

/* const player = obj.player;
const experience = obj.experience;
let wizardLevel = obj.wizardLevel;
 */
/* 
 const {player,experience} = obj;
 let { wizardLevel}=obj;
 console.log(player);
 console.log(experience);
 console.log(wizardLevel);
  */
// 


// // template String

// const name = "Sally";
// const age = "34";
// const pet = "horse";
// const greetingBest = `Hello ${name} you seem to be ${age -10}. what a lovely ${pet} you have.`

// function greet(name='', age =30, pet = 'cat') {  
//     return `Hello ${name} you seem to be ${age -10}. what a lovely ${pet} you have.`

// }

/* 
function outerFunction(a,b) {
    this.a =a;
    this.b=b;
    this.innerFunction = function() {
        return (this.a + this.b)*2;
      }
}

var outer = new outerFunction(3,5);
document.write(outer.innerFunction())


var a =5;
// do {
//     a++;
// }
// while(a++<10);
// console.log(a);

if(++a<6){
    a--;
}
console.log(a);

 */


/*  function checkPrime (n) {
     var num=0;
     for(var i=1;i<=n;i++){
        if(n%i===0){
            num++
        }
     }
     if(num===2){
        return true
     }
     return false;
 }

var input= document.getElementById("inNumber");
var button= document.getElementById("getInNumber");



button.addEventListener("click",function () {
    var number = input.value;
    document.write("Các số nguyên tố là","<br>")
    for(i=0;i<=number;i++){
        if(checkPrime(i)){

            document.write(`${i} `);
        }
    }
  })
 */

//  var divArr = document.getElementsByTagName("div");
//  for (let i = 0; i < divArr.length; i++) {
//      if((i+1)%2===0){
//         divArr[i].style.background = "crimson";
//      }else{
//         divArr[i].style.background = "teal";
//      }
//  }

/* function calSum(n) {
    var i=0;
    var sum=0;
    while(i<=n){
        if(i%2===0){
            sum+=i
        }
        i++;
    }
    console.log(sum);
    
} */

console.log('one');

setTimeout(() => {
    console.log('two');
    
}, 0);
console.log('three')

