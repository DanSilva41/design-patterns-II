package br.com.alura.guru.template_method;

/**
 * Class of social network
 */
public class Twitter extends Network {

    public Twitter(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    String getSocialNetworkName() {
        return "== TWITTER ==";
    }

    @Override
    boolean logIn(String username, String password) {
        System.out.println("\n == TWITTER ==");
        System.out.println("\nChecking user's parameters");
        System.out.println("Name: " + this.username);
        System.out.print("Password: ");
        for (int i = 0; i < this.password.length(); i++) {
            System.out.print("*");
        }
        simulateNetworkLatency();
        System.out.println("\n\nLogIn success on Twitter");
        return true;
    }

    @Override
    boolean sendData(byte[] data) {
        System.out.println("Message: '" + new String(data) + "' was posted on Twitter");
        return true;
    }

    @Override
    void logOut() {
        System.out.println("User: '" + this.username + "' was logged out from Twitter");
    }

    private void simulateNetworkLatency() {
        try {
            int i = 0;
            System.out.println();
            while (i < 10) {
                System.out.print(".");
                Thread.sleep(500);
                i++;
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
