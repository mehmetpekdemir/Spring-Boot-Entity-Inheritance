package com.mehmetpekdemir.backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class LaptopCreateRequest {

    @NotBlank
    @Size(min = 4, max = 20)
    private String barcode;

    @NotBlank
    @Size(min = 4, max = 100)
    private String itemName;

    @NotBlank
    @Size(min = 4, max = 100)
    private String brand;

    @NotNull
    private BigDecimal price;

    @NotBlank
    @Size(min = 10, max = 400)
    private String description;

    @NotBlank
    @Size(min = 4, max = 100)
    private String operatingSystem;

    @NotBlank
    @Size(min = 4, max = 50)
    private String cpuManufacturer;

    @NotBlank
    @Size(min = 4, max = 50)
    private String graphicCard;

    @NotBlank
    @Size(min = 4, max = 50)
    private String memory;

    @NotBlank
    @Size(min = 4, max = 50)
    private String hardDisk;

    @NotBlank
    @Size(min = 4, max = 50)
    private String screenDisplaySize;

}
