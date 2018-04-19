

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
        $('#btnLogin').attr('disabled',true);
      },
      success: function (res) {
        var _username = res.username;
        var _password = res.password;
  
        var inputUsername = $('#username').val();
        var inputPassword = $('#passuser').val();
  
        if (inputUsername === _username && inputPassword === _password) {
          
          window.location.href="./home.html";
        } else {
          alert('du lieu nhap vao khong dung');
          $('#loginFr')[0].reset();
        }
      },
      error : function(){
        
      },
      complete: function() {
        $('#btnLogin').attr('disabled',false);
      }

    })
  }