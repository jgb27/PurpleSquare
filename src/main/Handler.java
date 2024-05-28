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
}
