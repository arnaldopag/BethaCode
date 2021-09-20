package DAO;

import Conexao.ConexaoJDBC;
import Model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private Connection conexao;
    public AlunoDAO(){
        this.conexao = ConexaoJDBC.getConnection();
    }
    public void CriarAluno(Aluno novoAluno){
        try{
            String meuSql = "INSERT INTO aluno (nome, idade, cidade, estado) VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(meuSql);
            preparedStatement.setString(1,novoAluno.getNome());
            preparedStatement.setInt(2,novoAluno.getIdade());
            preparedStatement.setString(3,novoAluno.getCidade());
            preparedStatement.setString(4,novoAluno.getEstado());
            int linhaInserida = preparedStatement.executeUpdate();
            System.out.println("Informacao inserida com sucesso: " + linhaInserida);
        }catch (SQLException e) {
            System.out.println("Erro de banco: " + e.getMessage() );
        }
    }
    public List<Aluno> buscarAlunos(){
        List<Aluno> alunosCadastrados = new ArrayList<>();
        String meuSql = "SELECT * FROM alunos";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(meuSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Aluno cadastrado = new Aluno();
                cadastrado.setId(resultSet.getInt("id"));
                cadastrado.setNome(resultSet.getString("nome"));
                cadastrado.setCidade(resultSet.getString("cidade"));
                cadastrado.setEstado(resultSet.getString("estado"));
                alunosCadastrados.add(cadastrado);
            }
        } catch (SQLException e) {
            System.out.println("Erro banco dados: " + e.getMessage());
        }
        return alunosCadastrados;
    }
    public Aluno buscarPorId(int id){
        Aluno alunoCadastrado = new Aluno();
        String meuSql = "SELECT * FROM aluno WHERE id = ?";
        try{
            PreparedStatement preparedStatement = conexao.prepareStatement(meuSql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                alunoCadastrado.setId(resultSet.getInt("id"));
                alunoCadastrado.setNome(resultSet.getString("nome"));
                alunoCadastrado.setIdade(resultSet.getInt("idade"));
                alunoCadastrado.setCidade(resultSet.getString("cidade"));
                alunoCadastrado.setEstado(resultSet.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Erro coexao banco: " + e.getMessage());
        }
        return alunoCadastrado;
    }
    public void atualizarAluno(Aluno novoAluno){

        String meuSql = "UPDATE aluno SET nome=?, idade=?, cidade=?, estado=? WHERE id=?";
        try{
            PreparedStatement preparedStatement = conexao.prepareStatement(meuSql);
            preparedStatement.setString(1,novoAluno.getNome());
            preparedStatement.setInt(2,novoAluno.getIdade());
            preparedStatement.setString(3,novoAluno.getCidade());
            preparedStatement.setString(4,novoAluno.getEstado());
            preparedStatement.setInt(5,novoAluno.getId());
        } catch (SQLException e) {
            System.out.println("Erro coexao banco: " + e.getMessage());
        }
    }
    public void excluirAluno(Aluno novoAluno){

        String meuSql = "DELETE FROM aluno WHERE id=?";
        try{
            PreparedStatement preparedStatement = conexao.prepareStatement(meuSql);
            preparedStatement.setInt(1,novoAluno.getId());
        } catch (SQLException e) {
            System.out.println("Erro coexao banco: " + e.getMessage());
        }
    }
}
