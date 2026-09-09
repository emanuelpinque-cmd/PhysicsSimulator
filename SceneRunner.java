public class SceneRunner implements Runnable {
int delay;
Scene s;
float g = 0.1f;
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
    if(s.gravityOpt)
       {s.updateGForcesS(s.universe,g);}
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
