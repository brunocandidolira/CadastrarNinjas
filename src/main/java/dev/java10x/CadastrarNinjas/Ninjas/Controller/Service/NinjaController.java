package dev.java10x.CadastrarNinjas.Ninjas.Controller.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja =ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(" Ninja criado com sucesso "+ novoNinja.getNome()+" ID: "+novoNinja.getId());
    }

    //Procurar Ninja por ID(CREATE)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable long id) {

          NinjaDTO ninjaDTO= ninjaService.listarNinjasPorId(id);
       if(ninjaDTO != null){
           return ResponseEntity.ok( ninjaDTO);
       }
else {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("ninja com o ID: "+id+" não encontrado");
       }
    }

    // mostrar ninjas todos os ninjas(READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas= ninjaService.listarNinja();
      return  ResponseEntity.ok(ninjas);
    }

    //alterar dados dos ninjas(UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> aletrarNinjaPorId(@PathVariable Long id,@RequestBody NinjaDTO ninjaAtalizado) {
      if(ninjaService.listarNinjasPorId(id)!= null) {
          ninjaService.atualizarNinja(id, ninjaAtalizado);

          return  ResponseEntity.ok(ninjaAtalizado);
      }
      else{
          return  ResponseEntity.ok("esse ID :"+id +"informado, não foi encontrado !!");
      }
      }

    //apagar ninjas(DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjasPorId(@PathVariable Long id) {
        if (ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja de ID :"+ id +" deletado com sucesso");
        }
         else{
             return ResponseEntity.status(HttpStatus.NOT_FOUND)
                     .body("O ninja com o ID: "+id +" não foi encontrado!! ");
        }
    }
}

