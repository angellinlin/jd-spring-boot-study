package com.jincou.validation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhouguilong6
 * @date 2025/2/26 14:23
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskBean {

    private Long id;
    private int yn;
    private int rev;

    private String taskId;

    private String status;
    private String tenantId;
    private String taskName;
    private String subject;
    private String instId;

    private Date createTime;
}
