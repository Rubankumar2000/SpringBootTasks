package org.rest.serviceimpl;

import java.util.List;

import org.rest.model.Student;
import org.rest.repository.StudentRepository;
import org.rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	RestTemplate restTemplate = new RestTemplate();

	@Override
	public List<Student> saveAllStudent(List<Student> students) {
		return studentRepository.saveAll(students);
	}

	@Override
	public ResponseEntity<Student> getAll() {
//		studentRepository.findAll();
		return new ResponseEntity(studentRepository.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Student[]> saveRest(List<Student> students) {
		String url = "http://192.168.0.56:9090/student/saveStudents";
		return restTemplate.postForEntity(null, url, null);
	}

	@Override
	public String deleteRest(int id) throws Exception {
		String url = "http://192.168.0.57:9090/student/delete/{student_id}";
		restTemplate.delete(url, 6);
		return "Deleted Successfully";

	}

	@Scheduled(fixedDelay = 10000, initialDelay = 5000)
	// @Scheduled(cron = "0 */5 * * * *")
	public String getAllDetails() throws Exception {
		try {
			String url = "http://192.168.0.57:9090/student/jenova/get";
			Student[] student = restTemplate.getForObject(url, Student[].class);
			int id = 0;
			if (student.length > 0) {
				id = student[0].getStudent_id();
				System.out.println(id);
				return this.deleteRest(id);
			} else {
				System.out.println("No Data found...");
				return "No Data Found...";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage() + ", Call by Ruban";
			// throw new RubanFileException(", Call by Ruban");
			// throw e;
		}

	}

}
