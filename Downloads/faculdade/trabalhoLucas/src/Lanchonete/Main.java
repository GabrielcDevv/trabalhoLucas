package Lanchonete;
import java.util.Scanner;


public class Main{
    static Produtos produtoLista = new Produtos();
    static Clientes clienteLista = new Clientes();



    private static final int Max_pedidos = 12;
    private static Pedidos[] pedidos = new Pedidos[Max_pedidos];
    private static int totalPedidos = 0;
    private static int proximoNumero = 1;

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

    public static void menuPedido() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("1 - Cadastrar pedido");
            System.out.println("2 - Listar pedidos");
            System.out.println("3 - Adicionar ou remover produto de um pedido");
            System.out.println("4 - Alterar status de um pedido");
            System.out.println("0 - Voltar");
            opcao = lerInteiro(scanner, "Escolha: ");
            switch (opcao) {
                case 1: criarPedido(scanner); break;
                case 2: listarPedidos(); break;
                case 3: alterarProdutosPedido(scanner); break;
                case 4: alterarStatus(scanner); break;
                case 0: break;
                default: System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
        menuPrincipal();
    }

    private static void criarPedido(Scanner scanner) {
        if (totalPedidos >= Max_pedidos) {
            System.out.println("Limite de pedidos atingido.");
            return;
        }
        System.out.println("\n===== ESCOLHA O CLIENTE =====");
        clienteLista.listarCliente();
        int indiceCliente = lerInteiro(scanner, "Numero do cliente: ");
        Cliente cliente = clienteLista.buscarCliente(indiceCliente);
        if (cliente == null) {
            System.out.println("Cliente nao encontrado. Cadastre um cliente primeiro.");
            return;
        }
        int capacidade = lerInteiro(scanner, "Capacidade maxima de produtos: ");
        if (capacidade <= 0) {
            System.out.println("A capacidade deve ser maior que zero.");
            return;
        }
        Pedidos pedido = new Pedidos(proximoNumero, capacidade);
        pedido.setCliente(cliente);
        produtoLista.getProdutos();
        while (pedido.getQuantidadeProdutos() < pedido.getCapacidade()) {
            int indice = lerInteiro(scanner, "Numero do produto (-1 para finalizar): ");
            if (indice == -1) break;
            Produto produto = produtoLista.buscarProduto(indice);
            if (produto == null) {
                System.out.println("Produto nao encontrado. Cadastre um produto primeiro.");
                continue;
            }
            if (pedido.adicionarProduto(produto)) {
                System.out.println("Adicionado: " + produto.getNome());
            }
        }
        if (pedido.getQuantidadeProdutos() == 0) {
            System.out.println("Pedido nao salvo: nenhum produto selecionado.");
            return;
        }
        pedidos[totalPedidos] = pedido;
        totalPedidos++;
        proximoNumero++;
        System.out.println("Pedido criado com sucesso!");
        pedido.exibirPedido();
    }

    private static void listarPedidos() {
        if (totalPedidos == 0) {
            System.out.println("Nenhum pedido cadastrado.");
            return;
        }
        for (int i = 0; i < totalPedidos; i++) pedidos[i].exibirPedido();
    }

    private static void alterarProdutosPedido(Scanner scanner) {
        Pedidos pedido = escolherPedido(scanner);
        if (pedido == null) return;
        pedido.exibirPedido();
        System.out.println("1 - Adicionar produto");
        System.out.println("2 - Remover produto");
        int opcao = lerInteiro(scanner, "Escolha: ");
        if (opcao == 1) {
            if (pedido.getQuantidadeProdutos() >= pedido.getCapacidade()) {
                System.out.println("Pedido cheio.");
                return;
            }
            produtoLista.getProdutos();
            int indice = lerInteiro(scanner, "Numero do produto: ");
            Produto produto = produtoLista.buscarProduto(indice);
            if (produto == null) {
                System.out.println("Produto nao encontrado.");
            } else if (pedido.adicionarProduto(produto)) {
                System.out.println("Produto adicionado!");
            }
        } else if (opcao == 2) {
            int indice = lerInteiro(scanner, "Posicao do produto no pedido (inicia em 0): ");
            System.out.println(pedido.removerProduto(indice)
                    ? "Produto removido!" : "Posicao invalida!");
        } else {
            System.out.println("Opcao invalida.");
        }
    }

    private static void alterarStatus(Scanner scanner) {
        Pedidos pedido = escolherPedido(scanner);
        if (pedido == null) {
            return;
        }
 
        System.out.println("1 - Pendente");
        System.out.println("2 - Em preparo");
        System.out.println("3 - Pronto");
        System.out.println("4 - Entregue");
        System.out.println("5 - Cancelado");
        int opcao = lerInteiro(scanner, "Novo status: ");
 
        switch (opcao) {
            case 1:
                pedido.setStatus("Pendente");
                break;
            case 2:
                pedido.setStatus("Em preparo");
                break;
            case 3:
                pedido.setStatus("Pronto");
                break;
            case 4:
                pedido.setStatus("Entregue");
                break;
            case 5:
                pedido.setStatus("Cancelado");
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }
        System.out.println("Status atualizado para: " + pedido.getStatus());
    }
 
    
    private static Pedidos escolherPedido(Scanner scanner) {
        if (totalPedidos == 0) {
            System.out.println("Nenhum pedido cadastrado.");
            return null;
        }
 
        int numero = lerInteiro(scanner, "Número do pedido: ");
        for (int i = 0; i < totalPedidos; i++) {
            if (pedidos[i].getNumeroPedido() == numero) {
                return pedidos[i];
            }
        }
 
        System.out.println("Pedido não encontrado!");
        return null;
    }
 
    
    private static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String linha = scanner.nextLine().trim();
 
            
            while (linha.isEmpty()) {
                linha = scanner.nextLine().trim();
            }
 
            try {
                return Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
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
                menuPedido();
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
