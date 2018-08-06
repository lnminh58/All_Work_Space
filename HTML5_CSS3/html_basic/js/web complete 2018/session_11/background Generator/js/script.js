var css = document.querySelector("h3");
var color1 = document.querySelector(".color1");
var color2 = document.querySelector(".color2");
var deg = document.querySelector(".deg");
var body = document.getElementById("gradient");
console.log(css);
console.log(color1);
console.log(color2);

color1.addEventListener("input",setGradient)
color2.addEventListener("input",setGradient)
deg.addEventListener("input",setGradient);
function setGradient () { 
    body.style.background="linear-gradient("+deg.value+"deg," + color1.value +", "+color2.value+")";
    css.textContent = body.style.background + ";" ;
 }