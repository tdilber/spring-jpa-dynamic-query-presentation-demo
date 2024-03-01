package com.beyt.presentation.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.Set;

@ToString
@Getter
@Setter
@Entity
@Table(name = "course")
@FieldNameConstants
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Date startDate;

    private Integer maxStudentCount;

    private Boolean active;

    private String description;


    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private Set<Student> students;
}
