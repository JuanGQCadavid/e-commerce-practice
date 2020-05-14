package com.ecommercepractice.carservice.service;

import com.ecommercepractice.carservice.exception.CartNotActiveException;
import com.ecommercepractice.carservice.exception.CartNotFoundedException;
import com.ecommercepractice.carservice.exception.NotProductListAttachedToCartException;
import com.ecommercepractice.carservice.model.Cart;
import com.ecommercepractice.carservice.model.CartWithProductsList;
import com.ecommercepractice.carservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductListService productListService;

    /**
     * Creates a new cart and attached it to a
     * user.
     * @param idUser
     * @return
     */
    public Cart createCart(Long idUser){
        Cart cart = new Cart();

        cart.setIdUser(idUser);
        cart.setIsActive(true);
        cart.setIsSaved(false);

        return cartRepository.save(cart);

    }

    /**
     * If there is an active cart associated to a user then it should
     * be returned, if not a new cart should be created.
     * @param idUser
     * @return
     */
    public CartWithProductsList fetchActiveCart(Long idUser){
        Cart actualCart = cartRepository.findActiveCartByIdUser(idUser).orElseGet(() -> createCart(idUser));

        return actualCart.getIdProductList() == null ? new CartWithProductsList().setCart(actualCart)
                : new CartWithProductsList().setCart(actualCart).setProductList(productListService.fetchById(actualCart.getIdProductList()));

    }

    /**
     * Makes a cart not active by toggling its isActive flag.
     * @param idCart
     */
    public void disableCart(Integer idCart, Boolean permanently){
        Cart cart =  cartRepository.findById(idCart).orElseThrow(() -> new CartNotFoundedException(idCart));
        if(permanently){
            cartRepository.delete(cart);
        }else{
            cart.setIsActive(false);
            cartRepository.save(cart);
        }
    }

    /**
     * Fetches a cart by its id.
     * @param idCart
     * @return
     */
    public CartWithProductsList fetchByIdCart(Integer idCart){
        Cart cart = cartRepository.findById(idCart).orElseThrow(()-> new CartNotFoundedException(idCart));

        return cart.getIdProductList() == null ? new CartWithProductsList().setCart(cart)
                : new CartWithProductsList().setCart(cart).setProductList(productListService.fetchById(cart.getIdProductList()));

    }

    /**
     * Internal method used to fetch an active cart, if not it should
     * throw a CartNotActiveException
     * @param idCart
     * @return
     */
    public Cart getCart(Integer idCart){
        Cart cart =  cartRepository.findById(idCart).orElseThrow(() -> new CartNotFoundedException(idCart));
        if(cart.getIsActive() != true){ throw new CartNotActiveException(idCart); }
        return cart;
    }

    /**
     * Internal method used to fetch the cart id products, if not it should
     * throw a NotProductListAttachedToCartException
     * @param cart
     * @return
     */
    public Integer getIdProductList(Cart cart){
     return Optional.ofNullable(cart.getIdProductList())
             .orElseThrow(() -> new NotProductListAttachedToCartException(cart.getIdCart()));
    }

    /**
     * Add a product inside a product list that belongs to a cart.
     * @param idCart
     * @param productId
     * @param quantity
     */
    public void appendProductToCart(Integer idCart, Integer productId, Integer quantity){
        Cart cart = getCart(idCart);

        if (cart.getIdProductList() == null){
            cart.setIdProductList(productListService.createAndAppend(productId, quantity));
            cartRepository.save(cart);
        }else{
            productListService.appendProduct(cart.getIdProductList(), productId, quantity);
        }

    }

    /**
     * Update a cart's product.
     * @param idCart
     * @param productId
     * @param quantity
     */
    public void updateProductToCart(Integer idCart, Integer productId, Integer quantity) {
        Cart cart = getCart(idCart);
        Integer idProductList = getIdProductList(cart);
        productListService.updateProduct(idProductList,productId,quantity);
    }

    /**
     * Remove a cart's product.
     * @param idCart
     * @param idProductStock
     */
    public void removeProduct(Integer idCart, Integer idProductStock) {
        Cart cart = getCart(idCart);
        productListService.removeProduct(getIdProductList(cart),idProductStock);

        if (productListService.checkQuantity(cart.getIdProductList()) == 0){
            cart.setIdProductList(null);
            cartRepository.save(cart);
        }

    }

    /**
     * Makes a cart saved by toggling its isSave flag true.
     * @param idCart
     */
    public void saveCart(Integer idCart) {
        Cart cart = getCart(idCart);
        cart.setIsSaved(true);
        cartRepository.save(cart);
    }
    /**
     * Makes a cart unsaved by toggling its isSave flag false.
     * @param idCart
     */
    public void removeSaveCart(Integer idCart) {
        Cart cart = getCart(idCart);
        cart.setIsSaved(false);
        cartRepository.save(cart);
    }

    /**
     * Fetch all carts and their products.
     * @return
     */
    public List<CartWithProductsList> getAll() {
        List<Cart> carts = cartRepository.findAll();
        List<CartWithProductsList> cartWithProductsLists = carts.stream()
                .map(car -> { return new CartWithProductsList(car, productListService.getAll(car.getIdProductList()));})
                .collect(Collectors.toList());

        return cartWithProductsLists;
    }
}
