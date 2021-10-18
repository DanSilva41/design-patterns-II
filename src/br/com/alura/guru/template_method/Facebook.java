package br.com.alura.guru.template_method;

/**
 * Class of social network
 */
public class Facebook extends Network {

    public Facebook(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    String getSocialNetworkName() {
        return "== FACEBOOK ==";
    }

    @Override
    boolean logIn(String username, String password) {
        System.out.println("\n == FACEBOOK ==");
        System.out.println("\nChecking user's parameters");
        System.out.println("Name: " + this.username);
        System.out.print("Password: ");
        for (int i = 0; i < this.password.length(); i++) {
            System.out.print("*");
        }
        simulateNetworkLatency();
        System.out.println("\n\nLogIn success on Facebook");
        return true;
    }

    @Override
    boolean sendData(byte[] data) {
        System.out.println("Message: '" + new String(data) + "' was posted on Facebook");
        return true;
    }

    @Override
    void logOut() {
        System.out.println("User: '" + this.username + "' was logged out from Facebook");
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
