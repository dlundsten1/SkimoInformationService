package se.lundsten;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import se.lundsten.controller.ResultController;
import se.lundsten.model.Individual;
import se.lundsten.model.Race;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication

public class Application {

    public static void main(String[] args) {

          SpringApplication.run(Application.class, args);
        ResultController.race();


    }

}