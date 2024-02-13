package com.example.domy.user;

import com.example.domy.user.dto.UserDto;
import com.example.domy.user.dto.UserRegistrationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{user-id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or #userId == authentication.principal.userId")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "user-id") Long userId) {
        return ResponseEntity.ok(userService.getUserDtoById(userId));
    }

    @GetMapping("/users")
    public ResponseEntity<UserDto> getLoggedInUser(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(userService.getUserDtoById(user.getUserId()));
    }



    @PostMapping("/public/users")
    public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserRegistrationRequest request) {
        return ResponseEntity.created(URI.create("/api/users/" + userService.registerUser(request).getUserId())).build();
    }
}
