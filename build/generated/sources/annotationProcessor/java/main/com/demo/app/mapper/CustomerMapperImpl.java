package com.demo.app.mapper;

import com.demo.app.dto.request.CustomerRequestDto;
import com.demo.app.dto.response.CustomerResponseDto;
import com.demo.app.dto.response.OrderResponseDto;
import com.demo.app.entity.CustomerEntity;
import com.demo.app.entity.OrderEntity;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-02T15:58:58+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerEntity toEntity(CustomerRequestDto customerRequestDto) {
        if ( customerRequestDto == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setName( customerRequestDto.name() );
        customerEntity.setAge( customerRequestDto.age() );

        return customerEntity;
    }

    @Override
    public CustomerResponseDto toDto(CustomerEntity customer) {
        if ( customer == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        Integer age = null;
        Set<OrderResponseDto> orderList = null;

        id = customer.getId();
        name = customer.getName();
        age = customer.getAge();
        orderList = orderEntitySetToOrderResponseDtoSet( customer.getOrderList() );

        CustomerResponseDto customerResponseDto = new CustomerResponseDto( id, name, age, orderList );

        return customerResponseDto;
    }

    @Override
    public List<CustomerResponseDto> toDtoList(List<CustomerEntity> customerEntities) {
        if ( customerEntities == null ) {
            return null;
        }

        List<CustomerResponseDto> list = new ArrayList<CustomerResponseDto>( customerEntities.size() );
        for ( CustomerEntity customerEntity : customerEntities ) {
            list.add( toDto( customerEntity ) );
        }

        return list;
    }

    @Override
    public CustomerEntity update(CustomerRequestDto customerRequestDto, CustomerEntity customer) {
        if ( customerRequestDto == null ) {
            return null;
        }

        if ( customerRequestDto.name() != null ) {
            customer.setName( customerRequestDto.name() );
        }
        if ( customerRequestDto.age() != null ) {
            customer.setAge( customerRequestDto.age() );
        }

        return customer;
    }

    protected OrderResponseDto orderEntityToOrderResponseDto(OrderEntity orderEntity) {
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

    protected Set<OrderResponseDto> orderEntitySetToOrderResponseDtoSet(Set<OrderEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<OrderResponseDto> set1 = new HashSet<OrderResponseDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OrderEntity orderEntity : set ) {
            set1.add( orderEntityToOrderResponseDto( orderEntity ) );
        }

        return set1;
    }
}
