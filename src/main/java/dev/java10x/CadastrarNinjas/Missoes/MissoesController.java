import dev.java10x.CadastrarNinjas.Missoes.MissoesDTO;
import dev.java10x.CadastrarNinjas.Missoes.MissoesService;
import dev.java10x.CadastrarNinjas.Ninjas.Controller.Service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;
    private final NinjaService ninjaService;

    public MissoesController(MissoesService missoesService, NinjaService ninjaService) {
        this.missoesService = missoesService;
        this.ninjaService = ninjaService;
    }

    // Adicionar Ninja(CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO dto) {
        MissoesDTO novaMissao =missoesService.criarMissO(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(" missao criada com sucesso "+ novaMissao.getNomeMissao()+" ID: "+ novaMissao.getId());
    }

}
