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
    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.criarNinja(ninja);
    }

    //Procurar Ninja por ID(CREATE)
    @GetMapping("/listar/{id}")
    public NinjaDTO listarNinjasPorId(@PathVariable long id) {
        return ninjaService.listarNinjasPorId(id);
    }

    // mostrar ninjas todos os ninjas(READ)
    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas() {
        return ninjaService.listarNinja();
    }

    //alterar dados dos ninjas(UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaDTO aletrarNinjaPorId(@PathVariable Long id,@RequestBody NinjaDTO ninjaAtalizado) {
        return ninjaService.atualizarNinja(id,ninjaAtalizado);
    }

    //apagar ninjas(DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjasPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
    }
}

