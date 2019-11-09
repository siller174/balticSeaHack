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
public class Event {
//    @Id
//    @Column(name = "ID")
//    @GeneratedValue
    @ApiModelProperty("Event Id")
    private Long id;

//    @Column(name = "NAME")
    @ApiModelProperty("Event name")
    private String name;

//    @Column(name = "REDIRECTURL")
    @ApiModelProperty("Redirect Url")
    private String redirectUrl;

    private String[] colors;
}
