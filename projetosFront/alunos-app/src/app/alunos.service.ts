import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Aluno } from './alunos/aluno';

@Injectable({
  providedIn: 'root'
})
export class AlunosService {

  constructor(private http: HttpClient) { }

  salvar(aluno:Aluno):Observable<Aluno>{
    return this.http.post<Aluno>('http://localhost:8080/api/alunos',aluno)
  }
}
