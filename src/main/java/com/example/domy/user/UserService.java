package com.example.domy.user;

import com.example.domy.exception.EntityNotFoundException;
import com.example.domy.user.dto.UserDto;
import com.example.domy.user.dto.UserRegistrationRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;


@Service
public class UserService implements UserDetailsService {

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
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new EntityNotFoundException(User.class, "username", username));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Transactional
    public UserDto registerUser(UserRegistrationRequest request) {
        if(userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        } else if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        } else {
            // encoder for password
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            User user = new User();
            user.setUsername(request.getUsername());
            user.setEmail(request.getEmail());
            // password is encoded before saving to the database
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setRoles(Set.of(User.Role.ROLE_USER.name()));

            return userMapper.mapToUserDto(userRepository.save(user));
        }
    }


}
