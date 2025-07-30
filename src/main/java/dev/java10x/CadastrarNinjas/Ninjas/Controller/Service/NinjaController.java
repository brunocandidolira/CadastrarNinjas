package dev.java10x.CadastrarNinjas.Ninjas.Controller.Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {
    @GetMapping("/testando")
    public String testando() {
        return "Testando a Rota";
    }
}
