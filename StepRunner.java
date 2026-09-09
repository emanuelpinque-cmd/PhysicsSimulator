public abstract class StepRunner implements Runnable {
    Scene s;
    int delay;
    public StepRunner(Scene s,int delay) {
        this.s = s;
        this.delay = delay;
    }

}
