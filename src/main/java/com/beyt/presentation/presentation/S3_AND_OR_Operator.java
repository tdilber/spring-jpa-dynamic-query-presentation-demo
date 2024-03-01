package com.beyt.presentation.presentation;

import com.beyt.jdq.dto.Criteria;
import com.beyt.jdq.dto.CriteriaList;
import com.beyt.jdq.dto.enums.CriteriaOperator;
import com.beyt.presentation.annotation.PresentationMethod;
import com.beyt.presentation.annotation.PresentationService;
import com.beyt.presentation.model.entity.Course;
import com.beyt.presentation.repository.CourseRepository;
import com.beyt.presentation.repository.DepartmentRepository;
import com.beyt.presentation.util.PresentationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
@PresentationService
public class S3_AND_OR_Operator {
    private @Autowired CourseRepository courseRepository;
    private @Autowired DepartmentRepository departmentRepository;


    @PresentationMethod
    public void and() {
        var criteriaList = CriteriaList.of(
                Criteria.of(Course.Fields.name, CriteriaOperator.CONTAIN, "II"),
                Criteria.of(Course.Fields.id, CriteriaOperator.GREATER_THAN, 5));
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }


    @PresentationMethod
    public void and2() {
        var criteriaList = CriteriaList.of(
                Criteria.of(Course.Fields.name, CriteriaOperator.CONTAIN, "II"),
                Criteria.of(Course.Fields.id, CriteriaOperator.EQUAL, 7, 8, 9, 10),
                Criteria.of(Course.Fields.active, CriteriaOperator.SPECIFIED, false));
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }


    @PresentationMethod
    public void or() {
        var criteriaList = CriteriaList.of(
                Criteria.of(Course.Fields.name, CriteriaOperator.CONTAIN, "II"),
                Criteria.of(Course.Fields.id, CriteriaOperator.EQUAL, 7, 8, 9, 10),
                Criteria.of(Course.Fields.active, CriteriaOperator.SPECIFIED, false),
                Criteria.OR(),
                Criteria.of(Course.Fields.id, CriteriaOperator.EQUAL, 1, 2, 3, 4, 5),
                Criteria.of(Course.Fields.id, CriteriaOperator.LESS_THAN, 3)
        );
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }


    @PresentationMethod
    public void or2() {
        var criteriaList = CriteriaList.of(
                Criteria.of(Course.Fields.name, CriteriaOperator.CONTAIN, "II"),
                Criteria.of(Course.Fields.id, CriteriaOperator.EQUAL, 7, 8, 9, 10),
                Criteria.of(Course.Fields.active, CriteriaOperator.SPECIFIED, false),
                Criteria.OR(),
                Criteria.of(Course.Fields.id, CriteriaOperator.EQUAL, 1, 2, 3, 4, 5),
                Criteria.OR(),
                Criteria.of(Course.Fields.id, CriteriaOperator.LESS_THAN, 3)
        );
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }
}
