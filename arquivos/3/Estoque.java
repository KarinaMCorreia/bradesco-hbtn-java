import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Estoque {

    private final String caminhoArquivo;
    private final List<Produto> produtos = new ArrayList<>();
    private int proximoId = 1;

    public Estoque(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
        carregarDoArquivo();
    }

    private void carregarDoArquivo() {
        produtos.clear();
        proximoId = 1;

        File f = new File(caminhoArquivo);
        if (!f.exists()) {
            try {
                f.getParentFile();
                f.createNewFile();
            } catch (IOException ignored) {}
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;
                String[] cols = linha.split(",", -1);
                if (cols.length < 4) continue; // ignora linhas malformadas

                int id = Integer.parseInt(cols[0].trim());
                String nome = cols[1].trim();
                int quantidade = Integer.parseInt(cols[2].trim());
                double preco = Double.parseDouble(cols[3].trim());

                produtos.add(new Produto(id, nome, quantidade, preco));
                if (id >= proximoId) proximoId = id + 1;
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    private void salvarNoArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo, false))) {
            for (Produto p : produtos) {
                bw.write(p.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome inválido.");
            return;
        }
        if (quantidade < 0) {
            System.out.println("Quantidade deve ser um número não negativo.");
            return;
        }
        if (preco < 0) {
            System.out.println("Preço deve ser um número não negativo.");
            return;
        }

        Produto novo = new Produto(proximoId++, nome.trim(), quantidade, preco);
        produtos.add(novo);
        salvarNoArquivo();
        System.out.println("Produto adicionado: " + novo);
    }

    public void excluirProduto(int id) {
        boolean removido = false;
        for (Iterator<Produto> it = produtos.iterator(); it.hasNext(); ) {
            Produto p = it.next();
            if (p.getId() == id) {
                it.remove();
                removido = true;
                break;
            }
        }
        if (removido) {
            salvarNoArquivo();
            System.out.println("Produto de ID " + id + " removido.");
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    public void atualizarQuantidade(int id, int novaQuantidade) {
        if (novaQuantidade < 0) {
            System.out.println("Nova quantidade deve ser um número não negativo.");
            return;
        }
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setQuantidade(novaQuantidade);
                salvarNoArquivo();
                System.out.println("Quantidade atualizada: " + p);
                return;
            }
        }
        System.out.println("Produto com ID " + id + " não encontrado.");
    }

    public void exibirEstoque() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio.");
            return;
        }
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }
}