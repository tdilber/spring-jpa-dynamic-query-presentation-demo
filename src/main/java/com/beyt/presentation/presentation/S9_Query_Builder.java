package com.beyt.presentation.presentation;

import com.beyt.jdq.dto.Criteria;
import com.beyt.jdq.dto.CriteriaList;
import com.beyt.jdq.dto.DynamicQuery;
import com.beyt.jdq.dto.enums.CriteriaOperator;
import com.beyt.jdq.dto.enums.Order;
import com.beyt.jdq.query.builder.QuerySimplifier;
import com.beyt.presentation.annotation.PresentationMethod;
import com.beyt.presentation.annotation.PresentationService;
import com.beyt.presentation.model.entity.Course;
import com.beyt.presentation.model.entity.authorization.AdminUser;
import com.beyt.presentation.repository.AdminUserRepository;
import com.beyt.presentation.repository.CourseRepository;
import com.beyt.presentation.repository.DepartmentRepository;
import com.beyt.presentation.util.PresentationUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.util.Pair;

import java.util.List;

import static com.beyt.jdq.query.builder.QuerySimplifier.*;

@PresentationService
public class S9_Query_Builder {
    private @Autowired AdminUserRepository adminUserRepository;


    public static class AuthorizationSummary {
        @Getter
        @Setter
        private Long adminId;
        @Getter @Setter private String adminUsername;
        @Getter @Setter private Long roleId;
        @Getter @Setter private String roleName;
        @Getter @Setter private Long authorizationId;
        @Getter @Setter private String authorizationName;
        @Getter @Setter private String menuIcon;
    }
    @PresentationMethod
    public void queryBuilder() {
        Page<AuthorizationSummary> result = adminUserRepository.queryBuilder()
                .select(Select("id", "adminId"),
                        Select("username", "adminUsername"),
                        Select("roles.id", "roleId"),
                        Select("roles.name", "roleName"),
                        Select("roles.roleAuthorizations.authorization.id", "authorizationId"),
                        Select("roles.roleAuthorizations.authorization.name", "authorizationName"),
                        Select("roles.roleAuthorizations.authorization.menuIcon", "menuIcon"))
                .distinct(false)
                .where(Field("roles.roleAuthorizations.authorization.menuIcon").startWith("icon"), Parantesis(Field("id").eq(3), OR, Field("roles.id").eq(4), OR, Field("id").eq(5)), Parantesis(Field("id").eq(5), OR, Field("id").eq(4), OR, Field("roles.id").eq(3)))
                .orderBy(OrderBy("roles.id", Order.DESC))
                .page(1, 2)
                .getResultAsPage(AuthorizationSummary.class);

        PresentationUtil.prettyPrint(result);
    }
}
