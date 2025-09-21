import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GestaoAlunos {

    private final List<Aluno> alunos = new ArrayList<>();

    // Adiciona um aluno
    public void adicionarAluno(String nome, int idade) {
        alunos.add(new Aluno(nome, idade));
    }

    // Exclui um aluno pelo nome (ignora maiusculas/minusculas)
    public boolean excluirAluno(String nome) {
        Iterator<Aluno> it = alunos.iterator();
        while (it.hasNext()) {
            Aluno a = it.next();
            if (a.getNome().equalsIgnoreCase(nome)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    // Busca um aluno pelo nome (ignora maiusculas/minusculas)
    public Aluno buscarAluno(String nome) {
        for (Aluno a : alunos) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                return a;
            }
        }
        return null;
    }

    // Lista todos os alunos
    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        for (Aluno a : alunos) {
            System.out.println(a);
        }
    }

    // Demonstração das operacoes solicitadas
    public static void main(String[] args) {
        GestaoAlunos gestao = new GestaoAlunos();

        // Adicionar tres alunos
        gestao.adicionarAluno("Ana", 20);
        gestao.adicionarAluno("Bruno", 22);
        gestao.adicionarAluno("Carla", 19);

        // Exibir lista
        System.out.println("Alunos cadastrados:");
        gestao.listarAlunos();
        System.out.println();

        // Buscar um aluno
        System.out.println("Buscando aluno 'Bruno':");
        Aluno achado = gestao.buscarAluno("Bruno");
        if (achado != null) {
            System.out.println("Encontrado: " + achado);
        } else {
            System.out.println("Aluno 'Bruno' nao encontrado.");
        }
        System.out.println();

        // Excluir um aluno
        System.out.println("Excluindo aluno 'Ana':");
        boolean removido = gestao.excluirAluno("Ana");
        System.out.println(removido ? "Aluno 'Ana' removido." : "Aluno 'Ana' nao encontrado.");
        System.out.println();

        // Tentar excluir um inexistente e buscar outro
        System.out.println("Excluindo aluno 'Daniel':");
        System.out.println(gestao.excluirAluno("Daniel") ? "Aluno 'Daniel' removido." : "Aluno 'Daniel' nao encontrado.");
        System.out.println();

        System.out.println("Buscando aluno 'Ana':");
        System.out.println(gestao.buscarAluno("Ana") != null ? "Encontrado." : "Aluno 'Ana' nao encontrado.");
        System.out.println();

        // Exibir lista final
        System.out.println("Alunos cadastrados (final):");
        gestao.listarAlunos();
    }
}