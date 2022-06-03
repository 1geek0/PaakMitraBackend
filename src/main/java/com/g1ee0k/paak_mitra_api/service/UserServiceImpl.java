package com.g1ee0k.paak_mitra_api.service;

import com.g1ee0k.paak_mitra_api.model.User;
import com.g1ee0k.paak_mitra_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean userExists(String email) {
        return userRepository.findByEmail(email) != null;
    }
}
