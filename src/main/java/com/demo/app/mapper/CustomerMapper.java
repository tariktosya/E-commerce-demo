package com.demo.app.mapper;

import com.demo.app.dto.request.CustomerRequestDto;
import com.demo.app.dto.response.CustomerResponseDto;
import com.demo.app.entity.CustomerEntity;
import com.demo.app.service.OrderService;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {
        OrderService.class
})
public interface CustomerMapper {
    CustomerEntity toEntity(CustomerRequestDto customerRequestDto);
    CustomerResponseDto toDto(CustomerEntity customer);
    List<CustomerResponseDto> toDtoList(List<CustomerEntity> customerEntities);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CustomerEntity update(CustomerRequestDto customerRequestDto, @MappingTarget CustomerEntity customer);

}
