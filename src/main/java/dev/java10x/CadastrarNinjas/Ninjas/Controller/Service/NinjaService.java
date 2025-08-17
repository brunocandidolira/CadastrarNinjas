package dev.java10x.CadastrarNinjas.Ninjas.Controller.Service;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
    // listar ninjas
    public List<NinjaModel> listarNinja(){
        return ninjaRepository.findAll();
    }
 // listar ninjas por ID
    public NinjaModel listarNinjasPorId( long id){
        Optional<NinjaModel> ninjaPorId= ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
        }
    //criar ninjas
    public NinjaModel criarNinja(NinjaModel ninja) {
        return  ninjaRepository.save(ninja);
    }
    }
