package com.beyt.presentation.repository;

import com.beyt.jdq.repository.JpaDynamicQueryRepository;
import com.beyt.presentation.model.entity.Address;
import com.beyt.presentation.model.entity.authorization.Role;
import com.beyt.presentation.model.entity.authorization.RoleAuthorization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>, JpaDynamicQueryRepository<Role, Long> {}
