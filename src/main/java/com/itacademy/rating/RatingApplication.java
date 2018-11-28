package com.itacademy.rating;

import com.itacademy.rating.model.IncorrectDniException;
import com.itacademy.rating.model.User;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class RatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingApplication.class, args);
	}

	@Component
	private class CommandLineAppStartupRunner implements ApplicationRunner
	{
		@Override
		public void run(ApplicationArguments arg0) throws Exception
		{
			try {
				User u1 = new User("43550300F");
				System.out.println("Dni correcto");
			}
			catch (IncorrectDniException e){
				System.out.println("Dni Incorrecto");
			}
		}
	}
}