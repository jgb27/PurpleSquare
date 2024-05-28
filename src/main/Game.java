package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import entities.Player;

public class Game extends Canvas implements Runnable {

    static final long serialVersionUID = 1L; // Serve para não dar warning no código (não é obrigatório)

    // Variáveis
    boolean isRunning = false; // Variável para saber se o jogo está rodando
    Thread thread; // A Thread Serve para rodar o jogo em paralelo com o resto do código
    Handler handler; // Variável para gerenciar os objetos do jogo

    final int WIDTH = 1366; // Largura da janela
    final int HEIGHT = 768; // Altura da janela

    // Construtor
    public Game() {
        new Windows(WIDTH, HEIGHT, "Purple Square", this); // Cria a janela do jogo
        start(); // Inicia o jogo

        handler = new Handler(); // Inicializa o handler

        handler.addObject(new Player(100, 100)); // Adiciona um jogador ao jogo
    }

    // start
    private void start() {
        isRunning = true; // O jogo está rodando
        thread = new Thread(this); // Cria uma nova thread
        thread.start(); // Inicia a thread
    }

    // Método para parar o jogo
    public void stop() {
        isRunning = false;
        try {
            thread.join(); // Para a thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Método para iniciar o jogo
    @Override
    public void run() {

        this.requestFocus(); // Faz com que o jogo tenha foco
        long lastTime = System.nanoTime(); // Pega o tempo atual em nanosegundos
        double amountOfTicks = 60.0; // Quantidade de atualizações por segundo
        double ns = 1000000000 / amountOfTicks; // Quantidade de nanosegundos por atualização
        double delta = 0; // Variável para controlar o tempo
        long timer = System.currentTimeMillis(); // Pega o tempo atual em milisegundos
        int frames = 0; // Variável para contar os frames

        while (isRunning) { // Enquanto o jogo estiver rodando
            long now = System.nanoTime(); // Pega o tempo atual em nanosegundos
            delta += (now - lastTime) / ns; // Adiciona o tempo passado desde a última atualização
            lastTime = now; // Atualiza o tempo da última atualização
            while (delta >= 1) { // Se o delta for maior ou igual a 1
                tick(); // Atualiza o jogo
                delta--; // Diminui o delta
            }
            if (isRunning) { // Se o jogo estiver rodando
                render(); // Renderiza o jogo
            }
            frames++; // Adiciona um frame
            if (System.currentTimeMillis() - timer > 1000) { // Se passou 1 segundo
                timer += 1000; // Adiciona 1 segundo ao timer
                System.out.println("FPS: " + frames); // Mostra os frames por segundo
                frames = 0; // Reseta os frames
            }
        }
        stop(); // Para o jogo
    }

    // Método para atualizar o jogo
    public void tick() {
        handler.tick();
    }

    // Método para renderizar o jogo
    public void render() {
        /**
         * BufferStrategy é uma técnica usada para evitar o flickering (tremulação) na
         * tela. Ela consiste em criar um buffer para armazenar os frames.
         * Desta forma, o buffer é renderizado na tela de uma só vez, evitando o
         * flickering.
         * Font: https://encurtador.com.br/1ecNx
         */
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) { // Se o BufferStrategy não existir
            this.createBufferStrategy(3); // Cria o BufferStrategy
            return; // Retorna
        }

        /**
         * Graphics é uma classe abstrata que permite desenhar na tela. Ela é usada
         * para desenhar formas, imagens e textos.
         * Font: https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
         */
        Graphics g = bs.getDrawGraphics(); // Cria um objeto Graphics

        g.setColor(Color.BLACK); // Pinta a tela de preto

        g.fillRect(0, 0, WIDTH, HEIGHT); // Pinta a tela de preto

        handler.render(g); // Renderiza os objetos do jogo

        g.dispose(); // Libera os recursos do objeto Graphics
        bs.show(); // Mostra o BufferStrategy
    }

    public static void main(String[] args) {
        new Game(); // Inicia o jogo
    }
}
