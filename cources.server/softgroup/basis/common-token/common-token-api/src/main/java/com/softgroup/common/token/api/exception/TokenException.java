package com.softgroup.common.token.api.exception;

import io.jsonwebtoken.JwtException;

/**
 * Created by zigza on 31.03.2017.
 */
public class TokenException extends JwtException {
    public TokenException(String message) {
        super(message);
    }

    public TokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
