package br.com.alura.guru.chain_of_responsability.middleware;

/**
 * ConcreteHandler. Checks a user's role.
 */
public class RoleCheckMiddleware extends Middleware {

    private static final String ADMIN_EMAIL = "admin@example.com";

    @Override
    public boolean check(String email, String password) {
        if (ADMIN_EMAIL.equals(email)) {
            System.out.println("Hello, admin!");
            return true;
        }
        System.out.println("Hello, user!");
        return checkNext(email, password);
    }
}
