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
			authController.RegisterUser(new AuthRequest("none","test"));
			authController.RegisterUser(new AuthRequest("trial","test"));
			authController.RegisterUser(new AuthRequest("member","test"));
			authController.RegisterUser(new AuthRequest("recruiter","test"));
			authController.RegisterUser(new AuthRequest("gamemaster","test"));
			authController.RegisterUser(new AuthRequest("admin","test"));
			userService.setRole(userService.getUserByEmail("trial").getId(), UserRole.TRIAL);
			userService.setRole(userService.getUserByEmail("member").getId(), UserRole.MEMBER);
			userService.setRole(userService.getUserByEmail("recruiter").getId(), UserRole.RECRUITER);
			userService.setRole(userService.getUserByEmail("gamemaster").getId(), UserRole.GAMEMASTER);
			userService.setRole(userService.getUserByEmail("admin").getId(), UserRole.ADMIN);
		};
	}

}
