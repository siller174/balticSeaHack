package com.baltichack.view.entity;


import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//import javax.persistence.*;


//@Entity
@Getter
@Setter
@AllArgsConstructor
//@Table(name = "EVENTS")
public class User {
//    @Id
//    @Column(name = "ID")
//    @GeneratedValue
    private Integer id;

//    @Column(name = "NAME")
    private String name;

//    @Column(name = "REDIRECTURL")
    private String redirectUrl;


}
