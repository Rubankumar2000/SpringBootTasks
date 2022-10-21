package com.dbexample.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dbexample.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//	String raw="select * from employees where eid=?1 and employee_name=?2";
	@Query(nativeQuery = true,value = "select * from employees where eid=?1")
	List<Employee> getId(int id,String ename);
	
	@Query("select e from Employee e where eID=?1")
	List<Employee> getEmp(int id);
	
	@Query("select e from Employee e")
	List<Employee> getAll();
	
	@Modifying
	@Query(value="insert into employees(eid,employee_name,department) values(?1,?2,?3)",nativeQuery=true)
	@Transactional
	void saveEmp(int eID, String eName,String dept);
	
	@Modifying
	@Query(value="delete from employees where eid=?1",nativeQuery = true )
	@Transactional
	void delEmp(int id);
	
	@Modifying
	@Query(nativeQuery = true,value = "update employees set eid=?1,employee_name=?2,department=?3 where eid=23")
	@Transactional
	void updateEmp(int eID,String eName,String dept);
	
	@Modifying
	@Query(value = "create table employees1(eID int,eName varchar(20),dept varchar(20))",nativeQuery = true)
	@Transactional
	void createEmp1();
	
	@Modifying
	@Query(value="drop table employees1",nativeQuery = true)
	@Transactional
	void dropEmp1();

	List<Employee> findAllByDeptInAndEName(List<String> dept,String eName);
}
