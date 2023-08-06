package com.algaworks.banco.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco {

    private List<Conta> contas = new ArrayList<>();

    public Banco() {
        var pessoa1 = new Pessoa("João da Silva", "111111111-11");
        var pessoa2 = new Pessoa("Maria das Couves", "222222222-22");

        var conta1 = new ContaInvestimento(pessoa1, 222, 999);
        var conta2 = new ContaInvestimento(pessoa1, 123, 888);
        var conta3 = new ContaInvestimento(pessoa2, 123, 567);
        var conta4 = new ContaEspecial(pessoa1, 123, 188, new BigDecimal(0));
        var conta5 = new ContaEspecial(pessoa2, 123, 222, new BigDecimal(0));

        conta1.depositar(new BigDecimal("120"));
        conta2.depositar(new BigDecimal("150"));
        conta3.depositar(new BigDecimal("500"));
        conta5.depositar(new BigDecimal("12000"));

        contas.add(conta1);
        contas.add(conta2);
        contas.add(conta3);
        contas.add(conta4);
        contas.add(conta5);
    }

    public List<Conta> getContas() {
        return  contas;
    }

    public Optional<Conta> buscar(int agencia, int numeroConta) {
        for (Conta conta : getContas()) {
            if (conta.getAgencia() == agencia
                    && conta.getNumero() == numeroConta) {
                return Optional.of(conta);
            }
        }
        return Optional.empty();  // Optional, não pode retornar NULL.
    }

//    public Conta buscar(int agencia, int numeroConta) {
//        for (Conta conta : getContas()) {
//            if (conta.getAgencia() == agencia
//                    && conta.getNumero() == numeroConta) {
//                return conta;
//            }
//        }
//        return null;
//    }
}
