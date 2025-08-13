package dev.java10x.CadastrarNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {
@PostMapping("/criar")
    public String missoesCriar(){
    return" missoes Criada" ;
}
@PutMapping ("/alterar")
    public String missoesAlterar(){
    return "alterado sua missao";
}
    @DeleteMapping("/deletar")
    public String missoesDeletar(){
        return "deletado sua missao";
    }
@GetMapping("/listar")
public String listarMissoes(){
    return "listar missoes com sucesso";
}
}
