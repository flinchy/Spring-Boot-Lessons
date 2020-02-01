package com.chisom.spring_security_jwt_RBA.repository;

import com.chisom.spring_security_jwt_RBA.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByDepartmentName(String departmentName);

    Iterable<Department> findAllByCreator(String username);

    Department getById(Long id);

    Department findBySlug(String slug);
}
