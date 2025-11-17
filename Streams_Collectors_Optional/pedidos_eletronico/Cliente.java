import java.util.Objects;

public class Cliente {

    private final int codigo;
    private final String nome;
    private final boolean premium;

    public Cliente(int codigo, String nome, boolean premium) {
        this.codigo = codigo;
        this.nome = Objects.requireNonNull(nome, "nome nao pode ser nulo");
        this.premium = premium;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public boolean isPremium() {
        return premium;
    }
}