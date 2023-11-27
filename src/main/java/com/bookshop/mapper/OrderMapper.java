package com.bookshop.mapper;

import com.bookshop.config.MapperConfig;
import com.bookshop.dto.order.OrderResponseDto;
import com.bookshop.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface OrderMapper {
    @Mapping(source = "user.id", target = "userId")
    OrderResponseDto toDto(Order order);
}
