package com.kozdemir.backend.api;

import com.kozdemir.backend.dto.UserCreateDTO;
import com.kozdemir.backend.dto.UserViewDTO;
import com.kozdemir.backend.service.UserService;
import com.kozdemir.backend.shared.GenericResponse;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserApi {

    private final UserService userService;

    @GetMapping("v1/user/{id}")
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable Long id) throws NotFoundException {
        final UserViewDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("v1/user")
    public ResponseEntity<?> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        userService.createUSer(userCreateDTO);
        return ResponseEntity.ok(new GenericResponse("User Created..."));
    }


}
