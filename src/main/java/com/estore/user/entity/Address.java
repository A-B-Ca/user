package com.estore.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    private String unitNumber;
    private String streetName;
    private String city;
    private String postalCode;
  /*  @ManyToOne
    @JoinColumn(nullable = false)
    private User user;*/
}
