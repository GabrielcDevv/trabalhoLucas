package Lanchonete;

public class Pedidos {

    // ===== Atributos =====
    private int numeroPedido;
    private int quantidadeProdutos;
    private String status;
    private int capacidade;

    // ===== Construtor =====
    public Pedidos(int numeroPedido, int capacidade) {
        this.numeroPedido = numeroPedido;
        this.quantidadeProdutos = 0;
        this.status = "Pendente";
        this.capacidade = capacidade;
    }

    // ===== Getters e Setters =====

    // numeroPedido
    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    // quantidadeProdutos
    public int getQuantidadeProduto() {
        return quantidadeProdutos;
    }

    public void setQuantidadeProdutos(int quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
    }

    // status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // capacidade
    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}