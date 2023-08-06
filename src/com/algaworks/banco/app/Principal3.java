package com.algaworks.banco.app;

import com.algaworks.banco.modelo.Banco;
import com.algaworks.banco.modelo.Conta;

import java.util.Comparator;

public class Principal3 {

    public static void main(String[] args) {
        var banco = new Banco();

/*        Criando uma expressão Lambda  */
/*  1      ToIntFunction<Conta> function = (Conta conta) -> {
            return conta.getNumero();
        };        */
/*     Melhorando a expressão Lambda anterior/acima  */
// 2       ToIntFunction<Conta> function = Conta::getNumero;

//  1      banco.getContas().sort(Comparator.comparingInt(new NumeroContaFunction()));
//  2      banco.getContas().sort(Comparator.comparingInt(function));

/*     A expressão anterior, ainda pode ser melhorada e reduzida a expressão Lambda, conforme o exemplo abaixo. */
/*        banco.getContas().sort(Comparator.comparingInt(
                conta -> conta.getNumero()));
                */

                banco.getContas().sort(Comparator.comparingInt(Conta::getNumero));

        for (Conta conta : banco.getContas()) {
            System.out.println(conta.getAgencia() + "/" + conta.getNumero());
        }
    }
}
