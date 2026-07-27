public class DampingForce extends Force{
float rho;

public DampingForce(float rho){
this.rho=rho;    
}
@Override
public void update(){
this.compX = -this.applyObj.speedX*rho;    
this.compY = -this.applyObj.speedY*rho;    
};    
}
