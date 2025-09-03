package dev.java10x.CadastrarNinjas.Missoes;

import dev.java10x.CadastrarNinjas.Ninjas.Controller.Service.NinjaDTO;
import dev.java10x.CadastrarNinjas.Ninjas.Controller.Service.NinjaModel;
import dev.java10x.CadastrarNinjas.Ninjas.Controller.Service.NinjaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;
    private final NinjaService ninjaService;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper, NinjaService ninjaService) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
        this.ninjaService = ninjaService;
    }

    public List<MissoesDTO> listarMissoes() {
        return missoesRepository.findAll()
                .stream()
                .map(missoesMapper::map)
                .toList();
    }

    public MissoesDTO criarMissO(MissoesDTO DTO) {
        MissoesModel model  = missoesMapper.map(DTO);
        model= missoesRepository.save(model);
        return  missoesMapper.map(model);
    }
}
