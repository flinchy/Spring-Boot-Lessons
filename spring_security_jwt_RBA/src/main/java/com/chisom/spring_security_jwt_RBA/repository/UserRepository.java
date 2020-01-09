package com.chisom.spring_security_jwt_RBA.repository;

import com.chisom.spring_security_jwt_RBA.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
//    Optional<User> findByUsername(String username);
    User getById(Long id);
}
