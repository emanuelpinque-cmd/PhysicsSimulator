public class SpringForce extends Force{
float springX;
float springY;
float k;
float c;
SpringForce(float x,float y,float k,float c)    
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
