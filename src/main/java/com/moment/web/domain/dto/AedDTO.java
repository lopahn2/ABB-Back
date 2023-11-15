package com.moment.web.domain.dto;

import com.moment.web.domain.Aed;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AedDTO {
    private Long id;
    private boolean isWorked;
    private boolean isExist;
    private double locationX;
    private double locationY;
    private String location;
    private String address;
    private String lastCheckTime;

    public static AedDTO from(Aed aed) {
        return AedDTO.builder()
                .id(aed.getId())
                .locationX(aed.getLocationX())
                .locationY(aed.getLocationY())
                .location(aed.getLocation())
                .address(aed.getAddress())
                .lastCheckTime(aed.getLastCheckTime())
                .build();
    }
}
