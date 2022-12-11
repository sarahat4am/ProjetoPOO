package projeto.poo.ufpb;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaBancoTest {
	
	private SistemaBanco sistema;
	private Conta conta, conta2;

	@BeforeEach
	void test() {
		sistema = new SistemaBanco();
		conta = new Conta("1234567", "123", "50", 500.0);
		conta2 = new Conta("7654321", "321", "60", 400.0);
	}
	
	@Test
	void TestarCadastro() throws ContaJaExisteException {
		boolean cadastrou = sistema.abrirConta(conta.getCpfTitular(), conta.getNumeroConta(), conta.getNumeroAgencia(), conta.getSaldo());
		assertEquals(cadastrou, true);
	}
	
	@Test
	void TestarSaque() throws ContaJaExisteException, SaldoInsuficienteException {
		assertEquals(conta.getCpfTitular(), "1234567");
		sistema.sacarDeConta(conta.getCpfTitular(), conta.getNumeroAgencia(), 200.0);
		
		
	}
	
	@Test
	void TestarTransferencia() throws ContaJaExisteException, SaldoInsuficienteException {
		assertEquals(conta.getCpfTitular(), "1234567");
		assertEquals(conta.getNumeroConta(), "123");
		
		boolean agenciaIgual = conta2.getNumeroAgencia().equals("60");
		
		assertEquals(agenciaIgual, true);
		assertTrue(agenciaIgual);
		sistema.transferir(conta.getNumeroConta(), conta.getNumeroAgencia(), conta2.getNumeroConta(), conta2.getNumeroAgencia(), 200.0);
		
		
	}
	
	@Test
	void testarPesquisarConta() throws ContaJaExisteException {
		sistema.abrirConta(conta.getCpfTitular(), conta.getNumeroConta(), conta.getNumeroAgencia(), conta.getSaldo());
		boolean contaEncontrada = sistema.existeConta(conta.getNumeroConta(), conta.getNumeroAgencia());
		assertTrue(contaEncontrada);
		
	}
	
	@Test
	void testarConsultarSaldo() throws ContaJaExisteException {
		sistema.abrirConta(conta.getCpfTitular(), conta.getNumeroConta(), conta.getNumeroAgencia(), conta.getSaldo());
		double saldo = sistema.consultarSaldoDeConta(conta.getNumeroConta(), conta.getNumeroAgencia());
		assertEquals(conta.getSaldo(), saldo);
		
	}
	
	@Test
	void testarDepositar() throws ContaJaExisteException {
		sistema.abrirConta(conta.getCpfTitular(), conta.getNumeroConta(), conta.getNumeroAgencia(), conta.getSaldo());
		double saldo = sistema.depositarEmConta(conta.getNumeroConta(), conta.getNumeroAgencia(), 200.0);
		
		assertEquals(saldo, 700.0);
		
	}

}
