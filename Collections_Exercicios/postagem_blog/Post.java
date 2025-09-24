import java.util.Objects;

public class Post implements Comparable<Post> {

    private Autor autor;
    private String titulo;
    private String corpo;
    private Categorias categoria;

    public Post(Autor autor, String titulo, String corpo, Categorias categoria) {
        this.autor = autor;
        this.titulo = titulo;
        this.corpo = corpo;
        this.categoria = categoria;
    }

    public Autor getAutor() { return autor; }
    public String getTitulo() { return titulo; }
    public String getCorpo() { return corpo; }
    public Categorias getCategoria() { return categoria; }

    @Override
    public String toString() {
        return titulo;
    }

    @Override
    public int compareTo(Post other) {
        int cmp = this.titulo.compareTo(other.titulo);
        if (cmp != 0) return cmp;
        return this.autor.toString().compareTo(other.autor.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return Objects.equals(autor, post.autor) &&
                Objects.equals(titulo, post.titulo) &&
                Objects.equals(corpo, post.corpo) &&
                categoria == post.categoria;
    }

    @Override
    public int hashCode() {
        return Objects.hash(autor, titulo, corpo, categoria);
    }
}