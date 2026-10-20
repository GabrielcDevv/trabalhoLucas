package Lanchonete;

public class Pedidos {
    private int numeroPedido;
    private Cliente cliente;
    private Produto[] produtos;
    private int quantidadeProdutos;
    private String status;
    private int capacidade;

    public Pedidos(int numeroPedido, int capacidade) {
        if (capacidade <= 0) throw new IllegalArgumentException("Capacidade deve ser positiva.");
        this.numeroPedido = numeroPedido;
        this.capacidade = capacidade;
        this.produtos = new Produto[capacidade];
        this.quantidadeProdutos = 0;
        this.status = "Pendente";
    }

    public int getNumeroPedido() { return numeroPedido; }
    public void setNumeroPedido(int numeroPedido) { this.numeroPedido = numeroPedido; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Produto[] getProdutos() { return produtos.clone(); }
    public void setProdutos(Produto[] novosProdutos) {
        if (novosProdutos == null || novosProdutos.length > capacidade)
            throw new IllegalArgumentException("Lista de produtos invalida.");
        Produto[] copia = new Produto[capacidade];
        for (int i = 0; i < novosProdutos.length; i++) {
            if (novosProdutos[i] == null) throw new IllegalArgumentException("Produto nulo.");
            copia[i] = novosProdutos[i];
        }
        produtos = copia;
        quantidadeProdutos = novosProdutos.length;
    }

    public int getQuantidadeProdutos() { return quantidadeProdutos; }
    public int getQuantidadeProduto() { return quantidadeProdutos; }
    public void setQuantidadeProdutos(int quantidade) {       
        if (quantidade < 0 || quantidade > quantidadeProdutos)
            throw new IllegalArgumentException("Use adicionarProduto para aumentar a quantidade.");
        for (int i = quantidade; i < quantidadeProdutos; i++) produtos[i] = null;
        quantidadeProdutos = quantidade;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty())
            throw new IllegalArgumentException("Status invalido.");
        this.status = status;
    }

    public int getCapacidade() { return capacidade; }
    public void setCapacidade(int novaCapacidade) {
        if (novaCapacidade < quantidadeProdutos || novaCapacidade <= 0)
            throw new IllegalArgumentException("Capacidade menor que os produtos atuais.");
        Produto[] novoArray = new Produto[novaCapacidade];
        for (int i = 0; i < quantidadeProdutos; i++) novoArray[i] = produtos[i];
        produtos = novoArray;
        capacidade = novaCapacidade;
    }

    public boolean adicionarProduto(Produto produto) {
        if (produto == null || quantidadeProdutos >= capacidade) return false;
        produtos[quantidadeProdutos] = produto;
        quantidadeProdutos++;
        return true;
    }

    public boolean removerProduto(int posicao) {
        if (posicao < 0 || posicao >= quantidadeProdutos) return false;
        for (int i = posicao; i < quantidadeProdutos - 1; i++)
            produtos[i] = produtos[i + 1];
        produtos[quantidadeProdutos - 1] = null;
        quantidadeProdutos--;
        return true;
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < quantidadeProdutos; i++) total += produtos[i].getPreco();
        return total;
    }

    public void exibirPedido() {
        System.out.println("PEDIDO " + numeroPedido + " ");
        System.out.println("Cliente: " + (cliente == null ? "Nao informado" : cliente.getNome()));
        System.out.println("Status: " + status);
        System.out.println("Produtos: " + quantidadeProdutos + "/" + capacidade);
        for (int i = 0; i < quantidadeProdutos; i++) {
            System.out.printf("%d - %s - R$ %.2f%n", i, produtos[i].getNome(), produtos[i].getPreco());
        }
        System.out.printf("TOTAL: R$ %.2f%n", calcularTotal());
    }
}
