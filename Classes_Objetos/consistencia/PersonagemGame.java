public class PersonagemGame {

    private int saudeAtual;
    private String nome;
    private String status; // "vivo" ou "morto"

    // Construtor garantindo consistência inicial
    public PersonagemGame(int saudeAtual, String nome) {
        setNome(nome);           // mantém nome consistente (não aceita null/"" no setter)
        setSaudeAtual(saudeAtual); // também define o status conforme a saúde
    }

    public int getSaudeAtual() {
        return saudeAtual;
    }

    // Setter centraliza regras de consistência (0..100) e atualiza status
    public void setSaudeAtual(int saudeAtual) {
        if (saudeAtual < 0) {
            this.saudeAtual = 0;
        } else if (saudeAtual > 100) {
            this.saudeAtual = 100;
        } else {
            this.saudeAtual = saudeAtual;
        }
        // status depende exclusivamente da saúde atual
        if (this.saudeAtual > 0) {
            this.status = "vivo";
        } else {
            this.status = "morto";
        }
    }

    public String getNome() {
        return nome;
    }

    // Não aceita nome nulo ou vazio; mantém o atual se vier inválido
    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            // ignora alteração inválida
            return;
        }
        this.nome = nome;
    }

    // Usa SEMPRE o setter de saúde para manter a lógica em um único ponto
    public void tomarDano(int quantidadeDeDano) {
        setSaudeAtual(this.saudeAtual - quantidadeDeDano);
    }

    public void receberCura(int quantidadeDeCura) {
        setSaudeAtual(this.saudeAtual + quantidadeDeCura);
    }

    // Somente leitura
    public String getStatus() {
        return status;
    }
}