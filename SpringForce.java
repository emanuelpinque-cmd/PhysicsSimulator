public class SpringForce extends Force{
Float springX;
Float springY;
Float k;
Float c;
SpringForce(Float x,Float y,Float k,float c)    
{
this.springX = x;
this.springY = y;
this.k = k;
this.c = c;
}
@Override
public void update() {
this.compY = -k*(this.applyObj.CoMy-springY)-c*this.applyObj.speedY;
this.compX = -k*(this.applyObj.CoMx-springX)-c*this.applyObj.speedX;
}
}
