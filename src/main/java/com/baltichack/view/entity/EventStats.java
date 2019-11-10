package com.baltichack.view.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Table;

@ApiModel
@Getter
@Setter
@AllArgsConstructor
@Table(appliesTo = "EVENTSTATS")
public class EventStats {

    @ApiModelProperty("Event Id")
    private Long eventId;

    @ApiModelProperty("User Id")
    private Long userId;
}
