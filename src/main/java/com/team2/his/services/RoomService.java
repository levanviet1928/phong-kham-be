package com.team2.his.services;

import com.team2.his.dto.PageRequest;
import com.team2.his.dto.PageResponse;
import com.team2.his.dto.Response;
import com.team2.his.dto.RoomDto;

import java.util.UUID;

public interface RoomService {
    Response<RoomDto> save(RoomDto request);

    PageResponse<RoomDto> findAll(PageRequest request);

    Response<RoomDto> getRoomById(UUID roomId);

    Response<String> deleteRoom(UUID roomId);
}
