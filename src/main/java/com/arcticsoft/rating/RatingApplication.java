package com.arcticsoft.rating;

import com.arcticsoft.rating.model.User;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;


@SpringBootApplication
public class RatingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RatingApplication.class, args);
    }

    @Component
    private class CommandLineAppStartupRunner implements ApplicationRunner
    {
        @Override
        public void run(ApplicationArguments arg0)
        {
            try
            {
                User u1 = new User("43170873B");
                System.out.println("Dni correcto");
            }
            catch (ResponseStatusException e)
            {
                System.out.println("Dni Incorrecto");
            }
        }
    }
}