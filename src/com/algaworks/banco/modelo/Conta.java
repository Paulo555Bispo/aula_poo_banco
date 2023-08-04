package com.algaworks.banco.modelo;

import com.algaworks.banco.modelo.excecao.SaldoInsuficienteException;

import java.math.BigDecimal;
import java.util.Objects;

// Uma classe abstrata, não pode ser instanciada.
//Colocando a palavra 'abstract' antes da classe, nos impedimos que objetos dessa classe Conta,
// seja instanciada diretamente, sem ser por uma subclasse específica.
// Você também pode criar métodos abstratos.
public abstract class Conta {

    private Pessoa titular;
    private int agencia;
    private int numero;
    private BigDecimal saldo = BigDecimal.ZERO;

    Conta() {
    }

    public Conta(Pessoa titular, int agencia, int numero) {
        Objects.requireNonNull(titular);
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }

    public void depositar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw  new IllegalArgumentException("Valor deve ser maior que 0 (zero).");
        }
        saldo = saldo.add(valor);
    }

    public void sacar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw  new IllegalArgumentException("Valor deve ser maior 0 (zero).");
        }

        if (getSaldoDisponivel().subtract(valor).compareTo(BigDecimal.ZERO)  < 0 ) {
            throw  new SaldoInsuficienteException("Saldo insuficiente.");
        }
        saldo = saldo.subtract(valor);
    }

    // Todas as subclasses da classe Conta, serão obrigadas a implementar o método abstrato da classe Conta.
    // Um método abstrato, não tem implementação.
    public abstract void debitarTarifaMensal();

    public void sacar(BigDecimal valor, BigDecimal taxaSaque) {
        sacar(valor.add(taxaSaque));
    }

    public Pessoa getTitular() {
        return titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public BigDecimal getSaldoDisponivel() { return getSaldo(); }

}
