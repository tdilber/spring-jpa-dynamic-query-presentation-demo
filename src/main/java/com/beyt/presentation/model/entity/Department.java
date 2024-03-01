package com.beyt.presentation.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.Set;

@ToString
@Getter
@Setter
@Entity
@Table(name = "department")
@FieldNameConstants
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy="department", fetch = FetchType.EAGER)
    private Set<Student> students;
}
