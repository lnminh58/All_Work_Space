// reference type

// context vs scope
const objectOne = {
    a:function () { 
        console.log(this);
     }
}

// instantiation

class Player{
    constructor(name, type){
        this.name = name;
        this.type = type;
    }
    introduce () {
        console.log(`Hi I'm ${this.name}, I'm a ${this.type}`);
        
    }
}

var playerOne = new Player("Minh","FPS gamer");
playerOne.introduce();
// playerOne.play();
class Wizard extends Player {
    constructor(name, type){
        super(name, type);
    }
    play(){
        console.log(`WEEEEEE I'm a ${this.type}`);
        
    }
}

const wizard1 = new Wizard("Minh", "Healer");
const wizard2 = new Wizard("John", "Dark Magic");
wizard1.introduce();
wizard2.play();


// Solve the below problems:


// #1) Check if this array includes the name "John".
const dragons = ['Tim', 'Johnathan', 'Sandy', 'Sarah'];
console.log(dragons.includes('Tim'));


// #2) Check if this array includes any name that has "John" inside of it. If it does, return that
// name or names in an array.
// const dragons = ['Tim', 'Johnathan', 'Sandy', 'Sarah'];


// #3) Create a function that calulates the power of 100 of a number entered as a parameter


// #4) Useing your function from #3, put in the paramter 10000. What is the result?
// Research for yourself why you get this result


