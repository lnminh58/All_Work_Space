let count_cart = 0; // tao 1 bien dem toan cuc
let cart_arr = [];

// key, avatar, name, price, quantity
$(document).on('click', '.add-cart', function () {
  var _prd = $(this).data();

  if ( _prd.quantity > 0) {
    checkCart(_prd);
  } else {
    alert('san pham khong co san trong kho');
  }

  if (cart_arr.length) {
    showTotal(_prd);
  }

  console.log(cart_arr);
});

$(document).on('click', '.cart', function () {
  renderCartList();
});

function checkCart (product) {
  if (cart_arr.length > 0) {
    var _prd_tmp = cart_arr.find(item => item.key === product.key);

    if ( _prd_tmp && _prd_tmp.key) {
      if (_prd_tmp.quantity >= product.quantity) {
        alert('san pham khong duoc add');
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
    avatar: product.avatar,
    price: product.price,
    quantity: 1
  });
}

function showTotal(product) {
  var _total = 0;

  cart_arr.forEach(item => {
    _total += item.quantity;
  });

  $('.cart-count').text(_total).show();
  $('.cart .fas').removeClass('fa-shopping-cart').addClass('fa-cart-plus');
}

function renderCartList () {
  var _cartList = $('.cart-list');

  if (_cartList.is(":visible")) {
    _cartList.hide();
  } else {
    _cartList.show();
  }

  if (_cartList.children().length === 0) {
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
}