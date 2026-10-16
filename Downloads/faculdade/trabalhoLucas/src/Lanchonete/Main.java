package Lanchonete;
import java.util.Scanner;

public class Main{
    static Produtos produtoLista = new Produtos();

    public static void cadastrarProduto() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Qual o tipo de produto voce deseja cadastrar\n");
        System.out.println("1-Comida\n");
        System.out.println("2-Bebida\n");
        int tipoProduto = scanner.nextInt();

        System.out.println("Qual o nome do produto?");
        String nome = scanner.next();

        System.out.println("Qual o valor do produto?");
        double preco = scanner.nextDouble();

        Produto produto = new Produto(tipoProduto, nome, preco);
        produtoLista.adcionarNaLista(produto);;
        produtoLista.getProdutos();
   
        

    }

    public static void menuProduto(){
                Scanner scanner = new Scanner(System.in);
                System.out.println("O que voce quer fazer?\n");
                System.out.println("1-Cadastrar novo produto\n");
                System.err.println("2-Modificar um produto\n");
                System.out.println("3-Sair");
                int escolha = scanner.nextInt();

                switch(escolha){
                 case 1 ->{
                    Main.cadastrarProduto();
                    menuProduto();
                    break;
                 }
                 case 2->{
                    System.out.println("Escolha o numero produto voce quer modificar\n");
                    produtoLista.getProdutos();
                    int produtoParaMudanca = scanner.nextInt();
                    produtoLista.produtoParaMudanca(produtoParaMudanca);
                    menuProduto();
                 }
                 case 3->{
                    menuPrincipal();
                 }
                }
    }
    public static void menuPrincipal(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("O que voce deseja fazer\n");
        System.out.println("1-Pedido\n");
        System.out.println("2-Produto\n");
        System.out.println("3-Cliente\n");
        int escolha = scanner.nextInt();
        switch (escolha) {
            case 1 -> {
                //pedido
            }
            case 2 -> {
                Main.menuProduto();
                }
            case 3 ->{
                //cliente
            }
            }
    }

    public static void main(String[] args) {
        Main.menuPrincipal();
        
    }
}