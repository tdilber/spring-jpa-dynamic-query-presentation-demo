package com.beyt.presentation.repository;

import com.beyt.presentation.model.entity.Address;
import com.beyt.presentation.model.entity.Course;
import com.beyt.jdq.repository.JpaDynamicQueryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>, JpaDynamicQueryRepository<Course, Long> {
}
