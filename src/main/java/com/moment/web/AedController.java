package com.moment.web;

import com.moment.web.domain.Aed;
import com.moment.web.domain.dto.AedDTO;
import com.moment.web.domain.dto.AedMsgDTO;
import com.moment.web.domain.AedService;
import com.moment.web.domain.kafka_service.ProducerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/aed")
@Controller
public class AedController {
    private final AedService aedService;
    private final ProducerService producerService;
    @GetMapping("/view-all")
    public ResponseEntity<List<Aed>> viewAll() {
        List<Aed> aeds = aedService.viewAll();
        return ResponseEntity.status(HttpStatus.OK).body(aeds);
    }
    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody AedMsgDTO aedMsgDTO) {
        log.info("worked : {}", aedMsgDTO.isWorked());
        log.info("exist : {}", aedMsgDTO.isExist());
        Aed aed = aedService.update(aedMsgDTO);
        String status = producerService.sendMsg(aed);
        return ResponseEntity.status(HttpStatus.OK).body(status);
    }
}
