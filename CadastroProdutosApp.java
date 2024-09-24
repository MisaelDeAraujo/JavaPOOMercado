import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroProdutosApp {
    private GerenciadorProdutos gerenciador;
    private JTextField nomeField;
    private JTextField precoField;
    private JTextField quantidadeField;
    private JTextArea listaProdutosArea;

    public CadastroProdutosApp() {
        gerenciador = new GerenciadorProdutos();
        criarInterface();
    }

    private void criarInterface() {
        JFrame frame = new JFrame("Cadastro de Produtos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Nome do Produto:"));
        nomeField = new JTextField();
        panel.add(nomeField);

        panel.add(new JLabel("Preço:"));
        precoField = new JTextField();
        panel.add(precoField);

        panel.add(new JLabel("Quantidade:"));
        quantidadeField = new JTextField();
        panel.add(quantidadeField);

        JButton adicionarButton = new JButton("Adicionar Produto");
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarProduto();
            }
        });
        panel.add(adicionarButton);

        listaProdutosArea = new JTextArea();
        listaProdutosArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(listaProdutosArea);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void adicionarProduto() {
        String nome = nomeField.getText();
        double preco = Double.parseDouble(precoField.getText());
        int quantidade = Integer.parseInt(quantidadeField.getText());

        Produto produto = new Produto(nome, preco, quantidade);
        gerenciador.adicionarProduto(produto);
        
        listaProdutosArea.append(produto.toString() + "\n");
        
        // Limpar os campos
        nomeField.setText("");
        precoField.setText("");
        quantidadeField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CadastroProdutosApp());
    }
}
