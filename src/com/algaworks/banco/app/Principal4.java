package com.algaworks.banco.app;

import com.algaworks.banco.modelo.Banco;
import com.algaworks.banco.modelo.Conta;
import com.algaworks.banco.modelo.Pessoa;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal4 {

    public static void main(String[] args) {
        var banco = new Banco();

         List<Pessoa> titulares =  banco.getContas().stream()
                .map(Conta::getTitular)
                .distinct()
                        .toList();
//                .collect(Collectors.toList());  // Você deve usar o método anterior
        System.out.println(titulares);

        BigDecimal saldoTotal = banco.getContas().stream()
                        .map(Conta::getSaldo)
                                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(saldoTotal);
/*
        Stream<Conta> stream = banco.getContas().stream();
        Stream<Conta> stream2 = stream.filter(
                conta -> conta.getSaldo().compareTo(new BigDecimal("130")) > 0 );
        Stream<Conta> stream3 = stream2.filter(conta -> conta.getNumero() > 300);

        stream3.forEach(conta -> {
//            conta.depositar(new BigDecimal("10"));
            System.out.println(conta.getAgencia() + "/" +
                    conta.getNumero() +
                    " = " + conta.getSaldo());
        });
  Melhorando o bloco de código acima.  */
/*
        banco.getContas().stream()
            .filter(conta -> conta.getSaldo().compareTo(new BigDecimal("50")) > 0 )
                .filter(conta -> conta.getNumero() > 200)
                .sorted(Comparator.comparingInt(Conta::getNumero))
                .forEach(conta -> {
                    System.out.println(conta.getAgencia() + "/" +
                    conta.getNumero() +
                    " = " + conta.getSaldo());
        });
        */
        banco.getContas().stream()
                .filter(conta -> conta.getSaldo().compareTo(new BigDecimal("50")) > 0 )
                .filter(conta -> conta.getNumero() > 200)
                .map(Conta::getTitular)
                .distinct()
                .forEach(System.out::println);
    }
}
