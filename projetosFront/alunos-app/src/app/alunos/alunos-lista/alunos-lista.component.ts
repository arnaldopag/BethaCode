import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AlunosService } from 'src/app/alunos.service';
import { Aluno } from '../aluno';

@Component({
  selector: 'app-alunos-lista',
  templateUrl: './alunos-lista.component.html',
  styleUrls: ['./alunos-lista.component.css']
})
export class AlunosListaComponent implements OnInit {
  alunos: Aluno[] = [];
  alunoSelecionado: Aluno;
  mensagemSucesso : string;
  mensagemErro : string;

  constructor(private serviceAlunos : AlunosService,
              private router : Router) { }

  ngOnInit(): void {
    this.serviceAlunos
        .getAlunos()
        .subscribe(respostaSucesso =>{
          this.alunos = respostaSucesso;
        })
  }
  preparaDelecao(aluno : Aluno){
    this.alunoSelecionado = aluno
  }
  deletarAluno(){
    this.serviceAlunos
        .deletar(this.alunoSelecionado)
        .subscribe(respostaSucesso => {
          this.mensagemSucesso = "Aluno excluido"
          this.mensagemErro = null
          this.ngOnInit();
        }, repostaErro =>{          
          this.mensagemSucesso = null;
          this.mensagemErro = "Aluno não excluido";
        })
  }
  novoCadastro(){
    this.router.navigate(['/alunosForm'])
  }
}
