package com.algaworks.banco.app;

import com.algaworks.banco.modelo.*;
import com.algaworks.banco.modelo.atm.CaixaEletronico;
import com.algaworks.banco.modelo.excecao.SaldoInsuficienteException;
import com.algaworks.banco.modelo.pagamento.Boleto;
import com.algaworks.banco.modelo.pagamento.DocumentoPagavel;
import com.algaworks.banco.modelo.pagamento.Holerite;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Principal {

    public static void main(String[] args) {
        var titular1 = new Pessoa();
        titular1.setNome("João da Silva");
        titular1.setDocumento("111222333-12");
        titular1.setRendimentoAnual(new BigDecimal("15000"));
        titular1.setTipo(TipoPessoa.JURIDICA);

        titular1.setDataUltimaAtualizacao(LocalDateTime.parse("2023-08-10T21:00:00"));
        System.out.println(titular1.getDataUltimaAtualizacao());

        var titular2 = new Pessoa();
        titular2.setNome("Maria Abadia");
        titular2.setDocumento("444555666-45");

        var caixaEletronico = new CaixaEletronico();

        var minhaConta = new ContaInvestimento(titular1, 123, 987);
        var suaConta = new ContaEspecial(titular2, 222, 333, new BigDecimal("1000"));

        try {
            minhaConta.depositar(new BigDecimal("30000"));
            minhaConta.sacar(new BigDecimal("1000"));
//        minhaConta.creditarRendimentos(10);
//        minhaConta.debitarTarifaMensal();

            suaConta.depositar(new BigDecimal("15000"));
            suaConta.sacar(new BigDecimal("15500"));
            suaConta.debitarTarifaMensal();

            var boletoEscola = new Boleto(titular2, new BigDecimal("35000"));
            var salarioFuncionario = new Holerite(titular2, new BigDecimal("100"), 160);

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
// TODO -- 2.6 - Boxing, enumerações, datas e valores monetários
