import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class ConsultaPessoas {

    private ConsultaPessoas() {
    }

    public static Map<String, Map<Integer, Long>> obterContagemPessoasPorCargoEIdade(
            List<Pessoa> pessoas) {

        return pessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo,
                        Collectors.groupingBy(
                                Pessoa::getIdade,
                                Collectors.counting()
                        )
                ));
    }
}