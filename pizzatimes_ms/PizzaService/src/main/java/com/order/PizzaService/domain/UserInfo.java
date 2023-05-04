package com.order.PizzaService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserInfo {

    @Id
    private String email;
    private String password;
    private String username;
    private Address address;
    private List<Product> productList;
    private List<OrderList> orderList;
}
