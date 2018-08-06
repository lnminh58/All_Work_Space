/* var button =document.getElementsByTagName("button")[0];
var list = document.querySelectorAll("li");
var index =0;

button.addEventListener("click",LineThrough)
// document.addEventListener("keydown",LineThrough)




function LineThrough (){
  
    if(index>=list.length){
        alert("All Done!!!");
    }else{
        list[index].classList.add("done");
    }
    index++;
    
}

 */

var button = document.getElementById("enter");
var input = document.getElementById("item")
var index = 0;



function inputLenght() {
    return input.value.trim().length;
}

function AddItem() {
    if (inputLenght() > 0) {

        var li = document.createElement("li");
        li.appendChild(document.createTextNode(input.value));

        var button = document.createElement("button");
        button.className = "delete";
        button.appendChild(document.createTextNode("delete item"));
        var ul = document.querySelector("ul");
        li.addEventListener("click", function () {
            this.classList.toggle("done");
        })
        button.addEventListener("click", function () {
            this.previousElementSibling.remove();
            this.remove();
        })
        ul.appendChild(li);
        ul.appendChild(button);


    }
    input.value = "";
}

function isEnterPress(event) {
    if (event.keyCode === 13) {
        return true;
    }
    return false;
}

// button.addEventListener("click", function () {
//     AddItem();
// })

// input.addEventListener("keypress", function (event) {
//     if (isEnterPress()) {
//         AddItem();
//     }
// })


function AddItemAfterClick() {
    AddItem();
}

function AddItemAfterPressEnter(event) {
    if (isEnterPress(event)) {
        AddItem();
    }
}
button.addEventListener("click", AddItemAfterClick);
input.addEventListener("keypress", AddItemAfterPressEnter);


function addListItemEvent() {
    var listItem = document.querySelectorAll("li");

    listItem.forEach(function (item) {
        item.addEventListener("click", function () {
            this.classList.toggle("done");
        })

    })

    // listItem.forEach(element => {
    //     element.addEventListener("click", function () {
    //         this.classList.toggle("done");
    //     })
    // });
}


function addButtonEvent() {
    var listButton = document.querySelectorAll(".delete")
    listButton.forEach(function (item) {
        item.addEventListener("click", function () {
            this.previousElementSibling.remove();
            this.remove();
        })
    })
}

addButtonEvent();
addListItemEvent();