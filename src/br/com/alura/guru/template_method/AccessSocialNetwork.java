package br.com.alura.guru.template_method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Demo class. Everything comes together here.
 */
public class AccessSocialNetwork {

    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Network network;
        System.out.println("Input user name: ");
        String username = reader.readLine();
        System.out.println("Input password: ");
        String password = reader.readLine();

        // Enter the message
        System.out.println("Input message: ");
        String message = reader.readLine();


        int choice = 0;
        while (choice != 1 && choice != 2) {
            System.out.println("\nChoose social network for posting message.\n" +
                    "1 - Facebook\n" +
                    "2 - Twitter");
            choice = Integer.parseInt(reader.readLine());
            System.out.println(choice);
        }

        // Create proper network object and send the message.
        if (choice == 1)
            network = new Facebook(username, password);
        else
            network = new Twitter(username, password);
        network.post(message);
    }
}
