package com.demo.app.controller;

import com.demo.app.dto.request.OrderRequestDto;
import com.demo.app.dto.response.OrderResponseDto;
import com.demo.app.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<OrderResponseDto> getAll(){
        return orderService.getAll();
    }

    @PostMapping
    public OrderResponseDto save(@RequestBody OrderRequestDto orderRequestDto){
        return orderService.save(orderRequestDto);
    }

    @PutMapping
    public OrderResponseDto update(@RequestParam Long id,
                                      @RequestBody OrderRequestDto orderRequestDto){
        return orderService.update(id, orderRequestDto);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
        orderService.delete(id);
    }

    @GetMapping("/get-by-id")
    public OrderResponseDto getById(@RequestParam Long id){
        return orderService.findById(id);
    }

    @GetMapping("/get-by-date")
    public List<OrderResponseDto> getByDate(@RequestParam Instant date){
        return orderService.getByCreateDate(date);
    }

}
