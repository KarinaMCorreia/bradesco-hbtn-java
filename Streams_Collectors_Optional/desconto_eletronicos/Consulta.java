import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Consulta {

    private Consulta() {
    }

    public static List<Produto> aplicar15PorcentoDescontoEletronicos(List<Produto> produtos) {
        Objects.requireNonNull(produtos, "produtos nao pode ser nulo");

        return produtos.stream()
                .map(produto -> {
                    if (produto.getCategoria() == CategoriaProduto.ELETRONICO) {
                        double novoPreco = produto.getPreco() * 0.85;
                        produto.setPreco(novoPreco);
                    }
                    return produto;
                })
                .collect(Collectors.toList());
    }
}