/// <reference path="../typings/globals/jquery/index.d.ts" />
let cart_arr = [];

$(document).on('click', '.add-cart', function () {
    console.log($(this).data());
    var product = $(this).data();
    if (product.quantity > 0) {
        checkcart(product);
    } else {
        alert("Unavaible Out of Stock");
    }
    if(cart_arr.length){
        showTotal();
    }

    localStorage.setItem("payment",JSON.stringify(cart_arr));
});

$(document).on('click','.cart-button',function () {
   renderCartList(); 
});

function checkcart(product) {
    if (cart_arr.length > 0) {

        var _prd_tmp = cart_arr.find(item => item.key === product.key);
        if (_prd_tmp && _prd_tmp.key) {
            // var idx = cart_arr.indexOf(_prd_tmp); // _prd_tmp == cart_arr[idx]
            if (_prd_tmp.quantity >= product.quantity) {
                alert("Out of stock");
            } else {
                _prd_tmp.quantity += 1;
            }
            return;
        }
    }
    initCart(product);


}

function initCart(product) {
    cart_arr.push({
        key: product.key,
        name: product.name,
        price: product.price,
        avatar: product.avatar,
        quantity: 1,

    })
}

function showTotal() {
    var _total = 0;
    cart_arr.forEach(item => {
        _total += item.quantity;
    });
    $('.cart-count').text(_total);
}

// function renderCartList() { 
//     var _cartList = $('.cart-list');
//     cart_arr.forEach(item =>{
//         var _cartItem=$('<div>');
//         var _img = $('<img>');
//         _img.attr({
//             src:item.avatar,
//         })
//         _cartItem.append(_img);
//         _cartList.append(_cartItem);
//     });

// }


function renderCartList () {
   
    var _cartList = $('.cart-list');
    _cartList.empty();
    if (_cartList.is(":visible")) {
      _cartList.hide();
    } else {
      _cartList.show();
    }
    
      cart_arr.forEach(item => {
        var _cartItem = $('<div>');
        _cartItem.addClass('cart-item');
    
        var _img = $('<img>');
        _img.attr({
          src: item.avatar,
          width: '50px'
        });
    
        var _name = $('<span>');
        _name.addClass('cart-item_name');
        _name.text(item.name);
    
        var _price = $('<span>');
        _price.addClass('cart-item_price');
        _price.text(item.price);
    
        _cartItem.append(_img);
        _cartItem.append(_name);
        _cartItem.append(_price);
        _cartList.append(_cartItem);
      });
    
  }