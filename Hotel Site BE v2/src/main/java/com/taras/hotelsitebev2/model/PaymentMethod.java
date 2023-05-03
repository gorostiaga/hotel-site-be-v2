package com.taras.hotelsitebev2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment_methods")
public class PaymentMethod extends BaseEntity {

    @Enumerated(value = EnumType.STRING)
    private PaymentType paymentType;

    @OneToMany(mappedBy = "paymentMethod")
    @JsonIgnore
    private Set<Booking> bookings = new HashSet<>();
}
