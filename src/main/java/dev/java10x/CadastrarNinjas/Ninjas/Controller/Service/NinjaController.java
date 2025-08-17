package dev.java10x.CadastrarNinjas.Ninjas.Controller.Service;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Adicionar Ninja(CREATE)
    @PostMapping ("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return  ninjaService.criarNinja(ninja);
    }

    //Procurar Ninja por ID(CREATE)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable long id){
        return ninjaService.listarNinjasPorId(id);
    }
    // mostrar ninjas todos os ninjas(READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
         return ninjaService.listarNinja();
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
