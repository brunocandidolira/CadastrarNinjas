package dev.java10x.CadastrarNinjas.Ninjas.Controller.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final  NinjaService ninjaService;


    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }
    // mostrar ninjas todos os ninjas(READ)
    @GetMapping("/listar")
    public String listarNinjas(Model model) {
        List<NinjaDTO> ninjas= ninjaService.listarNinja();
        model.addAttribute("ninjas",ninjas);
        return  "ListarNinjas";//tem que retornar o nome da pagina que renderiza
    }
}

