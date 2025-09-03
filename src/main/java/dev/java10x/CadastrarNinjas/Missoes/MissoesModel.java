package dev.java10x.CadastrarNinjas.Missoes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastrarNinjas.Ninjas.Controller.Service.NinjaModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @Column(name="nomeMissao")
    private String nomeMissao;

   @Column(name="dificuldade")
    private String dificuldade;

   // uma missão pode ter varios ninjas
   @OneToMany(mappedBy = "missoes", cascade = CascadeType.ALL, orphanRemoval = true)
   @JsonIgnore

   private List <NinjaModel>ninjas;


}