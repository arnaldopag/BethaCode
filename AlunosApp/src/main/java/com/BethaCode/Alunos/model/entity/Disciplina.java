package com.BethaCode.Alunos.model.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "Deve ser informada o nome da disciplina!!!")
    private String descricao;

    @Column(name = "numero_horas")
    @Min(value = 1, message = "A disciplina não pode ter menos de uma hora!!!")
    @Max(value = 11, message = "A disciplina não pode ter mais que onze hora!!!")
    private Integer numeroHoras;

}
