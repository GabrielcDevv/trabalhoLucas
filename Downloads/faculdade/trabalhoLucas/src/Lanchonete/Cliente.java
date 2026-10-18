package Lanchonete;

public class Cliente {
    private String nome;
    private String endereco;
    private String telefone;

    public Cliente(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String trocaNome(String nome){
        if(nome.equals(getNome())){
            System.out.println("Digite um nome diferente");
        }else{
            setNome(nome);
        }
        return getNome();
    }

    public String trocaEndereco(String endereco){
        if(endereco.equals(getEndereco())){
            System.out.println("Digite um endereço diferente");
        }else{
            setEndereco(endereco);
        }
        return getEndereco();
    }

    public String trocaTelefone(String telefone){
        if(telefone.equals(getTelefone())){
            System.out.println("Digite um telefone diferente");
        }else{
            setTelefone(telefone);
        }
        return getTelefone();
    }
}
