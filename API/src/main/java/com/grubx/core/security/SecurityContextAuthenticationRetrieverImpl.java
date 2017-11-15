package com.grubx.core.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityContextAuthenticationRetrieverImpl implements SecurityContextAuthenticationRetriever {

    @Override
    public Authentication retrieveAuthenticationFromSecurityContext() {
	return SecurityContextHolder.getContext().getAuthentication();
    }

}
