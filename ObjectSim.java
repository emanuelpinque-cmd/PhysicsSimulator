import java.util.HashMap;
public class ObjectSim {
Float CoMx;
Float CoMy;
Float mass;
Float density;
Float volume;
Float speedX;
Float speedY;
HashMap<Integer,Force> forces;
Integer lastForceId = 0;
Force sum;
public ObjectSim(Float posX,Float posY)
{
this.CoMx=posX;
this.CoMy=posY;
this.speedX=0.0f;
this.speedY=0.0f;
this.sum = new LinearForce(0.0f,0.0f   );
this.forces = new HashMap<>();
}

public void addForce(Force f){
this.lastForceId++;
forces.put(lastForceId,f);
this.updateSum();
}

public void updateSum(){
    Float totalX = 0.0f;
    Float totalY = 0.0f;

    for (Force f : forces.values()) {
        totalX += f.compX;
        totalY += f.compY;
    }

    this.sum = new LinearForce(totalX, totalY);
}

public void updatePosition(float step){
this.CoMx += step * this.speedX;
this.CoMy += step * this.speedY;
}

public void updateSpeed(float step){
this.speedX += step * this.sum.compX;
this.speedY += step * this.sum.compY;
}

public void showStats(){
System.out.println("pos:"+this.CoMx+","+this.CoMy);    
System.out.println("speed:"+this.speedX+","+this.speedY);   
}

}
