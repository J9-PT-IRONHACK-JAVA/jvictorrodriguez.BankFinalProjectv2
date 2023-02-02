package com.ironhack.bankproject.user.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Address {
    @Size(min = 2)
    @NotBlank(message = "Street should be valid")
    private String street;
    @NotBlank(message = "CP should be valid")
    private String code;
    @NotBlank(message = "City should be valid")
    private String city;
    @NotBlank(message = "Country should be valid")
    private String country;

//todo no respeta estas validaciones
}
