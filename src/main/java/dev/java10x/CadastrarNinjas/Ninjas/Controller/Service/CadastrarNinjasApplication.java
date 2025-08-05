package dev.java10x.CadastrarNinjas.Ninjas.Controller.Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "dev.java10x.CadastrarNinjas")
@EntityScan(basePackages = "dev.java10x.CadastrarNinjas")
public class CadastrarNinjasApplication {

    public static void main(String[] args) {
        SpringApplication.run(CadastrarNinjasApplication.class, args);
    }

}
