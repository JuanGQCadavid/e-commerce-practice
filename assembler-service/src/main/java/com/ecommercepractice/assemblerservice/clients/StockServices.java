package com.ecommercepractice.assemblerservice.clients;

import com.ecommercepractice.assemblerservice.models.stockModels.response.StockProduct;
import io.reactivex.Observable;
import org.springframework.hateoas.EntityModel;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface StockServices {
    final String ENDPOINT_PREFIX = "stock/products";

    @GET(ENDPOINT_PREFIX + "/filter")
    Observable<List<EntityModel<StockProduct>>> filterProducts(@Query("price") Float price,
                                                                              @Query("stockQuantity") Long stockQuantity,
                                                                              @Query("soldQuantity") Long soldQuantity,
                                                                              @Query("onlyActive") Boolean onlyActive);

    @GET(ENDPOINT_PREFIX + "/filter")
    Observable<List<EntityModel<StockProduct>>> filterProducts();


}
