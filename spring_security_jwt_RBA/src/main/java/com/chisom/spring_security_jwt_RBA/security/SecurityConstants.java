package com.chisom.spring_security_jwt_RBA.security;

public class SecurityConstants {


    public static final String SIGN_UP_URLS = "/api/v1/users/**";
    public static final String H2_URL = "/h2/**";
    /**
     * We will build our token with the below constants
     */
    public static final String SECRET = "secretKeyToGenerateJWTs";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final long EXPIRATION_TIME = 300_000;
}
