import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AlunosService } from 'src/app/alunos.service';
import { Aluno } from '../aluno';

@Component({
  selector: 'app-alunos-form',
  templateUrl: './alunos-form.component.html',
  styleUrls: ['./alunos-form.component.css']
})
export class AlunosFormComponent implements OnInit {
  aluno    : Aluno;
  sucesso  : boolean = false;
  errosApi : String[]; 
  id       : number;

  constructor(private servicoAlunos: AlunosService,
              private router : Router,
              private activatedRoute : ActivatedRoute) {
    this.aluno = new Aluno()
   }

  ngOnInit(): void {
    let params : Observable<Params> = this.activatedRoute.params;
    params.subscribe(urlParams => {
          this.id = urlParams['id']
          if(this.id){
            this.servicoAlunos
                .getAlunosById(this.id)
                .subscribe(respostaSucesso => {
                  this.aluno = respostaSucesso
                },respotaErro => {
                  this.aluno = new Aluno();
                }) 
          }
    })
  }
  gravarAluno(){
    
    if(this.id){
      this.servicoAlunos
      .atualizar(this.aluno)
      .subscribe(respostaSucesso=>{
        this.sucesso = true;
        this.errosApi = null;
      },respostaErro => {
        this.sucesso = false;
        this.errosApi = respostaErro.error.erros;
      })
    }else{
      this.servicoAlunos
      .salvar(this.aluno)
      .subscribe(respostaSucesso =>{
        this.sucesso = true;
        this.errosApi = null;
        this.aluno = respostaSucesso;
      },respostaErro =>{
        this.sucesso = false;
        this.errosApi = respostaErro.error.erros;
      })}
        
  }


  voltarListagem(){
    this.router.navigate(['/alunosLista'])
  }
}
