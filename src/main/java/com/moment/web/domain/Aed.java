package com.moment.web.domain;

import com.moment.web.domain.dto.AedMsgDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Aed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isWorked;
    private boolean isExist;
    private String location;
    private String address;
    private double locationX;
    private double locationY;
    private String lastCheckTime;

    public Aed from(AedMsgDTO aedMsgDTO) {
        this.isWorked = aedMsgDTO.isWorked();
        this.isExist = aedMsgDTO.isExist();
        this.lastCheckTime = aedMsgDTO.getLastCheckTime();
        return this;
    }
}
