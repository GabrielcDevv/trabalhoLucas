package Lanchonete;


public class Produto {

    private int tipoProduto;
    private String nome;
    private double preco;

    Produto(int tipoProduto, String nome, double preco){
        this.tipoProduto = tipoProduto;
        setNome(nome);
        setPreco(preco);
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public int getTipoProduto() {
        return this.tipoProduto;
    }
    
    public double trocaPreco(double preco) {
    
        if (preco != getPreco() && preco > 0) {
            setPreco(preco);
        } else {
            System.out.println("Troca de valor invalida, preco não atualizado\n");
        }
        return getPreco();
    }

    public String trocaNome(String nome) {
        if (nome.equals(getNome())) {
            System.out.println("Troca de nome invalida, não realizada \n");
        } else {
            setNome(nome);
        }
        return getNome();

    }

     public double getPreco() {
        return this.preco;
    }

    public String getNome() {
        return this.nome;
    }

}