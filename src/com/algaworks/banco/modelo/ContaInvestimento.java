package com.algaworks.banco.modelo;

public class ContaInvestimento extends Conta {

    public ContaInvestimento(Pessoa titular, int agencia, int numero) {
        super(titular, agencia, numero);
    }

    @Override
    public void debitarTarifaMensal() {
        if ( getSaldo() < 10_000 ) {
            sacar(30);
        }
    }

    public void creditarRendimentos(double PercentualJuros) {
        double valorRendimentos = (getSaldo() * (PercentualJuros / 100)) ;
        depositar(valorRendimentos);
    }
}
