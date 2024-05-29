package main;

import java.util.LinkedList;
import java.awt.Graphics;

import abstracts.GameObject;

/**
 * Classe Handler é responsável por gerenciar os objetos do jogo.
 * Ela contém uma lista de objetos e métodos para adicionar e remover objetos.
 */

public class Handler {
  
  LinkedList<GameObject> object = new LinkedList<GameObject>();

  private boolean up = false, down = false, right = false, left = false;

  // Método tick() percorre a lista de objetos e chama o método tick() de cada
  // objeto.
  public void tick() {
    for (int i = 0; i < object.size(); i++) {
      GameObject tempObject = object.get(i);

      tempObject.tick();
    }
  }

  // Método render() percorre a lista de objetos e chama o método render() de cada
  // objeto.
  public void render(Graphics g) {
    for (int i = 0; i < object.size(); i++) {
      GameObject tempObject = object.get(i);

      tempObject.render(g);
    }
  }

  // Métodos para adicionar e remover objetos da lista.
  public void addObject(GameObject object) {
    this.object.add(object);
  }

  public void removeObject(GameObject object) {
    this.object.remove(object);
  }

  // Getters e Setters
  public boolean isUp() {
    return up;
  }

  public void setUp(boolean up) {
    this.up = up;
  }

  public boolean isDown() {
    return down;
  }

  public void setDown(boolean down) {
    this.down = down;
  }

  public boolean isRight() {
    return right;
  }

  public void setRight(boolean right) {
    this.right = right;
  }

  public boolean isLeft() {
    return left;
  }

  public void setLeft(boolean left) {
    this.left = left;
  }
}
