package com.demo.app.controller;

import com.demo.app.dto.request.CustomerRequestDto;
import com.demo.app.dto.response.CustomerResponseDto;
import com.demo.app.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<CustomerResponseDto> getAll(){
        return customerService.getAll();
    }

    @PostMapping
    public CustomerResponseDto save(@RequestBody CustomerRequestDto customerRequestDto){
        return customerService.save(customerRequestDto);
    }

    @PutMapping
    public CustomerResponseDto update(@RequestParam Long id,
                                      @RequestBody CustomerRequestDto customerRequestDto){
        return customerService.update(id, customerRequestDto);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
        customerService.delete(id);
    }

    @GetMapping("/get-by-id")
    public CustomerResponseDto getById(@RequestParam Long id){
        return customerService.findById(id);
    }

    @GetMapping("/get-by-name-like")
    public List<CustomerResponseDto> getByNameLike(@RequestParam String name){
        return customerService.getByNameLike(name);
    }

    @GetMapping("/get-by-order")
    public List<CustomerResponseDto> getByOrder(){
        return customerService.getByOrderListIsNull();
    }
}
