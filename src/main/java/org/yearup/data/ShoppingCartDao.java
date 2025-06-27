package org.yearup.data;

import org.yearup.models.Category;
import org.yearup.models.ShoppingCart;

public interface ShoppingCartDao {
    ShoppingCart getByUserId(int userId);

    ShoppingCart addtoShoppingCart(ShoppingCart shoppingCart, int productId);

    void changeQuantity(int productId, ShoppingCart shoppingCart, int quantity);

    void clearCart(ShoppingCart shoppingCart);
}
