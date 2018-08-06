
/// <reference path="../typings/globals/jquery/index.d.ts" />

  
// $(function () {  
 
// })
  

$(document).ready(function () {  
  $('#formLogin').submit(function(e) {
    $(".message").empty();
    $(".message").show();
    e.preventDefault();
  
    showAlert();
    $('#loginModal').modal('hide');
     $(".message").fadeOut(2000);
  });
})

function showAlert() {
  var divMessage = $(".message");
  var divAlert = $("<div>");
  var btnClose = $("<button>");
  divAlert.attr({
    "class":"alert alert-warning alert-dismissible fade show my-0",
    "role":"alert"
  })
  divAlert.text("Login success! Welcome To System");
  divMessage.append(divAlert);
}