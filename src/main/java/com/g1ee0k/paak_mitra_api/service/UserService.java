package com.g1ee0k.paak_mitra_api.service;

import com.g1ee0k.paak_mitra_api.model.User;

import java.util.List;

public interface UserService {
    // Create operation
    User saveUser(User user);

    // Read operation
    List<User> fetchUsers();

    boolean userExists(String email);
}
