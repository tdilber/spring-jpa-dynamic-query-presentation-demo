package com.beyt.presentation.model.entity.authorization;

import com.beyt.presentation.model.entity.authorization.Authorization;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    Set<RoleAuthorization> roleAuthorizations;
}
