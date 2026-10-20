package Lanchonete;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Produtos{

    Scanner scan = new Scanner(System.in);

   private List <Produto> produtos = new ArrayList<>();


    public  void adcionarNaLista(Produto produto){
        this.produtos.addLast(produto);
    }



    public void getProdutos(){
         for (Produto produto : produtos) {
             System.out.println("Numero produto: " + produtos.indexOf(produto));
             System.out.println("Tipo do produto: " + produto.getTipoProduto());
             System.out.println("Nome produto: " + produto.getNome());
             System.out.println("Preco  do produto: " + produto.getPreco());
             System.out.println("----------------------------------------------");
         }

    }


    public Produto produtoParaMudanca(int produtoParaMudanca){
        Produto produto = produtos.get(produtoParaMudanca);
        System.out.println("Qual o tipo de mudanca voce quer fazer?\n");
        System.out.println("1-Nome\n");
        System.out.println("2-Preco\n");
        int tipoMudanca =  scan.nextInt();
        switch (tipoMudanca) {
            case 1 ->{
                System.out.println("Qual o novo nome?");
                String novoNome = scan.next();
                produto.trocaNome(novoNome);
            }
            case 2 ->{
                System.out.println("Qual o novo preco?");
                double novoPreco = scan.nextDouble();
                produto.trocaPreco(novoPreco);
            }
            default ->  {
                Main.menuProduto();
            }
        }
        return produto;
    }

    public Produto buscarProduto(int indice) {
        if (indice < 0 || indice >= produtos.size()) return null;
        return produtos.get(indice);
    }
}