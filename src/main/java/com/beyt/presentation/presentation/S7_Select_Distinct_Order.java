package com.beyt.presentation.presentation;

import com.beyt.jdq.dto.Criteria;
import com.beyt.jdq.dto.CriteriaList;
import com.beyt.jdq.dto.DynamicQuery;
import com.beyt.jdq.dto.enums.CriteriaOperator;
import com.beyt.jdq.dto.enums.Order;
import com.beyt.presentation.annotation.PresentationMethod;
import com.beyt.presentation.annotation.PresentationService;
import com.beyt.presentation.model.entity.Course;
import com.beyt.presentation.model.entity.Student;
import com.beyt.presentation.repository.CourseRepository;
import com.beyt.presentation.repository.DepartmentRepository;
import com.beyt.presentation.repository.StudentRepository;
import com.beyt.presentation.util.PresentationUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.util.Pair;

import javax.persistence.Tuple;
import java.util.List;

@PresentationService
public class S7_Select_Distinct_Order {
    private @Autowired CourseRepository courseRepository;
    private @Autowired StudentRepository studentRepository;


    @PresentationMethod
    public void selectSameObject() {
        DynamicQuery dynamicQuery = new DynamicQuery();
        dynamicQuery.getSelect().add(Pair.of("name", "name"));
        dynamicQuery.getSelect().add(Pair.of("description", "description"));
        dynamicQuery.setWhere(CriteriaList.of(Criteria.of(Course.Fields.id, CriteriaOperator.GREATER_THAN, 3)));
        PresentationUtil.prettyPrint(dynamicQuery);
        List<Course> courseList = courseRepository.findAll(dynamicQuery);
        PresentationUtil.prettyPrint(courseList);
    }

    public static class CourseName { @Getter @Setter private String name;}

    @PresentationMethod
    public void selectDifferentObject() {
        DynamicQuery dynamicQuery = new DynamicQuery();
        dynamicQuery.getSelect().add(Pair.of("name", "name"));
        dynamicQuery.setWhere(CriteriaList.of(Criteria.of(Course.Fields.id, CriteriaOperator.GREATER_THAN, 3)));
        PresentationUtil.prettyPrint(dynamicQuery);
        List<CourseName> courseList = courseRepository.findAll(dynamicQuery, CourseName.class);
        PresentationUtil.prettyPrint(courseList);
    }
    @PresentationMethod
    public void selectDifferentObjectDifferent() {
        DynamicQuery dynamicQuery = new DynamicQuery();
        dynamicQuery.getSelect().add(Pair.of("description", "name"));
        dynamicQuery.setWhere(CriteriaList.of(Criteria.of(Course.Fields.id, CriteriaOperator.GREATER_THAN, 3)));
        PresentationUtil.prettyPrint(dynamicQuery);
        List<CourseName> courseList = courseRepository.findAll(dynamicQuery, CourseName.class);
        PresentationUtil.prettyPrint(courseList);
    }
    @PresentationMethod
    public void selectDifferentEntityObject() {
        DynamicQuery dynamicQuery = new DynamicQuery();
        dynamicQuery.getSelect().add(Pair.of("description", "name"));
        dynamicQuery.setWhere(CriteriaList.of(Criteria.of(Course.Fields.id, CriteriaOperator.GREATER_THAN, 3)));
        PresentationUtil.prettyPrint(dynamicQuery);
        List<Student> courseList = courseRepository.findAll(dynamicQuery, Student.class);
        PresentationUtil.prettyPrint(courseList);
    }

    @PresentationMethod
    public void distinct() {
        DynamicQuery dynamicQuery = new DynamicQuery();
//        dynamicQuery.setDistinct(true);
        dynamicQuery.setWhere(CriteriaList.of(Criteria.of("courses.id", CriteriaOperator.GREATER_THAN, 1), Criteria.of("id", CriteriaOperator.EQUAL, 2)));
        PresentationUtil.prettyPrint(dynamicQuery);
        List<Student> courseList = studentRepository.findAll(dynamicQuery);
        PresentationUtil.prettyPrint(courseList);
    }

    @PresentationMethod
    public void orderBy() {
        DynamicQuery dynamicQuery = new DynamicQuery();
        dynamicQuery.setOrderBy(List.of(Pair.of(Course.Fields.id, Order.DESC)));
        PresentationUtil.prettyPrint(dynamicQuery);
        List<Course> courseList = courseRepository.findAll(dynamicQuery);
        PresentationUtil.prettyPrint(courseList);
    }


    @PresentationMethod
    public void orderByMulti() {
        DynamicQuery dynamicQuery = new DynamicQuery();
        dynamicQuery.setOrderBy(List.of(Pair.of(Course.Fields.maxStudentCount, Order.DESC), Pair.of(Course.Fields.id, Order.DESC)));
        PresentationUtil.prettyPrint(dynamicQuery);
        List<Course> courseList = courseRepository.findAll(dynamicQuery);
        PresentationUtil.prettyPrint(courseList);
    }
    @PresentationMethod
    public void page() {
        DynamicQuery dynamicQuery = new DynamicQuery();
        dynamicQuery.setWhere(CriteriaList.of(Criteria.of(Course.Fields.id, CriteriaOperator.GREATER_THAN, 3)));
        dynamicQuery.setPageSize(2);
        dynamicQuery.setPageNumber(1);
        System.out.println("Page");
        Page<Course> allAsPage = courseRepository.findAllAsPage(dynamicQuery);
        PresentationUtil.prettyPrint(courseRepository.findAllAsPage(dynamicQuery));
        System.out.println("Page With Projection");
        dynamicQuery.getSelect().add(Pair.of("name", "name"));
        PresentationUtil.prettyPrint(courseRepository.findAllAsPage(dynamicQuery, CourseName.class));
        System.out.println("Tuple");
        List<Tuple> allAsTuple = courseRepository.findAllAsTuple(dynamicQuery);
        System.out.println("Tuple Page");
        Page<Tuple> allAsTuplePage = courseRepository.findAllAsTuplePage(dynamicQuery);

    }
}
