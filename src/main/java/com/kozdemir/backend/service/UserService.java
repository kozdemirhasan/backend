package com.kozdemir.backend.service;

import com.kozdemir.backend.dto.UserCreateDTO;
import com.kozdemir.backend.dto.UserUpdateDTO;
import com.kozdemir.backend.dto.UserViewDTO;

import java.util.List;


public interface UserService {

    UserViewDTO getUserById(Long id) ;

    List<UserViewDTO> getUsers();

    UserViewDTO createUser(UserCreateDTO userCreateDTO);


    UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO);
}
