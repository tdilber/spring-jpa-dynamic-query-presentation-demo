package com.beyt.presentation.presentation;

import com.beyt.jdq.annotation.model.JdqField;
import com.beyt.jdq.annotation.model.JdqModel;
import com.beyt.jdq.dto.Criteria;
import com.beyt.jdq.dto.CriteriaList;
import com.beyt.jdq.dto.DynamicQuery;
import com.beyt.jdq.dto.enums.CriteriaOperator;
import com.beyt.jdq.dto.enums.Order;
import com.beyt.presentation.annotation.PresentationMethod;
import com.beyt.presentation.annotation.PresentationService;
import com.beyt.presentation.model.entity.Course;
import com.beyt.presentation.model.entity.Student;
import com.beyt.presentation.model.entity.authorization.AdminUser;
import com.beyt.presentation.repository.AdminUserRepository;
import com.beyt.presentation.repository.CourseRepository;
import com.beyt.presentation.repository.DepartmentRepository;
import com.beyt.presentation.repository.StudentRepository;
import com.beyt.presentation.util.PresentationUtil;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;

import java.util.List;

@PresentationService
public class S8_Advenced_Projection {
    private @Autowired AdminUserRepository adminUserRepository;


    public static class AuthorizationSummary {
        @Getter @Setter private Long adminId;
        @Getter @Setter private String adminUsername;
        @Getter @Setter private Long roleId;
        @Getter @Setter private String roleName;
        @Getter @Setter private Long authorizationId;
        @Getter @Setter private String authorizationName;
        @Getter @Setter private String menuIcon;
    }
    @PresentationMethod
    public void roleJoin() {
        DynamicQuery dynamicQuery = new DynamicQuery();
        dynamicQuery.getSelect().add(Pair.of("id", "adminId"));
        dynamicQuery.getSelect().add(Pair.of("username", "adminUsername"));
        dynamicQuery.getSelect().add(Pair.of("roles.id", "roleId"));
        dynamicQuery.getSelect().add(Pair.of("roles.name", "roleName"));
        dynamicQuery.getSelect().add(Pair.of("roles.roleAuthorizations.authorization.id", "authorizationId"));
        dynamicQuery.getSelect().add(Pair.of("roles.roleAuthorizations.authorization.name", "authorizationName"));
        dynamicQuery.getSelect().add(Pair.of("roles.roleAuthorizations.authorization.menuIcon", "menuIcon"));
        var criteriaList = CriteriaList.of(Criteria.of("roles.roleAuthorizations.authorization.menuIcon", CriteriaOperator.START_WITH, "icon"));
        dynamicQuery.getWhere().addAll(criteriaList);
        PresentationUtil.prettyPrint(dynamicQuery);
        List<AdminUser> result = adminUserRepository.findAll(criteriaList);
        PresentationUtil.prettyPrint(result);
        List<AuthorizationSummary> result2 = adminUserRepository.findAll(dynamicQuery, AuthorizationSummary.class);
        PresentationUtil.prettyPrint(result2);
    }


    @JdqModel
    public static class AnnotatedAuthorizationSummary {
        @JdqField("id")
        @Getter @Setter
        private Long adminId;
        @JdqField("username")
        @Getter @Setter private String adminUsername;
        @JdqField("roles.id")
        @Getter @Setter private Long roleId;
        @JdqField("roles.name")
        @Getter @Setter private String roleName;
        @JdqField("roles.roleAuthorizations.authorization.id")
        @Getter @Setter private Long authorizationId;
        @JdqField("roles.roleAuthorizations.authorization.name")
        @Getter @Setter private String authorizationName;
        @JdqField("roles.roleAuthorizations.authorization.menuIcon")
        @Getter @Setter private String menuIcon;
    }

    @PresentationMethod
    public void roleJoinWithAnnotatedModel() {
        DynamicQuery dynamicQuery = new DynamicQuery();
        dynamicQuery.getWhere().add(Criteria.of("roles.roleAuthorizations.authorization.menuIcon", CriteriaOperator.START_WITH, "icon"));
        PresentationUtil.prettyPrint(dynamicQuery);
        List<AnnotatedAuthorizationSummary> result2 = adminUserRepository.findAll(dynamicQuery, AnnotatedAuthorizationSummary.class);
        PresentationUtil.prettyPrint(result2);
    }
}
