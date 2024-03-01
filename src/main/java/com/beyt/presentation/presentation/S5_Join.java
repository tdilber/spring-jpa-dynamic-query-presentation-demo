package com.beyt.presentation.presentation;

import com.beyt.jdq.dto.Criteria;
import com.beyt.jdq.dto.CriteriaList;
import com.beyt.jdq.dto.enums.CriteriaOperator;
import com.beyt.presentation.annotation.PresentationMethod;
import com.beyt.presentation.annotation.PresentationService;
import com.beyt.presentation.model.entity.Department;
import com.beyt.presentation.model.entity.Student;
import com.beyt.presentation.repository.DepartmentRepository;
import com.beyt.presentation.repository.StudentRepository;
import com.beyt.presentation.util.PresentationUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@PresentationService
public class S5_Join {
    private @Autowired DepartmentRepository departmentRepository;
    private @Autowired StudentRepository studentRepository;


    /**
     * Inner join with single entity criteria
     */
    @PresentationMethod
    public void innerJoin() {
        var criteriaList = CriteriaList.of(Criteria.of("department.name", CriteriaOperator.START_WITH, "P"));
        PresentationUtil.prettyPrint(criteriaList);
        List<Student> students = studentRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(students);
    }

    /**
     * Inner join with multi joined entity criteria
     */
    @PresentationMethod
    public void innerJoin2() {
        var criteriaList = CriteriaList.of(
                Criteria.of("department.name", CriteriaOperator.START_WITH, "P"),
                Criteria.of("department.id", CriteriaOperator.GREATER_THAN, 3)
        );
        PresentationUtil.prettyPrint(criteriaList);
        List<Student> students = studentRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(students);
    }

    /**
     * Inner join with different entity criteria
     */
    @PresentationMethod
    public void innerJoin3() {
        var criteriaList = CriteriaList.of(
                Criteria.of("department.name", CriteriaOperator.START_WITH, "P"),
                Criteria.of("name", CriteriaOperator.START_WITH, "Robert")
        );
        PresentationUtil.prettyPrint(criteriaList);
        List<Student> students = studentRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(students);
    }

    /**
     * One to many inner join
     */
    @PresentationMethod
    public void innerJoin4() {
        var criteriaList = CriteriaList.of(
                Criteria.of("students.id", CriteriaOperator.GREATER_THAN, 3),
                Criteria.of("id", CriteriaOperator.LESS_THAN, 6)
        );
        PresentationUtil.prettyPrint(criteriaList);
        List<Department> departments = departmentRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(departments);
    }

    /**
     * Many to many inner join
     */
    @PresentationMethod
    public void innerJoin5() {
        var criteriaList = CriteriaList.of(
                Criteria.of("courses.maxStudentCount", CriteriaOperator.GREATER_THAN, 100),
                Criteria.of("id", CriteriaOperator.GREATER_THAN, 3)
        );
        PresentationUtil.prettyPrint(criteriaList);
        List<Student> students = studentRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(students);
    }

    /**
     * Typical left join with is null check
     */
    @PresentationMethod
    public void leftJoin() {
        var criteriaList = CriteriaList.of(
                Criteria.of("department<id", CriteriaOperator.SPECIFIED, false),
                Criteria.of("id", CriteriaOperator.GREATER_THAN, 3)
        );
        PresentationUtil.prettyPrint(criteriaList);
        List<Student> students = studentRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(students);
    }
}
