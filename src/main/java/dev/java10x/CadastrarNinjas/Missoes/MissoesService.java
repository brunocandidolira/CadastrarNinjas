package dev.java10x.CadastrarNinjas.Missoes;

import dev.java10x.CadastrarNinjas.Ninjas.Controller.Service.NinjaDTO;
import dev.java10x.CadastrarNinjas.Ninjas.Controller.Service.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {
    private  final  MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    public MissoesService(MissoesMapper missoesMapper, MissoesRepository missoesRepository) {
        this.missoesMapper = missoesMapper;
        this.missoesRepository = missoesRepository;
    }
// listar missoes
public List<MissoesDTO> listarMissoes() {
    return missoesRepository.findAll()
            .stream()
            .map(missoesMapper::map)
            .collect(Collectors.toList());
}

    // listar missoes  por ID
    public MissoesDTO listarMissoesPorId( long id){
        Optional<MissoesModel> missoesPorId= missoesRepository.findById(id);
        return missoesPorId.map(missoesMapper::map).orElse(null);
    }

    //criar missoes
    public MissoesDTO criarMissoes(MissoesDTO missoesDTO) {
        MissoesModel missoes = missoesMapper.map(missoesDTO);
        missoes= missoesRepository.save(missoes);
        return  missoesMapper.map(missoes);
    }
    // Deletar missoes metodo void pos não precisa retornar um objeto
    public void deletarMissoesPorId(Long id){
        missoesRepository.deleteById(id);
    }

    // atualizar missoes
    public MissoesDTO atualizarMissoes( Long id,MissoesDTO missoesDto) {

        Optional<MissoesModel> missoesBuscaId= missoesRepository.findById(id);
        if (missoesBuscaId.isPresent()){
            MissoesModel missoesAtualizadas= missoesMapper.map(missoesDto);
            missoesAtualizadas.setId(id);
            MissoesModel missoesSalvas = missoesRepository.save(missoesAtualizadas);
            return missoesMapper.map(missoesSalvas);

        }
        return null;
    }
}
