package dev.java10x.CadastrarNinjas.Missoes;

import dev.java10x.CadastrarNinjas.Ninjas.Controller.Service.NinjaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Adicionar missoes(CREATE)
@PostMapping("/criar")
public ResponseEntity<String> criarmissoes(@RequestBody MissoesDTO missoes ) {
    MissoesDTO novaMissoes  =missoesService.criarMissoes(missoes);
    return ResponseEntity.status(HttpStatus.CREATED)
            .body(" Missão criada com sucesso "+ novaMissoes.getNomeMissao()+" ID: "+novaMissoes.getId());
}
@PutMapping ("/alterarMissoes{id}")
public  ResponseEntity<?> alterarMissoes(@PathVariable long id,@RequestBody MissoesDTO missoesDTO){
        if(missoesService.listarMissoesPorId(id)!=null){
            missoesService.atualizarMissoes(id,missoesDTO);
            return  ResponseEntity.ok(missoesDTO);
        }
        else{
            return ResponseEntity.ok("essa Missão"+id+" não foi encontrada!!");

        }
}



    //apagar missoes(DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarMissoesPorId(@PathVariable Long id) {
        if (missoesService.listarMissoesPorId(id) != null) {
            missoesService.deletarMissoesPorId(id);
            return ResponseEntity.ok("A Missão de ID :"+ id +" foi deletada com sucesso");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(" A missão com o ID: "+id +" não foi encontrada!! ");
        }

}

    //Procurar missoes por ID(CREATE)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissoesPorId(@PathVariable long id) {

        MissoesDTO missoesDTO= missoesService.listarMissoesPorId(id);
        if(missoesDTO != null){
            return ResponseEntity.ok( missoesDTO);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(" A missão com o ID: "+id+" não foi encontrada");
        }
    }

// mostrar todas as missoes(READ)

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
        List<MissoesDTO> missoes= missoesService.listarMissoes();
        return  ResponseEntity.ok(missoes);
    }

}
