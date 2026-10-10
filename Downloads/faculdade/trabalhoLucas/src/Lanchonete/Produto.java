package Lanchonete;

import java.util.ArrayList;
import java.util.List;

public class Produto {
    private int id;
    private int tipoProduto;
    private String nome;
    private double preco;
    private List <Produto> produtos;

    Produto(int id, int tipoProduto, String nome, double preco) {
        this.id = id;
        this.tipoProduto = tipoProduto;
        setNome(nome);
        setPreco(preco);
        this.produtos= new ArrayList<>();
    }

    public String setNome(String nome) {
        this.nome = nome;
        return this.nome;
    }

    public double setPreco(double preco) {
        this.preco = preco;
        return this.preco;
    }
    public double adicionarProduto(Produto p){
        this.produtos.add(p);
        return 0;
    }
    
    public void getNome(){
        System.out.println(this.nome);
    }
    public void getPreco(){
        System.out.println(this.preco);
    }
    
    public void getLista(){
        produtos.forEach(p -> p.getNome());
        produtos.forEach(p-> p.getPreco());
    }    

}
