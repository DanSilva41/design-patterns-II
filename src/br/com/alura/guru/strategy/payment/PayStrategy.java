package br.com.alura.guru.strategy.payment;

/**
 * Common interface for all payment strategies.
 */
public interface PayStrategy {

    void collectPaymentDetails();

    boolean pay(int paymentAmount);
}
