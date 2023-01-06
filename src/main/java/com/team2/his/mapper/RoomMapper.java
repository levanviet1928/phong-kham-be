package com.team2.his.mapper;

import com.team2.his.dto.RoomDto;
import com.team2.his.dto.UltrasoundDto;
import com.team2.his.entity.RoomEntity;
import com.team2.his.entity.ServiceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper extends EntityMapper<RoomDto, RoomEntity>{
}
