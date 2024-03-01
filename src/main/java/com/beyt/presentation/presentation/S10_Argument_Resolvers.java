package com.beyt.presentation.presentation;

import com.beyt.presentation.annotation.PresentationMethod;
import com.beyt.presentation.annotation.PresentationService;
import com.beyt.presentation.repository.CourseRepository;
import com.beyt.presentation.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

@PresentationService
public class S10_Argument_Resolvers {
    private @Autowired CourseRepository courseRepository;
    private @Autowired DepartmentRepository departmentRepository;


    @PresentationMethod
    public void test() {
        // TODO paginational fetch
    }
}
