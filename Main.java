public class Main {
    public static void main(String[] args) {


        Scene s = new Scene();
        s.gravityOpt = true;
        s.setGravity(0.0f);
        s.addSquareOfCircles(10, 2.0f,-50.0f,5.0f,0.1f);
        s.addSquareOfCircles(10, 2.0f,50.0f,-5.05f,-0.1f);
      /*for(ObjectSim o:s.objects.values()){
      System.out.println(o.Objectid+" "+"("+o.CoMx+"," + o.CoMy + ")");
      }*/
      s.initSquare();
      System.out.println("");
      SceneCanvas sceneCanvas = new SceneCanvas(s,16);
      SceneRunner sceneRunner = new SceneRunner(s,1);
      Thread canvasT = new Thread(sceneCanvas);
      Thread runnerT = new Thread(sceneRunner);

      canvasT.start();
      runnerT.start();

    }
}