package com.g1ee0k.paak_mitra_api.repository;

import com.g1ee0k.paak_mitra_api.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtRepository extends JpaRepository<RefreshToken, String> {
    RefreshToken getRefreshTokenByEmailAndRefreshToken(String email, String refreshToken);

    void deleteRefreshTokenByEmailAndRefreshToken(String email, String refreshToken);
}
