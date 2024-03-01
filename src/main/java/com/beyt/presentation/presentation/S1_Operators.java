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
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
@PresentationService
public class S1_Operators {
    private @Autowired CourseRepository courseRepository;
    private @Autowired DepartmentRepository departmentRepository;


//CONTAIN
//DOES_NOT_CONTAIN
//END_WITH
//START_WITH
//SPECIFIED
//EQUAL
//NOT_EQUAL
//GREATER_THAN
//GREATER_THAN_OR_EQUAL
//LESS_THAN
//LESS_THAN_OR_EQUAL

    @PresentationMethod
    public void contain() {
        var criteriaList = CriteriaList.of(Criteria.of("name", CriteriaOperator.CONTAIN, "Calculus"));
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }

    @PresentationMethod
    public void doesNotContain() {
        var criteriaList = CriteriaList.of(Criteria.of("name", CriteriaOperator.DOES_NOT_CONTAIN, "I"));
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }

    @PresentationMethod
    public void endWith() {
        var criteriaList = CriteriaList.of(Criteria.of("name", CriteriaOperator.END_WITH, "Science"));
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }

    @PresentationMethod
    public void startWith() {
        var criteriaList = CriteriaList.of(Criteria.of("name", CriteriaOperator.START_WITH, "Physics"));
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }

    @PresentationMethod
    public void specifiedTrue() {
        var criteriaList = CriteriaList.of(Criteria.of("active", CriteriaOperator.SPECIFIED, "true"));
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }


    @PresentationMethod
    public void specifiedFalse() {
        var criteriaList = CriteriaList.of(Criteria.of("active", CriteriaOperator.SPECIFIED, "false"));
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }

    @PresentationMethod
    public void equal() {
        var criteriaList = CriteriaList.of(Criteria.of("name", CriteriaOperator.EQUAL, "Calculus I"));
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }

    @SneakyThrows
    @PresentationMethod
    public void equalDate() {
        var criteriaList = CriteriaList.of(Criteria.of("startDate", CriteriaOperator.EQUAL, "2015-06-18"));
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }

    @SneakyThrows
    @PresentationMethod
    public void equalInteger() {
        var criteriaList = CriteriaList.of(Criteria.of("maxStudentCount", CriteriaOperator.EQUAL, 54));
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }

    @PresentationMethod
    public void notEqual() {
        var criteriaList = CriteriaList.of(Criteria.of("name", CriteriaOperator.NOT_EQUAL, "Introduction to Computer Science"));
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }

    @PresentationMethod
    public void greaterThan() {
        var criteriaList = CriteriaList.of(Criteria.of("id", CriteriaOperator.GREATER_THAN, 5));
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }

    @PresentationMethod
    public void greaterThanDate() {
        var criteriaList = CriteriaList.of(Criteria.of("startDate", CriteriaOperator.GREATER_THAN, "2015-06-18"));
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }

    @PresentationMethod
    public void greaterThanOrEqual() {
        var criteriaList = CriteriaList.of(Criteria.of("id", CriteriaOperator.GREATER_THAN_OR_EQUAL, 8));
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }

    @PresentationMethod
    public void greaterThanOrEqualDate() {
        var criteriaList = CriteriaList.of(Criteria.of("startDate", CriteriaOperator.GREATER_THAN_OR_EQUAL, "2019-06-18"));
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }

    @PresentationMethod
    public void lessThan() {
        var criteriaList = CriteriaList.of(Criteria.of(Course.Fields.maxStudentCount, CriteriaOperator.LESS_THAN, 40));
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }

    @PresentationMethod
    public void lessThanOrEqual() {
        var criteriaList = CriteriaList.of(Criteria.of(Course.Fields.maxStudentCount, CriteriaOperator.LESS_THAN_OR_EQUAL, 40));
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }
}
