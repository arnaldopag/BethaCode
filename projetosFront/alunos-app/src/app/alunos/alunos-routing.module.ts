import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AlunosFormComponent } from './alunos-form/alunos-form.component';
import { AlunosListaComponent } from './alunos-lista/alunos-lista.component';


const routes: Routes = [
  {path: 'alunosForm',component: AlunosFormComponent},
  {path: 'alunosLista',component: AlunosListaComponent},
  {path: 'alunosForm/:id',component: AlunosFormComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AlunosRoutingModule { }
