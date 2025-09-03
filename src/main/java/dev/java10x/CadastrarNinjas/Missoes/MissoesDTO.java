package dev.java10x.CadastrarNinjas.Missoes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MissoesDTO {
    private Long id;
    private String nomeMissao;
    private String dificuldade;
    private List<Long> ninjasIds; // IDs dos ninjas selecionados
}
