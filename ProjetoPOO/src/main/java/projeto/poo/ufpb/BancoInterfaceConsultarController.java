package projeto.poo.ufpb;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BancoInterfaceConsultarController implements ActionListener {

    private BancoInterface banco;
    private JFrame janelaPrincipal;

    public BancoInterfaceConsultarController(BancoInterface banco, JFrame janelaPrincipal){
        this.banco = banco;
        this.janelaPrincipal = janelaPrincipal;
    }

    public void actionPerformed(ActionEvent e) {
        String numConta = JOptionPane.showInputDialog("Informe o número da conta:");
        String numAgencia = JOptionPane.showInputDialog("Informe o número da agência:");
        if (banco.existeConta(numConta, numAgencia)) {
            double saldoConta = banco.consultarSaldoDeConta(numConta, numAgencia);
            JOptionPane.showMessageDialog(janelaPrincipal, "O saldo desta conta é de:" + saldoConta);
        }
    }
}
