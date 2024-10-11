package com.skyler.mybible_api.user.repo;

import com.skyler.mybible_api.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
