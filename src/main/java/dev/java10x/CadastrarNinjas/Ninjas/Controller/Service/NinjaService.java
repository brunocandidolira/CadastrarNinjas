package dev.java10x.CadastrarNinjas.Ninjas.Controller.Service;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
