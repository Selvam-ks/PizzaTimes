package com.order.PizzaService.controller;

import com.order.PizzaService.domain.Product;
import com.order.PizzaService.exception.ProductAlreadyPresentPs;
import com.order.PizzaService.exception.ProductNotFoundPs;
import com.order.PizzaService.exception.UnAuthToAccess;
import com.order.PizzaService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
//@CrossOrigin
@RequestMapping("pizzaTimes/product/")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("admin/addProduct")
    public ResponseEntity<?> saveProductToList(@RequestBody Product product, HttpServletRequest request) throws ProductAlreadyPresentPs, UnAuthToAccess {

        try {
            String object = (String) request.getAttribute("role");
            String email = (String) request.getAttribute("email");
//            return new ResponseEntity<>(productService.AddProduct(product),HttpStatus.OK);
            if(object.equals("admin")){
                return new ResponseEntity<>(productService.AddProduct(product),HttpStatus.OK);
            }else
                throw new UnAuthToAccess();
        } catch (ProductAlreadyPresentPs e) {
            throw new ProductAlreadyPresentPs();
            }
        catch (UnAuthToAccess e) {
            throw new UnAuthToAccess();
        }
    }

    @GetMapping("admin/getProduct/{product_name}")
    public ResponseEntity<?> getOneProduct(@PathVariable String product_name,HttpServletRequest request){
        String object = (String) request.getAttribute("role");
        String email = (String) request.getAttribute("email");
        return new ResponseEntity<>(productService.getA_Product(product_name),HttpStatus.OK);
    }

    @PutMapping("admin/update")
    public ResponseEntity<?> updateProduct(@RequestBody Product product,HttpServletRequest request) throws UnAuthToAccess, ProductNotFoundPs {
        try {
            String object = (String) request.getAttribute("role");
            if(object.equals("admin")){
                return new ResponseEntity<>(productService.updateProduct(product),HttpStatus.OK);
            }else
                throw new UnAuthToAccess();
        }catch (UnAuthToAccess e) {
            throw new UnAuthToAccess();
        }catch (ProductNotFoundPs e){
            throw new ProductNotFoundPs();
        }
    }

    @DeleteMapping("admin/delete/{name}")
    public ResponseEntity<?> deleteProduct(@PathVariable String name,HttpServletRequest request)throws UnAuthToAccess, ProductNotFoundPs{
        try {
            System.out.println(name);
            String object = (String) request.getAttribute("role");
            if(object.equals("admin")){
                System.out.println("in the process");
                return new ResponseEntity<>(productService.deleteProduct(name),HttpStatus.OK);
            }else
                throw new UnAuthToAccess();
        }catch (UnAuthToAccess e) {
            throw new UnAuthToAccess();
        }catch (ProductNotFoundPs e){
            throw new ProductNotFoundPs();
        }
    }
}
