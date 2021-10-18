package br.com.alura.guru.observer.listener;

import java.io.File;

public class EmailNotificationListener implements EventListener {
    private final String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Email  to " + email + ": Someone has perfomed " + eventType + " operation with the following file: " + file.getName());
    }
}
