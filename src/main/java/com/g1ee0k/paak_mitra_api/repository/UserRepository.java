package com.g1ee0k.paak_mitra_api.repository;

import com.g1ee0k.paak_mitra_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
