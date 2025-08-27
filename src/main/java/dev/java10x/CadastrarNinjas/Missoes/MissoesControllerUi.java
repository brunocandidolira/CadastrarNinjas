package dev.java10x.CadastrarNinjas.Missoes;

import dev.java10x.CadastrarNinjas.Ninjas.Controller.Service.NinjaDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/missoes/ui")
public class MissoesControllerUi {
private final MissoesService missoesService;

    public MissoesControllerUi(MissoesService missoesService) {
        this.missoesService = missoesService;
    }
    @GetMapping("/listar")
    public String listarMissoes(Model model) {
        List<MissoesDTO> missoes= missoesService.listarMissoes();
        model.addAttribute("missoes",missoes);
        return  "ListarMissoes";//tem que retornar o nome da pagina que renderiza
    }
}
