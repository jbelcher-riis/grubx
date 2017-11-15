package com.grubx.core.security;

import org.springframework.security.core.Authentication;

public interface SecurityContextAuthenticationRetriever {
    Authentication retrieveAuthenticationFromSecurityContext();
}
