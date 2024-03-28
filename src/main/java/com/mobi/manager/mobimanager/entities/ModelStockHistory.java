package com.mobi.manager.mobimanager.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "modelstockhistory")
@Data
public class ModelStockHistory extends BaseEntity {

    @Column(name = "quantity", nullable = false, length = 10)
    private Integer quantity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "modelId", nullable = false)
    private Model model;
}
