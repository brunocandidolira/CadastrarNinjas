package dev.java10x.CadastrarNinjas.Ninjas.Controller.Service;

import dev.java10x.CadastrarNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "missoes")
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name ="imgUrl")
    private String imgUrl;

  @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name="idade")
    private int idade;

    @Column (name="rank")
    private  String rank;
    // @ManyToOne cada ninja tem um unica missao
    @ManyToOne
    @JoinColumn(name ="missoes_id")//chave estrageira
    private MissoesModel missoes;


    public void setId(Long id) {
    }
}
