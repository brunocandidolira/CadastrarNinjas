package dev.java10x.CadastrarNinjas.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO dto) {
        MissoesModel model = new MissoesModel();
        model.setId(dto.getId());
        model.setNomeMissao(dto.getNomeMissao());
        model.setDificuldade(dto.getDificuldade());
        // NINJAS serão setados no Service
        return model;
    }

    public MissoesDTO map(MissoesModel model) {
        MissoesDTO dto = new MissoesDTO();
        dto.setId(model.getId());
        dto.setNomeMissao(model.getNomeMissao());
        dto.setDificuldade(model.getDificuldade());
        // Aqui podemos extrair IDs se necessário
        if (model.getNinjas() != null) {
            dto.setNinjasIds(model.getNinjas().stream().map(n -> n.getId()).toList());
        }
        return dto;
    }
}
