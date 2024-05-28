package entities;

import abstracts.GameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {

  public Player(int x, int y) {
    super(x, y);
  }

  @Override
  public void tick() {
  }

  public void render(Graphics g) {
    // purple square
    g.setColor(Color.MAGENTA.darker());
    g.fillRect(this.x, this.y, 32, 32);
  }

  public Rectangle getBounds() {
    return null;
  }
}
