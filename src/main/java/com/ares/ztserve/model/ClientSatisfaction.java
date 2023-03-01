package com.ares.ztserve.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ESy
 * @date 2023/2/21 021 9:57
 * create table xx_cst
 * (
 * cst_id       number,
 * client_id    varchar2(32),
 * type         varchar2(32),
 * satis_degree    number,
 * satis_desc      varchar2(2000),
 * feedback     varchar2(2000)
 * );
 */
@Data
@ApiModel("客户满意度类")
public class ClientSatisfaction {
    @ApiModelProperty("主键")
    private int cstId;
    @ApiModelProperty("客户邮箱")
    private String userName;
    @ApiModelProperty("问题分类")
    private String type;
    @ApiModelProperty("满意度")
    private int satisDegree;
    @ApiModelProperty("满意度描述")
    private String satisDesc;
    @ApiModelProperty("反馈")
    private String feedback;
}
