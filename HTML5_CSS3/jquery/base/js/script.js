/// <reference path="../typings/globals/jquery/index.d.ts" />

// $(function(){
//   $(".blue-box").animate({
//     "margin-left":"+200px"

//   },1000,"linear",function () {
//     $(".blue-box").animate({
//       "margin-left":"+100px"
//     })
//   });
// });

// 012
// $(function () {
//     $('.blue-box').animate({
//       // "margin-left":"200px",
//       // "opacity":"0",
//       // "height":"50px",
//       // "width":"50px",
//       // "margin-top":"25px"
//       marginLeft:"200px",
//       opacity:"0",
//       height:"50px",
//       width:"50px",
//       marginTop:"25px"

//     },1000)
//     $("p").animate({
//      // "font-size":"20px",

//     },1000)
//     $("p").attr({
//       style:"color:red;font-size:50px",
//     })
// })


// 013
/* $(function () {
  $('.red-box').fadeTo(1000,0.2);
  $('.green-box').delay(1000).fadeTo(1000,0.5).fadeOut(1000).delay(1000).fadeIn(500);
  $('.blue-box').delay(1000).fadeTo(1000,0.8).fadeTo(1000,0.3);
}) */

//014
/* $(function () {
  $('.red-box').slideUp(1000, function () {
    $('.green-box').animate({
      marginLeft: "200px",
    }, 1000, function () {
      $('.blue-box').fadeOut(500, function () {
        $('.green-box').animate({
          marginLeft: "20px",
        }, 1000);
      });
    });
  });
}) */

// //015

// $(function () {
//   $('.lightbox').delay(500).slideDown(1000)
// })

// 016
/* $(function () { 
  //  $("p").css("background-color","rgba(30,180,30,0.8)");
  //  $(".red-box").css("background-color","rgba(30,180,30,0.8)");
  //  $("#list").css("background-color","rgba(30,180,30,0.8)");
  // $("h2,p,input").css("background-color","rgba(30,180,30,0.8)");   
  //  $("p:first").css("background-color","rgba(30,180,30,0.8)");   
  //  $("li:last").css("background-color","rgba(30,180,30,0.8)");   
  //  $("li:even").css("background-color","rgba(30,180,30,0.8)");   
  //  $("li:odd").css("background-color","rgba(30,180,30,0.8)");   

  //checked
  $("input:seleted").css("background-color","rgba(30,180,30,0.8)");   
}); */



// 017

/* $(function () {


  // $("#list").find("li").css("background-color","rgba(30,180,30,0.8)");   
  // $("#list").children("li").css("background-color","rgba(30,180,30,0.8)");   
  // $("#list").siblings(":header").css("background-color","rgba(30,180,30,0.8)");   
  // $("#list").prev().css("background-color","rgba(30,180,30,0.8)");   
  // $("#list").next().css("background-color","rgba(30,180,30,0.8)");   
  // $("#list").siblings(":header").next().css("background-color","rgba(30,180,30,0.8)");   

});
 */
//  018
/* $(function () {
  // $("#list").find("li").filter(":even").css("background-color","rgba(30,180,30,0.8)");
  // $("li").filter(function (index) {
  //     return index % 3===1;
  // }).css("background-color","rgba(30,180,30,0.8)");

  // $("li").first().css("background-color","rgba(30,180,30,0.8)");
  // $("li").last().css("background-color","rgba(30,180,30,0.8)");
  // $("li").eq(0).css("background-color","rgba(30,180,30,0.8)");
  $("li").not(function (index) {
    return index%3===0
  }).css("background-color","rgba(30,180,30,0.8)");
 });
 */

//020
/*  $(function () {
  //  $("ul ul:first").append("<li>I'm gonna be the last sub-item</li>");
  //  $("<li>I'm gonna be the last item</li>").appendTo($('ul ul:first'))
  //  $("ul ul:first").prepend("<li>I'm gonna be the last sub-item</li>");
  //  $("<li>I'm gonna be the last item</li>").prependTo($('ul ul:first'))


  //  $("<h4>Perter Somerhoff</h4>").prependTo($('#content'))

  // $(".red-box").after("<div class='red-box'>Another red</div>");
  // $(".blue-box").before("<div class='blue-box'>Another blue</div>");

    // $(".blue-box").before(function () { 
    //     return "<div class='blue-box'>Blue2</div>";
    //  }
    // );
    $(".blue-box").after($(".red-box").clone());
    // $("p").after($("#list"))

}) */


//  021

// $(function () { 
//   // $("li").replaceWith("<li>Replace.</li>");
//   // $("li").replaceWith(function () { 
//   //   return "<li> replace item with function </li>"
//   //  });

//     a= $("li");  
//   // $("p:first").replaceWith(firstListItem);

//   // var greenBox = $(".green-box").clone();
//   // $('.red-box,.blue-box').replaceWith(greenBox);

//   // $(greenBox).replaceAll('.red-box,.blue-box')


//  });


//  022
/* $(function () { 
  // var removeListItem= $("li").remove();
  // $("form").children().not("input,br").remove();

 var detachedListItem= $("#list").detach();
$("#content").append(detachedListItem);
  // $("p:first").empty();
  // $(".green-box,.blue-box").empty();

 })
 */
// 023
/* $(function () {
    // attr() , prop(), val()
    //  var specialLink= $("#specialLink");
    // specialLink.attr( {
    //   href:"https://google.com.vn",
    //   });
    
    // specialLink.attr("href","https://zing.vn"); 

    //  var checkbox = $('input:checkbox');
    // console.log(checkbox.prop('checked'));

    // checkbox.prop({
    //   checked:false,
    // })
    
    // console.log(checkbox.prop('checked')); 

    // var textInput=$("input:text"); 
    // var range=$("input[type='range']");
    // console.log((textInput.val()));
    // $("input:submit").click(function (e) { 
    //   e.preventDefault();
    //   console.log((textInput.val()));
    //   console.log((range.val()));
    // });
    
}) */

/* $(function () {
  var galleryImage = $(".gallery").find("img").first();
  var images = [
    "images/laptop-mobile_small.jpg",
    "images/laptop-on-table_small.jpg",
    "images/people-office-group-team_small.jpg"
  ];
  var i = 0;
  setInterval(function () {
    i = (i + 1) % images.length; // 0 1 2 0 1 2
    galleryImage.fadeOut(function () {
      $(this).attr("src", images[i]);
      $(this).fadeIn(1000);
    });
    console.log(galleryImage.attr("src"));
    
  }, 5000);
}); */


// 025

/* $(function () {
  $('.gallery').css("display","none"); // .hide()
  var redBox = $('.red-box');
  console.log(redBox.css('width'));
  console.log(redBox.width());
  
  redBox.css('background-color',"#AA7700");
  $('p').css("font-size","18px");

  console.log(redBox.css('background-color'));

  redBox.css("width","+=80")
  var properties= $("p").css(["font-size","line-height","color"]);
  console.log(properties);
  console.log(properties["font-size"]);

  redBox.css("user-select","none")
  
})

 */

// 026

/* $(function () {
  $("a").addClass("fancy-link");

  $("p:first").addClass("large emphasize");

  $("li li").addClass(function (index) { 
    $(this).addClass("item-" + index);
   })

  //  $("div").addClass(function (index, currentClass) {
  //     if(currentClass==="dummy"){
  //       return "red-box"
  //     }
  //    })

  //    $(".red-box").removeClass("red-box").addClass("blue-box")

  $('.dummy').removeClass("dummy").addClass("green-box");

    //  $("div").addClass(function (index, currentClass) {
    //   if(currentClass==="dummy"){
    //     $(this).removeClass("dummy").addClass("red-box");
        
    //   }
    //  })

}); */

/* //027
$(function () {
  var gallery=$(".gallery");
  var images = [
    "images/laptop-mobile_small.jpg",
    "images/laptop-on-table_small.jpg",
    "images/people-office-group-team_small.jpg"
  ];
  gallery.data("availableImages",images);
  console.log(gallery.data("availableImages"));

  gallery.data("name","the Awesome Gallery");
  console.log(gallery.data());
  gallery.removeData("name");
  console.log(gallery.data("name"));
}); */

// 028
/* 
$(function () { 
  // text() , html()
  var firstPar = $("p:first");
  // console.log(firstPar.text());
  // console.log(firstPar.html());
  // console.log($('p').html());
  // firstPar.text("<strong>Hello</strong> World!");
  firstPar.html(firstPar.html()+"<strong>Hello</strong> World!");
  
});
 */
//029

/* $(function () {
  // $('#btnClick').click(function (event) { 
  //   console.log(event);
    
  //   alert("button was clicked")
  //  })

  $('#btnClick').on('click',function () {
    $('.red-box').fadeTo(2000,0.5);
    console.log("click");
    
    })
})
 */

// 031

/* $(function () {
  // $('#btnHover').hover(function () {
  //   alert("Button war hover")
  // });
  var i=0;
  $('.green-box').hover(function () {
    i++;
    if(i%2===1){
      $(this).text("I was Hover");
    }
    else{
      $(this).text("Green");
    }
    })
}) */


//032

/* $(function () {
  var blueBox = $('.blue-box');
  // blueBox.mouseenter(function () {  
  //   $(this).stop().fadeTo(500,0.7);
  // })
  // blueBox.mouseleave(function () {  
  //   $(this).stop().fadeTo(500,1);
  // })

  blueBox.hover(
    function () {
      $(this).stop().fadeTo(1000,0.5);
    },
    function () {
      $(this).stop().fadeTo(1000,1);
      
    }
  )

}) */


//033

/* $(function () {  
  //.on("click",function(){})

  $('html').on("click keydown",function () { 
    console.log("mouse was clicked or key was press");
   })

   var images = [
    "images/laptop-mobile_small.jpg",
    "images/laptop-on-table_small.jpg",
    "images/people-office-group-team_small.jpg"
  ];
  var i=0;
  $('.gallery').find("img").on("click",function () { 
    i= (i+1)%images.length;
    $(this).fadeOut(function () { 
      $(this).attr("src",images[i]).fadeIn();
     })
   })

}) */

/* // 034
$(function () {  

  $('html').on("click keydown",logEvent);
  galleryImage.on("click",changeImages)
})


var images = [
  "images/laptop-mobile_small.jpg",
  "images/laptop-on-table_small.jpg",
  "images/people-office-group-team_small.jpg"
];
var i=0;
var galleryImage=$('.gallery').find("img");
function  changeImages () { 
  i= (i+1)%images.length;
  $(galleryImage).fadeOut(function () { 
    $(galleryImage).attr("src",images[i]).fadeIn();
   })
 }



function  logEvent (){ 
  console.log("mouse was clicked or key was press");
 } */


//035

/* $(function () {
  //  $('p').click(function () {  
  //    $(this).slideUp();
  //  })
  //  $('#content').append("<p> this is my name");

  //delegate events
  // $('#content').on('click','p',function () {
  //   $(this).slideUp();
  // })
  // $('#content').append("<p> this is my name");

  $('body').on('mouseenter', 'li', function () {
    $(this).css("color", "red");
  })
  $('body').on('mouseleave', 'li', function () {
    $(this).css("color", "#000");
  })


}) */

// 036

/* $(function () {
  $('#btnClick').click({
    user:"Peter",
    domain: "Petersomerhoff.com"
  },function(event){
    console.log(event);
    
    greetUser(event.data);
  });

  function greetUser (userdata) { 
    username=userdata.user||"anonymous";
    domain=userdata.domain||"example.com";
    alert("Welcome back "+username+" from "+domain+"!");
   }
}) */

// 037

/* $(function () {  
  var galleryItems =$('.gallery').find("img");
  galleryItems.css("width","30%").css("opacity","0.7");
  galleryItems.mouseenter(function () {  
    $(this).stop().fadeTo(200,1);
  });
  galleryItems.mouseleave(function () {  
    $(this).stop().fadeTo(200,0.7);
  });
  galleryItems.click(function(){
    var source = $(this).attr("src");
    var image = $("<img>").attr("src", source).css("width","100%");
    $('.lightbox').empty().append(image).fadeIn(1000);
  })
  $('.lightbox').click(function () {  
    $(this).stop().fadeOut();
  })

}); */


// 038

/* $(function () {
  //keypress()-Evil!
  $("html").keydown(function (event) {
    var keyvalue = event.which;
    console.log(keyvalue);
    if (keyvalue === 68) {
      // $('.lightbox').fadeIn(1000);
      $('.blue-box').animate({
        marginLeft: "+=10",
      },100)
    };
    // $('.lightbox').click(function () {  
    //   $(this).stop().fadeOut();
    // });
    if (keyvalue === 65) {
      // $('.lightbox').fadeIn(1000);
      $('.blue-box').animate({
        marginLeft: "-=10",
      },100)
    };
    if (keyvalue === 83) {
      // $('.lightbox').fadeIn(1000);
      $('.blue-box').animate({
        marginTop: "+=10",
      },100)
    };
    if (keyvalue === 87) {
      // $('.lightbox').fadeIn(1000);
      $('.blue-box').animate({
        marginTop: "-=10",
      },100)
    };
  })
}); */

/* //039

$(function () {  
    var inputFields = $("input:text,input:password, textarea");
    inputFields.focus(function () {  
      $(this).css("box-shadow","0 0 4px #666")
    });
    inputFields.blur(function () {  
      $(this).css("box-shadow","none");
    })

    $("#name").blur(function () {
      var text = $(this).val();
      if(text.length < 3){
        $(this).css("box-shadow","0 0 10px #811");
      }else {
        $(this).css("box-shadow","0 0 10px #181");
      }
    })
}); */


// 040

/* $(function () {  
  $("#checkbox").change(function () {  
    var isChecked = $(this).is(":checked");
    if(isChecked){
      $(this).add("label[for='cb']").css("box-shadow","0 0 4px #181");
    }else{
      $(this).add("label[for='cb']").css("box-shadow","0 0 4px #811");
    };
  });
  $('#selection').change(function () {  
    var selectedOption = $(this).find(":selected").text();
    alert(selectedOption);
  })
}); */


// 041

/* $(function () {  
  $("#form").submit(function (event) {  
    var textarea = $("#message");
    if(textarea.val().trim()==""){
      textarea.css("box-shadow","0 0 4px #811");
      event.preventDefault();
    } else {
    
    }
  });
});
 */


// 042 043

// $(function () {
//   var form = $('#form');
//   enableFastFeedback(form);



//   $('#form').submit(function (event) {

//     var name = $("#name").val();
//     var password = $("#password").val();
//     var message = $("#message").val();
//     var checked = $("#checkbox").is(':checked');
//     validateNameField(name, event);
//     validatePasswordField(password, event);
//     validateMessageField(message, event);
//     validateCheckboxField(checked, event);
//   });
// });

// function enableFastFeedback(formElement) {
//   var nameInput = formElement.find("#name");
//   var passwordInput = formElement.find("#password");
//   var messageInput = formElement.find("#message");
//   var checkboxInput = formElement.find("#checkbox");

//   nameInput.blur(function () {
//     var name = $(this).val();
//     validateNameField(name, event);
//     if (!isValidName(name)) {
//       invalidFeedBack($(this));
//     } else {
//       validFeedBack($(this));
//     }
//   });

//   passwordInput.blur(function () {
//     var password = $(this).val();
//     validatePasswordField(password, event);
//     if (!isValidPassword(password)) {
//       invalidFeedBack($(this));
//     } else {
//       validFeedBack($(this));
//     }
//   });

//   messageInput.blur(function () {
//     var message = $(this).val();
//     validateMessageField(message, event);
//     if (!isValidMessage(message)) {
//       invalidFeedBack($(this));
//     } else {
//       validFeedBack($(this));
//     }
//   });


//   checkboxInput.change(function (event) {
//     var isChecked = $(this).is(":checked");
//     validateCheckboxField(isChecked, event);

//     if (!isChecked) {

//      invalidFeedBack($(this).add("label[for='cb']"));
//     } else {
//      validFeedBack($(this).add("label[for='cb']"))
//     }
//   });
// }

// function invalidFeedBack(element) {
//   element.css({
//     "box-shadow": "0 0 4px #811",
//     "border": "1px solid #600"
//   });
// }

// function validFeedBack(element) { 
//   element.css({
//     "box-shadow": "0 0 4px #181",
//     "border": "1px solid #060"
//   });
// }


// function validateNameField(name, event) {
//   if (!isValidName(name)) {
//     $('#name-feedback').text("please enter at least two characters");
//     event.preventDefault();
//   } else {
//     $('#name-feedback').text("");
//   }
// }

// function validatePasswordField(password, event) {
//   if (!isValidPassword(password)) {
//     $("#password-feedback").text("please enter at least six characters and contain a number");
//     event.preventDefault();
//   } else {
//     $('#password-feedback').text("");
//   }
// }

// function validateMessageField(message, event) {
//   if (!isValidMessage(message)) {
//     $("#message-feedback").text("please enter a message");
//     event.preventDefault();
//   } else {
//     $('#message-feedback').text("");
//   }
// }


// function validateCheckboxField(isChecked, event) {
//   if (!isChecked) {
//     $("#checkbox-feedback").text("Please agree to this");
//     event.preventDefault();
//   } else {
//     $("#checkbox-feedback").text("");
//   }
// }

// function isValidName(name) {
//   console.log(name.length);

//   return name.length >= 2;

// }

// function isValidPassword(password) {
//   console.log(password.length);
//   return password.length >= 6 && /.*[0-9].*/.test(password);
// }

// function isValidMessage(message) {
//   return message.trim() != "";
// }

// 045
/* 
$(function () {  
  //$.load()
  // $("#code").load("js/script.js");
  $("#code").load("js/script.js",function (response,status) {  
    if(status=="error"){
      alert("could not find file");
    }
    console.log(response);
  });

}); */


//046
/* 
$(function () {
  //json $.getJSON()
  var flickrApiUrl = "https://api.flickr.com/services/feeds/photos_public.gne?jsoncallback=?";
  $.getJSON(flickrApiUrl, {
    //options...
    tags: "aquarium",
    tagmode: "any",
    format: "json",
  }).done(function (data) {
    // success
    console.log(data);
    $.each(data.items,function (index,item) {  
      console.log(item);
      $("<img>").attr("src",item.media.m).appendTo("#flickr")
      if(index==4){
        return false;
      }
    });
  }).fail(function () {
    // failure
    alert("Ajax call Failed")
  })
}) */



//047

$(function () {
  var pokeApiUrl = "https://pokeapi.co/api/v2/generation/1/";
  var pokemonByName = "https://pokeapi.co/api/v2/pokemon/";
  $.getJSON(pokeApiUrl).done(function (data) {
    // success
    console.log(data);
    $.each(data.pokemon_species, function (index, pokemon) {
      var name = pokemon.name.charAt(0).toUpperCase() + pokemon.name.slice(1);
      var link = $("<a>").attr("id", pokemon.name).attr("href", "#").append($("<strong>").text(name));
      var par = $("<p>").html("Pokemon species no." + (index + 1) + " is ").append(link);

      link.click(function (event) {
        $.getJSON(pokemonByName + pokemon.name).done(function (details) {
          console.log(details);
          var pokemonDiv = $("#pokemon-details");
          pokemonDiv.empty();
          pokemonDiv.append("<h2>" + name + "</h2>");
          pokemonDiv.append("<img src = '" + details.sprites.front_default + "'>");
          pokemonDiv.append("<img src = '" + details.sprites.back_default + "'>");
          pokemonDiv.append("<img src = '" + details.sprites.front_shiny + "'>");
          pokemonDiv.append("<img src = '" + details.sprites.back_shiny + "'>");
        });
        event.preventDefault();
      })

      par.appendTo("#pokemon");
    });
  }).fail(function () {
    // failure
    alert("Ajax call Failed")
  }).always(function () {
    console.log("pokemon is Awesome");

  });
});