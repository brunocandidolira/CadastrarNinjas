package dev.java10x.CadastrarNinjas.Ninjas.Controller.Service;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {
    @GetMapping("/testando")
    public String testando() {
        return "Testando a Rota";
    }
    // Adicionar Ninja(CREATE)
    @PostMapping ("/criar")
    public String criarNinja(){
        return "ninja criado";
    }
    //Procurar Ninja por ID(CREATE)
    @GetMapping("/todosId")
    public String mostrarNinjasPorId(){
        return "mostrar ninjas por Id";
    }
    // mostrar ninjas todos os ninjas(READ)
    @GetMapping("/todos")
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
