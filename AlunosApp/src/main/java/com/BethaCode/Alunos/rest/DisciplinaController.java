package com.BethaCode.Alunos.rest;

import com.BethaCode.Alunos.model.entity.Disciplina;
import com.BethaCode.Alunos.model.repository.DisciplinaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaController {
    private final DisciplinaRepository repository;

    @Autowired
    public DisciplinaController(DisciplinaRepository repository){
        this.repository = repository;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Disciplina salvar(@Valid @RequestBody Disciplina disciplina){
        return repository.save(disciplina);
    }


    @GetMapping("{id}")
    public Disciplina acharPorId(@PathVariable Integer id){
        return repository
                .findById(id)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "A disciplina pesquisada não existe"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository
                .findById(id)
                .map(disciplinaExluir ->{
                    repository.delete(disciplinaExluir);
                    return Void.TYPE;
                } )
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "A disciplina não existe"));
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id,@Valid @RequestBody Disciplina dadoAtualizado){
        repository
                .findById(id)
                .map(disciplina -> {
                    disciplina.setDescricao(dadoAtualizado.getDescricao());
                    disciplina.setNumeroHoras(dadoAtualizado.getNumeroHoras());
                    return repository.save(disciplina);
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "A disciplina não existe!!!"));
    }

}













