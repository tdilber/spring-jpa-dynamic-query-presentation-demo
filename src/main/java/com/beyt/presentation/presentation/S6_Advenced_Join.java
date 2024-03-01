package com.beyt.presentation.presentation;

import com.beyt.jdq.dto.Criteria;
import com.beyt.jdq.dto.CriteriaList;
import com.beyt.jdq.dto.enums.CriteriaOperator;
import com.beyt.presentation.annotation.PresentationMethod;
import com.beyt.presentation.annotation.PresentationService;
import com.beyt.presentation.model.entity.authorization.AdminUser;
import com.beyt.presentation.repository.AdminUserRepository;
import com.beyt.presentation.repository.DepartmentRepository;
import com.beyt.presentation.util.PresentationUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@PresentationService
public class S6_Advenced_Join {
    private @Autowired AdminUserRepository adminUserRepository;
    private @Autowired DepartmentRepository departmentRepository;

    @PresentationMethod
    public void roleJoin() {
        var criteriaList = CriteriaList.of(Criteria.of("roles.roleAuthorizations.authorization.menuIcon", CriteriaOperator.START_WITH, "icon"));
        PresentationUtil.prettyPrint(criteriaList);
        List<AdminUser> courseList = adminUserRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }

    @PresentationMethod
    public void roleLeftJoin() {
        var criteriaList = CriteriaList.of(Criteria.of("roles<roleAuthorizations<authorization<menuIcon", CriteriaOperator.START_WITH, "icon"));
        PresentationUtil.prettyPrint(criteriaList);
        List<AdminUser> courseList = adminUserRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(courseList);
    }
}
