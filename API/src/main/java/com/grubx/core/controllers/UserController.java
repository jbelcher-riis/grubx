package com.grubx.core.controllers;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.grubx.core.Dtos.LoginResponseDto;
import com.grubx.core.Dtos.NewUserDto;
import com.grubx.core.Services.UserService;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public @ResponseBody LoginResponseDto createNewUser(@RequestBody NewUserDto newUser)
	    throws UnsupportedEncodingException {
	return userService.save(newUser);
    }

}
