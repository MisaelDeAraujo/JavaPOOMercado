import java.util.ArrayList;

public class GerenciadorProdutos {
    private ArrayList<Produto> produtos;

    public GerenciadorProdutos() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public ArrayList<Produto> listarProdutos() {
        return produtos;
    }
}
