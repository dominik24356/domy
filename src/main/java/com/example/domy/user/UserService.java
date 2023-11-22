package com.example.domy.user;

import com.example.domy.user.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.getByUserId(id).orElseThrow(() -> new UserNotFoundException(id));
    }
}
