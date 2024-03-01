package com.beyt.presentation.model.entity;

import com.beyt.presentation.model.entity.Address;
import com.beyt.presentation.model.entity.Course;
import com.beyt.presentation.model.entity.Department;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Set;

@ToString
@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="department_id", nullable=false)
    private Department department;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    @JoinTable(
      name = "StudentCourse",
      joinColumns = @JoinColumn(name = "student_id"),
      inverseJoinColumns = @JoinColumn(name = "course_id"))
    Set<Course> courses;
}
