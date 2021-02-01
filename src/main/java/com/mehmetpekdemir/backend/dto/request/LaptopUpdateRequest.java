package com.mehmetpekdemir.backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class LaptopUpdateRequest {

    private Long id;

    private String barcode;

    private String itemName;

    private String brand;

    private BigDecimal price;

    private String description;

    private String operatingSystem;

    private String cpuManufacturer;

    private String graphicCard;

    private String memory;

    private String hardDisk;

    private String screenDisplaySize;

}
