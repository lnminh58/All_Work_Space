package com.lnminh.springjpadatawithoutmvc;

import com.lnminh.dao.StudentRepository;
import com.lnminh.entity.Batch;
import com.lnminh.entity.Student;
import com.lnminh.service.BatchService;
import com.lnminh.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@SpringBootApplication
@ComponentScan("com.lnminh.*")
@EnableJpaRepositories("com.lnminh.*")
@EntityScan("com.lnminh.*")
@EnableTransactionManagement(proxyTargetClass = true)
public class SpringJpaDataWithoutMvcApplication {


	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run
				(SpringJpaDataWithoutMvcApplication.class, args);

		StudentService studentService = applicationContext.getBean(StudentService.class);

//		List student

//		List<Student> students = studentService.getAllStudent();
//		List<Student> students = studentService.getStudentsHaveAgeOrNameEqual(24, "Le Ngoc Minh");
//		List<Student> students = studentService.getStudentsHaveAgeGreaterThanOrBatchNameContain
//				(24, "30");
//		List<Student> students = studentService.getAllStudentsOrderByAge();

//		List<Student> students = studentService.getStudentsHaveGender(true);

//		Page<Student> students = studentService.getLimitNumberRow(new
//				PageRequest(0, 2));

		List<Student> students = studentService.findStudentsByAbstractField("full_name", "a");
		System.out.println("\n\n\n\n");
		for (Student student : students) {
			System.out.println(student.toString());
		}
		System.out.println("\n\n\n\n");

//		list batch

		BatchService batchService = applicationContext.getBean(BatchService.class);


		List<Batch> batchs = batchService.getAllBatchs();
//		List<Batch> batchs = batchService.getBatchByBatchName("Batch_130");

		System.out.println("\n\n\n\n");
		for (Batch batch : batchs){
			System.out.println(batch.toString());
		}
		System.out.println("\n\n\n\n");

		((ConfigurableApplicationContext) applicationContext).close();

	}
}
