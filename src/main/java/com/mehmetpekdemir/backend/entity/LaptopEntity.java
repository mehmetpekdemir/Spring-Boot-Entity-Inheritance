package com.mehmetpekdemir.backend.entity;

import com.mehmetpekdemir.backend.common.entity.BaseItem;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "laptop")
public class LaptopEntity extends BaseItem {

    @Column(name = "operating_system", nullable = false, length = 100)
    private String operatingSystem;

    @Column(name = "cpu_manufacturer", nullable = false, length = 50)
    private String cpuManufacturer;

    @Column(name = "graphic_card", nullable = false, length = 50)
    private String graphicCard;

    @Column(name = "memory", nullable = false, length = 50)
    private String memory;

    @Column(name = "hard_disk", nullable = false, length = 50)
    private String hardDisk;

    @Column(name = "screen_display_size", nullable = false, length = 50)
    private String screenDisplaySize;

}
