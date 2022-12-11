package projeto.poo.ufpb;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class BancoInterfaceAddController implements ActionListener {
    private BancoInterface banco;
    private JFrame janelaPrincipal;

    public BancoInterfaceAddController (BancoInterface banco, JFrame janelaPrincipal) {
        this.banco = banco;
        this.janelaPrincipal = janelaPrincipal;
    }

    public void actionPerformed(ActionEvent e){
        String cpfTitular = JOptionPane.showInputDialog("Digite seu CPF:");
        String numConta = JOptionPane.showInputDialog("Informe o número da conta:");
        String numAgencia = JOptionPane.showInputDialog("Informe o número da agência:");
        double saldoInicial = Double.parseDouble(JOptionPane.showInputDialog("Qual será o valor do seu saldo inicial?"));
        boolean cadastra = false;
        try {
            cadastra = banco.abrirConta(cpfTitular, numConta, numAgencia, saldoInicial);
        } catch (ContaJaExisteException ex) {
            ex.printStackTrace();
        }
        if(cadastra){
            JOptionPane.showMessageDialog(janelaPrincipal, "Conta cadastrada");
            try {
                this.banco.salvarOsDados();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Conta não cadastrada. Verifique se já não existia.");
        }
    }
}
