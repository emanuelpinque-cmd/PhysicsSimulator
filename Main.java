public class Main {
    public static void main(String[] args) {
      Scene s = new Scene();
      s.setGravity(0.0f);
      s.addSquareOfCircles(50, 2.0f,-200.0f,0.0f,5.0f);
       s.addSquareOfCircles(50, 2.0f,200.0f,40.0f,-5.0f);
      /*for(ObjectSim o:s.objects.values()){
      System.out.println(o.Objectid+" "+"("+o.CoMx+"," + o.CoMy + ")");
      }*/
      s.initSquare();
      System.out.println("");
      SceneSim sim = new SceneSim(s);
      
      
    }
}