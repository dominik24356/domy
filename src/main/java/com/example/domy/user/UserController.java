package com.example.domy.user;

import com.example.domy.user.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{user-id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "user-id") Long userId) {
        return ResponseEntity.ok(userService.getUserDtoById(userId));
    }

}
