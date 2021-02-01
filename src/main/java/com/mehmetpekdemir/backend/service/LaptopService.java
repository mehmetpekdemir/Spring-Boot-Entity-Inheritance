package com.mehmetpekdemir.backend.service;

import com.mehmetpekdemir.backend.common.generic.service.GenericService;
import com.mehmetpekdemir.backend.dto.request.LaptopCreateRequest;
import com.mehmetpekdemir.backend.dto.request.LaptopUpdateRequest;
import com.mehmetpekdemir.backend.dto.response.LaptopResponse;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface LaptopService extends GenericService<LaptopResponse, LaptopCreateRequest, LaptopUpdateRequest> {

}
