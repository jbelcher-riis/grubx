package com.grubx.core.components;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncoderFactoryImpl implements EncoderFactory {

    @Override
    public BCryptPasswordEncoder makeEncoder() {
	return new BCryptPasswordEncoder();
    }

}
