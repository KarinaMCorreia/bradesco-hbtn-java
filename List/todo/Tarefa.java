public class Tarefa {
    private String descricao;
    private boolean estahFeita;
    private int identificador;

    public Tarefa(String descricao, int identificador) {
        validarDescricao(descricao);
        this.descricao = descricao;
        this.identificador = identificador;
        this.estahFeita = false; // inicia não feita
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isEstahFeita() {
        return estahFeita;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void modificarDescricao(String novaDescricao) {
        validarDescricao(novaDescricao);
        this.descricao = novaDescricao;
    }

    public void marcarFeita() {
        this.estahFeita = true;
    }

    public void marcarNaoFeita() {
        this.estahFeita = false;
    }

    private void validarDescricao(String d) {
        if (d == null || d.trim().isEmpty()) {
            throw new IllegalArgumentException("Descricao de tarefa invalida");
        }
    }
}
