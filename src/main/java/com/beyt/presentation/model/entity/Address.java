package com.beyt.presentation.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity
@Table(name = "address")
@FieldNameConstants
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String state;
    private String zip;

    @ToString.Exclude
    @JsonIgnore
    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Student student;
}
