package com.g1ee0k.paak_mitra_api.controller;

import com.g1ee0k.paak_mitra_api.dto.JwtResponseWithId;
import com.g1ee0k.paak_mitra_api.dto.Register;
import com.g1ee0k.paak_mitra_api.dto.SignIn;
import com.g1ee0k.paak_mitra_api.exception.InvalidCredentialsException;
import com.g1ee0k.paak_mitra_api.exception.UserExistsException;
import com.g1ee0k.paak_mitra_api.model.RefreshToken;
import com.g1ee0k.paak_mitra_api.model.User;
import com.g1ee0k.paak_mitra_api.repository.JwtRepository;
import com.g1ee0k.paak_mitra_api.repository.UserRepository;
import com.g1ee0k.paak_mitra_api.security.jwt.JwtUtils;
import com.g1ee0k.paak_mitra_api.service.UserService;
import com.g1ee0k.paak_mitra_api.utils.PasswordUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;

    final JwtUtils jwtUtils;

    final JwtRepository jwtRepository;

    public AuthController(UserRepository userRepository, JwtUtils jwtUtils, JwtRepository jwtRepository) {
        this.userRepository = userRepository;
        this.jwtUtils = jwtUtils;
        this.jwtRepository = jwtRepository;
    }

    @PostMapping("/register")
    public JwtResponseWithId register(@Valid @RequestBody Register register) {
        String email = register.getEmail();

        User alreadyExists = userRepository.findByEmail(email);
        if (alreadyExists != null) {
            throw new UserExistsException();
        }

        String hashedPwd = PasswordUtils.hashPassword(register.getPassword());
        User mUser = User.builder()
                .email(register.getEmail())
                .name(register.getName())
                .password(hashedPwd)
                .build();
        User createdUser = userRepository.save(mUser);

        String jwt = jwtUtils.generateJwtToken(register.getEmail(), String.valueOf(createdUser.getUserId()));
        String refreshToken = jwtUtils.generateRefreshToken(register.getEmail());
        RefreshToken refreshTokenObject = RefreshToken.builder().userId(mUser).email(register.getEmail()).refreshToken(refreshToken).name(register.getName()).build();
        jwtRepository.save(refreshTokenObject);
        return new JwtResponseWithId(jwt, refreshToken, register.getName(), register.getEmail(), String.valueOf(createdUser.getUserId()));
    }

    @PostMapping("/signin")
    public JwtResponseWithId signin(@RequestBody SignIn signIn) {
        User mUser = userRepository.findByEmail(signIn.getEmail());
        if (mUser == null)
            throw new InvalidCredentialsException();
        boolean isPasswordCorrect = PasswordUtils.validatePassword(signIn.getPassword(), mUser.getPassword());
        if (!isPasswordCorrect)
            throw new InvalidCredentialsException();
        String jwt = jwtUtils.generateJwtToken(signIn.getEmail(), String.valueOf(mUser.getUserId()));
        String refreshToken = jwtUtils.generateRefreshToken(signIn.getEmail());
        RefreshToken refreshTokenObject = RefreshToken.builder().userId(mUser).email(signIn.getEmail()).refreshToken(refreshToken).name(mUser.getName()).build();
        jwtRepository.save(refreshTokenObject);
        return new JwtResponseWithId(jwt, refreshToken, mUser.getName(), signIn.getEmail(), String.valueOf(mUser.getUserId()));
    }
}
