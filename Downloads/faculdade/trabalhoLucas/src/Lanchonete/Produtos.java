package Lanchonete;
import java.util.ArrayList;
import java.util.List;

public class Produtos{

    List <Produto> produtos = new ArrayList<>();


    public void adcionarNaLista(Produto produto){
        produtos.add(produto);
    }



    public void getProdutos(){
        for (int i = 0; i < produtos.size(); i++) {
            produtos.get(i).getProduto();
        }
    }
}