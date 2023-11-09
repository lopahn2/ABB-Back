package com.moment.web.domain.dto;

import com.moment.web.domain.Aed;
import lombok.Data;

@Data
public class AedDTO {
    private Long id;
    private double locationX;
    private double locationY;

    private AedDTO(Long id, double locationX, double locationY) {
        this.id = id;
        this.locationX = locationX;
        this.locationY = locationY;
    }

    public static AedDTO from(Aed aed) {
        return new AedDTO(aed.getId(), aed.getLocationX(), aed.getLocationY());
    }
}
