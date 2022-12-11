package projeto.poo.ufpb;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BancoFrame extends JFrame {

    JLabel linha1, linha2;
    ImageIcon bancoImg = new ImageIcon("banco-do-brasil-5.png");
    ImageIcon addImg = new ImageIcon("cadastrar.png");
    ImageIcon searchImg = new ImageIcon("pesquisar.png");
    ImageIcon sacar = new ImageIcon("saque.png");
    ImageIcon depositar = new ImageIcon("depositar.png");
    ImageIcon transferir = new ImageIcon("transferir.png");
    ImageIcon saldo = new ImageIcon("saldo.png");

    JButton botaoCadastrar, botaoPesquisarConta, botaoSacar, botaoDepositar, botaoTransferir, botaoSaldo;
    BancoInterface banco = new SistemaBanco();

    public BancoFrame(){

        try {
            banco.recuperarDadosSalvos();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setTitle("Caixa Eletrônico");
        setSize(800, 800);
        setLocation(300, 300);
        setResizable(true);
        getContentPane().setBackground(Color.yellow);
        linha1 = new JLabel("Banco do Brasil", JLabel.LEFT);
        linha1.setBorder(BorderFactory.createEmptyBorder(0,0 , 0, 80));
        linha1.setForeground(Color.blue);
        linha1.setFont(new Font("Arial",Font.BOLD,30));
        linha2 = new JLabel(bancoImg, JLabel.LEFT);
        linha2.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 0));
        botaoCadastrar = new JButton("Cadastrar", addImg);
        botaoCadastrar.setFont(new Font("Arial", Font.BOLD, 16));
        botaoCadastrar.setForeground(Color.white);
        botaoCadastrar.setBackground(Color.blue);
        botaoCadastrar.addActionListener(new BancoInterfaceAddController(banco, this));
        botaoPesquisarConta = new JButton("Pesquisar conta", searchImg);
        botaoPesquisarConta.setFont(new Font("Arial", Font.BOLD, 16));
        botaoPesquisarConta.setForeground(Color.white);
        botaoPesquisarConta.setBackground(Color.blue);
        botaoPesquisarConta.addActionListener(new BancoInterfaceSearchController(banco, this));
        botaoSacar = new JButton("Sacar", sacar);
        botaoSacar.setFont(new Font("Arial", Font.BOLD, 16));
        botaoSacar.setForeground(Color.white);
        botaoSacar.setBackground(Color.blue);
        botaoSacar.addActionListener(new BancoInterfaceSacarController(banco, this));
        botaoDepositar = new JButton("Depositar", depositar);
        botaoDepositar.setFont(new Font("Arial", Font.BOLD, 16));
        botaoDepositar.setForeground(Color.white);
        botaoDepositar.setBackground(Color.blue);
        botaoDepositar.addActionListener(new BancoInterfaceDepositarController(banco, this));
        botaoTransferir = new JButton("Transferir", transferir);
        botaoTransferir.setFont(new Font("Arial", Font.BOLD, 16));
        botaoTransferir.setForeground(Color.white);
        botaoTransferir.setBackground(Color.blue);
        botaoTransferir.addActionListener(new BancoInterfaceTransferirController(banco, this));
        botaoSaldo = new JButton("Consultar Saldo", saldo);
        botaoSaldo.setFont(new Font("Arial", Font.BOLD, 16));
        botaoSaldo.setForeground(Color.white);
        botaoSaldo.setBackground(Color.blue);
        botaoSaldo.addActionListener(new BancoInterfaceConsultarController(banco, this));

        JPanel painel1 = new JPanel();
        painel1.setBackground(Color.yellow);
        painel1.setLayout(new GridLayout(1, 3));
        painel1.add(linha2);
        painel1.add(linha1);

        JPanel painel2 = new JPanel();
        painel2.setBackground(Color.yellow);
        painel2.add(botaoCadastrar);
        painel2.add(botaoTransferir);
        painel2.add(botaoPesquisarConta);
        painel2.setLayout(new GridLayout(1, 3));
        painel2.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JPanel painel3 = new JPanel();
        painel3.setBackground(Color.yellow);
        painel3.add(botaoSacar);
        painel3.add(botaoSaldo);
        painel3.add(botaoDepositar);
        painel3.setLayout(new GridLayout(1, 3));
        painel3.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        getContentPane().setLayout(new GridLayout(3, 1));
        add(painel1);
        add(painel2);
        add(painel3);

    }

    public static void main (String[]args){
        JFrame janela = new BancoFrame();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
