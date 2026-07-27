public class GravityForce extends Force {
    ObjectSim targetObj;
    float G;
    public GravityForce(ObjectSim targetObj, float G) {
        this.targetObj = targetObj;
        this.G = G;
    }

    @Override
    public void update() {
        float dx = this.targetObj.CoMx - this.applyObj.CoMx;
        float dy = this.targetObj.CoMy - this.applyObj.CoMy;
        float r2 = dx*dx + dy*dy;
        float r = (float)Math.sqrt(r2);

        float magnitud = G * this.applyObj.mass * this.targetObj.mass / r2;

        this.compX = magnitud * (dx / r);
        this.compY = magnitud * (dy / r);
    }
}