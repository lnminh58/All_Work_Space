/// <reference path="../typings/globals/jquery/index.d.ts" />

var cart_list = localStorage.getItem('payment');
var cart_arr=JSON.parse(cart_list);
$(document).ready(function () {  
    // localStorage.clear();
    renderCartList();
})

function  renderCartList(){
     
    var _cartList = $('.cart-payment');
    _cartList.empty();
 
    
      cart_arr.forEach(item => {
          
        var _cartItem = $('<tr>');
        _cartItem.addClass('cart-item');
       
        var _img = $('<img>');
        _img.attr({
          src: item.avatar
        });
        _img.css({
            "max-width":"50px"
        })
        var _name = $('<td>');
        _name.addClass('cart-item_name');
        _name.text(item.name);
    
        var _price = $('<td>');
        _price.addClass('cart-item_price');
        _price.text(item.price);

        var _quantity = $('<input>');
        _quantity.attr({
            value:item.quantity,
        });

        _cartItem.append($("<td>").append(_img));
        _cartItem.append(_name);
        _cartItem.append(_price);
        _cartItem.append($("<td>").append(_quantity));
        _cartList.append( _cartItem);
      });
    

}