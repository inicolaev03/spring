package ro.springboot.spring.student;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			Student testStudent = new Student("Test", "test@gmail.com", LocalDate.now().minusYears(7));
			studentRepository.save(testStudent);
		};
	}
}
