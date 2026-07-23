public class GravityForce extends Force {
    ObjectSim targetObj;
    Float G;

    public GravityForce(ObjectSim targetObj, Float G) {
        this.targetObj = targetObj;
        this.G = G;
    }

    @Override
    public void update() {
        Float dx = this.targetObj.CoMx - this.applyObj.CoMx;
        Float dy = this.targetObj.CoMy - this.applyObj.CoMy;
        Float r2 = dx*dx + dy*dy;
        Float r = (float)Math.sqrt(r2);

        Float magnitud = G * this.applyObj.mass * this.targetObj.mass / r2;

        this.compX = magnitud * (dx / r);
        this.compY = magnitud * (dy / r);
    }
}