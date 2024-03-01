// RoleAuthorization.java
package com.beyt.presentation.model.entity.authorization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "role_authorization")
@FieldNameConstants
public class RoleAuthorization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "authorization_id")
    private Authorization authorization;
}
