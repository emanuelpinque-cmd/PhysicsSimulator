public class SceneRunner implements Runnable {
int delay = 100;
Scene s;

public SceneRunner(Scene s,int delay) {



    this.s = s;
    this.delay = delay;
}

@Override
    public void run() {
    while(true) {
        s.updateCellS();
        if(!s.isRunning)
        return;

    s.updateForcesS();
    s.updateSpeedS();
    s.updatePositionS();
    s.time +=s.step;

    try {
        Thread.sleep(delay);
    } catch (InterruptedException e) {
    }
}
}

}
