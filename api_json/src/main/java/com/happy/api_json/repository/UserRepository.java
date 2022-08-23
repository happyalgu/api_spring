package com.happy.api_json.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.happy.api_json.user.ERole;
import com.happy.api_json.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
 
}
