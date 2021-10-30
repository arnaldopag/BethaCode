package com.BethaCode.Alunos.rest;

import com.BethaCode.Alunos.model.dto.NotaDTO;
import com.BethaCode.Alunos.model.entity.Aluno;
import com.BethaCode.Alunos.model.entity.Disciplina;
import com.BethaCode.Alunos.model.entity.Nota;
import com.BethaCode.Alunos.model.repository.AlunoRepository;
import com.BethaCode.Alunos.model.repository.DisciplinaRepository;
import com.BethaCode.Alunos.model.repository.NotaRepository;
import com.BethaCode.Alunos.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/notas")
@RequiredArgsConstructor
public class NotaController {
    private final NotaRepository notaRepository;
    private final AlunoRepository alunoRepository;
    private final DisciplinaRepository disciplinaRepository;
    private final BigDecimalConverter bigDecimalConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Nota salvar (@RequestBody NotaDTO notaDTO){

        LocalDate dataNota = LocalDate.parse(notaDTO.getDataNota(),
                                             DateTimeFormatter.ofPattern("dd/MM/yyy"));
        BigDecimal valorDaNota = bigDecimalConverter.converter(notaDTO.getNota());
        Integer idAluno = notaDTO.getIdAluno();
        Aluno valorDoAluno = alunoRepository
                    .findById(idAluno)
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.BAD_REQUEST,
                            "O Aluno " + idAluno + " Não existe"
                    ));
        Integer idDisciplina = notaDTO.getIdDisciplina();
        Disciplina valorDisciplina = disciplinaRepository
                        .findById(idDisciplina)
                        .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.BAD_REQUEST,
                             "A disciplina " + idDisciplina + " não existe"
                        ));


        Nota notaASalvar = new Nota();
        notaASalvar.setDataNota(dataNota);
        notaASalvar.setNota(valorDaNota);
        notaASalvar.setAluno(valorDoAluno);
        return notaRepository.save(notaASalvar);
    }
    @GetMapping("{id}")
    public Nota acharPorId(@PathVariable Integer id){
        return notaRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.BAD_REQUEST,
                                "A Nota " + id + " Não existe"
                ));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){

        notaRepository
                .findById(id)
                .map(nota ->{
                        notaRepository.delete(nota);
                        return Void.TYPE;
                        })
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "A nota " + id + " nao existe"
                        ));
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar (@PathVariable Integer id, @RequestBody NotaDTO dto){
        LocalDate dataNota =  LocalDate.parse(
                dto.getDataNota(),
                DateTimeFormatter.ofPattern("dd/MM/yyyy")
        );
        BigDecimal valorNota = bigDecimalConverter.converter(dto.getNota());

        Integer idAluno = dto.getIdAluno();
        Aluno alunoBanco = alunoRepository
                .findById(idAluno)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Aluno " + idAluno +" Não existe"
                ));
        Integer idDisciplina = dto.getIdDisciplina();
        Disciplina disciplinaBanco = disciplinaRepository
                .findById(idDisciplina)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Disciplina "  + idDisciplina + " Não existe!!!"
                ));
        notaRepository
                .findById(id)
                .map(notaCadastrada ->{
                    notaCadastrada.setNota(valorNota);
                    notaCadastrada.setDataNota(dataNota);
                    notaCadastrada.setAluno(alunoBanco);
                    notaCadastrada.setDisciplina(disciplinaBanco);
                    return notaRepository.save(notaCadastrada);
                        }).orElseThrow(()-> new ResponseStatusException(
                                HttpStatus.BAD_REQUEST,
                                "A nota: " + valorNota + " Não existe"
                ));

    }

}
