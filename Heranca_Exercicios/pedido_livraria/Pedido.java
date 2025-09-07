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
}