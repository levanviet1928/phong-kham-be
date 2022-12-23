package com.team2.his.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Response<T> {
    private ErrorInfo error;
    private T data;

    public Response(T data){
        this.data = data;
    }
}
