import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Livro> livrosNaColecao;
    private ArrayList<Usuario> usuariosCadastrados;

    public Biblioteca() {
        this.livrosNaColecao = new ArrayList<>();
        this.usuariosCadastrados = new ArrayList<>();
    }

    public void listarLivrosNaColecao() {
        if (livrosNaColecao.isEmpty()) {
            System.out.println("A Biblioteca não tem livros em sua coleção");
            return;
        }

        System.out.println("Livros na coleção da Biblioteca:");
        for (Livro livro : livrosNaColecao) {
            System.out.println("- " + livro.getTitulo() + " (" + livro.getAutor() + ")");
        }
    }

    public void listarUsuariosCadastrados() {
        if (usuariosCadastrados.isEmpty()) {
            System.out.println("Nenhum usuário esta cadastrado no sistema da Biblioteca");
            return;
        }

        System.out.println("Usuários cadastrados no sistema:");
        for (Usuario usuario : usuariosCadastrados) {
            System.out.println("Nome: " + usuario.getNome() + " - CPF: " + usuario.getCpf());
        }
    }

    /*
        public void buscarLivroNaColecao(Livro livro) {
            if (livro == null || livro.getTitulo() == null || livro.getAutor() == null) {
                System.out.println("Livro deve existir e ter todas as informações");
                return;
            }

            if (!livrosNaColecao.contains(livro)) {
                System.out.println("Livro não existe na coleção");
                return;
            } else {
                if (!livro.isDisponivel()) {
                    System.out.println("Livro não esta disponível para empréstimo");
                    return;
                }

                System.out.println("Livro " + livro.getTitulo() + " (" + livro.getAutor() + ") esta disponível");
            }
        }
    */
    public void buscarLivroNaColecao(String titulo, String autor) {
        if (titulo == null || autor == null) {
            System.out.println("Título e Autor devem ser informados na busca");
            return;
        }

        for (Livro livro : livrosNaColecao) {
            if (livro.getTitulo().equalsIgnoreCase(titulo) && livro.getAutor().equalsIgnoreCase(autor)) {
                if (livro.isDisponivel()) {
                    System.out.println("Livro " + livro.getTitulo() + " (" + livro.getAutor() + ") esta disponível");
                } else {
                    System.out.println("Livro esta a coleção, porém indísponivel para empréstimo");
                }
                return;
            }
        }
        System.out.println("Livro não foi encontrado no Sistema");
    }

    public void adicionarLivroNaColecao(Livro novoLivro) {
        if (novoLivro == null || novoLivro.getAutor() == null || novoLivro.getTitulo() == null) {
            System.out.println("Inserção do novo livro inválida");
            return;
        }

        livrosNaColecao.add(novoLivro);
        System.out.println("Livro adicionado à coleção da Biblioteca com sucesso");
        listarLivrosNaColecao();
    }

    public void removerLivroDaColecao(Livro livro) {
        if (livro == null || livro.getAutor() == null || livro.getTitulo() == null) {
            System.out.println("Remoção do novo livro inválida: Livro deve existir");
            return;
        }

        if (!livrosNaColecao.contains(livro)) {
            System.out.println("Livro não esta na coleção da Biblioteca");
            return;
        }

        livrosNaColecao.remove(livro);
        System.out.println("Livro removido da coleção da Biblioteca com sucesso: " + livro.getTitulo() + " (" + livro.getAutor() + ")");
    }

    public void adicionarUsuarioNoSistema(Usuario novoUsuario) {
        if (novoUsuario == null || novoUsuario.getNome() == null || novoUsuario.getCpf() == null) {
            System.out.println("Usuário e suas informações devem existir");
            return;
        }

        if (usuariosCadastrados.contains(novoUsuario)) {
            System.out.println("Usuário já cadastrado no sistema");
            return;
        }

        usuariosCadastrados.add(novoUsuario);
        System.out.println("Usuário cadastrado com sucesso");
        System.out.println("Nome: " + novoUsuario.getNome() + " - " + novoUsuario.getCpf());
    }

    public void removerUsuarioDoSistema(Usuario usuario) {
        if (usuario == null || usuario.getNome() == null || usuario.getCpf() == null) {
            System.out.println("Usuário e suas informações devem existir");
            return;
        }

        if (!usuariosCadastrados.contains(usuario)) {
            System.out.println("Usuário não esta cadastrado no Sistema");
            return;
        }

        usuariosCadastrados.remove(usuario);
        System.out.println("Usuário removido do sistema");
        System.out.println("Nome: " + usuario.getNome() + " - " + usuario.getCpf());
    }

    public void emprestarLivro(Usuario usuario, Livro livro) {
        if (usuario == null || livro == null) {
            System.out.println("Usuário e Livro devem existir");
            return;
        }

        if (!livro.isDisponivel() || !livrosNaColecao.contains(livro)) {
            System.out.println("Livro não esta disponível para empréstimo");
            return;
        }

        if (!usuariosCadastrados.contains(usuario)) {
            System.out.println("Usuário não existe no sistema");
            return;
        }

        usuario.adicionarLivroEmprestado(livro);
        livro.setDisponivel(false);
        System.out.println("Empréstimo efetuado com sucesso");
        System.out.println(usuario.getNome() + " - " + livro.getTitulo() + " (" + livro.getAutor() + ")");
    }

    public void devolverLivro(Usuario usuario, Livro livro) {
        if (usuario == null || livro == null) {
            System.out.println("Usuário e Livro devem existir");
            return;
        }

        if (!usuariosCadastrados.contains(usuario)) {
            System.out.println("Usuário não existe no sistema");
            return;
        }

        if (!usuario.possuiLivroEmprestado(livro)) {
            System.out.println("Usuário não emprestou o livro");
            return;
        }

        usuario.removerLivroEmprestado(livro);
        livro.setDisponivel(true);
        System.out.println("Devolução efetuada com sucesso");
        System.out.println(usuario.getNome() + " - " + livro.getTitulo() + " (" + livro.getAutor() + ")");
    }
}