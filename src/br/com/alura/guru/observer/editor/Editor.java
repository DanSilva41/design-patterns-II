package br.com.alura.guru.observer.editor;

import br.com.alura.guru.observer.publisher.EventManager;

import java.io.File;

public class Editor {

    public final EventManager events;
    private File file;

    public Editor() {
        this.events = new EventManager("open", "save");
    }

    public void openFile(String filePath) {
        this.file = new File(filePath);
        events.notify("open", file);
    }

    public void saveFile() {
        if (this.file != null) {
            events.notify("save", file);
        } else {
            throw new UnsupportedOperationException("Please open a file first.");
        }
    }
}
