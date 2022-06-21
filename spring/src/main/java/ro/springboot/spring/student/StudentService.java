package ro.springboot.spring.student;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ro.springboot.spring.exception.ApiRequestException;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public void saveStudent(Student student) {
		Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
		if (studentByEmail.isPresent()) {
			throw new ApiRequestException("student email exist");
		}
		studentRepository.save(student);
	}

	public void deleteStudentById(Long id) {
		boolean existStudent = studentRepository.existsById(id);
		if (!existStudent) {
			throw new ApiRequestException("student id " + id + " dont exist");
		}
		studentRepository.deleteById(id);
	}

}
