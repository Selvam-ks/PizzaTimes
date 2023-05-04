package com.order.PizzaService.service;

import com.order.PizzaService.domain.OrderList;
import com.order.PizzaService.domain.Product;
import com.order.PizzaService.domain.UserInfo;
import com.order.PizzaService.exception.ProductAlreadyPresentPs;
import com.order.PizzaService.exception.UserAlreadyExistsPs;
import com.order.PizzaService.proxy.UserProxy;
import com.order.PizzaService.repository.ProductRepos;
import com.order.PizzaService.repository.UserRepos;
import com.order.PizzaService.exception.UserNotFoundPs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepos userRepos;

    @Autowired
    private ProductRepos productRepos;

    @Autowired
    private UserProxy proxy;
    @Override
    public UserInfo saveNewUser(UserInfo userInfo) throws UserAlreadyExistsPs {
        if(userRepos.findById(userInfo.getEmail()).isPresent()){
            throw new UserAlreadyExistsPs();
        }
        UserInfo addUser = userRepos.save(userInfo);
        if(!(addUser.getEmail().isEmpty())){
            ResponseEntity<?> re = proxy.userRegistration(addUser);
        }
        return addUser;
    }

    @Override
    public boolean deleteProduct(String email, String product_name) throws UserNotFoundPs{
        if(userRepos.findById(email).isEmpty()){
            throw new UserNotFoundPs();
        }
        UserInfo  userInfo = userRepos.findById(email).get();
        List<Product> products = userInfo.getProductList();
        boolean value = products.removeIf(obj -> obj.getName().equals(product_name));
        userInfo.setProductList(products);
        userRepos.save(userInfo);
        return value;
    }

    @Override
    public boolean conformOrder(String email) {
        UserInfo userInfo = userRepos.findById(email).get();
//        if(userInfo.getOrderList()==null){
//
//        }
//        List<OrderList> orderList = userInfo.getOrderList();
//        orderList.add((OrderList) userInfo.getProductList());
//        userInfo.setOrderList(orderList);
        userInfo.setProductList(new ArrayList<Product>());
        userRepos.save(userInfo);
        return true;
    }

    @Override
    public UserInfo addProductToUser(Product product, String email) throws UserNotFoundPs, ProductAlreadyPresentPs {
        if(userRepos.findById(email).isEmpty()){
            throw new UserNotFoundPs();
        }
        UserInfo userTemp = userRepos.findById(email).get();
        if(userTemp.getProductList() == null){
            userTemp.setProductList(Arrays.asList(product));
        }else{
            List<Product> products = userTemp.getProductList();
            for (Product obj: products) {
                if((obj.equals(product))){
                    throw new ProductAlreadyPresentPs();
                }
            }
            products.add(product);
            userTemp.setProductList(products);
        }
        return userRepos.save(userTemp);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepos.findAll();
    }

    @Override
    public UserInfo updateProduct(Product product, String email) throws UserNotFoundPs {
        if(userRepos.findById(email).isEmpty()){
            throw new UserNotFoundPs();
        }
        UserInfo userTemp = userRepos.findById(email).get();
        List<Product> productsTrmp = userTemp.getProductList();
        for (Product pr: productsTrmp) {
           if(pr.getName().equals(product.getName())) {
               pr.setQty(product.getQty());
           }
        }
        userTemp.setProductList(productsTrmp);
        userRepos.save(userTemp);
        return userRepos.save(userTemp);
    }

    @Override
    public List<Product> getAllProductsFromUser(String email) throws UserNotFoundPs {
        if(userRepos.findById(email).isEmpty()){
            throw new UserNotFoundPs();
        }
        return userRepos.findById(email).get().getProductList();
    }
}
