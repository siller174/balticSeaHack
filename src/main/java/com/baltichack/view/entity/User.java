package com.baltichack.view.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//import javax.persistence.*;


//@Entity
@Getter
@Setter
@AllArgsConstructor
@ApiModel
//@Table(name = "EVENTS")
public class User {

    // Инфа: 1) ФИО, 2) номер телефона 3) емейл 4) город 5) дата рождения

    //    @Id
//    @Column(name = "ID")
//    @GeneratedValue
    @ApiModelProperty
    private Long id;

    //    @Column(name = "NAME")
    @ApiModelProperty("Full name")
    private String name;

    //    @Column(name = "EMAIL")
    @ApiModelProperty
    private String email;

    @ApiModelProperty
    private String phoneNumber;

    @ApiModelProperty
    private String city;

    @ApiModelProperty("Date of birth")
    private String data;
}
