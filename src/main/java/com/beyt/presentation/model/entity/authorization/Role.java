package com.beyt.presentation.model.entity.authorization;

import com.beyt.presentation.model.entity.authorization.Authorization;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "role")
@FieldNameConstants
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    Set<RoleAuthorization> roleAuthorizations;
}
