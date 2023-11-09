package com.moment.web;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/aed")
@Controller
public class AedController {
    private final AedService aedService;
    @GetMapping("/view-all")
    public ResponseEntity<List<AedDTO>> viewAll() {
        List<AedDTO> aedDTOs = aedService.viewAll();
        return ResponseEntity.status(HttpStatus.OK).body(aedDTOs);
    }
    @GetMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable("id") Long id) {

    }
}
