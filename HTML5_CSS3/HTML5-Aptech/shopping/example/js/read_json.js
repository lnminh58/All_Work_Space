$(document).on('click', '#readJson', function () {
  $.ajax({
    url: 'https://vnexpress.net/rss/tin-moi-nhat.rss',
    type: 'GET',
    dataType: "xml",
    success: function(res) {
      $.each($("item", res), function(i, e) {
        console.log(i, e);
        // var blogNumber = i + 1 + ". ";

        // var itemURL = ($(e).find("link"));
        // var blogURL = "<a href='" + itemURL.text() + "'>" + itemURL.text() +"</a>";

        // var itemTitle = ($(e).find("title"));
        // var blogTitle = "<h4>" + blogNumber + itemTitle.text() + "</h4>";

        // $("#feed").append(blogTitle);
        // $("#feed").append(blogURL);

    });
    },
    errors: function (error) {
      console.log(error, 'errors');
    }
  });
});


$(document).ready(function() {
  // handleLogin();
  // $(window).scrollY = "100px"; 
  // $('html, body').animate({
  //   scrollTop: $(window).scrollTop() + 500
  // });
  // console.log()

  $(window).scroll(function(e) {
    if (window.scrollY >= 300) {
      $('.form-login').attr({
        class: 'abc dce dhg dsd'
      });
    } else {
      $('.form-login').removeClass('abc dce dhg dsd');
    }
  });
});

$(document).on('click', '.scroll-to-top', function() {
  console.log(1);
  $('html, body').animate({
    scrollTop: 0
  }, 'slow');
});

$(document).on('click', '#scroll', function() {
  $('html, body').animate({
    scrollTop: $('#test').css('top')
  }, 800, function() {
    $('html, body').animate({
      scrollTop: 0
    }, 'slow');
  })
});

function handleLogin() {
  $('#loginFr').submit(function(e) {
    e.preventDefault();
    checkLogin();
  });
}

function checkLogin() {
  $.ajax({
    url: './emp.json',
    type: 'GET',
    dataType: 'json',
    beforeSend: function () {
      console.log('dang xu ly du lieu');
    },
    success: function (res) {
      var _username = res.username;
      var _password = res.password;

      var inputUsername = $('#username').val();
      var inputPassword = $('#passuser').val();

      if (inputUsername === _username && inputPassword === _password) {
        $('#loginFr').hide();
        $('.content').text('login success');
      } else {
        alert('duw lieu nhap vao khong dung');
        $('#loginFr')[0].reset();
      }
    },
    complete: function() {
      console.log('ban da login thanh cong');
    }
  })
}