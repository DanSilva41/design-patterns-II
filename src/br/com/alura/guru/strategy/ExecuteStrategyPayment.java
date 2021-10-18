package br.com.alura.guru.strategy;

import br.com.alura.guru.strategy.domain.Order;
import br.com.alura.guru.strategy.domain.Product;
import br.com.alura.guru.strategy.payment.PayStrategy;
import br.com.alura.guru.strategy.payment.PaymentType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class ExecuteStrategyPayment {

    private static final Set<Product> products = new HashSet<>();
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final Order order = new Order();
    private static PayStrategy strategy;

    static {
        products.add(new Product(1, "Motherboard", 2200));
        products.add(new Product(2, "CPU", 1850));
        products.add(new Product(3, "HDD", 1100));
        products.add(new Product(4, "Memory", 890));
    }

    public static void main(String[] args) throws IOException {
        while (!order.isClosed()) {

            AtomicReference<String> continueChoice = new AtomicReference<>("Y");
            do {
                System.out.println("Please, select a product:");
                products.stream()
                        .sorted(Comparator.comparing(Product::getIdentifier))
                        .forEach(p -> System.out.println(p.getDescription()));

                System.out.print("Select: ");
                int choice = Integer.parseInt(reader.readLine());

                products.stream().filter(p -> choice == p.getIdentifier())
                        .map(Product::getPrice)
                        .findFirst()
                        .ifPresent(priceOfFoundProduct -> {
                            System.out.print("Count: ");
                            try {
                                int count = Integer.parseInt(reader.readLine());
                                order.setTotalCost(priceOfFoundProduct * count);
                                System.out.print("Do you wish to continue selecting products? Y/N: ");
                                continueChoice.set(reader.readLine());
                            } catch (IOException ignored) {
                            }
                        });
            } while (continueChoice.get().equalsIgnoreCase("Y"));

            if (strategy == null) {
                System.out.println("Please, select a payment method:");
                Arrays.stream(PaymentType.values()).forEach(type -> System.out.println(type.getDescription()));

                int paymentMethod = Integer.parseInt(reader.readLine());
                final PaymentType paymentType = PaymentType.fromIdentifier(paymentMethod);
                strategy = paymentType.buildStrategy();
            }

            // Order object delegates gathering payment data to strategy object,
            // since only strategies know what data they need to process a
            // payment.
            order.processOrder(strategy);

            System.out.print("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
            String proceed = reader.readLine();
            if (proceed.equalsIgnoreCase("P")) {
                // Finally, strategy handles the payment.
                if (strategy.pay(order.getTotalCost())) {
                    System.out.println("Payment has been successful.");
                } else {
                    System.out.println("FAIL! Please, check your data.");
                }
                order.setClosed();
            }
        }
    }

}
