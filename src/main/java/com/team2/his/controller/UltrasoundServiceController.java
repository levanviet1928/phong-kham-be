package com.team2.his.controller;

import com.team2.his.dto.PageRequest;
import com.team2.his.dto.Response;
import com.team2.his.dto.UltrasoundDto;
import com.team2.his.services.UltrasoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/service")
@RequiredArgsConstructor
public class UltrasoundServiceController {

    private final UltrasoundService ultrasoundService;

    @PostMapping
    public ResponseEntity<Response<UltrasoundDto>> saveService(@Valid @RequestBody UltrasoundDto request) {
        return ResponseEntity.ok(ultrasoundService.save(request));
    }

    @GetMapping
    public ResponseEntity<?> getAllService(PageRequest request) {
        return ResponseEntity.ok(ultrasoundService.findAll(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getServiceById(@PathVariable("id") UUID serviceId) {
        return ResponseEntity.ok(ultrasoundService.getUltrasoundById(serviceId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<String>> deleteService(@PathVariable("id") UUID serviceId) {
        return ResponseEntity.ok(ultrasoundService.deleteService(serviceId));
    }
}
