package com.example.optimisticlocking.service;

import com.example.optimisticlocking.dto.UserDto;
import com.example.optimisticlocking.entity.User;
import com.example.optimisticlocking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  UserDto convertUserDto(@NonNull User user) {
    UserDto out = new UserDto();
    out.setName(user.getName());
    out.setVersion(user.getVersion());
    out.setId(user.getId());
    return out;
  }

  public UserDto createUser(@NonNull UserDto userDto) {
    User user = new User();
    user.setName(userDto.getName());
    user = userRepository.save(user);
    return convertUserDto(user);
   }

  public UserDto updateUser(@NonNull Long id, @NonNull  UserDto userDto) {
    User user = new User();
    user.setId(id);
    user.setVersion(userDto.getVersion());
    user.setName(userDto.getName());
    user = userRepository.save(user);
    return convertUserDto(user);
  }

  public UserDto findUser(@NonNull Long id) {
    return convertUserDto(userRepository.findById(id).get());
  }
}
