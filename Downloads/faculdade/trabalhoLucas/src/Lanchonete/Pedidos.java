import Lanchonete.Produto;


public class Pedidos {

    private int numeroPedido;
    private Produto[] produto;
    private int quantidadeProdutos;
    private String status;

    private int capacidade;


    public Pedidos(int numeroPedido, int capacidade) {
        this.numeroPedido = numeroPedido;
        this.produto = new Produto[capacidade];
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

    
    public Produto[] getProduto() {
        return produto;
    }

    public void setProduto(Produto[] produto) {
        this.produto = produto;
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


    public void removerProduto(int posicao) {

        if (posicao >= 0 && posicao < quantidadeProdutos) {

            for (int i = posicao; i < quantidadeProdutos - 1; i++) {
                produto[i] = produto[i + 1];
            }

            produto[quantidadeProdutos - 1] = null;
            quantidadeProdutos--;

            System.out.println("Produto removido!");
        } else {
            System.out.println("Posição inválida!");
        }
    }

    public double calcularTotal() {

        double total = 0;

        for (int i = 0; i < quantidadeProdutos; i++) {
            total += produto[i].getPreco();
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
                    produto[i].getNome() +
                    " - R$ " +
                    String.format("%.2f", produto[i].getPreco())
                );
            }
        }

        System.out.println("-------------------");
        System.out.printf("TOTAL: R$ %.2f%n", calcularTotal());
    }
}