package dev.java10x.CadastrarNinjas.Missoes;

import dev.java10x.CadastrarNinjas.Ninjas.Controller.Service.NinjaDTO;
import dev.java10x.CadastrarNinjas.Ninjas.Controller.Service.NinjaModel;
import dev.java10x.CadastrarNinjas.Ninjas.Controller.Service.NinjaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    // Deletar missoes metodo void pos não precisa retornar um objeto
    public void deletarmissoesPorId(Long id){

        missoesRepository.deleteById(id);
    }
    // atualizar missoes
    public MissoesDTO atualizarMissoes( Long id,MissoesDTO missoesDto) {

        Optional<MissoesModel> missoesBuscaId= missoesRepository.findById(id);
        if (missoesBuscaId.isPresent()){
            MissoesModel missaoAtualizada= missoesMapper.map(missoesDto);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);

        }
        return null;
    }
    public List<MissoesDTO> listarMissoes() {
        return missoesRepository.findAll()
                .stream()
                .map(missoesMapper::map)
                .toList();
    }
    public MissoesDTO listarMissoesPorId( long id){
        Optional<MissoesModel> missoesPorId= missoesRepository.findById(id);
        return missoesPorId.map(missoesMapper::map).orElse(null);
    }

    public MissoesDTO criarMissO(MissoesDTO DTO) {
        MissoesModel model  = missoesMapper.map(DTO);
        model= missoesRepository.save(model);
        return  missoesMapper.map(model);
    }
}
