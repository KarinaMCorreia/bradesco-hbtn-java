import java.util.ArrayList;
import java.util.List;
import atividades.Atividade;

public class Workflow {

    private List<Atividade> atividades = new ArrayList<>();

    public void registrarAtividade(Atividade atividade) {
        if (atividade != null) {
            atividades.add(atividade);
        }
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }
}