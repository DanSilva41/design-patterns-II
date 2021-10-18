package br.com.alura.guru.strategy.payment;

import java.util.Arrays;

public enum PaymentType {

    PAY_PAL(1, "PayPal") {
        @Override
        public PayStrategy buildStrategy() {
            return new PayByPayPal();
        }
    },
    CREDIT_CARD(2, "Credit card") {
        @Override
        public PayStrategy buildStrategy() {
            return new PayByCreditCard();
        }
    };

    private final int identifier;
    private final String name;

    PaymentType(final int identifier, final String name) {
        this.identifier = identifier;
        this.name = name;
    }

    public String getDescription() {
        return this.identifier + " - " + this.name;
    }

    public static PaymentType fromIdentifier(final int identifier) {
        return Arrays.stream(PaymentType.values())
                .filter(type -> type.identifier == identifier)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public abstract PayStrategy buildStrategy();
}
