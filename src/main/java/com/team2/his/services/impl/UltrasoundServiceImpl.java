package com.team2.his.services.impl;

import com.team2.his.dto.PageRequest;
import com.team2.his.dto.PageResponse;
import com.team2.his.dto.Response;
import com.team2.his.dto.UltrasoundDto;
import com.team2.his.dto.search.UltrasoundRequest;
import com.team2.his.entity.ServiceEntity;
import com.team2.his.exception.CommonException;
import com.team2.his.mapper.UltrasoundMapper;
import com.team2.his.repostiris.UltrasoundServiceRepository;
import com.team2.his.services.UltrasoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UltrasoundServiceImpl implements UltrasoundService {

    private final UltrasoundServiceRepository serviceRepository;
    private final UltrasoundMapper ultrasoundMapper;

    @Override
    @Transactional
    public Response<UltrasoundDto> save(UltrasoundDto request) {
        Response<UltrasoundDto> response = new Response<>();
        if (request.getServiceId() != null) {
            ServiceEntity serviceEntity = serviceRepository.findById(request.getServiceId()).orElseThrow(() ->
                    new CommonException(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.toString(), "Không tìm thấy thông tin dịch vụ"));
            BeanUtils.copyProperties(request, serviceEntity);
            serviceEntity = serviceRepository.save(serviceEntity);
            response.setData(ultrasoundMapper.toDto(serviceEntity));
            return response;
        }
        ServiceEntity serviceEntity = serviceRepository.save(ultrasoundMapper.toEntity(request));
        response.setData(ultrasoundMapper.toDto(serviceEntity));
        return response;
    }

    @Override
    public PageResponse<UltrasoundDto> findAll(PageRequest request) {
        Page<ServiceEntity> allService =  serviceRepository.findAll(request.getPageable());
        PageResponse<UltrasoundDto> response = new PageResponse<>();
        response.setData(ultrasoundMapper.toDto(allService.getContent()));
        response.setTotalRecord(allService.getContent().size());
        return response;
    }

    @Override
    public Response<UltrasoundDto> getUltrasoundById(UUID serviceId) {
        ServiceEntity serviceEntity =  serviceRepository.findById(serviceId).orElseThrow(() ->
                new CommonException(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.toString(), "Không tìm thấy thông tin dịch vụ"));
        Response<UltrasoundDto> response = new Response<>();
        response.setData(ultrasoundMapper.toDto(serviceEntity));
        return response;
    }

    @Override
    public Response<String> deleteService(UUID serviceId) {
        ServiceEntity serviceEntity =  serviceRepository.findById(serviceId).orElseThrow(() ->
                new CommonException(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.toString(), "Không tìm thấy thông tin dịch vụ"));
        serviceEntity.setIsDeleted(true);
        serviceRepository.save(serviceEntity);
        return new Response<>("Thành công");
    }
}
