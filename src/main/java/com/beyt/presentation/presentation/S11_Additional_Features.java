package com.beyt.presentation.presentation;

import com.beyt.jdq.dto.Criteria;
import com.beyt.jdq.dto.CriteriaList;
import com.beyt.jdq.dto.DynamicQuery;
import com.beyt.jdq.dto.enums.CriteriaOperator;
import com.beyt.presentation.annotation.PresentationMethod;
import com.beyt.presentation.annotation.PresentationService;
import com.beyt.presentation.repository.CourseRepository;
import com.beyt.presentation.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

@PresentationService
public class S11_Additional_Features {
    private @Autowired CourseRepository courseRepository;


    @PresentationMethod
    public void consumePartially() {
        courseRepository.consumePartially((courseList) -> {
            courseList.forEach(course -> {
                System.out.println(course.getName());
            });
            System.out.println("Consumed partially");
        }, 2);
    }

    @PresentationMethod
    public void consumePartially2() {
        CriteriaList criteriaList = CriteriaList.of(Criteria.of("id", CriteriaOperator.GREATER_THAN, 5));
        courseRepository.consumePartially(criteriaList, (courseList) -> {
            courseList.forEach(course -> {
                System.out.println(course.getName());
            });
            System.out.println("Consumed partially");
        }, 2);
    }
}
