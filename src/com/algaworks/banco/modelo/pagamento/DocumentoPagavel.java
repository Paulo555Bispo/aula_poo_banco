package com.algaworks.banco.modelo.pagamento;

import java.math.BigDecimal;
import java.sql.SQLOutput;

public interface DocumentoPagavel {

    // Seria redundante declarar os métodos public abstract, portanto é desnecessário na interface.
    BigDecimal getValorTotal();
    boolean estaPago();
    void quitarPagamento();

    // Colocando a palavra DEFAULT para declarar um método na interface, ele não precisará ser implantado
    // nas classes que utilizam esta interface.
    // Porem, não é ideal que você utilize sempre o método DEFAULT.
    default void imprimirRecibo() {
        System.out.println("RECIBO");
        System.out.println("Valor pago: " + getValorTotal());
        System.out.println("Pago: " + estaPago());
    }
}
