package dev.java10x.CadastrarNinjas.Missoes;


import dev.java10x.CadastrarNinjas.Ninjas.Controller.Service.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

   @Column(name="nomeMissao")
    private String nomeMissao;

   @Column(name="dificuldade")
    private String dificuldade;

   // uma missão pode ter varios ninjas
    @OneToMany(mappedBy = "missoes")
    private List <NinjaModel>ninjas;

}