package com.beyt.presentation.model.entity.authorization;

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
@Table(name = "admin_user")
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
      name = "admin_user_role",
      joinColumns = @JoinColumn(name = "admin_user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roles;
}
