package com.algaworks.banco.app;

import com.algaworks.banco.modelo.*;
import com.algaworks.banco.modelo.atm.CaixaEletronico;
import com.algaworks.banco.modelo.excecao.SaldoInsuficienteException;
import com.algaworks.banco.modelo.pagamento.Boleto;
import com.algaworks.banco.modelo.pagamento.DocumentoPagavel;
import com.algaworks.banco.modelo.pagamento.Holerite;

public class Principal {

    public static void main(String[] args) {
        var titular1 = new Pessoa();
        titular1.setNome("João da Silva");
        titular1.setDocumento("111222333-12");

        var titular2 = new Pessoa();
        titular2.setNome("Maria Abadia");
        titular2.setDocumento("444555666-45");

        var caixaEletronico = new CaixaEletronico();

        var minhaConta = new ContaInvestimento(titular1, 123, 987);
        var suaConta = new ContaEspecial(titular2, 222, 333, 1_000);

        try {
            minhaConta.depositar(30_000);
            minhaConta.sacar(1_000);
//        minhaConta.creditarRendimentos(10);
//        minhaConta.debitarTarifaMensal();

            suaConta.depositar(15_000);
            suaConta.sacar(15_500);
            suaConta.debitarTarifaMensal();

            var boletoEscola = new Boleto(titular2, 35_000);
            var salarioFuncionario = new Holerite(titular2, 100, 160);

            caixaEletronico.pagar(boletoEscola, minhaConta);
            caixaEletronico.pagar(salarioFuncionario, minhaConta);

            caixaEletronico.estornarPagamento(boletoEscola, minhaConta);

            boletoEscola.imprimirRecibo();
            System.out.println();
            salarioFuncionario.imprimirRecibo();
//        } catch (Exception e) {  VOCÊ PODE USAR EXCEPTION, MAS FICA UMA CAPTURA MUITO GENÉRICA, NÃO DEVE SER USADA.
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro ao executar operação na conta. " + e.getMessage());
        }

//        System.out.println("Boleto pago: " + boletoEscola.estaPago());
//        System.out.println("Salário pago: " + salarioFuncionario.estaPago());

        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println();
        caixaEletronico.imprimirSaldo(suaConta);

    }
}

