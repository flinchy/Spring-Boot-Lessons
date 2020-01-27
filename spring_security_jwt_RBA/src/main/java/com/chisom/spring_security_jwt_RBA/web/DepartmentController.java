package com.chisom.spring_security_jwt_RBA.web;

import com.chisom.spring_security_jwt_RBA.Services.DepartmentService;
import com.chisom.spring_security_jwt_RBA.Services.MapValidationErrorService;
import com.chisom.spring_security_jwt_RBA.model.Department;
import com.chisom.spring_security_jwt_RBA.model.User;
import com.chisom.spring_security_jwt_RBA.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewDepartment(@Valid @RequestBody Department department,
                                                 BindingResult result, Principal principal) {

        ResponseEntity<?> errMap = mapValidationErrorService.mapValidationService(result);
        if(errMap != null) return errMap;

        departmentService.saveOrUpdateDepartment(department, principal.getName());
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @GetMapping("/{department_slug}")
    public ResponseEntity<?> getDepartmentBySlug(@PathVariable String department_slug) {
        Department department = departmentService.findDepartmentBySlug(department_slug);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @GetMapping("")
    public Iterable<?> getAllDepartments(Principal principal) {
        return departmentRepository.findAllByCreator(principal.getName());
    }

    @PostMapping("/{department_slug}")
    public ResponseEntity<?> addMemberToDepartment(@Valid @RequestBody User user, BindingResult result,
                                                   @PathVariable String slug, Principal principal) {

        ResponseEntity<?> errMap = mapValidationErrorService.mapValidationService(result);
        if(errMap != null) return errMap;

        return null;
    }
}
