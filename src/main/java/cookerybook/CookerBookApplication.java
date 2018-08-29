package cookerybook;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class CookerBookApplication {
    public static void main(String[] args) {
        SpringApplication.run(CookerBookApplication.class, args);
        System.out.println("TEST");
    }
}
