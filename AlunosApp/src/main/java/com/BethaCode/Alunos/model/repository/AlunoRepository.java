package com.BethaCode.Alunos.model.repository;

import com.BethaCode.Alunos.model.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository <Aluno, Integer>{
}
