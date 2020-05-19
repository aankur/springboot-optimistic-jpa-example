package com.example.optimisticlocking.controller;

import com.example.optimisticlocking.dto.UserDto;
import com.example.optimisticlocking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = {"/api/v1"})
public class UserController {

  @Autowired
  UserService userService;

  @RequestMapping(value = "/users/new", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public UserDto newUser(@Valid @RequestBody UserDto userDto) {
    return userService.createUser(userDto);
  }

  @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
  public UserDto updateUser(@PathVariable @Valid Long id, @Valid @RequestBody UserDto userDto) {
    return userService.updateUser(id, userDto);
  }

  @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public UserDto updateUser(@PathVariable @Valid Long id) {
    return userService.findUser(id);
  }

}
