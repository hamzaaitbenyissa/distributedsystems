package com.benyissa.costumerservice.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestDTO {
    String name;
    String email;
}
