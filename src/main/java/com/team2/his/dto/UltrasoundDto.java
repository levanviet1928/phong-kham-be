package com.team2.his.dto;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class UltrasoundDto {

    private UUID ServiceId;

    private String ServiceCode;

    private String  ServiceName;
    private Integer Price;
}
