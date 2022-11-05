package com.benyissa.orderservice.services;


import com.benyissa.orderservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductRestClient {

    //    get a product by id
    @GetMapping(path = "/products/{id}?projection=fullProduct")
    Product getProductById(@PathVariable Long id);

    //    get list of products
    @GetMapping(path = "/products?projection=fullProduct")
    PagedModel<Product> listProducts();
}
