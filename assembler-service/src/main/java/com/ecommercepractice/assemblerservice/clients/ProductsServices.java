package com.ecommercepractice.assemblerservice.clients;

import com.ecommercepractice.assemblerservice.models.productModels.response.Product;
import io.reactivex.Observable;
import org.springframework.hateoas.EntityModel;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface ProductsServices {
    final String ENDPOINT_PREFIX = "products";

    @GET(ENDPOINT_PREFIX + "/{productId}")
    Observable<EntityModel<Product>> fetchProductById(@Path("productId") Long productId);

}
