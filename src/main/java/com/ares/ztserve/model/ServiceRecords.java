package com.ares.ztserve.model;

import lombok.Data;

/**
 * @author ESy
 * @date 2023/2/15 015 15:43
 * 客服维护记录返回对象
 * custom_no	varchar2(100)
 * custom_name	varchar2(255)
 * is_describe	varchar2(2000)
 * is_solve	varchar2(2000)
 * feedbackrater	varchar2(32)
 * first_response	varchar2(7)
 * cliend_id	number
 */
@Data
public class ServiceRecords {
    private String clientId;
    private String isDescribe;
    private String isSolve;
    private String firstResponse;
}
