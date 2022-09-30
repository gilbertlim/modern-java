package com.gilbert.modern.MapStruct;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;

    @EventListener(ApplicationStartedEvent.class)
    public List<OrderDto> getOrders() {
        log.info("===== MapStruct =====");

        List<Order> orders = Arrays.asList(new Order(1L, "test1", "콜라", 1000, "111-1", LocalDateTime.now()),
            new Order(2L, "test2", "빵", 1000, "111-1", LocalDateTime.now()),
            new Order(3L, "test3", "커피", 1000, "111-1", LocalDateTime.now()));

        List<OrderDto> orderDtos = orders.stream().map(orderMapper::orderToDto).toList();

        orderDtos.forEach(o -> log.debug(o.getProduct()));

        return orderDtos;
    }

}
