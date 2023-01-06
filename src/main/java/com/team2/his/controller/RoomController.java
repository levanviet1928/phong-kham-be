package com.team2.his.controller;


import com.team2.his.dto.PageRequest;
import com.team2.his.dto.Response;
import com.team2.his.dto.RoomDto;
import com.team2.his.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;


    @PostMapping
    public ResponseEntity<Response<RoomDto>> saveService(@Valid @RequestBody RoomDto request) {
        return ResponseEntity.ok(roomService.save(request));
    }

    @GetMapping
    public ResponseEntity<?> getAllService(PageRequest request) {
        return ResponseEntity.ok(roomService.findAll(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getServiceById(@PathVariable("id") UUID roomId) {
        return ResponseEntity.ok(roomService.getRoomById(roomId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<String>> deleteService(@PathVariable("id") UUID roomId) {
        return ResponseEntity.ok(roomService.deleteRoom(roomId));
    }


}
