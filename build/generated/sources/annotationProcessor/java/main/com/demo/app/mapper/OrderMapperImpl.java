package com.demo.app.mapper;

import com.demo.app.dto.request.OrderRequestDto;
import com.demo.app.dto.response.OrderResponseDto;
import com.demo.app.entity.OrderEntity;
import com.demo.app.service.CustomerService;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-02T16:09:53+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    private final CustomerService customerService;

    @Autowired
    public OrderMapperImpl(CustomerService customerService) {

        this.customerService = customerService;
    }

    @Override
    public OrderEntity toEntity(OrderRequestDto orderRequestDto) {
        if ( orderRequestDto == null ) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setCustomer( customerService.getEntityById( orderRequestDto.customerId() ) );
        orderEntity.setTotalPrice( orderRequestDto.totalPrice() );

        return orderEntity;
    }

    @Override
    public OrderResponseDto toDto(OrderEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }

        Long id = null;
        Instant createDate = null;
        Double totalPrice = null;

        id = orderEntity.getId();
        createDate = orderEntity.getCreateDate();
        totalPrice = orderEntity.getTotalPrice();

        OrderResponseDto orderResponseDto = new OrderResponseDto( id, createDate, totalPrice );

        return orderResponseDto;
    }

    @Override
    public List<OrderResponseDto> toDtoList(List<OrderEntity> orderEntities) {
        if ( orderEntities == null ) {
            return null;
        }

        List<OrderResponseDto> list = new ArrayList<OrderResponseDto>( orderEntities.size() );
        for ( OrderEntity orderEntity : orderEntities ) {
            list.add( toDto( orderEntity ) );
        }

        return list;
    }

    @Override
    public OrderEntity update(OrderRequestDto orderRequestDto, OrderEntity order) {
        if ( orderRequestDto == null ) {
            return null;
        }

        if ( orderRequestDto.totalPrice() != null ) {
            order.setTotalPrice( orderRequestDto.totalPrice() );
        }

        return order;
    }
}
