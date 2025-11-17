import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public final class ConsultaPessoas {

    private ConsultaPessoas() {
        // Impede instanciação
    }

    public static Map<String, List<Pessoa>> obterPessoasPorCargoAcimaDe40anos(List<Pessoa> pessoas) {
        Objects.requireNonNull(pessoas, "lista de pessoas nao pode ser nula");

        return pessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo,
                        Collectors.filtering(
                                p -> p.getIdade() > 40,
                                Collectors.toList()
                        )
                ));
    }
}