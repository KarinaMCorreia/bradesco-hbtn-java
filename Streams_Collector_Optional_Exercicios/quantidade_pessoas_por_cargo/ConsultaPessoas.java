import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class ConsultaPessoas {

    private ConsultaPessoas() {
    }

    public static Map<String, Long> obterContagemPessoasPorCargo(List<Pessoa> pessoas) {

        return pessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo,
                        Collectors.counting()
                ));
    }
}