package br.com.alura.guru.observer.publisher;

import br.com.alura.guru.observer.listener.EventListener;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener listener) {
        listeners.get(eventType)
                .add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        listeners.get(eventType)
                .remove(listener);
    }

    public void notify(String eventType, File file) {
        List<EventListener> users = listeners.get(eventType);
        users.forEach(l -> l.update(eventType, file));
    }
}
