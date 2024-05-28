package main;

import javax.swing.JFrame;
import java.awt.Dimension;

public class Windows {

    // Construtor
    public Windows(int width, int height, String title, Game game) {
        JFrame frame = new JFrame(title); // Cria a janela do jogo
        frame.setPreferredSize(new Dimension(width, height)); // Define o tamanho da janela
        frame.setMaximumSize(new Dimension(width, height)); // Define o tamanho máximo da janela
        frame.setMinimumSize(new Dimension(width, height)); // Define o tamanho mínimo da janela
        frame.add(game); // Adiciona o jogo na janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o que acontece quando a janela é fechada
        frame.setResizable(false); // Define se a janela pode ser redimensionada
        frame.setLocationRelativeTo(null); // Define a posição da janela
        frame.setVisible(true); // Define se a janela é visível
    }
}
