package com.kozdemir.backend.service;

import com.kozdemir.backend.dto.UserCreateDTO;
import com.kozdemir.backend.dto.UserViewDTO;



public interface UserService {

    UserViewDTO getUserById(Long id) ;

    UserViewDTO createUSer(UserCreateDTO userCreateDTO);
}
