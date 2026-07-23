import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
public class Draw extends JPanel{
ArrayList<Dot> dots;
Integer scalarX = 1;
Integer scalarY = 1;
Integer setPointY = 500;
Draw(ArrayList<Dot> dots)
{
this.dots = dots;
}

@Override
protected void paintComponent(Graphics g)
{
super.paintComponent(g);
g.setColor(Color.BLACK);
for(Dot d:dots)
{
g.drawLine(d.x/scalarX,d.y/scalarY + setPointY,d.x/scalarX,d.y/scalarY + setPointY);

}

}


}
