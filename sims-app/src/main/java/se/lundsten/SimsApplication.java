package se.lundsten;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.lundsten.controller.ResultController;

@SpringBootApplication

public class SimsApplication {

  public static void main(String[] args) {
    SpringApplication.run(SimsApplication.class, args);
    ResultController.race();
  }
}
