import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public final class ConsultaPessoas {

    private ConsultaPessoas() {
    }

    public static Map<String, List<Pessoa>> obterPessoasPorCargo(List<Pessoa> pessoas) {
        Objects.requireNonNull(pessoas, "lista de pessoas nao pode ser nula");

        return pessoas.stream()
                .collect(Collectors.groupingBy(Pessoa::getCargo));
    }
}