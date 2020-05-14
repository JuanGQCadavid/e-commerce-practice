package com.ecommercepractice.carservice.repository;

import com.ecommercepractice.carservice.model.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {

    Optional<Cart> findByIdUser(String idUser);

    @Query("SELECT c FROM Cart c WHERE c.idUser = ?1 AND c.isActive = true")
    Optional<Cart> findActiveCartByIdUser(Long idUser);

    @Query("SELECT c FROM Cart c WHERE c.idCart = ?1 AND c.isActive = true")
    Optional<Cart> findActiveCartByIdCart(Integer idCart);

    @Query("SELECT c FROM Cart c")
    List<Cart> findAll();

}
