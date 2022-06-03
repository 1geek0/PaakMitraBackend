package com.g1ee0k.paak_mitra_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignIn {
    private String email;
    private String password;
}
