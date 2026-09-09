public class GridRunner extends StepRunner {

    public GridRunner(Scene s,int delay) {
        super(s,delay);
    }

    @Override
    public void run(){
        while(true){
        s.updateForcesS();
        try {
            Thread.sleep(delay);
        }catch (InterruptedException e){}
        }

    }

}
