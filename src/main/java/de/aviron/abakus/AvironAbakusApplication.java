package de.aviron.abakus;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.aviron.abakus.controllers.AuthController;
import de.aviron.abakus.enums.UserRole;
import de.aviron.abakus.requests.AuthRequest;
import de.aviron.abakus.services.UserService;

@SpringBootApplication
public class AvironAbakusApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvironAbakusApplication.class, args);
	}

	@Bean
	CommandLineRunner run(AuthController authController, UserService userService) {
		return args -> {
			authController.RegisterUser(new AuthRequest("none@test.de","test"));
			authController.RegisterUser(new AuthRequest("trial@test.de","test"));
			authController.RegisterUser(new AuthRequest("member@test.de","test"));
			authController.RegisterUser(new AuthRequest("recruiter@test.de","test"));
			authController.RegisterUser(new AuthRequest("gamemaster@test.de","test"));
			authController.RegisterUser(new AuthRequest("admin@test.de","test"));
			userService.setRole(userService.getUserByEmail("trial@test.de").getId(), UserRole.TRIAL);
			userService.setRole(userService.getUserByEmail("member@test.de").getId(), UserRole.MEMBER);
			userService.setRole(userService.getUserByEmail("recruiter@test.de").getId(), UserRole.RECRUITER);
			userService.setRole(userService.getUserByEmail("gamemaster@test.de").getId(), UserRole.GAMEMASTER);
			userService.setRole(userService.getUserByEmail("admin@test.de").getId(), UserRole.ADMIN);
		};
	}

}
