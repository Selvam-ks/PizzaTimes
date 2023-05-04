package com.order.PizzaService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Address {
    private String door_no;
    private String Street;
    private String city;
    private String State;
    private long zipcode;
}
