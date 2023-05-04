package com.order.PizzaService.service;

import com.order.PizzaService.domain.Product;
import com.order.PizzaService.exception.ProductAlreadyPresentPs;
import com.order.PizzaService.exception.ProductNotFoundPs;
import com.order.PizzaService.repository.ProductRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepos repos;

    @Override
    public Product AddProduct(Product product) throws ProductAlreadyPresentPs {
       if(repos.findById(product.getName()).isPresent()){
           throw new ProductAlreadyPresentPs();
       }
        return repos.save(product);
    }

    @Override
    public boolean deleteProduct(String product_name) throws ProductNotFoundPs {
        if(!repos.findById(product_name).isPresent()){
            System.out.println("in error");
            throw new ProductNotFoundPs();
        }
        System.out.println("beffore return");
        repos.deleteById(product_name);
        return true;
    }

    @Override
    public Product getA_Product(String product_name) {
        return repos.findById(product_name).get();
    }

    @Override
    public Product updateProduct(Product product) throws ProductNotFoundPs {
        if(repos.findById(product.getName()).isEmpty()){
            throw new ProductNotFoundPs();
        }
        Product productTemp = repos.findById(product.getName()).get();
        if(product.getType_vg()!=null){
           productTemp.setType_vg(product.getType_vg());
        }
        if(product.getDescription()!=null){
            productTemp.setDescription(product.getDescription());
        }
        if(product.getSize()!=null) {
            productTemp.setSize(product.getSize());
        }
        if(product.getPrice()!=0 && product.getPrice()>0){
            productTemp.setPrice(product.getPrice());
        }
        if(product.getCrust()!=null){
            productTemp.setCrust(product.getCrust());
        }
        if(product.getImageurl()!=null){
            productTemp.setImageurl(product.getImageurl());
        }
        return repos.save(productTemp);
    }
}
