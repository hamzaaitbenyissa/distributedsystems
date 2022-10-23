package com.benyissa.costumerservice.mappers;


import com.benyissa.costumerservice.DTOs.CustomerRequestDTO;
import com.benyissa.costumerservice.DTOs.CustomerResponseDTO;
import com.benyissa.costumerservice.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);

    Customer customerReuestDTOTocustomer(CustomerRequestDTO customerRequestDTO);


}
