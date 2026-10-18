package Lanchonete;
import java.util.Scanner;

public class Main{

  private static final int MAX_PEDIDOS = 100;
    private static Pedidos[] pedidos = new Pedidos[MAX_PEDIDOS];
    private static int totalPedidos = 0;
    private static int proximoNumero = 1;        


    public static void cadastrarProduto() {
        Produtos produtoLista = new Produtos();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual o tipo de produto voce deseja casdatrar\n" + "1-comida" + "2-Bebida");
        int tipoProduto = scanner.nextInt();
        System.out.println("Qual o nome do produto?");
        String nome = scanner.next();
        System.out.println("Qual o valor do produto?");
        double preco = scanner.nextDouble();

        Produto produto = new Produto(tipoProduto, nome, preco);
        produtoLista.adcionarNaLista(produto);
   
        

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produtos produtonaLista = new Produtos(); 


//tem q abrir um um while nisso aqui pq fica rodando em looping para evitar q o cliente quebre, ass:Will
        System.out.println("O que voce deseja fazer\n" + "1-Pedido" + "2-Produto" + "3-Cliente");
        int escolha = scanner.nextInt();
        switch (escolha) {
            case 1:
                System.err.println("");
                break;
            case 2: 
                System.out.println("O que voce quer fazer?\n" + "1-Cadastrar novo produto\n" + "2-Modificar um produto");
                escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        Main.cadastrarProduto();
                        while(escolha == 1){
                            Main.cadastrarProduto();
                        }
                        break;
                    case 2:
                        
                        
                    default:
                        throw new AssertionError();
                }
            default:
                throw new AssertionError();
        }


    }

     private static final int MAX_PEDIDOS = 100;
    private static Pedidos[] pedidos = new Pedidos[MAX_PEDIDOS];
    private static int totalPedidos = 0;
    private static int proximoNumero = 1;        


}