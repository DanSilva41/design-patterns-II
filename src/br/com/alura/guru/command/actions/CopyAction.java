package br.com.alura.guru.command.actions;

import br.com.alura.guru.command.editor.Editor;

public class CopyAction extends Action {

    public CopyAction(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        editor.clipboard = editor.textField.getSelectedText();
        return false;
    }
}
