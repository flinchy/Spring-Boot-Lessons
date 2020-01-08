package com.chisom.spring_security_jwt_RBA.Services;

import com.chisom.spring_security_jwt_RBA.model.User;
import com.chisom.spring_security_jwt_RBA.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser (User newUser) {
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));

        //make sure that the email is unique
        //make sure that the password and confirmPassword match
        //we do not persist the confirmPassword

        return userRepository.save(newUser);
    }
}
