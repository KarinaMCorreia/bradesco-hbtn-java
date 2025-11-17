import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Pedido {

    private final int codigo;
    private final List<Produto> produtos;
    private final Cliente cliente;

    public Pedido(int codigo, List<Produto> produtos, Cliente cliente) {
        this.codigo = codigo;
        this.produtos = Collections.unmodifiableList(
                Objects.requireNonNull(produtos, "produtos nao pode ser nulo")
        );
        this.cliente = Objects.requireNonNull(cliente, "cliente nao pode ser nulo");
    }

    public int getCodigo() {
        return codigo;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "[" + codigo + "] " + cliente.getNome();
    }
}