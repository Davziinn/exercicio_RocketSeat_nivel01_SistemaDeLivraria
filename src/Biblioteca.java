import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> listarLivros (){
        return livros;
    }

    public List<Livro> listarLivrosDiponiveis() {
        List<Livro> livrosDiponiveis = new ArrayList<>();

        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                livrosDiponiveis.add(livro);
            }
        }
        return livrosDiponiveis;
    }

    public Livro buscarLivro(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    public void atualizarLivro(int id, String novoNome) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                livro.setTitulo(novoNome);
                break;
            }
        }
    }

    public void removerLivro(int id) {
        livros.removeIf(livro -> livro.getId() == id);
    }

    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    public List<Autor> listarAutor(){
        return autores;
    }

    public void atualizarAutor(int id, String novoNome) {
        for (Autor autor : autores) {
            if (autor.getId() == id) {
                autor.setNome(novoNome);
                break;
            }
        }
    }

    public void removerAutor(int id) {
        autores.removeIf(autor -> autor.getId() == id);
    }

    public void emprestarLivro(Livro livro, String nomeUsuario) {
        if(livro.isDisponivel()) {
            Emprestimo emprestimo = new Emprestimo(livro, nomeUsuario);
            emprestimos.add(emprestimo);
            livro.setDisponivel(false);
        } else {
            System.out.println("Livro não está disponível para empréstimo");
        }
    }

    public void devolverLivro(int idEmprestimo){
        for (Emprestimo emprestimo : emprestimos) {
            if(emprestimo.getId() == idEmprestimo && emprestimo.isAtivo()) {
                emprestimo.devolverLivro();
                break;
            }
        }
    }

    public List<Emprestimo> listarEmprestimo() {
        return emprestimos;
    }

}
