package com.beyt.presentation.repository;

import com.beyt.jdq.repository.JpaDynamicQueryRepository;
import com.beyt.presentation.model.entity.Address;
import com.beyt.presentation.model.entity.authorization.Authorization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizationRepository extends JpaRepository<Authorization, Long>, JpaDynamicQueryRepository<Authorization, Long> {}
