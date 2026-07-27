public class VirtualGravityForce extends Force{
Float x;
Float y;
Float virtualMass;
Float G;
Float offset=0.1f;
Float increment=0.1f;
public VirtualGravityForce(Float x,Float y,Float G,Float virtualMass){
this.x=x;   
this.y=y;
this.virtualMass = virtualMass;
this.G=G;
}

@Override
public void update() {
    
Float dx = x - this.applyObj.CoMx;
Float dy = y - this.applyObj.CoMy;
Float r2 = dx*dx + dy*dy+0.1f;
Float r = (float)Math.sqrt(r2);
Float magnitud = G * this.applyObj.mass * virtualMass / r2;

this.compX = magnitud * (dx / r);
this.compY = magnitud * (dy / r);
}
}
