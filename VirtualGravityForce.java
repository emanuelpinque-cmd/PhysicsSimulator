public class VirtualGravityForce extends Force{
float x;
float y;
float virtualMass;
float G;
float offset=0.1f;
float increment=0.1f;
public VirtualGravityForce(float x,float y,float G,float virtualMass){
this.x=x;   
this.y=y;
this.virtualMass = virtualMass;
this.G=G;
}

@Override
public void update() {
    float dx = x - this.applyObj.CoMx;
    float dy = y - this.applyObj.CoMy;
    float r2 = dx*dx + dy*dy;

    float minDist2 = 0.4f * 0.4f; // umbral al cuadrado, ajustá según tu escala

    if (r2 < minDist2) {
        this.compX = 0.0f;
        this.compY = 0.0f;
        return;
    }

    float r = (float) Math.sqrt(r2);
    float magnitud = G * this.applyObj.mass * virtualMass / r2;

    this.compX = magnitud * (dx / r);
    this.compY = magnitud * (dy / r);
}


}
