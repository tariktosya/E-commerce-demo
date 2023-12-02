package com.demo.app.mapper;

import com.demo.app.dto.request.OrderRequestDto;
import com.demo.app.dto.response.OrderResponseDto;
import com.demo.app.entity.OrderEntity;
import com.demo.app.service.CustomerService;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {
        CustomerService.class
})
public interface OrderMapper {
    @Mapping(target = "customer", source = "customerId")
    OrderEntity toEntity(OrderRequestDto orderRequestDto);
    OrderResponseDto toDto(OrderEntity orderEntity);
    List<OrderResponseDto> toDtoList(List<OrderEntity> orderEntities);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OrderEntity update(OrderRequestDto orderRequestDto, @MappingTarget OrderEntity order);

}
