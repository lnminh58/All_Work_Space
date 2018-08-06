
/// <reference path="../typings/globals/jquery/index.d.ts" />

$('.carousel').carousel({
  interval: 3000,
})

$(document).on('click', '[data-toggle="lightbox"]', function (event) {
  event.preventDefault();
  $(this).ekkoLightbox();
});


// $(".alert").alert('close');





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

$("#gallery .row").children().addClass("wow fadeInUp");
$('.title').addClass("wow fadeInDown")

$('.wow').attr ({
  "data-wow-duration":"1.5s",
  "data-wow-delay":"0.5s",
});


var wow = new WOW({
  // boxClass: 'wow', // animated element css class (default is wow)
  // animateClass: 'animated', // animation css class (default is animated)
  offset: 20, // distance to the element when triggering the animation (default is 0)
  // mobile: true, // trigger animations on mobile devices (default is true)
  live: true, // act on asynchronously loaded content (default is true)
  callback: function (box) {
      // the callback is fired every time an animation is started
      // the argument that is passed in is the DOM node being animated
  },
  scrollContainer: null // optional scroll container selector, otherwise use window
});
wow.init();

