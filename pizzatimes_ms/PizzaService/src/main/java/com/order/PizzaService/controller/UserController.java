package com.order.PizzaService.controller;
import com.order.PizzaService.domain.OrderList;
import com.order.PizzaService.domain.Product;
import com.order.PizzaService.domain.UserInfo;
import com.order.PizzaService.exception.ProductAlreadyPresentPs;
import com.order.PizzaService.exception.UserAlreadyExistsPs;
import com.order.PizzaService.exception.UserNotFoundPs;
import com.order.PizzaService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("pizzaTimes/product/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("signUp")
    public ResponseEntity<?> saveNewUser(@RequestBody UserInfo user) throws UserAlreadyExistsPs {
        try {
            if(user.getProductList() == null){
                user.setProductList(new ArrayList<Product>());
            }if(user.getOrderList() == null){
                user.setOrderList(new ArrayList<OrderList>());
            }
            return new ResponseEntity<>(userService.saveNewUser(user), HttpStatus.CREATED);
        }catch (UserAlreadyExistsPs e){
            throw new UserAlreadyExistsPs();
        }
    }

    @PostMapping("user/addProduct")
    public ResponseEntity<?> saveProductToList(@RequestBody Product product, HttpServletRequest request) throws UserNotFoundPs, ProductAlreadyPresentPs {
        try {
            String object = (String) request.getAttribute("email");
            return new ResponseEntity<>(userService.addProductToUser(product,object),HttpStatus.OK);
        } catch ( UserNotFoundPs e) {
            throw new UserNotFoundPs();
        } catch (ProductAlreadyPresentPs e) {
            throw new ProductAlreadyPresentPs();
        }
    }

    @DeleteMapping("user/deleteProduct/{name}")
    public ResponseEntity<?> deleteProduct(@PathVariable String name,HttpServletRequest request) throws UserNotFoundPs {
        try {
            String tocken = request.getHeader("") ;
            String object = (String) request.getAttribute("email");
            return new ResponseEntity<>(userService.deleteProduct(object,name),HttpStatus.OK);
        }catch (UserNotFoundPs e){
            throw new UserNotFoundPs();
        }
    }
    @GetMapping("user/getAllProduct")
    private ResponseEntity<?> getAllProductForUser(HttpServletRequest request) throws UserNotFoundPs{
        try {
            String object = (String) request.getAttribute("email");
            System.out.println(object);
            return new ResponseEntity<>(userService.getAllProductsFromUser(object),HttpStatus.OK);
        }catch (UserNotFoundPs e){
            throw new UserNotFoundPs();
        }
    }
    @GetMapping("getAllProduct")
    private ResponseEntity<?> getAllProduct() throws UserNotFoundPs{
            return new ResponseEntity<>(userService.getAllProducts(),HttpStatus.OK);
    }

    @PutMapping("user/updateProduct")
    private ResponseEntity<?> updateProductList(@RequestBody Product product,HttpServletRequest request) throws UserNotFoundPs {
        try {
            String object = (String) request.getAttribute("email");
            return new ResponseEntity<>(userService.updateProduct(product,object),HttpStatus.OK);
        }catch (UserNotFoundPs e){
            throw new UserNotFoundPs();
        }
    }

    @DeleteMapping("user/conformOrder")
    private ResponseEntity<?> conformOrder( HttpServletRequest request){
        String object = (String) request.getAttribute("email");
        return new ResponseEntity<>(userService.conformOrder(object),HttpStatus.OK);
    }
}