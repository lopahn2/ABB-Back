package com.moment.web;

import java.util.List;
import java.util.stream.Collectors;
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
