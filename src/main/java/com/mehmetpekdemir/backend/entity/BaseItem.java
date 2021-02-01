package com.mehmetpekdemir.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "base_item")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseItem extends AbstractBaseEntity {

    @Column(name = "barcode", nullable = false, length = 20, unique = true)
    private String barcode;

    @Column(name = "item_name", nullable = false, length = 100)
    private String itemName;

    @Column(name = "brand", nullable = false, length = 100)
    private String brand;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

}
