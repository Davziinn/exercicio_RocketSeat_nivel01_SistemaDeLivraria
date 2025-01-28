import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        Autor autor1 = new Autor(1, "J.K. Rowling", new Date());
        Autor autor2 = new Autor(2, "J.R.R. Tolkien", new Date());

        biblioteca.adicionarAutor(autor1);
        biblioteca.adicionarAutor(autor2);

        Livro livro1 = new Livro(1, "Harry Potter e a Pedra Filosofal", autor1);
        Livro livro2 = new Livro(2, "O Senhor dos Anéis: A Sociedade do Anel", autor2);
        Livro livro3 = new Livro(3, "Harry Potter e a Câmara Secreta", autor1);

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);

        while (true) {
            System.out.print("Deseja ver os livros disponíveis? (sim/nao) ");
            String resposta = sc.nextLine().toLowerCase();

            if (resposta.equals("sim")) {
                List<Livro> livrosDispoiveis = biblioteca.listarLivrosDiponiveis();

                if (livrosDispoiveis.isEmpty()) {
                    System.out.println("Não há livros disponíveis no momento.");
                } else {
                    System.out.println("Esses são os nossos livros disponíveis no momento");
                    for (Livro livro : livrosDispoiveis) {
                        System.out.println(livro.getId() + ": " + livro.getTitulo());
                    }
                }

                System.out.print("Digite o ID do livro que você deseja pegar emprestado: ");
                int idLivro = sc.nextInt();
                sc.nextLine();

                Livro livroSelecionado = biblioteca.buscarLivro(idLivro);

                if (livroSelecionado != null && livroSelecionado.isDisponivel()) {
                    System.out.print("Digite seu nome: ");
                    String nomeUsuario = sc.nextLine();

                    biblioteca.emprestarLivro(livroSelecionado, nomeUsuario);
                    System.out.println("O livro " + livroSelecionado.getTitulo() + " foi emprestado para " + nomeUsuario);
                } else {
                    System.out.println("Livro não encontrado ou não disponível para empréstimo.");
                }

            } else if (resposta.equals("nao")){
                System.out.println("Obrigado por usar o sistema da nossa livraria.");
                break;
            } else {
                System.out.println("Resposta inválida. Por favor, responda com 'sim' ou 'não'.");
            }
        }
        sc.close();
    }
}
