package com.grubx.core.controllers;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.grubx.core.Dtos.LoginRequestDto;
import com.grubx.core.Dtos.LoginResponseDto;
import com.grubx.core.Services.AuthService;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthenticationController {

    @Autowired
    AuthService authService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public @ResponseBody LoginResponseDto login(@RequestBody LoginRequestDto loginRequest)
	    throws UnsupportedEncodingException {
	return authService.login(loginRequest);
    }
}
