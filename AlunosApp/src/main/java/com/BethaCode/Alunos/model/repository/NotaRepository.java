package com.BethaCode.Alunos.model.repository;

import com.BethaCode.Alunos.model.entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository  extends JpaRepository<Nota, Integer> {
}
