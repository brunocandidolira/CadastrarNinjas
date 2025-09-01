package dev.java10x.CadastrarNinjas.Ninjas.Controller.Service;

import dev.java10x.CadastrarNinjas.Missoes.MissoesDTO;
import dev.java10x.CadastrarNinjas.Missoes.MissoesModel;
import dev.java10x.CadastrarNinjas.Missoes.MissoesRepository;
import dev.java10x.CadastrarNinjas.Missoes.MissoesService;
import io.micrometer.observation.ObservationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final  NinjaService ninjaService;
    private final MissoesService missoesService;
    private final MissoesRepository missoesRepository;
    private  final NinjaMapper ninjaMapper;

    public NinjaControllerUi(NinjaService ninjaService, MissoesService missoesService, MissoesRepository missoesRepository, NinjaMapper ninjaMapper) {
        this.ninjaService = ninjaService;
        this.missoesService = missoesService;
        this.missoesRepository = missoesRepository;
        this.ninjaMapper = ninjaMapper;
    }
@GetMapping("/home")
public String menuNinja(){
return "/homeNinjas";
}
@GetMapping("/listarNinjas")
public String listarNinja(){
        return "redirect:/ninjas/ui/listar";

}


    @GetMapping("/cadastrarNinja")
    public String mostrarFormularioAdicionarNinja(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "cadastrarNinja";
    }

    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        ninjaService.criarNinja(ninja);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja cadastrado com sucesso!");
        return "redirect:/ninjas/ui/listar";
    }


    // mostrar ninjas todos os ninjas(READ)
    @GetMapping("/listar")
    public String listarNinjas(Model model) {
        List<NinjaDTO> ninjas= ninjaService.listarNinja();
        model.addAttribute("ninjas",ninjas);
        return  "ListarNinjas";//tem que retornar o nome da pagina que renderiza
    }
    @GetMapping("/deletar/{id}")
    public String deletarNinjasPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
            return "redirect:/ninjas/ui/listar";
        }

    //Procurar Ninja por ID(CREATE)
    @GetMapping("/detalhes/{id}")
    public String listarId(@PathVariable long id,Model model) {

        NinjaDTO ninja= ninjaService.listarNinjasPorId(id);
        if(ninja != null){
         model.addAttribute("ninja",ninja);
            return"detalhesNinjas";
        }
        else {
            model.addAttribute("menssagem","ninja não encontrado ");
            return"listarNinjas";
        }
    }

}

