package com.grubx.core.components;

import java.io.UnsupportedEncodingException;

import com.grubx.core.Daos.UserDao;

public interface JwtCreator {
    String makeJwt(UserDao user) throws UnsupportedEncodingException;
}
