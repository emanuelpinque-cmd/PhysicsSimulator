public class Main {
    public static void main(String[] args) {
      Scene s = new Scene();
      s.setGravity(0.0f);
      s.addSquareOfCircles(8, 4.0f);
      /*for(ObjectSim o:s.objects.values()){
      System.out.println(o.Objectid+" "+"("+o.CoMx+"," + o.CoMy + ")");
      }*/
      s.initSquare();
      s.runStep();
      System.out.println("");
      SceneSim sim = new SceneSim(s);
      
      
    }
}