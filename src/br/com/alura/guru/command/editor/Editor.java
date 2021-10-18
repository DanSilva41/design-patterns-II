package br.com.alura.guru.command.editor;

import br.com.alura.guru.command.actions.Action;
import br.com.alura.guru.command.actions.*;

import javax.swing.*;
import java.awt.*;

public class Editor {
    public JTextArea textField;
    public String clipboard;
    private ActionHistory history = new ActionHistory();

    public void init() {
        JFrame frame = new JFrame("Text editor (type & use buttons, Luke!)");
        JPanel content = new JPanel();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        textField = new JTextArea();
        textField.setLineWrap(true);
        content.add(textField);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton ctrlC = new JButton("Ctrl+C");
        JButton ctrlX = new JButton("Ctrl+X");
        JButton ctrlV = new JButton("Ctrl+V");
        JButton ctrlZ = new JButton("Ctrl+Z");
        Editor editor = this;
        ctrlC.addActionListener(e -> executeCommand(new CopyAction(editor)));
        ctrlX.addActionListener(e -> executeCommand(new CutAction(editor)));
        ctrlV.addActionListener(e -> executeCommand(new PasteAction(editor)));
        ctrlZ.addActionListener(e -> undo());
        buttons.add(ctrlC);
        buttons.add(ctrlX);
        buttons.add(ctrlV);
        buttons.add(ctrlZ);
        content.add(buttons);
        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void executeCommand(Action action) {
        if (action.execute()) {
            history.push(action);
        }
    }

    private void undo() {
        if (history.isEmpty()) return;

        Action action = history.pop();
        if (action != null) {
            action.undo();
        }
    }
}
