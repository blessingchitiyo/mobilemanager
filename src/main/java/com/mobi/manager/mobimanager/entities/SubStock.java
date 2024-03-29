package com.mobi.manager.mobimanager.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sub_stock")
@Data
public class SubStock extends BaseEntity {

    @Column(name = "costPrice", nullable = false, length = 10)
    private Double costPrice;

    @Column(name = "quantity", nullable = false, length = 10)
    private Integer quantity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "modelId", nullable = false)
    private Model model;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;
}
