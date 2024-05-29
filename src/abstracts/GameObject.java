package abstracts;

import java.awt.Graphics;
import java.awt.Rectangle;

import enums.ID;

/**
 * Criamos a classe abstrata GameObject que será a base para todos os objetos do
 * jogo.
 * Ela contém métodos abstratos que serão implementados pelas classes filhas.
 */

public abstract class GameObject {

  // atributos
  protected int x, y;
  protected float velX = 0, velY = 0;
  protected ID id; // identificador do objeto no jogo
  
  // construtor
  public GameObject(int x, int y, ID id) {
    this.x = x;
    this.y = y;
    this.id = id;
  }

  // métodos abstratos 
  public abstract void tick(); // responsavel por atualizar o objeto

  public abstract void render(Graphics g); // responsavel por renderizar o objeto

  public abstract Rectangle getBounds(); // responsavel por retornar o retangulo de colisão

  // getters and setters

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public float getVelX() {
    return velX;
  }

  public void setVelX(float velX) {
    this.velX = velX;
  }

  public float getVelY() {
    return velY;
  }

  public void setVelY(float velY) {
    this.velY = velY;
  }

  public ID getId() {
    return id;
  }

  public void setId(ID id) {
    this.id = id;
  }
}
