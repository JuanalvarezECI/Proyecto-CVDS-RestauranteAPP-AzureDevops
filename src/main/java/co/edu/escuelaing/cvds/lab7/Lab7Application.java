package co.edu.escuelaing.cvds.lab7;

import co.edu.escuelaing.cvds.lab7.model.Configuration;
import co.edu.escuelaing.cvds.lab7.service.ConfigurationService;
import co.edu.escuelaing.cvds.lab7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab7Application {
	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(Lab7Application.class, args);
	}
	@Bean
	public CommandLineRunner run() throws Exception {
		return (args) -> {
			System.out.println("agregando usuarios....");
			userService.guardarUsuarios();
		};
	}
}

