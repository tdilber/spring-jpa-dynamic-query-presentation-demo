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
public class S4_SCOPE_Operator {
    private @Autowired CourseRepository courseRepository;
    private @Autowired DepartmentRepository departmentRepository;


    //     (A OR B) AND (C OR D)
    @PresentationMethod
    public void scope() {
        var criteriaList = CriteriaList.of(
                Criteria.of("", CriteriaOperator.PARENTHES,
                        CriteriaList.of(Criteria.of(Course.Fields.id, CriteriaOperator.EQUAL, 1),
                                Criteria.OR(),
                                Criteria.of(Course.Fields.id, CriteriaOperator.EQUAL, 2))),
                Criteria.of("", CriteriaOperator.PARENTHES,
                        CriteriaList.of(Criteria.of(Course.Fields.id, CriteriaOperator.EQUAL, 2),
                                Criteria.OR(),
                                Criteria.of(Course.Fields.id, CriteriaOperator.EQUAL, 3)))
        );
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }


    @PresentationMethod
    public void scopeInsideScope() {
        var criteriaList = CriteriaList.of(
                Criteria.of("", CriteriaOperator.PARENTHES,
                        CriteriaList.of(Criteria.of(Course.Fields.id, CriteriaOperator.EQUAL, 1, 2, 3),
                                Criteria.of(Course.Fields.id, CriteriaOperator.NOT_EQUAL, 2),
                        Criteria.OR(),
                        Criteria.of("", CriteriaOperator.PARENTHES,
                                CriteriaList.of(Criteria.of(Course.Fields.id, CriteriaOperator.EQUAL, 2),
                                        Criteria.of(Course.Fields.id, CriteriaOperator.NOT_EQUAL, 3)))))
        );
        PresentationUtil.prettyPrint(criteriaList);
        List<Course> courseList = courseRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }
}
