import java.util.function.Consumer;
import java.util.function.Supplier;

public class Produto {

    private String nome;
    private Double preco;
    private Double percentualMarkup = 10d;

    public Supplier<Double> precoComMarkup = () -> {
        return preco + (preco * percentualMarkup / 100);
    };

    public Consumer<Double> atualizarMarkup = (novoValor) -> {
        percentualMarkup = novoValor;
    };

    public Produto(Double preco, String nome) {
        this.preco = preco;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Double getPercentualMarkup() {
        return percentualMarkup;
    }
}