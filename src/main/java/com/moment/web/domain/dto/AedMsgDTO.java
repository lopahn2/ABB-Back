package com.moment.web.domain.dto;

import lombok.Data;

@Data
public class AedMsgDTO {
    private Long id;
    private boolean isWorked;
    private boolean isExist;
    private String lastCheckTime;
}
