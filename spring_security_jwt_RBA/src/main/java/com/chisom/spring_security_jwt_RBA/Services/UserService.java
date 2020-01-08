package com.chisom.spring_security_jwt_RBA.Services;

import com.chisom.spring_security_jwt_RBA.exceptions.UsernameAlreadyExistsException;
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

        try {
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));

            //make sure that the email is unique
            newUser.setEmail(newUser.getEmail());
            //make sure that the password and confirmPassword match
            //we do not persist the confirmPassword
            newUser.setConfirmPassword("");
            return userRepository.save(newUser);

        } catch (Exception ex) {
            throw new UsernameAlreadyExistsException("Email '" + newUser.getEmail() +"' already exists");
        }

    }
}
