package Lanchonete;

public class Pedidos {

    private int numeroPedido;
    private int quantidadeProdutos;
    private String status;
    private int capacidade;

    public Pedidos(int numeroPedido, int capacidade) {
        this.numeroPedido = numeroPedido;
        this.quantidadeProdutos = 0;
        this.status = "Pendente";
        this.capacidade = capacidade;
    }

    
    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public int getQuantidadeProduto() {
        return quantidadeProdutos;
    }

    public void setQuantidadeProdutos(int quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}