package com.mehmetpekdemir.backend.repository;

import com.mehmetpekdemir.backend.entity.BaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@NoRepositoryBean
public interface BaseItemRepository extends JpaRepository<BaseItem, Long> {

}
