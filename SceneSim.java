import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.Timer;

public class SceneSim {
    public SceneSim(Scene s) {
        JFrame sim = new JFrame();
        sim.setSize(400, 400);
        sim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Cord c = new Cord(0,-3);

        SceneFrame panel = new SceneFrame(s);
        sim.add(panel);
        sim.setVisible(true);

      Integer speedMultiplier = 1; 

    Timer timer = new Timer(16, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < speedMultiplier; i++) {
            s.runStep();

            System.out.println("cell");
            System.out.println("("+s.objects.get(0).actualCell.cord.x()+","+s.objects.get(0).actualCell.cord.y()+")");
            ArrayList<Cell> n;
            n=s.objects.get(0).actualCell.neighbors;
            System.out.println("Neighbords:");
            for(Cell c:n){
            System.out.println("("+c.cord.x()+","+c.cord.y()+")");}}
        
        panel.repaint();
    }
});
        timer.start();
    }
}