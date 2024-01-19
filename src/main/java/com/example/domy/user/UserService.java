package com.example.domy.user;

import com.example.domy.exception.EntityNotFoundException;
import com.example.domy.user.dto.UserDto;
import org.springframework.stereotype.Service;



@Service
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto getUserDtoById(Long userId) {
        return  userMapper.mapToUserDto(getUserById(userId));
    }

    public User getUserById(Long userId) {
        return  userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(User.class, "id", userId.toString()));
    }
}
