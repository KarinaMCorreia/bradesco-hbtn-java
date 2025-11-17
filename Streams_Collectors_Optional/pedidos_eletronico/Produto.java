import java.util.Objects;

public class Produto {

    private final int codigo;
    private final String nome;
    private final CategoriaProduto categoria;
    private final double preco;

    public Produto(int codigo, String nome, CategoriaProduto categoria, double preco) {
        this.codigo = codigo;
        this.nome = Objects.requireNonNull(nome, "nome nao pode ser nulo");
        this.categoria = Objects.requireNonNull(categoria, "categoria nao pode ser nula");
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }
}