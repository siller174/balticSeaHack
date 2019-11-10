package com.baltichack.view.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;


@Getter
@Setter
@AllArgsConstructor
@ApiModel
@Table(appliesTo = "EVENT")
public class Event {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    @ApiModelProperty("Event Id")
    private Long id;
    @Column(name = "NAME")
    @ApiModelProperty("Event name")
    private String name;
    @Column(name = "REDIRECTURL")
    @ApiModelProperty("Redirect Url")
    private String redirectUrl;
    private String[] colors;
}
