package entities;

import abstracts.GameObject;
import enums.ID;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {

  public Player(int x, int y, ID id) {
    super(x, y, id);
  }

  @Override
  public void tick() {
  }

  public void render(Graphics g) {
  }

  public Rectangle getBounds() {
    return null;
  }
}
