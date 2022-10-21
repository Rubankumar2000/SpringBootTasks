package org.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.student.dto.OrderDto;
import org.student.model.Student;
import org.student.model.Subject;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

	@Query(nativeQuery = true,value = "Select org.student.dto.OrderDto(s.stuId,s.name,s.address,sub.subName) from student s join s.subject sub")
	List<OrderDto> orderBy();
}
