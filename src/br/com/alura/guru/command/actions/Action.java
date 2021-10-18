package br.com.alura.guru.command.actions;

import br.com.alura.guru.command.editor.Editor;

public abstract class Action {
    public final Editor editor;
    private String backup;

    protected Action(Editor editor) {
        this.editor = editor;
    }

    public void backup() {
        backup = this.editor.textField.getText();
    }

    public void undo() {
        this.editor.textField.setText(backup);
    }

    public abstract boolean execute();
}
