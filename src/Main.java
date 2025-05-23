import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("[1] - Listar livros");
            System.out.println("[2] - Listar usuários");
            System.out.println("[3] - Buscar livros");
            System.out.println("[4] - Adicionar livros");
            System.out.println("[5] - Remover livros");
            System.out.println("[6] - Adicionar usuários");
            System.out.println("[7] - Remover usuários");
            System.out.println("[8] - Emprestar livros");
            System.out.println("[9] - Devolver livros");
            System.out.println("[0] - Sair");

            System.out.println("Sua opção: ");
            int opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    biblioteca.listarLivrosNaColecao();
                    break;

                case 2:
                    biblioteca.listarUsuariosCadastrados();
                    break;

                case 3: {
                    System.out.println("Digite o título do livro: ");
                    String titulo = sc.nextLine();
                    System.out.println("Digite o autor do livro: ");
                    String autor = sc.nextLine();

                    biblioteca.buscarLivroNaColecao(titulo, autor);
                    break;
                }

                case 4: {
                    System.out.println("Digite o título do livro: ");
                    String titulo = sc.nextLine();
                    System.out.println("Digite o autor do livro: ");
                    String autor = sc.nextLine();

                    biblioteca.adicionarLivroNaColecao(new Livro(titulo, autor));
                    break;
                }

                case 5: {
                    System.out.println("Digite o título do livro: ");
                    String titulo = sc.nextLine();
                    System.out.println("Digite o autor do livro: ");
                    String autor = sc.nextLine();

                    biblioteca.removerLivroDaColecao(new Livro(titulo, autor));
                    break;
                }

                case 6: {
                    System.out.println("Digite o nome do usuário: ");
                    String nome = sc.nextLine();
                    System.out.println("Digite o CPF do usuário: ");
                    String cpf = sc.nextLine();

                    biblioteca.adicionarUsuarioNoSistema(new Usuario(nome, cpf));
                    break;
                }

                case 7: {
                    System.out.println("Digite o nome do usuário: ");
                    String nome = sc.nextLine();
                    System.out.println("Digite o CPF do usuário: ");
                    String cpf = sc.nextLine();

                    biblioteca.removerUsuarioDoSistema(new Usuario(nome, cpf));
                    break;
                }

                case 8: {
                    System.out.println("Digite o nome do usuário: ");
                    String nome = sc.nextLine();
                    System.out.println("Digite o CPF do usuário: ");
                    String cpf = sc.nextLine();

                    System.out.println("Digite o título do livro: ");
                    String titulo = sc.nextLine();
                    System.out.println("Digite o autor do livro: ");
                    String autor = sc.nextLine();

                    Usuario usuario = new Usuario(nome, cpf);
                    Livro livro = new Livro(titulo, autor);

                    biblioteca.emprestarLivro(usuario, livro);
                    break;
                }

                case 9: {
                    System.out.println("Digite o nome do usuário: ");
                    String nome = sc.nextLine();
                    System.out.println("Digite o CPF do usuário: ");
                    String cpf = sc.nextLine();

                    System.out.println("Digite o título do livro: ");
                    String titulo = sc.nextLine();
                    System.out.println("Digite o autor do livro: ");
                    String autor = sc.nextLine();

                    Usuario usuario = new Usuario(nome, cpf);
                    Livro livro = new Livro(titulo, autor);
                    biblioteca.devolverLivro(usuario, livro);
                    break;
                }

                case 0:
                    System.out.println("Sistema fechando");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
}
