package com.beyt.presentation.repository;

import com.beyt.jdq.repository.JpaDynamicQueryRepository;
import com.beyt.presentation.model.entity.Address;
import com.beyt.presentation.model.entity.authorization.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long>, JpaDynamicQueryRepository<AdminUser, Long> {}
