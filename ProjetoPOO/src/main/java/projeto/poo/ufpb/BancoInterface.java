package projeto.poo.ufpb;

import java.io.IOException;
import java.util.ArrayList;

public interface BancoInterface {
    void salvarOsDados() throws IOException;
    void recuperarDadosSalvos() throws IOException;
    boolean abrirConta(String cpfTitular, String numeroConta, String numeroAgencia, double saldo) throws ContaJaExisteException;
    boolean existeConta(String numConta, String numAgencia);
    void transferir(String numContaO, String numAgO, String numContaD, String numAgenciaD, double valor);
    ArrayList<Conta> pesquisarContasComSaldoNegativo();
    double consultarSaldoDeConta(String numConta, String numAgencia);
    void sacarDeConta(String numConta, String numAgencia, double valor) throws SaldoInsuficienteException;
    double depositarEmConta(String numConta, String numAgencia, double valor);
}
