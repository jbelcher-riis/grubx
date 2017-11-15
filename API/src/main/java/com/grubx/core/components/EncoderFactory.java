package com.grubx.core.components;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public interface EncoderFactory {
    BCryptPasswordEncoder makeEncoder();
}
