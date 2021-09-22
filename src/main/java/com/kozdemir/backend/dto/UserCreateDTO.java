package com.kozdemir.backend.dto;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class UserCreateDTO {

  //  @Size(min=4, max=32, message="")
    private String firstName;

  // @Size(min=4, max=32, message="")
    private String lastName;

}
