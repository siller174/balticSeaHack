package com.baltichack.view.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;


@Entity
@Getter
@Setter
@AllArgsConstructor
@ApiModel
@Table(appliesTo = "USERS")
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    @ApiModelProperty
    private Long id;

    @Column(name = "NAME")
    @ApiModelProperty("Full name")
    private String name;

    @Column(name = "EMAIL")
    @ApiModelProperty
    private String email;

    @ApiModelProperty
    private String phoneNumber;

    @ApiModelProperty
    private String city;

    @ApiModelProperty("Date of birth")
    private String data;
}
