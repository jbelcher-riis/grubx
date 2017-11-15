package com.grubx.core.security;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

public interface JwtDecoder {
    DecodedJWT decode(String token) throws JWTDecodeException;
}
