package com.gilbert.modern.MapStruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    //  Instance가 OrderMapper를 상속받아서 OrderMapperImpl로 구현하게 됨.
    //  OrderMapper를 기반으로 메서드와 실제 로직들이 생성될 것이라고 명시하는 것
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "id", constant = "0L")
    Order orderDtoToEntity(OrderDto orderDto);

    @Mapping(target = "img", expression = "java(order.getProduct() + \".jpg\")")
    OrderDto orderToDto(Order order);
}
