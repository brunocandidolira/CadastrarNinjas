package dev.java10x.CadastrarNinjas.Ninjas.Controller.Service;

import dev.java10x.CadastrarNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String nome;
    private String email;
    private int idade;

    // @ManyToOne cada ninja tem um unica missao
    @ManyToOne
    @JoinColumn(name = "Missoes_id")//chave estrageira
    private MissoesModel Missoes;

}
