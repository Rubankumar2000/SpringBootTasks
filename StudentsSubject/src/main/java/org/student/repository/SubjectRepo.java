package org.student.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.student.model.Student;
import org.student.model.Subject;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Integer> {
	

}
