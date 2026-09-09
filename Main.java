public class Main {
    public static void main(String[] args) {


        Scene s = new Scene();

        s.setGravity(0.0f);
        s.addSquareOfCircles(50, 2.0f,-150.0f,20.0f,1.0f);
        s.addSquareOfCircles(50, 2.0f,150.0f,-20.05f,-1.0f);
      /*for(ObjectSim o:s.objects.values()){
      System.out.println(o.Objectid+" "+"("+o.CoMx+"," + o.CoMy + ")");
      }*/
      //s.initSquare();
      System.out.println("");
      SceneCanvas sceneCanvas = new SceneCanvas(s,16);
      SceneRunner sceneRunner = new SceneRunner(s,1);
      Thread canvasT = new Thread(sceneCanvas);
      Thread runnerT = new Thread(sceneRunner);

      canvasT.start();
      runnerT.start();

    }
}