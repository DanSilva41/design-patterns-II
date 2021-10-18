package br.com.alura.guru.command.actions;

import br.com.alura.guru.command.editor.Editor;

public class PasteAction extends Action {

    public PasteAction(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if (editor.clipboard == null || editor.clipboard.isEmpty()) return false;

        backup();
        editor.textField.insert(editor.clipboard, editor.textField.getCaretPosition());
        return true;
    }
}
