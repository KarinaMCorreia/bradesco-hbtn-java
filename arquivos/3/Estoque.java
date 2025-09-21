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
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;
                String[] cols = linha.split(",", -1);
                if (cols.length < 4) continue;

                int id = Integer.parseInt(cols[0].trim());
                String nome = cols[1].trim();
                int quantidade = Integer.parseInt(cols[2].trim());
                double preco = Double.parseDouble(cols[3].trim());

                produtos.add(new Produto(id, nome, quantidade, preco));
                if (id >= proximoId) proximoId = id + 1;
            }
        } catch (IOException | NumberFormatException e) {
        }
    }

    private void salvarNoArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo, false))) {
            for (Produto p : produtos) {
                bw.write(p.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
        }
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        if (nome == null || nome.trim().isEmpty()) return;
        if (quantidade < 0) return;
        if (preco < 0) return;

        Produto novo = new Produto(proximoId++, nome.trim(), quantidade, preco);
        produtos.add(novo);
        salvarNoArquivo();
    }

    public void excluirProduto(int id) {
        for (Iterator<Produto> it = produtos.iterator(); it.hasNext(); ) {
            if (it.next().getId() == id) {
                it.remove();
                salvarNoArquivo();
                return;
            }
        }
    }

    public void atualizarQuantidade(int id, int novaQuantidade) {
        if (novaQuantidade < 0) return;
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setQuantidade(novaQuantidade);
                salvarNoArquivo();
                return;
            }
        }
    }

    public void exibirEstoque() {
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }
}