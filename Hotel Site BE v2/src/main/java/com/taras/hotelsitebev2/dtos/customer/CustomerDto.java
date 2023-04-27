package com.taras.hotelsitebev2.dtos.customer;

import com.taras.hotelsitebev2.dtos.DtoInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto implements DtoInterface, Serializable {

    private String idCustomer;
    private String firstName;
    private String lastName;
    private String email;
    private Integer phone;
    private String originCity;
}
