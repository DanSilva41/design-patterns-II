package br.com.alura.guru.strategy.domain;

public class Product implements Comparable<Product> {

    private final int identifier;
    private final String name;
    private final int price;

    public Product(int identifier, String name, int price) {
        this.identifier = identifier;
        this.name = name;
        this.price = price;
    }

    public int getIdentifier() {
        return identifier;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return identifier + " - " + name + " : R$ " + price;
    }

    @Override
    public int compareTo(Product otherProduct) {
        return Integer.compare(identifier, otherProduct.identifier);
    }
}
