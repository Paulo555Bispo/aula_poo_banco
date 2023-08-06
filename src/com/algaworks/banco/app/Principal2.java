package com.algaworks.banco.app;

import com.algaworks.banco.modelo.Pessoa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Principal2 {

    public static void main(String[] args) {
        var pessoa1 = new Pessoa("João da Silva", "111111111-22");
        var pessoa2 = new Pessoa("Maria José", "222222222-33");

//        List<Pessoa> pessoas = new ArrayList<>();
        Set<Pessoa> pessoas = new HashSet<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
/**

        System.out.println(pessoas);

        Pessoa pessoa3 = pessoas.get(1);
        System.out.println(pessoa3);

        for (int i = 0; i < pessoas.size(); i++) {
            System.out.println(pessoas.get(i).getNome());
        }

*/
/**
          *  Enhanced for → Usando um 'for' aprimorado
*/
/**
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome());
        }
*/
        var pessoa4 = new Pessoa("João da Silva", "111111111-22");
        boolean existe = pessoas.contains(pessoa4);
        System.out.println(existe);
    }

}
