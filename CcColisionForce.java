public class CcColisionForce extends Force {
    Circle targetCircle;
    float cNormal;
    float cTangent;
    float k;
    public CcColisionForce(Circle targetCircle,float k, float cNormal,float cTangent) {
        this.targetCircle = targetCircle;
        this.k=k;
        this.cNormal = cNormal;
        this.cTangent = cTangent;
        
    }

@Override
public void update() {
    Circle applyCircle = (Circle) this.applyObj; 

    float dx = applyCircle.CoMx - this.targetCircle.CoMx; 
    float dy = applyCircle.CoMy - this.targetCircle.CoMy;
    float r2 = dx*dx + dy*dy;
    float r = (float)Math.sqrt(r2);

    float rsum = applyCircle.radius + targetCircle.radius;

    if (rsum < r) {
        this.compX = 0.0f;
        this.compY = 0.0f;
        return;
    }

    float penetration = rsum - r;
    float magnitud = k * penetration;

    //normal vector
    float nx = dx / r; 
    float ny = dy / r;

    //tangent vector
    float tx = -ny; 
    float ty = nx;

float relVelX = applyCircle.speedX - targetCircle.speedX;
float relVelY = applyCircle.speedY - targetCircle.speedY;

float relVelNormal = relVelX*nx + relVelY*ny;
float relVelTangent = relVelX*tx + relVelY*ty;

float dampNormal = cNormal * relVelNormal;
float dampTangent = cTangent * relVelTangent;

this.compX = magnitud*nx - dampNormal*nx - dampTangent*tx;
this.compY = magnitud*ny - dampNormal*ny - dampTangent*ty;
}
}