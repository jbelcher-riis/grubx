package com.grubx.core.security;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtTokenParser implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7168081630663233001L;

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenParser.class);

    @Autowired
    private JwtDecoder jwtDecoder;

    /**
     * returns email address from JWT
     *
     * @author jbelcher
     * @param token
     *            JWT token with Bearer prefix
     * @return email addess
     */
    public String getEmailFromToken(String token) {
	String email;
	try {
	    final DecodedJWT decodedJwt = jwtDecoder.decode(stripBearer(token));
	    email = decodedJwt.getSubject();
	} catch (final Exception e) {
	    LOGGER.info(e.getMessage(), e);
	    email = null;
	}
	return email;
    }

    /**
     * Strips Bearer from JWT
     *
     * @author jbelcher
     * @param token
     *            with Bearer prefix
     * @return token without Bearer
     */
    public String stripBearer(String token) {
	return token.replace("Bearer ", "");
    }

}
