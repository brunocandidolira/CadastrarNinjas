package dev.java10x.CadastrarNinjas.Ninjas.Controller.Service;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {
    public  NinjaModel map(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setImgUrl(ninjaDTO.getImgUrl());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setMissoes(ninjaDTO.getMissoes());
        ninjaModel.setRank(ninjaDTO.getRank());
        return ninjaModel;
    }


    public NinjaDTO map(NinjaModel ninjaModel){
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setImgUrl(ninjaModel.getImgUrl());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setMissoes(ninjaModel.getMissoes());
        ninjaDTO.setRank(ninjaModel.getRank());
        return ninjaDTO;
    }
}
