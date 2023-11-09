package com.moment.web.domain.service;

import com.moment.web.domain.Aed;
import com.moment.web.domain.dto.AedDTO;
import com.moment.web.domain.AedRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AedService {
    private final AedRepository aedRepository;

    public List<AedDTO> viewAll() {
        List<Aed> aeds = aedRepository.findAll();
        List<AedDTO> aedDTOs = aeds.stream().filter(aed -> aed.isExist() && aed.isWorked()).map(AedDTO::from).toList(); // 존재 & 작동 값이 True인 것만?
        return aedDTOs;
    }
}
