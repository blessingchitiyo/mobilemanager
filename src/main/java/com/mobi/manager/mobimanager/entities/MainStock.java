package com.mobi.manager.mobimanager.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "main_stock")
@Data
public class MainStock extends BaseEntity{

    @Column(name = "quantity", nullable = false, length = 10)
    private String quantity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;
}
