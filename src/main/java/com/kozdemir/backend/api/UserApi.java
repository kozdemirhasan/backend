package com.kozdemir.backend.api;

import com.kozdemir.backend.dto.UserCreateDTO;
import com.kozdemir.backend.dto.UserUpdateDTO;
import com.kozdemir.backend.dto.UserViewDTO;
import com.kozdemir.backend.service.UserService;
import com.kozdemir.backend.shared.GenericResponse;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("v1/user")
    public ResponseEntity<List<UserViewDTO>> getUsers() {
        final List<UserViewDTO> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }


    @PostMapping("v1/user")
    public ResponseEntity<?> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        userService.createUser(userCreateDTO);
        return ResponseEntity.ok(new GenericResponse("User Created..."));
    }

    @PutMapping("v1/user/{id}")
    public ResponseEntity<UserViewDTO> updateUser(@PathVariable("id") Long id, @RequestBody UserUpdateDTO userUpdateDTO) {
        final UserViewDTO user = userService.updateUser(id, userUpdateDTO);
        return ResponseEntity.ok(user);
    }


}
