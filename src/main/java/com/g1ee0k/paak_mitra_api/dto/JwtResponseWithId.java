package com.g1ee0k.paak_mitra_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

interface IJwtResponse {
    String accessToken = "";
    String refreshToken = "";
    String name = "";
    String email = "";
}
@Data
@AllArgsConstructor
public class JwtResponseWithId implements IJwtResponse {
    String accessToken;
    String refreshToken;
    String name;
    String email;
    String id;
}
