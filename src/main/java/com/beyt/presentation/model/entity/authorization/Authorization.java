package com.beyt.presentation.model.entity.authorization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "my_authorization")
public class Authorization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "menu_url")
    private String menuUrl;

    @Column(name = "menu_icon")
    private String menuIcon;


    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "authorization", fetch = FetchType.LAZY)
    Set<RoleAuthorization> roleAuthorizations;
}
