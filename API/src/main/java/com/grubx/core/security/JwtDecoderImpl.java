package com.grubx.core.security;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component
public class JwtDecoderImpl implements JwtDecoder {

    @Override
    public DecodedJWT decode(String token) throws JWTDecodeException {
	return JWT.decode(token);
    }

}
