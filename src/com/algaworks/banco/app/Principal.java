package com.algaworks.banco.app;

import com.algaworks.banco.modelo.*;

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

        minhaConta.depositar(10_000);
        minhaConta.sacar(1_000);
        minhaConta.creditarRendimentos(0.1);
        minhaConta.debitarTarifaMensal();

        suaConta.depositar(15_000);
        suaConta.sacar(15_500);
        suaConta.debitarTarifaMensal();

        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println();
        caixaEletronico.imprimirSaldo(suaConta);

    }
}

