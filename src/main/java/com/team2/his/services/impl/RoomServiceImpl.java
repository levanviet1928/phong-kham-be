package com.team2.his.services.impl;

import com.team2.his.dto.PageRequest;
import com.team2.his.dto.PageResponse;
import com.team2.his.dto.Response;
import com.team2.his.dto.RoomDto;
import com.team2.his.entity.RoomEntity;
import com.team2.his.exception.CommonException;
import com.team2.his.mapper.RoomMapper;
import com.team2.his.repostiris.RoomRepository;
import com.team2.his.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    @Override
    @Transactional
    public Response<RoomDto> save(RoomDto request) {
        Response<RoomDto> response = new Response<>();
        if (request.getRoomId() != null) {
            RoomEntity roomEntity = roomRepository.findById(request.getRoomId()).orElseThrow(() ->
                    new CommonException(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.toString(), "Không tìm thấy thông tin phòng"));
            BeanUtils.copyProperties(request, roomEntity);
            roomEntity = roomRepository.save(roomEntity);
            response.setData(roomMapper.toDto(roomEntity));
            return response;
        }
        RoomEntity roomEntity = roomRepository.save(roomMapper.toEntity(request));
        response.setData(roomMapper.toDto(roomEntity));
        return response;
    }

    @Override
    public PageResponse<RoomDto> findAll(PageRequest request) {
        Page<RoomEntity> allRoom = roomRepository.findAll(request.getPageable());
        PageResponse<RoomDto> response = new PageResponse<>();
        response.setData(roomMapper.toDto(allRoom.getContent()));
        response.setTotalRecord(allRoom.getContent().size());
        return response;
    }

    @Override
    public Response<RoomDto> getRoomById(UUID roomId) {
        RoomEntity roomEntity = roomRepository.findById(roomId).orElseThrow(() ->
                new CommonException(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.toString(), "Không tìm thấy thông tin phòng"));
        Response<RoomDto> response = new Response<>();
        response.setData(roomMapper.toDto(roomEntity));
        return response;
    }

    @Override
    public Response<String> deleteRoom(UUID roomId) {
        RoomEntity roomEntity = roomRepository.findById(roomId).orElseThrow(() ->
                new CommonException(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.toString(), "Không tìm thấy thông tin phòng"));
        roomEntity.setIsDeleted(true);
        roomRepository.save(roomEntity);
        return new Response<>("Xoá Thành công");
    }
}
