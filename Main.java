public class Main {
    public static void main(String[] args) {
      Scene s = new Scene();
      s.setGravity(0.0f);
        s.addMatrixCircle(12, 12, 2.0f, 0.8f, 0.0f, -0.0f, 18.0f, 500.0f);
        s.addMatrixCircle(12, 12, 2.0f, -0.8f, 0.0f, 0.0f, -18.0f, 500.0f);
        //s.updateNeighborsS();
        //c1.speedY = -0.5f;
        //System.out.println(s.actualGrid.cells.get(new Cord(0,0)).objects.size());
       
       
        SceneSim sim = new SceneSim(s);
    }
}