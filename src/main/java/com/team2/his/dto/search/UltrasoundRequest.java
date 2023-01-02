package com.team2.his.dto.search;

import com.team2.his.dto.PageRequest;

import java.math.BigDecimal;
import java.util.UUID;

public class UltrasoundRequest extends PageRequest {

    private UUID ServiceId;
    private String ServiceCode;
    private String  ServiceName;
    private BigDecimal Price;

}
