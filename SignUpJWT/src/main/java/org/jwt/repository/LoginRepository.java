package org.jwt.repository;

import org.jwt.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Student, Integer>{

	Student findByEmailEqualsIgnoreCaseAndPassword(String email, String password);

}
