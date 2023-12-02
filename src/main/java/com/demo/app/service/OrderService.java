package com.demo.app.service;

import com.demo.app.dto.request.OrderRequestDto;
import com.demo.app.dto.response.OrderResponseDto;
import com.demo.app.entity.OrderEntity;
import com.demo.app.exception.CustomException;
import com.demo.app.exception.ErrorCode;
import com.demo.app.mapper.OrderMapper;
import com.demo.app.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderResponseDto findById(Long id){
        return orderMapper.toDto(
                orderRepository.findById(id)
                        .orElseThrow(() -> new CustomException(ErrorCode.GNR_0001)));
    }
    public List<OrderResponseDto> getAll(){
        return orderMapper.toDtoList(
                orderRepository.findAll());
    }

    public OrderResponseDto save(OrderRequestDto orderRequestDto){
        return orderMapper.toDto(
                orderRepository.save(
                        orderMapper.toEntity(orderRequestDto)));
    }

    public OrderResponseDto update(Long id, OrderRequestDto orderRequestDto){
        OrderEntity order = orderRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.GNR_0001));

        return orderMapper.toDto(
                orderRepository.save(
                        orderMapper.update(orderRequestDto, order)));
    }

    public void delete(Long id){
        OrderEntity order = orderRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.GNR_0001));
        orderRepository.delete(order);
    }

    public List<OrderResponseDto> getByCreateDate(Instant date){
        return orderMapper.toDtoList(orderRepository.findByCreateDateGreaterThanOrderByCreateDateDesc(date));
    }
}
