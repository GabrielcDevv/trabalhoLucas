package Lanchonete;

import java.util.ArrayList;
import java.util.List;

public class Produto {

    private int id;
    private int tipoProduto;
    private String nome;
    private double preco;
    private List<Produto> produtos;

    Produto(int id, int tipoProduto, String nome, double preco) {
        this.id = id;
        this.tipoProduto = tipoProduto;
        setNome(nome);
        setPreco(preco);
        this.produtos = new ArrayList<>();
    }

    public double adicionarProduto(Produto p) {
        this.produtos.add(p);
        return 0;
    }

    public String setNome(String nome) {
        this.nome = nome;
        return this.nome;
    }

    public double setPreco(double preco) {
        this.preco = preco;
        return this.preco;
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
    
    public int getId(){
        return this.id;
    }
    
    public void getProduto() {
        System.out.println(getId());
        System.out.println("O nome desse item é: " + getNome());
        System.out.println("O valor desse item é: " + getPreco());
        System.out.println("------------------------------------");
    }

    public void getLista() {
        produtos.forEach(p -> p.getProduto());
    }
    

    
    
}