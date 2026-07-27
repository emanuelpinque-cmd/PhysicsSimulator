import java.awt.Color;
import java.awt.Graphics;

public class Circle extends ObjectSim {
    Float radius;

    public Circle(Float radius, Float posx, Float posy) {
        super(posx, posy);
        this.radius = radius;
        this.density = 1.0f;
        this.volume = (float)(Math.PI * radius * radius);
        this.mass = this.volume * this.density;
    }

    @Override
    public void draw(Graphics g, int panelWidth, int panelHeight) {
        g.setColor(Color.BLACK);
        int escala = 4;
        int centerX = panelWidth / 2;
        int centerY = panelHeight / 2;
        int px = (int)(this.CoMx * escala) + centerX;
        int py = centerY - (int)(this.CoMy * escala);
        int r = (int)(this.radius * escala);
        g.fillOval(px - r, py - r, r*2, r*2);
    }
}