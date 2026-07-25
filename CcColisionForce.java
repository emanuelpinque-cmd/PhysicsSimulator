public class CcColisionForce extends Force {
    Circle targetCircle;
    Float k;
    Float c;
    public CcColisionForce(Circle targetCircle, Float k,Float c) {
        this.targetCircle = targetCircle;
        this.k = k;
        this.c = c;
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

    Float nx = dx / r; 
    Float ny = dy / r;

    Float relSpeedX = applyCircle.speedX - targetCircle.speedX;
    Float relSpeedY = applyCircle.speedY - targetCircle.speedY;

    
    Float relSpeedNormal = relSpeedX * nx + relSpeedY * ny;

    Float dampingForce = c * relSpeedNormal; 

    this.compX = magnitud * nx - dampingForce * nx;
    this.compY = magnitud * ny - dampingForce * ny;
}
}