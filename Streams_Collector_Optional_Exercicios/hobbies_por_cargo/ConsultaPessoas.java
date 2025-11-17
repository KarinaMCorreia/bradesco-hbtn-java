import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public final class ConsultaPessoas {

    private ConsultaPessoas() {
    }

    public static Map<String, TreeSet<String>> obterHobbiesPorCargo(List<Pessoa> pessoas) {

        return pessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo,
                        Collectors.flatMapping(
                                pessoa -> pessoa.getHobbies().stream(),
                                Collectors.toCollection(TreeSet::new)
                        )
                ));
    }
}