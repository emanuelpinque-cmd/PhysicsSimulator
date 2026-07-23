import java.awt.Color;
import java.awt.Graphics;
public class Block extends ObjectSim{
    Float sizeX;
    Float sizeY;
    Float sizeZ;

public Block(Float size,Float posx,Float posy)
{
super(posx,posy);
this.sizeX=size;
this.sizeY=size;
this.sizeZ=1.0f;
this.density = 1.0f;
this.volume =sizeX*sizeY*sizeZ;
this.mass = this.volume * this.density;
}

@Override
public void draw(Graphics g, int panelWidth, int panelHeight){
    g.setColor(Color.BLACK);
    int scalar = 10;
    int centerX = panelWidth / 2;
    int centerY = panelHeight / 2;
    int px = (int)(this.CoMx * scalar) + centerX;
    int py = centerY - (int)(this.CoMy * scalar);
    int w = (int)(this.sizeX * scalar);
    int h = (int)(this.sizeY * scalar);
    g.fillRect(px - w/2, py - h/2, w, h);
}


}
