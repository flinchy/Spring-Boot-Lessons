package com.chisom.spring_security_jwt_RBA.web;

import com.chisom.spring_security_jwt_RBA.Services.MapValidationErrorService;
import com.chisom.spring_security_jwt_RBA.Services.UserService;
import com.chisom.spring_security_jwt_RBA.model.User;
import com.chisom.spring_security_jwt_RBA.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser (@Valid @RequestBody User user, BindingResult result) {
        //Validate passwords match
        userValidator.validate(user, result) ;

        ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
        if(errorMap != null) return errorMap;

        User newUser = userService.saveUser(user);
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);

    }
}
