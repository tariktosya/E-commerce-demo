package com.demo.app.service;

import com.demo.app.dto.request.CustomerRequestDto;
import com.demo.app.dto.response.CustomerResponseDto;
import com.demo.app.entity.CustomerEntity;
import com.demo.app.exception.CustomException;
import com.demo.app.exception.ErrorCode;
import com.demo.app.mapper.CustomerMapper;
import com.demo.app.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerResponseDto findById(Long id){
        return customerMapper.toDto(
                customerRepository.findById(id)
                        .orElseThrow(() -> new CustomException(ErrorCode.GNR_0001)));
    }

    public CustomerEntity getEntityById(Long id){
        return customerRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.GNR_0001));
    }
    public List<CustomerResponseDto> getAll(){
        return customerMapper.toDtoList(
                customerRepository.findAll());
    }

    public CustomerResponseDto save(CustomerRequestDto customerRequestDto){
        return customerMapper.toDto(
                customerRepository.save(
                        customerMapper.toEntity(customerRequestDto)));
    }

    public CustomerResponseDto update(Long id, CustomerRequestDto customerRequestDto){
        CustomerEntity customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.GNR_0001));

        return customerMapper.toDto(
                customerRepository.save(
                        customerMapper.update(customerRequestDto, customer)));
    }

    public void delete(Long id){
        CustomerEntity customer = customerRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.GNR_0001));
        customerRepository.delete(customer);
    }

    public List<CustomerResponseDto> getByNameLike(String name){
        return customerMapper.toDtoList(customerRepository.getAllByNameLike("%" + name + "%"));
    }

    public List<CustomerResponseDto> getByOrderListIsNull(){
        return customerMapper.toDtoList(customerRepository.getCustomerByOrderListIsNull());
    }
}
