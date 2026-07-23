import java.util.ArrayList;
import javax.swing.JFrame;
public class Grapher {
Integer Actualframe=0;
ObjectSim o;
ArrayList<Dot> frames;
JFrame window=new JFrame();
public Grapher(ObjectSim o)
{
frames = new ArrayList<>();
window.setSize(400,400);
this.o=o;
}
public void compute(Integer steps){
for(int i = 0;i<steps;i++){
frames.add(new Dot(o.actualScene.time,-o.CoMy));
o.actualScene.runStep();
Actualframe++;
}
window.add(new Draw(frames));
window.setVisible(true);
}


}
 