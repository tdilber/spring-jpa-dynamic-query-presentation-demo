package com.beyt.presentation.repository;

import com.beyt.presentation.model.entity.Student;
import com.beyt.jdq.repository.JpaDynamicQueryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, JpaDynamicQueryRepository<Student, Long> {
}
