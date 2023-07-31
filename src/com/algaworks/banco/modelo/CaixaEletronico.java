package com.algaworks.banco.modelo;

public class CaixaEletronico {

//    Upcasting e Polimorfismo
//    Usamos a classe Conta, para poder trazer as informações de todos os tipos de contas,
//    usando apenas um método.
    public void imprimirSaldo(Conta conta) {
        System.out.println("Agência/Conta : " + conta.getAgencia() + "/" + conta.getNumero());
        System.out.println("Titular: " + conta.getTitular().getNome());
        System.out.println("Saldo: " + conta.getSaldo());
        System.out.println("Saldo disponível: " + conta.getSaldoDisponivel());
    }
}
