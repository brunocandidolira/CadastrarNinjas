package dev.java10x.CadastrarNinjas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackages = "dev.java10x.CadastrarNinjas") // <- entidades
@EnableJpaRepositories(basePackages = "dev.java10x.CadastrarNinjas")
public class CadastrarNinjasApplication {

    public static void main(String[] args) {
        SpringApplication.run(CadastrarNinjasApplication.class, args);
    }

}
