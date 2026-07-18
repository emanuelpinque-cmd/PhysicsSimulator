import java.util.ArrayList;
import javax.swing.JFrame;

public class Main{
    public static void main(String[] args){
    ArrayList<Dot> frames = new ArrayList<>();
    Integer numberOfFrames = 0;
    
    JFrame frame = new JFrame("window");
    frame.setSize(400, 400);
    Scene s = new Scene();
    ObjectSim o = new Block(2.0f, 0.0f, 0.0f);
    s.addObject(o);
    //o.addForce(new Force(0.0f, 10.0f));
    o.speedY=6000.0f;
    for(int i = 0;i<6000;i++)
    {
    System.out.println(s.time);
    frames.add(new Dot(s.time,-o.CoMy));
    o.showStats();
    s.time += s.step;
    s.updateSpeedS();
    s.updatePositionS();
    
  }
 
    frame.add(new Draw(frames));
  
  
    frame.setVisible(true); 
    //System.out.println(s.objects.get(1).forces.get(1).compY);

}
}