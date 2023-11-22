package com.example.domy.user;

import com.example.domy.user.dto.UserDto;
import com.example.domy.user.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto getUserById(Long id) {
        return  userMapper.mapToUserDto(userRepository.getByUserId(id).orElseThrow(() -> new UserNotFoundException(id)));
    }
}
