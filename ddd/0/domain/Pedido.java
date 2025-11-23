package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pedido {

    private final String id;
    private Cliente cliente;
    private List<Produto> produtos;
    private StatusPedido status;

    public Pedido(Cliente cliente) {
        this.id = UUID.randomUUID().toString();
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        this.status = StatusPedido.PENDENTE;
    }

    public void adicionarProduto(Produto produto) {
        if (produto != null) {
            this.produtos.add(produto);
        }
    }

    public void removerProduto(Produto produto) {
        if (produto != null) {
            this.produtos.remove(produto);
        }
    }

    public void pagar() {
        // regra simples: só paga se não estiver cancelado
        if (this.status == StatusPedido.PENDENTE) {
            this.status = StatusPedido.PAGO;
        }
    }

    public void cancelar() {
        // se ainda não estiver pago, pode cancelar
        if (this.status == StatusPedido.PENDENTE) {
            this.status = StatusPedido.CANCELADO;
        }
    }

    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public StatusPedido getStatus() {
        return status;
    }
}