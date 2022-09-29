package com.gilbert.modern.MapStruct;

import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OrderMapperTest {

    @Test
    @DisplayName("DTO에서 Entity로 변환하는 테스트")
    void test_dto_to_entity() {
        //given
        final OrderDto orderDto = OrderDto.builder()
            .name("테스트")
            .product("음료수")
            .price(1000)
            .address("Seoul")
            .orderedTime(LocalDateTime.now())
            .build();

        // when
        final Order order = OrderMapper.INSTANCE.orderDtoToEntity(orderDto);

        // then
        assertNotNull(order);
        assertThat(order.getName()).isEqualTo("테스트");
    }

    @Test
    @DisplayName("Entity에서 DTO로 변환하는 테스트")
    void test_entity_to_dto() {
        //given
        final Order order = Order.builder()
            .id(1L)
            .name("테스트")
            .product("음료수")
            .price(1000)
            .address("Seoul")
            .orderedTime(LocalDateTime.now())
            .build();

        //when
        final OrderDto orderDto = OrderMapper.INSTANCE.orderToDto(order);

        //then
        assertNotNull(orderDto);
        assertThat(orderDto.getName()).isEqualTo("테스트");

    }
}