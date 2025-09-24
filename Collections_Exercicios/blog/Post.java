import java.util.Objects;

public class Post {

    private String autor;
    private String titulo;
    private String corpo;
    private String categoria;

    public Post(String autor, String titulo, String corpo, String categoria) {
        this.autor = autor;
        this.titulo = titulo;
        this.corpo = corpo;
        this.categoria = categoria;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return Objects.equals(autor, post.autor) &&
                Objects.equals(titulo, post.titulo) &&
                Objects.equals(corpo, post.corpo) &&
                Objects.equals(categoria, post.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autor, titulo, corpo, categoria);
    }
}
