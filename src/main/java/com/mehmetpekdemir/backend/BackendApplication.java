package com.mehmetpekdemir.backend;

import com.mehmetpekdemir.backend.entity.LaptopEntity;
import com.mehmetpekdemir.backend.repository.LaptopRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.math.BigDecimal;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@EnableJpaAuditing
@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    CommandLineRunner createInitialData(LaptopRepository laptopRepository) {
        return (args) -> {
            LaptopEntity laptop = new LaptopEntity();

            laptop.setBarcode("L1234");
            laptop.setItemName("Laptop");
            laptop.setBrand("Macbook Pro");
            laptop.setPrice(BigDecimal.valueOf(1200));
            laptop.setDescription("Test Description");

            laptop.setOperatingSystem("Mac OS");
            laptop.setCpuManufacturer("intel i7 7700hq");
            laptop.setGraphicCard("4GB Nvidia 1050 ti");
            laptop.setMemory("16GB");
            laptop.setHardDisk("1TB SSD");
            laptop.setScreenDisplaySize("15.9 inches");

            laptopRepository.save(laptop);
        };

    }

}
