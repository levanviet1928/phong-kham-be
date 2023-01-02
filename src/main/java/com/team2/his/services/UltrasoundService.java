package com.team2.his.services;

import com.team2.his.dto.PageRequest;
import com.team2.his.dto.PageResponse;
import com.team2.his.dto.Response;
import com.team2.his.dto.UltrasoundDto;

import java.util.UUID;

public interface UltrasoundService {

    Response<UltrasoundDto> save(UltrasoundDto request);

    PageResponse<UltrasoundDto> findAll(PageRequest request);

    Response<UltrasoundDto> getUltrasoundById(UUID serviceId);

    Response<String> deleteService(UUID serviceId);
}
