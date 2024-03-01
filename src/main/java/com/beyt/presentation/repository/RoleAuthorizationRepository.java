package com.beyt.presentation.repository;

import com.beyt.jdq.repository.JpaDynamicQueryRepository;
import com.beyt.presentation.model.entity.Address;
import com.beyt.presentation.model.entity.authorization.RoleAuthorization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleAuthorizationRepository extends JpaRepository<RoleAuthorization, Long>, JpaDynamicQueryRepository<RoleAuthorization, Long> {}
