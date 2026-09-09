import javax.swing.*;

public class SceneCanvas implements Runnable {
    Scene s;
    int delay = 100;
    public SceneCanvas(Scene s,int delay) {
        this.s = s;
        this.delay = delay;
    }

    @Override
    public void run() {
        JFrame sim = new JFrame();
        sim.setSize(400, 400);
        sim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SceneFrame panel = new SceneFrame(s);
        sim.add(panel);
        sim.setVisible(true);

        while(true) {
            panel.repaint();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {}
        }

    }

}
