package com.mehmetpekdemir.backend.controller;

import com.mehmetpekdemir.backend.common.generic.controller.GenericController;
import com.mehmetpekdemir.backend.dto.request.LaptopCreateRequest;
import com.mehmetpekdemir.backend.dto.request.LaptopUpdateRequest;
import com.mehmetpekdemir.backend.dto.response.LaptopResponse;
import com.mehmetpekdemir.backend.service.LaptopService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RestController
@RequestMapping("api/v1/laptop")
@RequiredArgsConstructor
public class LaptopController implements GenericController<LaptopResponse, LaptopCreateRequest, LaptopUpdateRequest> {

    private final LaptopService laptopService;

    @Override
    public ResponseEntity<LaptopResponse> findById(Long id) {
        final var laptop = laptopService.findById(id);
        return ResponseEntity.ok(laptop);
    }

    @Override
    public ResponseEntity<List<LaptopResponse>> findAll() {
        final var laptops = laptopService.findAll();
        return ResponseEntity.ok(laptops);
    }

    @Override
    public ResponseEntity<List<LaptopResponse>> findPaginated(Pageable pageable) {
        final var laptops = laptopService.findPaginated(pageable);
        return ResponseEntity.ok(laptops);
    }

    @Override
    public ResponseEntity<LaptopResponse> create(@Valid LaptopCreateRequest laptopCreateRequest) {
        final var laptop = laptopService.create(laptopCreateRequest);
        return ResponseEntity.ok(laptop);
    }

    @Override
    public ResponseEntity<LaptopResponse> update(@Valid LaptopUpdateRequest laptopUpdateRequest) {
        final var laptop = laptopService.update(laptopUpdateRequest);
        return ResponseEntity.ok(laptop);
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        laptopService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
