package com.chisom.spring_security_jwt_RBA.Services;

import com.chisom.spring_security_jwt_RBA.exceptions.DepartmentNotFoundException;
import com.chisom.spring_security_jwt_RBA.model.Department;
import com.chisom.spring_security_jwt_RBA.model.User;
import com.chisom.spring_security_jwt_RBA.repository.DepartmentRepository;
import com.chisom.spring_security_jwt_RBA.repository.UserRepository;
import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    UserRepository userRepository;

    public Department saveOrUpdateDepartment(Department department, String username) {

        Slugify slg = new Slugify();
        String shortUUID =  Long.toHexString(Double.doubleToLongBits(Math.random()));
        department.setSlug(slg.slugify(department.getDepartmentName() +"-"+ shortUUID));

        User user = userRepository.findByUsername(username);
        department.setCreator(user.getFullname());

        return departmentRepository.save(department);
    }

    public Department findDepartmentBySlug(String departmentSlug) {

        Department department = departmentRepository.findBySlug(departmentSlug.toLowerCase());
        if(department == null) {
            throw new DepartmentNotFoundException("Department with slug '" +departmentSlug+"' does not exist" );
        }

        return department;
    }

//    public Department addUser(String departmentSlug, User user ) {
//        //check to see if the department slug exist
//        Department department =
//        //check to see if the user already already exists in the department
//        //add the user to department
//    }
}
