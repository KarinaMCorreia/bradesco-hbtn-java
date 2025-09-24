import java.util.*;

public class Blog {

    private final List<Post> postagens;

    public Blog() {
        this.postagens = new ArrayList<>();
    }

    public void adicionarPostagem(Post postagem) {
        if (postagem == null) return;

        for (Post p : postagens) {
            if (p.getAutor().equals(postagem.getAutor()) &&
                    p.getTitulo().equals(postagem.getTitulo())) {
                throw new IllegalArgumentException("Postagem jah existente");
            }
        }
        postagens.add(postagem);
    }

    public Set<Autor> obterTodosAutores() {
        Set<Autor> autores = new TreeSet<>();
        for (Post p : postagens) {
            autores.add(p.getAutor());
        }
        return autores;
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagem = new EnumMap<>(Categorias.class);
        for (Post p : postagens) {
            Categorias cat = p.getCategoria();
            contagem.put(cat, contagem.getOrDefault(cat, 0) + 1);
        }
        return contagem;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> posts = new TreeSet<>();
        for (Post p : postagens) {
            if (p.getAutor().equals(autor)) {
                posts.add(p);
            }
        }
        return posts;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> posts = new TreeSet<>();
        for (Post p : postagens) {
            if (p.getCategoria() == categoria) {
                posts.add(p);
            }
        }
        return posts;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> mapa = new EnumMap<>(Categorias.class);
        for (Post p : postagens) {
            mapa.computeIfAbsent(p.getCategoria(), c -> new TreeSet<>()).add(p);
        }
        return mapa;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> mapa = new TreeMap<>();
        for (Post p : postagens) {
            mapa.computeIfAbsent(p.getAutor(), a -> new TreeSet<>()).add(p);
        }
        return mapa;
    }
}
