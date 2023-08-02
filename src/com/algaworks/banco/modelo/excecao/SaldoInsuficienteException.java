package com.algaworks.banco.modelo.excecao;


// Exception --> É uma exceção checada, que obriga você a tratar a exceção criada
// RuntimeException --> É um tipo de exceção, não checada.
public class SaldoInsuficienteException extends RuntimeException {

    public SaldoInsuficienteException(String message) {
        super(message);
    }
}
