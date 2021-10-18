package br.com.alura.guru.state;

import br.com.alura.guru.state.ui.Player;
import br.com.alura.guru.state.ui.UI;

public class ExecutePlayer {

    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
