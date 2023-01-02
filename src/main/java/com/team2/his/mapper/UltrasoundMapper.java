package com.team2.his.mapper;

import com.team2.his.dto.UltrasoundDto;
import com.team2.his.entity.ServiceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UltrasoundMapper extends EntityMapper<UltrasoundDto, ServiceEntity> {
}
