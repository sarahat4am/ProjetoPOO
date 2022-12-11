package projeto.poo.ufpb;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class BancoInterfaceSacarController implements ActionListener {

    private BancoInterface banco;
    private JFrame janelaPrincipal;

    public BancoInterfaceSacarController(BancoInterface banco, JFrame janelaPrincipal){
        this.banco = banco;
        this.janelaPrincipal = janelaPrincipal;
    }

    public void actionPerformed(ActionEvent e){
        String numConta = JOptionPane.showInputDialog("Informe o número da conta:");
        String numAgencia = JOptionPane.showInputDialog("Informe o número da agência:");
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor que deseja sacar:"));
        try {
            banco.sacarDeConta(numConta, numAgencia, valor);
            banco.salvarOsDados();
            JOptionPane.showMessageDialog(janelaPrincipal, "Saque efetuado com sucesso.");
        } catch (SaldoInsuficienteException ex) {
            JOptionPane.showMessageDialog(janelaPrincipal, ex.getMessage());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

