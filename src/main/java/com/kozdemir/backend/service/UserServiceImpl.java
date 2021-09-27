package com.kozdemir.backend.service;

import com.kozdemir.backend.dto.UserCreateDTO;
import com.kozdemir.backend.dto.UserUpdateDTO;
import com.kozdemir.backend.dto.UserViewDTO;
import com.kozdemir.backend.model.User;
import com.kozdemir.backend.repository.UserRepository;
import com.kozdemir.backend.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public UserViewDTO getUserById(Long id) throws NotFoundException {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not Found Exception"));
        return UserViewDTO.of(user) ;
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<UserViewDTO> getUsers() {
        return userRepository.findAll().stream().map(UserViewDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
        final User user = userRepository.save(new User(userCreateDTO.getFirstName(),userCreateDTO.getLastName()));
        return UserViewDTO.of(user);

    }

    @Override
    @Transactional
    public UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        //User controller; Ja oder Nein
        final User user = userRepository.findById(id).orElseThrow(()->new NotFoundException("Not Found Exception"));

        //Keine Exception danach Update
        user.setFistName(userUpdateDTO.getFirstName());
        user.setLastName(userUpdateDTO.getLastName());

        final User updatedUser = userRepository.save(user);

        return UserViewDTO.of(updatedUser);
    }
}
