public class Main {
    public static void main(String[] args) {
        Scene s = new Scene();
        s.setGravity(0.0f);
       
        Circle c2 = new Circle(1.0f, 0.0f, -9.0f);
        Circle c3 = new Circle(1.0f, 1.0f, -10.0f);
        Circle c1 = new Circle(1.0f, 0.0f, -10.0f);
        s.addObject(c1);
        s.addObject(c2);
        s.addObject(c3);

        s.updateNeighborsS();
        //c1.speedY = -0.2f;
    
       

        SceneSim sim = new SceneSim(s);
    }
}