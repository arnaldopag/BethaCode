import { Component, OnInit } from '@angular/core';
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

  constructor(private servicoAlunos: AlunosService) {
    this.aluno = new Aluno()
   }

  ngOnInit(): void {
  }
  gravarAluno(){
    this.servicoAlunos
        .salvar(this.aluno)
        .subscribe(respostaSucesso =>{
          this.sucesso = true;
          this.errosApi = null;
          this.aluno = respostaSucesso;
        },respostaErro =>{
          this.sucesso = false;
          this.errosApi = respostaErro.error.erros;
        })
  }
}
