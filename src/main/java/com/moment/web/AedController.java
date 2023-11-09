package com.moment.web;

import com.moment.web.domain.dto.AedDTO;
import com.moment.web.domain.dto.AedMsgDTO;
import com.moment.web.domain.service.AedService;
import com.moment.web.domain.service.ProducerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/aed")
@Controller
public class AedController {
    private final AedService aedService;
    private final ProducerService producerService;
    @GetMapping("/view-all")
    public ResponseEntity<List<AedDTO>> viewAll() {
        List<AedDTO> aedDTOs = aedService.viewAll();
        return ResponseEntity.status(HttpStatus.OK).body(aedDTOs);
    }
    @GetMapping("/update")
    public ResponseEntity<String> update(@RequestBody AedMsgDTO aedMsgDTO) {
        String status = producerService.sendMsg(aedMsgDTO);
        return ResponseEntity.status(HttpStatus.OK).body(status);
    }
}
