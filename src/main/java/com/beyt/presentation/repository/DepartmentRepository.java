package com.beyt.presentation.repository;

import com.beyt.presentation.model.entity.Address;
import com.beyt.presentation.model.entity.Department;
import com.beyt.jdq.repository.JpaDynamicQueryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>, JpaDynamicQueryRepository<Department, Long> {
}
