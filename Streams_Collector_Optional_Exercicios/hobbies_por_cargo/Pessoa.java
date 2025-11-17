import java.util.List;
import java.util.Objects;

public class Pessoa implements Comparable<Pessoa> {

    private final int codigo;
    private final String nome;
    private final String cargo;
    private final int idade;
    private final double salario;
    private final List<String> hobbies;

    public Pessoa(int codigo, String nome, String cargo, int idade, double salario, List<String> hobbies) {
        this.codigo = codigo;
        this.nome = Objects.requireNonNull(nome, "nome nao pode ser nulo");
        this.cargo = Objects.requireNonNull(cargo, "cargo nao pode ser nulo");
        this.idade = idade;
        this.salario = salario;
        this.hobbies = Objects.requireNonNull(hobbies, "hobbies nao pode ser nulo");
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public int getIdade() {
        return idade;
    }

    public double getSalario() {
        return salario;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    @Override
    public String toString() {
        String salarioFormatado = String.format("%.6f", salario).replace('.', ',');
        return "[" + codigo + "] "
                + nome + " "
                + cargo + " "
                + idade + " R$ "
                + salarioFormatado;
    }

    @Override
    public int compareTo(Pessoa outra) {
        return this.nome.compareTo(outra.nome);
    }
}