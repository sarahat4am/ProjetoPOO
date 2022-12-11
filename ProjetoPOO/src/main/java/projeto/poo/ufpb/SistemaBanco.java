package projeto.poo.ufpb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SistemaBanco implements BancoInterface{

    private String nome;
    private String cnpj;
    private ArrayList<Conta> contas;
    private GravadorDeDados gravador = new GravadorDeDados("contas.txt");

    public SistemaBanco(String nome, String cnpj, ArrayList<Conta> contas) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.contas = contas;
    }

    public SistemaBanco(){

        this("Sem nome", "Sem cnpj", new ArrayList<>());
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getCnpj() {

        return cnpj;
    }

    public void setCnpj(String cnpj) {

        this.cnpj = cnpj;
    }

    public void salvarOsDados() throws IOException {
        List<String> texto = new LinkedList<>();
        for (Conta c : this.contas) {
            String linha = c.getCpfTitular()+ "/" +c.getNumeroConta()+ "/" +c.getNumeroAgencia()+ "/" +c.getSaldo();
            texto.add(linha);
        }
        gravador.gravaTextoEmArquivo(texto);
    }

    public void recuperarDadosSalvos() throws IOException{
        List<String> textoLido = gravador.recuperaTextoDeArquivo();
        for (String linha: textoLido){
            String [] elemento = linha.split("/");
            Conta c = new Conta(elemento [0], elemento [1],  elemento [2], Double.parseDouble (elemento [3]));
            this.contas.add(c);
        }
    }

    public boolean abrirConta(String cpfTitular, String numeroConta, String numeroAgencia, double saldo) throws ContaJaExisteException{
        Conta novaConta = new Conta(cpfTitular, numeroConta, numeroAgencia, saldo);
        if (this.contas.contains(cpfTitular) || this.contas.contains(numeroConta) || this.contas.contains(numeroAgencia)){
            throw new ContaJaExisteException("Essa conta já existe.\nTente novamente.");
        }
        this.contas.add(novaConta);
        return true;
    }

    public boolean existeConta(String numConta, String numAgencia){
        for (Conta c: this.contas){
            if (c.getNumeroConta().equals(numConta) && c.getNumeroAgencia().equals(numAgencia)){
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "Banco " + this.nome + " de CNPJ " + this.cnpj + " e que tem " + this.contas.size() + " contas";
    }

    public void transferir(String numContaO, String numAgenciaO, String numContaD, String numAgenciaD, double valor) {

        Conta contaOrigem = null;
        Conta contaDestino = null;

        for (Conta c : this.contas) {
            if (c.getNumeroConta().equals(numContaO) && c.getNumeroAgencia().equals(numAgenciaO)) {
                contaOrigem = c;
            } else if (c.getNumeroConta().equals(numContaD) && c.getNumeroAgencia().equals(numAgenciaD)) {
                contaDestino = c;

            }
        }

        if (contaOrigem != null && contaDestino != null) {
            contaOrigem.debitar(valor);
            contaDestino.creditar(valor);
        }
    }

    public ArrayList<Conta> pesquisarContasComSaldoNegativo() {
        ArrayList<Conta> contasSaldoNegativo = new ArrayList<>();
        for(int k=0; k< this.contas.size(); k++){
            Conta c = this.contas.get(k);
            if (c.getSaldo()<0){
                contasSaldoNegativo.add(c);
            }
        }
        return contasSaldoNegativo;
    }

    public double consultarSaldoDeConta(String numConta, String numAgencia){
        double saldo = 0;
        for (Conta c : this.contas){
            if (c.getNumeroConta().equals(numConta) && c.getNumeroAgencia().equals(numAgencia)){
                return c.getSaldo();
            }
        }
        return saldo;
    }

    public void sacarDeConta(String numConta, String numAgencia, double valor) throws SaldoInsuficienteException {
        for(Conta c: this.contas){
            if (c.getNumeroConta().equals(numConta) && c.getNumeroAgencia().equals(numAgencia)){
                if (c.getSaldo() >= valor) {
                    c.debitar(valor);
                    break;
                }
                else{
                    throw new SaldoInsuficienteException("Saldo insuficiente. \nNão foi possível realizar o saque.");
                }
            }
        }
    }

    public double depositarEmConta(String numConta, String numAgencia, double valor) {
        double saldo = 0.0;
        for(Conta c: this.contas){
            if (c.getNumeroConta().equals(numConta) && c.getNumeroAgencia().equals(numAgencia)){
                saldo = c.creditar(valor);

                break;
            }
        }
        return saldo;
    }

}
