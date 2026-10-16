package Lanchonete;


public class Produto {

    private int tipoProduto;
    private String nome;
    private double preco;

    Produto(int tipoProduto, String nome, double preco){
        this.tipoProduto = tipoProduto;
        this.nome = nome;
        this.preco = preco;
    }

    public int getTipoProduto() {
        return this.tipoProduto;
    }
    
    public double trocaPreco(double preco) {
        if (preco != this.preco && preco > 0) {
            this.preco = preco;
        } else {
            System.out.println("Troca de valor invalida, preco não atualizado\n");
        }
        return this.preco;
    }

    public String trocaNome(String nome) {
        if (nome.equals(this.nome)) {
            System.out.println("Troca de nome invalida, não realizada \n");
        } else {
            this.nome = nome;
        }
        return this.nome;

    }

    public double getPreco() {
        return this.preco;
    }

    public String getNome() {
        return this.nome;
    }

}
