package com.itstudent.repository;

import com.itstudent.entities.data.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{

    @Query("from Brand b where b.id = ?1 and b.deleted = false")
    Brand findByIdAndDeletedFalse(Integer id);

    Long countByNameContainsAndDeletedFalse(String name);

    List<Brand> findByIdInAndDeletedFalse(List<Integer> ids);

    @Query("update Brand b set b.deleted = true where b.id = ?1")
    @Transactional
    @Modifying
    long delete(Integer id);

}