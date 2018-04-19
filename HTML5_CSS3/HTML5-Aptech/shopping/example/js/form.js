// function render() {
//   var cars = ["BMW", "Volvo", "Saab", "Ford"];
//   var i = 0;
//   var text = "";
//   var abc = document.createElement('p');
//   for (; cars[i];) {
//     text = cars[i] + '<br>';
//     i++;
//     $(abc).append(text);
//   }

//   $('#addText').html(abc);
// }

// function renderA() {
//   var i = 0;
//   var abc = document.createElement('p');
//   do {
//     text = i + '<br>';
//     i++;
//     console.log($(abc));
//     $(abc).append(text);
//   } while (i < 10);
//   console.log($('#addText'))
//   $('#addText').html(abc);
// }

// var sdc_text = document.getElementById('addText');

// function showEmailPass() {
//   // var username = document.getElementById('username');
//   // var password = document.getElementById('password');

//   // username.value = null;
//   // password.value = null;

//   // console.log(username.value, password.value);

//   // var tenchido = document.getElementsByClassName('item');

//   // for(var i = (tenchido.length -1); i >=0; i--) {
//   //   console.log(tenchido[i].textContent);
//   //   $('#addText')
//   //   document.getElementById('addText').innerHTML += tenchido[i].textContent;
//   // }

//   // var i = tenchido.length;
//   // do {
//   //   console.log(tenchido[i].textContent);
//   //   i--;
//   // } while( i > 0)

//   var dtype = new Date().getDay();
//   switch (dtype) {
//     case 0:
//       console.log('chu nhat');
//       break;

//     case 1:
//       console.log('thu 2');
//       break;

//     case 2:
//       console.log('thu 3');
//       break;

//     default:
//       console.log('khong biet');
//   }
// }

$("#loginForm").submit(function (e) {
  e.preventDefault();

  $.ajax({
    url: '/json/emp.json',
    type: 'GET',
    dataType: 'json',
    beforeSend: function () {
      $('#btnLogin').attr('disabled', true);
    },
    success: function (res) {
      var _username = res.username;
      var _password = res.password;

      var inputUsername = $('#username').val();
      var inputPassword = $('#passuser').val();

      if (inputUsername === _username && inputPassword === _password) {
        $('.alert').text('Login Success').show();
        setTimeout(function() {
          window.location.href = '/home.html'
        }, 2000);
      } else {
        alert('duw lieu nhap vao khong dung');
        // $('#loginFr')[0].reset();
      }
    },
    error: function () {

    },
    complete: function() {
      console.log('ban da login thanh cong');
      $('#btnLogin').attr('disabled', false);
    }
  })
  // var _default = {
  //   email: 'abc@gmail.com',
  //   pass: '123456'
  // };

  // var inputEmail = $('.username').val();
  // var inputPass = $('.password').val();

  // if (inputEmail === _default.email && inputPass === _default.pass) {
  //   window.location.href = '/home.html'
  // } else {
  //   alert('failed');
  // }
});