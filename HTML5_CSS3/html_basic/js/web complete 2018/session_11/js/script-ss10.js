// var todos = [
//     "clean room",
//     "brush teeth",
//     "exercise",
//     "study js",
//     "eat healthy"
// ]


// var todosV2 = [
//     "clean room!",
//     "brush teeth!",
//     "exercise!",
//     "study js!",
//     "eat healthy!"
// ]
// function logTodos(todo,i) {
//     console.log(todo,i);

// } 

// todos.forEach(logTodos);
// todosV2.forEach(logTodos);

var database = [{
        username: "lnminh58",
        password: "ngocminh58"
    },
    {
        username: "admin",
        password: "123456"
    },
    {
        username: "hello",
        password: "123456"
    }
];
var newsfeed = [{
        username: "katana",
        timeline: "Eat something"
    },
    {
        username: "sahara",
        timeline: "fuk something"
    },
    {
        username: "banana",
        timeline: "drink something"
    }
];

var userNamePrompt = prompt("what's your username");
var passwordPrompt = prompt("what's your password");

function signIn(user, pass) {
    var isValid = false 
    database.forEach(function (item) {
            if (user === item.username && pass === item.password) {
                console.log(newsfeed);
                isValid = true;
                return;
            }
      
        }
    )
    if(isValid===false){
        alert("Wrong username or password");
    }

}

// function signIn(user, pass) {
//     for(var i=0; i< database.length;i++){
//        if(user === database[i].username&& pass===database[i].password){
//            console.log(newsfeed);
//            return;
//         }
//     }
//     alert("Wrong username or password");

// }


signIn(userNamePrompt, passwordPrompt);