public class DampingForce extends Force{
Float rho;

public DampingForce(Float rho){
this.rho=rho;    
}
@Override
public void update(){
this.compX = -this.applyObj.speedX*rho;    
this.compY = -this.applyObj.speedY*rho;    
};    
}
