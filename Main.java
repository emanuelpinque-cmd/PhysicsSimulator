public class Main {
    public static void main(String[] args) {
      Scene s = new Scene();
      s.setGravity(0.0f);
      s.addObject(new Circle(1.0f, 1.0f, 1.0f));
      s.addObject(new Circle(1.0f, 1.0f, -1.0f));
      s.addObject(new Circle(1.0f, -1.0f, 1.0f));
      s.addObject(new Circle(1.0f, -1.0f, -1.0f));

      s.initSquare();
    System.out.println("");
    }
}