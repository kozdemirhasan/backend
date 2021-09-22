package com.kozdemir.backend.service;

import com.kozdemir.backend.dto.UserCreateDTO;
import com.kozdemir.backend.dto.UserViewDTO;
import com.kozdemir.backend.model.User;
import com.kozdemir.backend.repository.UserRepository;
import com.kozdemir.backend.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserViewDTO getUserById(Long id) throws NotFoundException {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not Found Exception"));
        return UserViewDTO.of(user) ;
    }

    @Override
    public UserViewDTO createUSer(UserCreateDTO userCreateDTO) {
        final User user = userRepository.save(new User(userCreateDTO.getFirstName(),userCreateDTO.getLastName()));
        return UserViewDTO.of(user);

    }
}
