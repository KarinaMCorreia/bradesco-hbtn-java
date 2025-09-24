import java.util.*;

public class Blog {

    private List<Post> postagens;

    public Blog() {
        this.postagens = new ArrayList<>();
    }

    public void adicionarPostagem(Post postagem) {
        if (postagem != null) {
            postagens.add(postagem);
        }
    }

    public Set<String> obterTodosAutores() {
        Set<String> autoresOrdenados = new TreeSet<>();
        for (Post p : postagens) {
            String autor = p.getAutor();
            if (autor != null && !autor.isEmpty()) {
                autoresOrdenados.add(autor);
            }
        }
        return autoresOrdenados;
    }

    public Map<String, Integer> obterContagemPorCategoria() {
        Map<String, Integer> contagem = new TreeMap<>();
        for (Post p : postagens) {
            String categoria = p.getCategoria();
            if (categoria != null && !categoria.isEmpty()) {
                contagem.put(categoria, contagem.getOrDefault(categoria, 0) + 1);
            }
        }
        return contagem;
    }
}
