package com.BethaCode.Alunos.rest;


import com.BethaCode.Alunos.model.entity.Aluno;
import com.BethaCode.Alunos.model.repository.AlunoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/api/alunos")
@CrossOrigin("http://localhost:4200")
public class AlunoController {

    private final AlunoRepository repository;

    @Autowired
    public AlunoController(AlunoRepository repository){
        this.repository = repository;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno salvar(@Valid @RequestBody Aluno aluno){
        return repository.save(aluno);
    }
    @GetMapping
    public List<Aluno> achartodos(){
        return repository.findAll();
    }
    @GetMapping("{id}")
    public Aluno acharPorId(@PathVariable Integer id){
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository
                .findById(id)
                .map(aluno ->{
                    repository.delete(aluno);
                    return  Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id,@Valid @RequestBody Aluno alunoAtualizado){
        repository
                .findById(id)
                .map(aluno -> {
                    aluno.setNome(alunoAtualizado.getNome());
                    aluno.setNumero(alunoAtualizado.getNumero());
                    aluno.setIdade(alunoAtualizado.getIdade());
                    aluno.setRua(alunoAtualizado.getRua());
                    aluno.setBairro(alunoAtualizado.getBairro());
                    aluno.setCidade(alunoAtualizado.getCidade());
                    aluno.setCep(alunoAtualizado.getCep());
                    aluno.setUf(alunoAtualizado.getUf());
                    return repository.save(aluno);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
