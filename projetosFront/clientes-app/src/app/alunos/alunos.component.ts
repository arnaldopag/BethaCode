import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-alunos',
  templateUrl: './alunos.component.html',
  styleUrls: ['./alunos.component.css']
})
export class AlunosComponent implements OnInit {

  alunos : Aluno[];
  
  constructor() { 
    let aluno1 = new Aluno("Arnaldo" , 25 , "Rincão");
    let aluno2 = new Aluno("zé" , 99 , "Rincão");
    
    this.alunos = [aluno1,aluno2];
  }

  ngOnInit(): void {
  }
}

class Aluno {
    constructor(
      public nome     : string,
      public idade    : number,
      public endereco : string,
    ) 
  {
    this.nome = nome;
    this.idade = idade;
    this.endereco = endereco;
  }
}


