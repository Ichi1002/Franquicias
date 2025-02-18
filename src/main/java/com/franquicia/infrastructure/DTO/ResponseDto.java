package com.franquicia.infrastructure.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResponseDto {
    private Object data;
    private int status;
    private String message;
}
