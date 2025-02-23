package xyz.vvrf.sci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SciApplication {

    public static void main(String[] args) {
        SpringApplication.run(SciApplication.class, args);
    }

}
