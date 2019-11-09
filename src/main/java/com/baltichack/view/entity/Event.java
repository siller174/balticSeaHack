package com.baltichack.view.entity;

import lombok.*;

//import javax.persistence.*;


//@Entity
@Getter
@Setter
@AllArgsConstructor
//@Table(name = "EVENTS")
public class Event {
//    @Id
//    @Column(name = "ID")
//    @GeneratedValue
    private Integer id;

//    @Column(name = "NAME")
    private String name;

//    @Column(name = "REDIRECTURL")
    private String redirectUrl;
}
