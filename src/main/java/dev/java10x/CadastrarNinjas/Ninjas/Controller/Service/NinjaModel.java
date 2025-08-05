package dev.java10x.CadastrarNinjas.Ninjas.Controller.Service;

import dev.java10x.CadastrarNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    Long id;

    @Column(name ="imgUrl")
    private String imgUrl;

  @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name="idade")
    private int idade;

    // @ManyToOne cada ninja tem um unica missao
    @ManyToOne
    @JoinColumn(name ="missoes_id")//chave estrageira
    private MissoesModel missoes;

}
