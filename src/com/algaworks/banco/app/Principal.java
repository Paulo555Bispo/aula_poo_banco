package com.algaworks.banco.app;

import com.algaworks.banco.modelo.Conta;
import com.algaworks.banco.modelo.Pessoa;

public class Principal {

    public static void main(String[] args) {
        var titular1 = new Pessoa();
        titular1.setNome("João da Silva");
        titular1.setDocumento("111222333-12");

        var titular2 = new Pessoa();
        titular2.setNome("Maria Abadia");
        titular2.setDocumento("444555666-45");

        var minhaConta = new Conta(titular1, 123, 987);

        var suaConta = new Conta(titular2, 222, 333);

        minhaConta.depositar(15_000);
        minhaConta.sacar(1_000, 10);

        suaConta.depositar(30_000);

        System.out.println("Titular: " + minhaConta.getTitular().getNome());
        System.out.println("Saldo: " + minhaConta.getSaldo());

        System.out.println("Titular: " + suaConta.getTitular().getNome());
        System.out.println("Saldo: " + suaConta.getSaldo());
    }
}
// TODO CPL2.1 -- ASSISTIR E CONTINUAR DESTA ÁULA.
// TODO TESTE DE ATUALIZAÇÃO DO GIT
