package org.yearup.data.mysql;

import org.yearup.data.ShoppingCartDao;
import org.yearup.models.ShoppingCart;

import javax.sql.DataSource;

public class MySqlShoppingCartDao extends MySqlDaoBase implements ShoppingCartDao {

    public MySqlShoppingCartDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public ShoppingCart getByUserId(int userId) {
        return null;
    }

    @Override
    public ShoppingCart addtoShoppingCart(ShoppingCart shoppingCart, int productId) {
        return null;
    }

    @Override
    public void changeQuantity(int productId, ShoppingCart shoppingCart, int quantity) {

    }


}
