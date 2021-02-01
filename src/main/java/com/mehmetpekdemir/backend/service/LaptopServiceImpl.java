package com.mehmetpekdemir.backend.service;

import com.mehmetpekdemir.backend.dto.request.LaptopCreateRequest;
import com.mehmetpekdemir.backend.dto.request.LaptopUpdateRequest;
import com.mehmetpekdemir.backend.dto.response.LaptopResponse;
import com.mehmetpekdemir.backend.entity.LaptopEntity;
import com.mehmetpekdemir.backend.exception.NotFoundException;
import com.mehmetpekdemir.backend.repository.LaptopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class LaptopServiceImpl implements LaptopService {

    private final LaptopRepository laptopRepository;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public LaptopResponse findById(Long id) {
        return toResponse(findLaptopById(id));
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<LaptopResponse> findAll() {
        return laptopRepository.findAll()
                .stream()
                .map(laptop -> toResponse((LaptopEntity) laptop))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<LaptopResponse> findPaginated(Pageable pageable) {
        return laptopRepository.findAll(pageable)
                .stream()
                .map(laptop -> toResponse((LaptopEntity) laptop))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public LaptopResponse create(LaptopCreateRequest laptopCreateRequest) {
        return toResponse(laptopRepository.save(toEntity(laptopCreateRequest)));
    }

    @Override
    @Transactional
    public LaptopResponse update(LaptopUpdateRequest laptopUpdateRequest) {
        final var laptopEntity = findLaptopById(laptopUpdateRequest.getId());

        fillData(laptopEntity, laptopUpdateRequest.getBarcode(), laptopUpdateRequest.getItemName(),
                laptopUpdateRequest.getBrand(), laptopUpdateRequest.getPrice(), laptopUpdateRequest.getDescription(),
                laptopUpdateRequest.getOperatingSystem(), laptopUpdateRequest.getCpuManufacturer(),
                laptopUpdateRequest.getGraphicCard(), laptopUpdateRequest.getMemory(),
                laptopUpdateRequest.getHardDisk(), laptopUpdateRequest.getScreenDisplaySize());

        return toResponse(laptopRepository.save(laptopEntity));
    }


    @Override
    @Transactional
    public void deleteById(Long id) {
        final var laptopEntity = findLaptopById(id);
        laptopRepository.deleteById(laptopEntity.getId());
    }

    private LaptopEntity findLaptopById(Long id) {
        return (LaptopEntity) laptopRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Laptop Not Found !"));
    }

    private void fillData(LaptopEntity laptopEntity, String barcode, String itemName, String brand,
                          BigDecimal price, String description, String operatingSystem, String cpuManufacturer,
                          String graphicCard, String memory, String hardDisk, String screenDisplaySize) {

        laptopEntity.setBarcode(barcode);
        laptopEntity.setItemName(itemName);
        laptopEntity.setBrand(brand);
        laptopEntity.setPrice(price);
        laptopEntity.setDescription(description);

        laptopEntity.setOperatingSystem(operatingSystem);
        laptopEntity.setCpuManufacturer(cpuManufacturer);
        laptopEntity.setGraphicCard(graphicCard);
        laptopEntity.setMemory(memory);
        laptopEntity.setHardDisk(hardDisk);
        laptopEntity.setScreenDisplaySize(screenDisplaySize);
    }

    private LaptopEntity toEntity(LaptopCreateRequest laptopCreateRequest) {
        final LaptopEntity laptopEntity = new LaptopEntity();
        fillData(laptopEntity, laptopCreateRequest.getBarcode(), laptopCreateRequest.getItemName(),
                laptopCreateRequest.getBrand(), laptopCreateRequest.getPrice(), laptopCreateRequest.getDescription(),
                laptopCreateRequest.getOperatingSystem(), laptopCreateRequest.getCpuManufacturer(),
                laptopCreateRequest.getGraphicCard(), laptopCreateRequest.getMemory(),
                laptopCreateRequest.getHardDisk(), laptopCreateRequest.getScreenDisplaySize());

        return laptopEntity;
    }

    private LaptopResponse toResponse(LaptopEntity laptopEntity) {
        return LaptopResponse.builder()
                .barcode(laptopEntity.getBarcode())
                .itemName(laptopEntity.getItemName())
                .brand(laptopEntity.getBrand())
                .price(laptopEntity.getPrice())
                .description(laptopEntity.getDescription())
                .operatingSystem(laptopEntity.getOperatingSystem())
                .cpuManufacturer(laptopEntity.getCpuManufacturer())
                .graphicCard(laptopEntity.getGraphicCard())
                .memory(laptopEntity.getMemory())
                .hardDisk(laptopEntity.getHardDisk())
                .screenDisplaySize(laptopEntity.getScreenDisplaySize())
                .build();
    }

}
