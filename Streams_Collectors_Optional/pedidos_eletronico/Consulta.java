import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Consulta {

    private Consulta() {
    }

    public static List<Pedido> obterPedidosComEletronicos(List<Pedido> pedidos) {
        Objects.requireNonNull(pedidos, "pedidos nao pode ser nulo");

        return pedidos.stream()
                .filter(pedido -> pedido.getProdutos().stream()
                        .anyMatch(produto -> produto.getCategoria() == CategoriaProduto.ELETRONICO))
                .collect(Collectors.toList());
    }
}