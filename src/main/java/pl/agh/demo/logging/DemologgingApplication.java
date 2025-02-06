package pl.agh.demo.logging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DemologgingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemologgingApplication.class, args);
    }

}
