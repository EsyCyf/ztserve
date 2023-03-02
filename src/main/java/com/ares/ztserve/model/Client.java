package com.ares.ztserve.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author ESy
 * @date 2023/2/27 027 9:32
 * select personnel_base_id,
 *        custom_no,
 *        user_name,
 *        user_password,
 *        user_name_sz,
 *        user_role,
 *        is_active,
 *        email,
 *        is_mail,
 *        update_by,
 *        update_date,
 *        update_program,
 *        create_by,
 *        create_date,
 *        create_program
 *   from xx_personnel_base;
 */
@Data
@ApiModel(value ="用户信息")
public class Client {
    @ApiModelProperty("主键")
    private Integer personnelBaseId;
    @ApiModelProperty("客户公司")
    private String customNo;
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("用户密码")
    private String userPassword;
    @ApiModelProperty("用户名称")
    private String userNameSz;
    @ApiModelProperty("用户角色/权限")
    private String userRole;
    @ApiModelProperty("是否生效")
    private String isActive;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("是否接收邮件")
    private String isMail;
    @ApiModelProperty("更新者")
    private String updateBy;
    @ApiModelProperty("更新日期")
    private Date updateDate;
    @ApiModelProperty("更新程式")
    private String updateProgram;
    @ApiModelProperty("创建者")
    private String createBy;
    @ApiModelProperty("创建日期")
    private Date createDate;
    @ApiModelProperty("创建程式")
    private String createProgram;
}
