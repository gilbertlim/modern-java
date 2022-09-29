package com.gilbert.modern.MapStruct;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
class OrderDto {

    private String name;

    private String product;

    private Integer price;

    private String address;

    private String img;

    private LocalDateTime orderedTime;
}