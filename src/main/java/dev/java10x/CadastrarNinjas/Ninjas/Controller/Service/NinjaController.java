package dev.java10x.CadastrarNinjas.Ninjas.Controller.Service;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    // Adicionar Ninja(CREATE)
    @PostMapping ("/criar")
    public String criarNinja(){
        return "ninja criado";
    }
    //Procurar Ninja por ID(CREATE)
    @GetMapping("/listarId")
    public String mostrarNinjasPorId(){
        return "mostrar ninjas por Id";
    }
    // mostrar ninjas todos os ninjas(READ)
    @GetMapping("/listar")
    public String mostrarTodosOsNinjas(){
        return "mostrar todos os ninja";
    }
    //alterar dados dos ninjas(UPDATE)
     @PutMapping("/alterar")
     public String aletrarNinjaPorId() {
         return "alterar  ninja";
     }
    //apagar ninjas(DELETE)
         @DeleteMapping("/deletarId")
         public String deletarNinjasPorId() {
             return " ninja deletado";
         }
}
