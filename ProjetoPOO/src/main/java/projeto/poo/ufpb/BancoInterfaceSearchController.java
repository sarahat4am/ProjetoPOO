package projeto.poo.ufpb;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BancoInterfaceSearchController implements ActionListener {

    private BancoInterface banco;
    private JFrame janelaPrincipal;

    public BancoInterfaceSearchController(BancoInterface banco, JFrame janelaPrincipal){
        this.banco = banco;
        this.janelaPrincipal = janelaPrincipal;
    }

    public void actionPerformed(ActionEvent e){
        String numConta = JOptionPane.showInputDialog("Informe o número da conta:");
        String numAgencia = JOptionPane.showInputDialog("Informe o número da agência:");
        if (banco.existeConta(numConta, numAgencia)) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Essa conta está cadastrada no banco.");
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Essa conta não está cadastrada no banco.");
        }
    }
}

