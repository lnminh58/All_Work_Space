
/* $(document).on('click','#readJson',function(){
    $.ajax({
        url: 'emp.json',
        
        type:'GET',
        dataType: 'json',
        success:function(res){
            $('#readJson').hide();
            $('.islogin').text(res.message.success).show();
        },
        errors: function(error){
            console.log(error,'errors')
        }
    })
}); */

$(document).ready(function(){
    handlelogin();
  
});

function handlelogin(){
  
    $('#loginFr').submit(function(e) {
        e.preventDefault();
        console.log(e);
        checkLogin();
    });
}

function checkLogin(param){
    $.ajax({
        url: 'emp.json',
        type:'GET',
        dataType: 'json',
        beforeSend:function(){
            console.log('Dang xu ly du lieu')
        },
        success:function(res){
            var _username=res.account.email;
            var _password=res.account.pass;

            var inputUsername = $('.username').val();
            var inputPassword = $('.password').val();
            if(inputUsername===_username&&inputPassword===_password){
                $('.loginFR').hide();
                $('.content').text("login success");
            }
            else{
                alert("username hoac password bi sai");
                
            }
            
        },
        complete : function(){
            console.log("login thanh cong");
        },

        errors: function(error){
            console.log(error,'errors');
        }
    })
}
   