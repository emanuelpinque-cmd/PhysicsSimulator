import java.awt.Graphics;
import javax.swing.JPanel;
public class SceneFrame extends JPanel{
Scene actualScene;
Integer frame;
public SceneFrame(Scene s){
this.actualScene = s;
}
@Override
protected void paintComponent(Graphics g){
    super.paintComponent(g);
    int w = getWidth();
    int h = getHeight();
    for(ObjectSim o : actualScene.objects.values()) {
        o.draw(g, w, h);
    }
}


}
    

