package com.moment.web.domain;

import com.moment.web.domain.Aed;
import com.moment.web.domain.dto.AedDTO;
import com.moment.web.domain.AedRepository;
import com.moment.web.domain.dto.AedMsgDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@RequiredArgsConstructor
@Service
public class AedService {
    private final AedRepository aedRepository;

    public List<Aed> viewAll() {
        List<Aed> aeds = aedRepository.findAll();
//        log.info("aed:{}", aeds.size());
//        List<AedDTO> aedDTOs = aeds.stream().filter(aed -> aed.isExist() && aed.isWorked()).map(AedDTO::from).toList(); // 존재 & 작동 값이 True인 것만?
//        log.info("aedDTO:{}", aedDTOs.size());
        return aeds;
    }

    public Aed update(AedMsgDTO aedMsgDTO) {
        Aed aed = aedRepository.findById(aedMsgDTO.getId()).orElseThrow(() -> new RuntimeException("존재하지 않는 AED 입니다."));
        aedRepository.save(aed.from(aedMsgDTO));
        return aed;
    }
}
