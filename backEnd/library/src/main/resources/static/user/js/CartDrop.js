
function UpdateCartMenu() {
    var url = "http://localhost:9098/cart-items/"+localStorage.getItem("userId");
    var total = 0; // Initialize total variable

    $.ajax({
        url: url,
        type: "GET",
        dataType: "json",
        success: function(data) {
            // Clear existing items in the cart menu
            $('#cart-items-list').empty();

            // Iterate through each item in the data array and append to cart menu
            for(var i = 0; i < data.length; i++) {
                var item = data[i];
                $('#cart-items-list').append(
                    `<li class="clearfix">
                            <div class="item-info">
                                <div class="name">
                                    <a href="#" class="item-name">${item.product.name}</a>
                                </div>
                                <div class="price">${item.quantity} X $${item.product.price.toFixed(2)}</div>
                            </div>
                            <a class="remove" data-item-id="${item.id}" href="#"><i class="fa fa-trash-o"></i></a>
                        </li>`
                    );
                total += item.quantity * item.product.price; // Calculate total
            }
            $('#cart-subtotal').text(total.toFixed(2)); // Update cart subtotal
            $('#numItemOfCart').text(data.length); // Update number of items in cart
        },
        error: function() {
            console.log("Error");
        }
    });
}

UpdateCartMenu();