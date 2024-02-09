package com.mobi.manager.mobimanager.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "model")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Model extends BaseEntity{
    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @Column(name = "price", nullable = false)
    @NotBlank
    private Double price;

}
