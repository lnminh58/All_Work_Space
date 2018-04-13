/* // alert("Tao là bạn thằng thiệm");

//   var a= function (){
//     document.write("<h2>Lê Ngọc Minh</h2> "+ "<p>Lớp HTML Express</p>");
//     alert("Viết được /n funtion rồi");
// }

const a =2;
let b=3;

function C(){
   
     function A(){
        var c= a+b;
        return c;
    };       
}

C();

function B(){
    b=A()+2;
}

B();
A();

console.log(a);
console.log(b);

let a=2 ;
let b=3;
while(a<b){
    a++;
    console.log(a);
    console.log(b);
} */
/* var b=[0,1,2,3];
var a =document.getElementsByClassName('text-title');
console.log(a);
console.log(a[0].innerHTML);
console.log(typeof(a));

 */

function showToConsole(){
    var firstname =  document.getElementById("name").value;
      console.log(firstname);
  }