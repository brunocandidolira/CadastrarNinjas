package dev.java10x.CadastrarNinjas.Ninjas.Controller.Service;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private  final  NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaMapper ninjaMapper, NinjaRepository ninjaRepository) {
        this.ninjaMapper = ninjaMapper;
        this.ninjaRepository = ninjaRepository;
    }

    // listar ninjas
    public List<NinjaDTO> listarNinja() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return  ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }
 // listar ninjas por ID
    public NinjaDTO listarNinjasPorId( long id){
        Optional<NinjaModel> ninjaPorId= ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
        }
    //criar ninjas
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja= ninjaRepository.save(ninja);
        return  ninjaMapper.map(ninja);
    }
    // Deletar ninjas metodo void pos não precisa retornar um objeto
    public void deletarNinjaPorId(Long id){
        ninjaRepository.deleteById(id);
    }

    // atualizar ninja
    public NinjaDTO atualizarNinja( Long id,NinjaDTO ninjaDto) {

   Optional<NinjaModel> ninjaBuscaId= ninjaRepository.findById(id);
   if (ninjaBuscaId.isPresent()){
       NinjaModel ninjaAtualizado= ninjaMapper.map(ninjaDto);
       ninjaAtualizado.setId(id);
       NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
       return ninjaMapper.map(ninjaSalvo);

   }
return null;
    }
    }
