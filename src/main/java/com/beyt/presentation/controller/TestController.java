package com.beyt.presentation.controller;

import com.beyt.jdq.dto.CriteriaList;
import com.beyt.jdq.dto.DynamicQuery;
import com.beyt.presentation.model.entity.Course;
import com.beyt.presentation.presentation.S9_Query_Builder;
import com.beyt.presentation.repository.AdminUserRepository;
import com.beyt.presentation.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test-api")
public class TestController {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private AdminUserRepository adminUserRepository;


    @GetMapping("/course")
    public ResponseEntity<List<Course>> getCourseWithCriteria(CriteriaList criteriaList) {
        List<Course> customerList = courseRepository.findAll(criteriaList);
        return ResponseEntity.ok().body(customerList);
    }

    @GetMapping("/course/as-page")
    public ResponseEntity<Page<Course>> getCourseWithSearchFilterAsPage(DynamicQuery dynamicQuery) {
        Page<Course> customerList = courseRepository.findAllAsPage(dynamicQuery);
        return ResponseEntity.ok().body(customerList);
    }

    @GetMapping("/course/as-list")
    public ResponseEntity<List<S9_Query_Builder.AuthorizationSummary>> getCourseWithSearchFilterAsList(DynamicQuery dynamicQuery) {
        List<S9_Query_Builder.AuthorizationSummary> customerList = adminUserRepository.findAll(dynamicQuery, S9_Query_Builder.AuthorizationSummary.class);
        return ResponseEntity.ok().body(customerList);
    }
}
