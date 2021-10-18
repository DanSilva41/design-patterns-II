package br.com.alura.guru.state.controls_state;

import br.com.alura.guru.state.ui.Player;

/**
 * Common interface for all states.
 */
public abstract class ControlState {
    Player player;

    protected ControlState(Player player) {
        this.player = player;
    }

    public abstract String onLock();

    public abstract String onPlay();

    public abstract String onNext();

    public abstract String onPrevious();
}
