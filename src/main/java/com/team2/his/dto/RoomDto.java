package com.team2.his.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor

public class RoomDto {
    private UUID RoomId;
    private String RoomCode;
    private String RoomName;
}
