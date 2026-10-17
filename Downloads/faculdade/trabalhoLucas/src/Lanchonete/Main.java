package Lanchonete;
import java.util.Scanner;


public class Main{
    static Produtos produtoLista = new Produtos();
    static Clientes clienteLista = new Clientes();

    public static void cadastrarProduto() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Qual o tipo de produto voce deseja cadastrar\n");
        System.out.println("1-Comida\n");
        System.out.println("2-Bebida\n");
        int tipoProduto = scanner.nextInt();
        
        if (tipoProduto ==1 || tipoProduto ==2){
             System.out.println("Qual o nome do produto?");
            String nome = scanner.next();


            System.out.println("Qual o valor do produto?");
            double preco = scanner.nextDouble();

            Produto produto = new Produto(tipoProduto, nome, preco);
            produtoLista.adcionarNaLista(produto);;
            produtoLista.getProdutos();
            } else {
                
                System.out.println("Digite uma opcao valida\n");
            }
    }
        

    public static void menuProduto(){
        try{
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
                 default -> {
                    System.out.println("Digite uma opcao valida\n");
                    menuProduto();
                 }
                }
                 
                }
                catch(Exception e){
                    System.out.println("Digite uma opcao valida\n");
                    menuProduto();

                }
    }

    public static void menuCliente(){
        try{
                Scanner scanner = new Scanner(System.in);
                System.out.println("O que voce quer fazer?\n");
                System.out.println("1-Cadastrar novo cliente\n");
                System.err.println("2-Modificar um cliente\n");
                System.out.println("3-Sair");
                int escolha = scanner.nextInt();


                switch(escolha){
                 case 1 ->{
                    Main.cadastrarCliente();
                    menuCliente();
                    break;
                 }
                 case 2->{
                    System.out.println("Escolha o numero cliente voce quer modificar\n");
                    clienteLista.listarCliente();
                    int clienteParaMudanca = scanner.nextInt();
                    clienteLista.modificarCliente(clienteParaMudanca);
                    menuCliente();
                 }
                 case 3->{
                    menuPrincipal();
                 }
                 default -> {
                    System.out.println("Digite uma opcao valida\n");
                    menuCliente();
                 }
                }
                 
                }
                catch(Exception e){
                    System.out.println("Digite uma opcao valida\n");
                    menuCliente();

                }
    }

    public static void cadastrarCliente() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Qual o nome do cliente?");
        String nome = scanner.nextLine();

        System.out.println("Qual o endereco do cliente?");
        String endereco = scanner.nextLine();

        System.out.println("Qual o telefone do cliente?");
        String telefone = scanner.nextLine();

        Cliente cliente = new Cliente(nome, endereco, telefone);

        clienteLista.lista(cliente);
        
    }

    public static void menuPrincipal(){
        try {       
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
                menuProduto();
                }
            case 3 ->{
                menuCliente();
            }
            default ->   {
                    System.out.println("Digite uma opcao valida");
                    menuPrincipal();
            }
        }
        } catch (Exception e){
            System.out.println("Digite uma opcao valida");
        }
    }

    public static void main(String[] args) {
        menuPrincipal();
        
    }
    }
