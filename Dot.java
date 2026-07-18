public class Dot {
    Integer x;   
    Integer y;
    Integer scalar = 1;
public Dot(Float Xf,Float Yf){
Xf = (Xf*scalar);
Yf = (Yf*scalar);
this.x = Xf.intValue();
this.y = Yf.intValue();
}

}
