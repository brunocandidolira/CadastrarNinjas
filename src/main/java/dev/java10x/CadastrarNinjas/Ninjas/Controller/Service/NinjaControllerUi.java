package dev.java10x.CadastrarNinjas.Ninjas.Controller.Service;

import dev.java10x.CadastrarNinjas.Missoes.*;
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
private final MissoesMapper missoesMapper;
    public NinjaControllerUi(NinjaService ninjaService, MissoesService missoesService, MissoesRepository missoesRepository, NinjaMapper ninjaMapper, MissoesMapper missoesMapper) {
        this.ninjaService = ninjaService;
        this.missoesService = missoesService;
        this.missoesRepository = missoesRepository;
        this.ninjaMapper = ninjaMapper;
        this.missoesMapper = missoesMapper;
    }
@GetMapping("/home")
public String menuNinja(){
return "/homeNinjas";
}
@GetMapping("/listarNinjas")
public String listarNinja(){
        return "redirect:/ninjas/ui/listar";

}

    @GetMapping("/alterar/{id}")
    public String mostrarFormularioAlterar(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if (ninja == null) {
            model.addAttribute("erro", "O ID " + id + " informado não foi encontrado!");
            return "erro";
        }

        // Carrega as missões cadastradas no banco
        List<MissoesDTO> missoesDisponiveis = missoesService.listarMissoes();

        model.addAttribute("ninja", ninja);
        model.addAttribute("missoesDisponiveis", missoesDisponiveis);
        return "alterarNinja";
    }

    @PostMapping("/alterar/{id}")
    public String alterarNinjaPorId(@PathVariable Long id,
                                    @ModelAttribute NinjaDTO ninjaAtualizado,
                                    Model model) {
        NinjaDTO existente = ninjaService.listarNinjasPorId(id);

        if (existente != null) {
            // Converte DTO para Model
            NinjaModel ninjaModel = ninjaMapper.map(ninjaAtualizado);

            // Buscar missão no banco pelo ID selecionado
            if (ninjaAtualizado.getMissoes() != null) {
                Long missaoId = ninjaAtualizado.getMissoes().getId();
                MissoesDTO missaoSelecionada = missoesService.listarMissoesPorId(missaoId);

                // Converter DTO -> Model e setar no Ninja
                ninjaModel.setMissoes(missoesMapper.map(missaoSelecionada));
            }

            // Atualiza Ninja com o Model
            ninjaService.atualizarNinja(id, ninjaMapper.map(ninjaModel));
            return "redirect:/ninjas/ui/listar";
        } else {
            model.addAttribute("erro", "O ID " + id + " informado não foi encontrado!");
            return "erro";
        }
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
        List<NinjaDTO> ninjas= null;
                ninjas= ninjaService.listarNinja();
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

