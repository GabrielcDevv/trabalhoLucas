public class Pedidos {

    private int numeroPedido;
    private Produtos[] produtos;
    private int quantidadeProdutos;
    private String status;

    public Pedidos(int numeroPedido, int capacidade) {
        this.numeroPedido = numeroPedido;
        this.produtos = new Produtos[capacidade];
        this.quantidadeProdutos = 0;
        this.status = "Pendente";
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    
    public Produtos[] getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos[] produtos) {
        this.produtos = produtos;
    }

  
    public int getQuantidadeProdutos() {
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

    public void adicionarProduto(Produtos produto) {

        if (quantidadeProdutos < produtos.length) {
            produtos[quantidadeProdutos] = produto;
            quantidadeProdutos++;

            System.out.println("Produto adicionado ao pedido!");
        } else {
            System.out.println("O pedido está cheio!");
        }
    }

    public void removerProduto(int posicao) {

        if (posicao >= 0 && posicao < quantidadeProdutos) {

            for (int i = posicao; i < quantidadeProdutos - 1; i++) {
                produtos[i] = produtos[i + 1];
            }

            produtos[quantidadeProdutos - 1] = null;
            quantidadeProdutos--;

            System.out.println("Produto removido!");
        } else {
            System.out.println("Posição inválida!");
        }
    }

    public double calcularTotal() {

        double total = 0;

        for (int i = 0; i < quantidadeProdutos; i++) {
            total += produtos[i].getPreco();
        }

        return total;
    }

    public void exibirPedido() {

        System.out.println("\n===== PEDIDO =====");
        System.out.println("Número: " + numeroPedido);
        System.out.println("Status: " + status);

        System.out.println("\nProdutos:");

        if (quantidadeProdutos == 0) {
            System.out.println("Nenhum produto no pedido.");
        } else {

            for (int i = 0; i < quantidadeProdutos; i++) {

                System.out.println(
                    (i + 1) + " - " +
                    produtos[i].getNome() +
                    " - R$ " +
                    String.format("%.2f", produtos[i].getPreco())
                );
            }
        }

        System.out.println("-------------------");
        System.out.printf("TOTAL: R$ %.2f%n", calcularTotal());
    }
}