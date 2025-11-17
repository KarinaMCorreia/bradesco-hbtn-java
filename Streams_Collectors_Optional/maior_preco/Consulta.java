import java.util.Comparator;
import java.util.List;

public class Consulta {

    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {
        return produtos.stream()
                .sorted(Comparator.comparing(Produto::getPreco).reversed())
                .findFirst()
                .orElse(null);
    }
}