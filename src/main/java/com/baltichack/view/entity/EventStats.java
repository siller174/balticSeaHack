package com.baltichack.view.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Getter
@Setter
public class EventStats {

    @ApiModelProperty("Event Id")
    private Long eventId;

    @ApiModelProperty("User Id")
    private Long userId;
}
