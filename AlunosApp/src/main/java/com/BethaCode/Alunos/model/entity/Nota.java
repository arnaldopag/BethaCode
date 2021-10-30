package com.BethaCode.Alunos.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter@Setter
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @NotNull(message = "Deve ser informado o aluno")
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    @ManyToOne
    @NotNull(message = "Deve ser informada a disciplina")
    @JoinColumn(name = "id_disciplina")
    private Disciplina disciplina;

    @Column(name = "data_nota")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNota;

    @Column
    @Min(value = 1, message = "não pode ser informada nota inferior a 1")
    @Max( value = 10,message = "Não pode ser informada nota superior a 10")
    private BigDecimal nota;





}
