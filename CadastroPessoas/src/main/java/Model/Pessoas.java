package Model;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Entity
public class Pessoas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false,length = 80)
    private String nome;

    @Column(nullable = false)
    private Integer idade;

    @Column(nullable = false,length = 60)
    private String rua;

    @Column(nullable = false,length = 100)
    private String numeroCasa;

    @Column(nullable = false,length = 60)
    private String bairro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Pessoas{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", rua='" + rua + '\'' +
                ", numeroCasa='" + numeroCasa + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade=" + cidade +
                '}';
    }
}
