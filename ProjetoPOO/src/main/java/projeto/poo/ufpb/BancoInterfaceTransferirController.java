package projeto.poo.ufpb;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class BancoInterfaceTransferirController implements ActionListener {

    private BancoInterface banco;
    private JFrame janelaPrincipal;

    public BancoInterfaceTransferirController(BancoInterface banco, JFrame janelaPrincipal){
        this.banco = banco;
        this.janelaPrincipal = janelaPrincipal;
    }

    public void actionPerformed(ActionEvent e){
        String numContaO = JOptionPane.showInputDialog("Informe o número da conta de origem:");
        String numContaD = JOptionPane.showInputDialog("Informe o número da conta de destino:");
        String numAgenciaO = JOptionPane.showInputDialog("Informe o número da agência da conta de origem:");
        String numAgenciaD = JOptionPane.showInputDialog("Informe o número da agência da conta de destino:");
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor que deseja transferir:"));
        banco.transferir(numContaO, numAgenciaO, numContaD, numAgenciaD, valor);
        try {
            banco.salvarOsDados();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        JOptionPane.showMessageDialog(janelaPrincipal, "Transferência realizada com sucesso.");
    }
}
