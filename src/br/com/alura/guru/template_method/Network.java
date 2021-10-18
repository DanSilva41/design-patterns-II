package br.com.alura.guru.template_method;

/**
 * Base class of social network.
 */
public abstract class Network {
    String username;
    String password;

    Network() {
    }


    /**
     * Publish the data to whatever network.
     */
    public boolean post(String message) {
        getSocialNetworkName();
        // Authenticate before posting. Every network uses a different
        // authentication method.
        if (logIn(this.username, this.password)) {
            // Send the post data.
            boolean result = sendData(message.getBytes());
            logOut();
            return result;
        }
        return false;
    }

    abstract String getSocialNetworkName();

    abstract boolean logIn(String username, String password);

    abstract boolean sendData(byte[] data);

    abstract void logOut();
}
