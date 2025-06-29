//package org.yearup.controllers;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;
//import org.yearup.data.ProductDao;
//import org.yearup.data.ShoppingCartDao;
//import org.yearup.data.UserDao;
//import org.yearup.models.ShoppingCart;
//import org.yearup.models.User;
//
//import java.security.Principal;
//@CrossOrigin
//@RestController
//// convert this class to a REST controller
//// only logged in users should have access to these actions
//public class ShoppingCartController
//{
//    // a shopping cart requires
//    private ShoppingCartDao shoppingCartDao;
//    private UserDao userDao;
//    private ProductDao productDao;
//
//
//
//    // each method in this controller requires a Principal object as a parameter
//    @GetMapping("/cart")
//    @PreAuthorize("isAuthenticated()")
//    public ShoppingCart getCart(Principal principal)
//    {
//        try
//        {
//            // get the currently logged in username
//            String userName = principal.getName();
//            // find database user by userId
//            User user = userDao.getByUserName(userName);
//            int userId = user.getId();
//
//            // use the shoppingcartDao to get all items in the cart and return the cart
//            return shoppingCartDao.getByUserId(userId);
//        }
//        catch(Exception e)
//        {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
//        }
//    }
//
//    // add a POST method to add a product to the cart - the url should be
//    // https://localhost:8080/cart/products/15 (15 is the productId to be added
//    @PostMapping("/cart/products/{productId}")
//    @PreAuthorize("isAuthenticated()")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ShoppingCart addToCart(@PathVariable int productId, Principal principal)
//    {
//        try
//        {
//            String userName = principal.getName();
//            User user = userDao.getByUserName(userName);
//            int userId = user.getId();
//
//            ShoppingCart cart = shoppingCartDao.getByUserId(userId);
//
//            return shoppingCartDao.addtoShoppingCart(cart, productId);
//        }
//        catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to add to cart.");
//        }
//    }
//
//    // add a PUT method to update an existing product in the cart - the url should be
//    // https://localhost:8080/cart/products/15 (15 is the productId to be updated)
//    // the BODY should be a ShoppingCartItem - quantity is the only value that will be updated
//    @PutMapping("/cart/products/{productId}")
//    @PreAuthorize("isAuthenticated()")
//    public void updateCartItem(@PathVariable int productId, @RequestBody Map<String, Integer> body, Principal principal)
//    {
//        try
//        {
//            int quantity = body.get;
//            String userName = principal.getName();
//            User user = userDao.getByUserName(userName);
//            int userId = user.getId();
//
//            ShoppingCart cart = shoppingCartDao.getByUserId(userId);
//
//            shoppingCartDao.changeQuantity(productId, cart, quantity);
//        }
//        catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update cart.");
//        }
//    }
//
//    // add a DELETE method to clear all products from the current users cart
//    // https://localhost:8080/cart
//    @DeleteMapping("/cart")
//    @PreAuthorize("isAuthenticated()")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void clearCart(Principal principal)
//    {
//        try
//        {
//            String userName = principal.getName();
//            User user = userDao.getByUserName(userName);
//            int userId = user.getId();
//
//            ShoppingCart cart = shoppingCartDao.getByUserId(userId);
//
//            shoppingCartDao.clearCart(cart);
//        }
//        catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to clear cart.");
//        }
//    }
//}
