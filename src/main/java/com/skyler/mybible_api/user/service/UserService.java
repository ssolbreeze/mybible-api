package com.skyler.mybible_api.user.service;

import com.skyler.mybible_api.user.entity.User;
import com.skyler.mybible_api.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User save(User user) {
        User newUser = userRepository.save(user);
        return newUser;

    }

    @Transactional
    public User getUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Transactional
    public List<User> getUserList() {
        return userRepository.findAll();
    }
}
