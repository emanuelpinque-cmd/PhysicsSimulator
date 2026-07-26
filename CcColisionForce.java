public class CcColisionForce extends Force {
    Circle targetCircle;
    Float cNormal;
    Float cTangent;
    Float k;
    public CcColisionForce(Circle targetCircle,Float k, Float cNormal,Float cTangent) {
        this.targetCircle = targetCircle;
        this.k=k;
        this.cNormal = cNormal;
        this.cTangent = cTangent;
        
    }

@Override
public void update() {
    Circle applyCircle = (Circle) this.applyObj; 

    Float dx = applyCircle.CoMx - this.targetCircle.CoMx; 
    Float dy = applyCircle.CoMy - this.targetCircle.CoMy;
    Float r2 = dx*dx + dy*dy;
    Float r = (float) Math.sqrt(r2);

    Float rsum = applyCircle.radius + targetCircle.radius;

    if (rsum < r) {
        this.compX = 0.0f;
        this.compY = 0.0f;
        return;
    }

    Float penetration = rsum - r;
    Float magnitud = k * penetration;

    //normal vector
    Float nx = dx / r; 
    Float ny = dy / r;

    //tangent vector
    Float tx = -ny; 
    Float ty = nx;

Float relVelX = applyCircle.speedX - targetCircle.speedX;
Float relVelY = applyCircle.speedY - targetCircle.speedY;

Float relVelNormal = relVelX*nx + relVelY*ny;
Float relVelTangent = relVelX*tx + relVelY*ty;

Float dampNormal = cNormal * relVelNormal;
Float dampTangent = cTangent * relVelTangent;

this.compX = magnitud*nx - dampNormal*nx - dampTangent*tx;
this.compY = magnitud*ny - dampNormal*ny - dampTangent*ty;
}
}