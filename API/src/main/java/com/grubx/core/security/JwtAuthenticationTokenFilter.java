package com.grubx.core.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.grubx.core.Daos.UserDao;
import com.grubx.core.repositories.UserRepository;

/**
 * Authenticates user using JWT
 *
 * @author jbelcher
 *
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    // Name of header that holds token
    private static final String TOKEN_HEADER = "Authorization";
    // Issuer of the token
    private static final String ISSUER = "GulpX";

    @Autowired
    private JwtTokenParser jwtTokenParser;

    @Autowired
    private SecurityContextAuthenticationRetrieverImpl securityContextAuthenticationRetriever;

    // Secret coming from application.properties
    @Value("${token.secret}")
    private String tokenSecret;

    @Autowired
    private UserRepository userRepository;

    /**
     * Authenticates user using JWT
     *
     * @author jbelcher
     * @param HttpServletRequest
     *            Client request
     * @param HttpServletResponse
     *            Server response
     * @param FilterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
	    throws IOException, ServletException {
	final String token = request.getHeader(TOKEN_HEADER);

	if (token == null) {
	    chain.doFilter(request, response);
	    return;
	}

	final String email = jwtTokenParser.getEmailFromToken(token);

	if (hasEmailBeenAuthenticated(email)) {
	    final UserDao userEntity = this.userRepository.findOneByEmail(email);

	    final Algorithm algorithm = Algorithm.HMAC256(tokenSecret);
	    final JWTVerifier jwtVerifier = JWT.require(algorithm).withIssuer(ISSUER).withSubject(email).build();

	    try {
		jwtVerifier.verify(jwtTokenParser.stripBearer(token));
		final UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
			userEntity, null, null);
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authentication);

	    } catch (final Exception ex) {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	    }
	}

	chain.doFilter(request, response);

    }

    private boolean hasBeenAuthenticated() {
	return securityContextAuthenticationRetriever.retrieveAuthenticationFromSecurityContext() != null;
    }

    private static boolean hasEmail(String email) {
	return email != null;
    }

    private boolean hasEmailBeenAuthenticated(String email) {
	return hasEmail(email) && !hasBeenAuthenticated();
    }

    /**
     * Sets token secret
     *
     * @param tokenSecret
     *            String
     */
    public void setTokenSecret(String tokenSecret) {
	this.tokenSecret = tokenSecret;
    }
}
