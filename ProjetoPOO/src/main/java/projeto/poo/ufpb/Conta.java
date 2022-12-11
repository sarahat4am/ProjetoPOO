package projeto.poo.ufpb;

public class Conta {

    private String cpfTitular;
    private String numeroConta;
    private String numeroAgencia;
    private double saldo;

    public Conta(String cpf, String numC, String numAg, double saldo) {
        this.cpfTitular = cpf;
        this.numeroConta = numC;
        this.numeroAgencia = numAg;
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conta conta = (Conta) o;

        if (numeroConta != null ? !numeroConta.equals(conta.numeroConta) : conta.numeroConta != null) return false;
        return numeroAgencia != null ? numeroAgencia.equals(conta.numeroAgencia) : conta.numeroAgencia == null;
    }

    @Override
    public int hashCode() {
        int result = numeroConta != null ? numeroConta.hashCode() : 0;
        result = 31 * result + (numeroAgencia != null ? numeroAgencia.hashCode() : 0);
        return result;
    }

    public String getNumeroConta() {

        return this.numeroConta;
    }

    public String getNumeroAgencia() {

        return this.numeroAgencia;
    }

    public void setNumeroConta(String novoNumero) {

        this.numeroConta = novoNumero;
    }

    public void setNumeroAgencia(String numeroAgencia) {

        this.numeroAgencia = numeroAgencia;
    }

    public String toString() {

        return "Conta de número" +this.numeroConta+ "do cliente de CPF" +this.cpfTitular;
    }

    public String getCpfTitular() {

        return this.cpfTitular;
    }

    public double getSaldo() {

        return this.saldo;
    }

    public void setCpfTitular(String cpf) {

        this.cpfTitular = cpf;
    }

    public void setSaldo(double saldo) {

        this.saldo = saldo;
    }

    public double creditar(double valor) {
        this.saldo+= valor;
        return this.saldo;
    }

    public double debitar(double valor) {
        this.saldo-= valor;
        return this.saldo;
    }

}
