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
  handleLogin();
});

function handleLogin() {
  $('#loginFr').submit(function(e) {
    e.preventDefault();
    checkLogin();
  });
}

function checkLogin() {
  $.ajax({
    url: './json/emp.json',
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