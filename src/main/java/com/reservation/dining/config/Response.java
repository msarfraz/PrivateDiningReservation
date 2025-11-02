package com.reservation.dining.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
    public Response(T data){
        this.data = data;
        this.status = "success";
    }
    public Response(String message){
        this.message = message;
        this.status = "failed";
    }
    private String message;
    private String status;
    private T data;
}
