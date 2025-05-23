import java.util.ArrayList;

public class Usuario {

    private String nome;
    private String cpf;
    private ArrayList<Livro> livrosEmprestados;

    public Usuario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.livrosEmprestados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void adicionarLivroEmprestado(Livro livro) {
        livrosEmprestados.add(livro);
    }

    public void removerLivroEmprestado(Livro livro) {
        livrosEmprestados.remove(livro);
    }

    public boolean possuiLivroEmprestado(Livro livro) {
        return livrosEmprestados.contains(livro);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Usuario other = (Usuario) obj;
        return cpf != null && cpf.equals(other.getCpf());
    }
}
