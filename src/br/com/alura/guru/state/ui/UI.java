package br.com.alura.guru.state.ui;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class UI {
    private Player player;
    private static JTextField textField = new JTextField();

    public UI(Player player) {
        this.player = player;
    }

    public void init() {
        // Context delegates handling user's input to a state object. Naturally,
        // the outcome will depend on what state is currently active, since all
        // states can handle the input differently.
        JButton play = new JButton("Play");
        play.addActionListener(e -> textField.setText(player.getState().onPlay()));
        JButton stop = new JButton("Stop");
        stop.addActionListener(e -> textField.setText(player.getState().onLock()));
        JButton next = new JButton("Next");
        next.addActionListener(e -> textField.setText(player.getState().onNext()));
        JButton prev = new JButton("Previous");
        prev.addActionListener(e -> textField.setText(player.getState().onPrevious()));

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttons.add(play);
        buttons.add(stop);
        buttons.add(next);
        buttons.add(prev);

        JPanel context = new JPanel();
        context.setLayout(new BoxLayout(context, BoxLayout.Y_AXIS));

        context.add(textField);
        context.add(buttons);

        JFrame frame = new JFrame("Text player");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().add(context);

        frame.setVisible(true);
        frame.setSize(500, 100);

    }
}
