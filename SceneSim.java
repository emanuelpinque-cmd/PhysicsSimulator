import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class SceneSim {


    public SceneSim(Scene s) {
        JFrame sim = new JFrame();
        sim.setSize(400, 400);
        sim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Cord c = new Cord(0,-3);
        SceneFrame panel = new SceneFrame(s);
        sim.add(panel);
        sim.setVisible(true);

      Integer speedMultiplier = 1; 

    Timer timer = new Timer(16, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < speedMultiplier; i++) {
            s.runStep();}
        
        panel.repaint();
    }
});
        timer.start();
    }
}