package br.com.alura.guru.command.actions;

import java.util.Stack;

public class ActionHistory {
    private Stack<Action> history = new Stack<>();

    public void push(Action c) {
        history.push(c);
    }

    public Action pop() {
        return history.pop();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

}
