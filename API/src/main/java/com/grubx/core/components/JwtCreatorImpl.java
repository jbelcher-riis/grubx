package com.grubx.core.components;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.grubx.core.Daos.UserDao;

@Component
public class JwtCreatorImpl implements JwtCreator {

    private static final int EXPIRE_MILLISECONDS = 7200000;

    @Value("${token.secret}")
    private String tokenSecret;

    @Override
    public String makeJwt(UserDao user) throws UnsupportedEncodingException {
	final Algorithm algorithm = Algorithm.HMAC256(tokenSecret);
	return JWT.create().withIssuer("GulpX").withSubject(user.getEmail())
		.withExpiresAt(new Date(generateExpirationDate())).sign(algorithm);
    }

    private long generateExpirationDate() {
	final long nowMilliseconds = new Date().getTime();

	return nowMilliseconds + EXPIRE_MILLISECONDS;

    }

}
