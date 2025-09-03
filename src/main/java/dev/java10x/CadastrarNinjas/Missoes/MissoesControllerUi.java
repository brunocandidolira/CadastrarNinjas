package dev.java10x.CadastrarNinjas.Missoes;

import dev.java10x.CadastrarNinjas.Ninjas.Controller.Service.NinjaDTO;
import dev.java10x.CadastrarNinjas.Ninjas.Controller.Service.NinjaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/missoes/ui")
public class MissoesControllerUi {

    private final MissoesService missoesService;
    private final NinjaService ninjaService;

    public MissoesControllerUi(MissoesService missoesService, NinjaService ninjaService) {
        this.missoesService = missoesService;
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public String listarMissoes(Model model) {
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        model.addAttribute("missoes", missoes);
        return "ListarMissoes";
    }

    @GetMapping("/cadastrarMissao")
    public String exibirFormulario(Model model) {
        model.addAttribute("missoesDTO", new MissoesDTO());
        model.addAttribute("ninjas", ninjaService.listarNinja()); // lista de todos os ninjas
        return "cadastrarMissao";
    }

    @PostMapping("/salvar")
    public String salvarMissao(@ModelAttribute MissoesDTO dto, RedirectAttributes redirectAttributes) {
        missoesService.criarMissO(dto);
        redirectAttributes.addFlashAttribute("mensagem", "missao cadastrada com sucesso!");
        return "redirect:/missoes/ui/listar";
    }





}