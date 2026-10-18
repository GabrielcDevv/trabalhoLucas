package Lanchonete;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Clientes {
    private List <Cliente> clienteLista = new ArrayList<>();


    public void lista(Cliente cliente){
        clienteLista.add(cliente);
    }
    
    public void listarCliente(){
        for(Cliente cliente: clienteLista){
            System.out.println("Número do cliente: " + clienteLista.indexOf(cliente));
            System.out.println("Nome do cliente: " + cliente.getNome()); 
            System.out.println("Endereço do cliente:" + cliente.getEndereco()); 
            System.out.println("Telefone do cliente: " + cliente.getTelefone()); 

        }
    }

    public Cliente modificarCliente(int index){
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = clienteLista.get(index);
        System.out.println("O que você deseja modificar? \n");
        System.out.println("1 - Nome \n");
        System.out.println("2 - Endereço \n");
        System.out.println("3 - Telefone \n");
        int resposta = scanner.nextInt();

        switch (resposta) {
            case 1:
                System.out.println("Qual o novo nome do cliente? \n");
                String nome = scanner.next();
                clienteLista.get(index).trocaNome(nome);
                break;
            case 2:
                System.out.println("Qual o novo endereço do cliente? \n");
                String endereco = scanner.next();
                clienteLista.get(index).trocaEndereco(endereco);

                break;
            case 3:
                System.out.println("Qual o novo telefone do cliente? \n");
                String telefone = scanner.next();
                clienteLista.get(index).trocaTelefone(telefone);

                break;
            default:
                Main.menuCliente();
                break;
        }
        return cliente;
    }
}
