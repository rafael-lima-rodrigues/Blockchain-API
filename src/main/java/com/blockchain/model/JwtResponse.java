package com.blockchain.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String jwtToken;

    public JwtResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }
}
