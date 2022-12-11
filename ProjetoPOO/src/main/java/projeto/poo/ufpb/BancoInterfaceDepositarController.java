package projeto.poo.ufpb;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class BancoInterfaceDepositarController implements ActionListener{

    private BancoInterface banco;
    private JFrame janelaPrincipal;

    public BancoInterfaceDepositarController(BancoInterface banco, JFrame janelaPrincipal){
        this.banco = banco;
        this.janelaPrincipal = janelaPrincipal;
    }

    public void actionPerformed (ActionEvent e){
        String numConta = JOptionPane.showInputDialog("Informe o número da conta:");
        String numAgencia = JOptionPane.showInputDialog("Informe o número da agência:");
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor que deseja depositar:"));
        banco.depositarEmConta(numConta, numAgencia, valor);
        try {
            banco.salvarOsDados();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        JOptionPane.showMessageDialog(janelaPrincipal, "Depósito efetuado com sucesso.");
    }
}
