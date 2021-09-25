package Aplicacao;

import DAO.AlunoDAO;
import Model.Aluno;

import java.util.List;

public class BethaCodeApp {
    public static void main(String[] args){
        AlunoDAO alunoDAO = new AlunoDAO();
       Aluno aluno = new Aluno("arnaldo", 25,"rincao","santa catarina");
        alunoDAO.CriarAluno(aluno);

        /*List<Aluno> alunosBanco = alunoDAO.buscarAlunos();
        alunosBanco.forEach( alunos -> System.out.println(alunos));

        Aluno alunoID = alunoDAO.buscarPorId(1);
        alunoDAO.atualizarAluno(alunoID);

        Aluno excluir  = alunoDAO.buscarPorId(1);
        alunoDAO.excluirAluno(excluir);*/

    }
}
