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
public class S2_Multi_Value_Operators {
    private @Autowired CourseRepository courseRepository;
    private @Autowired DepartmentRepository departmentRepository;


    @PresentationMethod
    public void equal() {
        var criteriaList = CriteriaList.of(Criteria.of(Course.Fields.name, CriteriaOperator.EQUAL, "Calculus I", "Calculus II"));
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }

    @PresentationMethod
    public void equalInteger() {
        var criteriaList = CriteriaList.of(Criteria.of(Course.Fields.maxStudentCount, CriteriaOperator.EQUAL, 40, 50));
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }

    @PresentationMethod
    public void notEqual() {
        var criteriaList = CriteriaList.of(Criteria.of(Course.Fields.name, CriteriaOperator.NOT_EQUAL, "Calculus I", "Calculus II"));
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }

    @PresentationMethod
    public void notEqualDate() {
        var criteriaList = CriteriaList.of(Criteria.of(Course.Fields.startDate, CriteriaOperator.NOT_EQUAL, "2013-06-18", "2015-06-18", "2016-06-18"));
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }
}
