import java.util.Locale;

public class Pedido {

    private double percentualDesconto; // em %
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double calcularTotal() {
        double total = 0.0;
        if (itens != null) {
            for (ItemPedido item : itens) {
                total += item.getQuantidade() * item.getProduto().obterPrecoLiquido();
            }
        }
        double fatorDesconto = 1.0 - (percentualDesconto / 100.0);
        return total * fatorDesconto;
    }

    public void apresentarResumoPedido() {
        System.out.println("------- RESUMO PEDIDO -------");

        double totalProdutos = 0.0;
        for (ItemPedido item : itens) {
            produtos.Produto produto = item.getProduto();
            String tipo = produto.getClass().getSimpleName();
            double preco = produto.obterPrecoLiquido();
            int quant = item.getQuantidade();
            double totalItem = preco * quant;
            totalProdutos += totalItem;

            System.out.printf(
                    "Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f\n",
                    tipo, produto.getTitulo(), preco, quant, totalItem
            );
        }

        double desconto = totalProdutos * (percentualDesconto / 100.0);
        double totalPedido = calcularTotal();

        System.out.println("----------------------------");
        System.out.printf("DESCONTO: %.2f\n", desconto);
        System.out.printf("TOTAL PRODUTOS: %.2f\n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f\n", totalPedido);
        System.out.println("----------------------------");
    }
}