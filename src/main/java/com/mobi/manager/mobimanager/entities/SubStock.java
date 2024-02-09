package com.mobi.manager.mobimanager.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sub_stock")
@Data
public class SubStock extends BaseEntity{

    @Column(name = "customer_id", nullable = false)
    private Long customer_id;

    @Column(name = "cost_price", nullable = false, length = 10)
    private Double costPrice;

    @ManyToOne(optional = false)
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;
}
