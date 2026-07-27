//GravityOptimizationLogic
import java.util.ArrayList;
public class Square {
Square NE;
Square NO;
Square SE;
Square SO;
Square dad;
Float x;
Float y;
Float CoMx;
Float CoMy;
Float mass;
Float size;
Integer deep;
ArrayList<ObjectSim> sObjects;
Scene actualScene;
Float theta=0.5f;
Integer cut=10;
//Universe constructor
public Square(Scene s,Float size){
this.x=0.0f;    
this.y=0.0f;
this.actualScene=s;
this.size=size;
this.dad=null;
this.deep=0;
//get allObjects of the sim
sObjects = new ArrayList<>(s.objects.values());
this.getCoMs();

float center = size/4;

NE = new Square(this,center,center);
NO = new Square(this,-center,center);
SE = new Square(this,center,-center);
SO = new Square(this,-center,-center);

}

private void asingObj(){
this.sObjects.get(0).actualSquare=this;}

private Square(Square dad,Float x,Float y){
this.x=x;
this.y=y;
this.dad=dad;

this.actualScene=dad.actualScene;
this.deep=dad.deep+1;
this.size=dad.size/2;
//filter objects
sObjects = new ArrayList<>();
this.updateObjects();

if((this.sObjects.size()<2)||(this.deep>cut))
{
    if(this.sObjects.size()==1){
        asingObj();
    }
    else if(this.sObjects.size()<2){  
        this.getCoMs();
    }
    else {
       
        for(ObjectSim o : this.sObjects){
            o.actualSquare = this;
        }
    }
    return;
}

float center = (this.size)/2;

NE = new Square(this,this.x+center,this.y+center);
NO = new Square(this,this.x-center,this.y+center);

SE = new Square(this,this.x+center,this.y-center);
SO = new Square(this,this.x-center,this.y-center);

}

private void updateObjects(){
//filter objects
for(ObjectSim o:dad.sObjects){
if((o.CoMx<(x+size))&&((x-size)<o.CoMx)&&(o.CoMy<(y+size))&&((y-size)<o.CoMy))
this.sObjects.add(o);
}
this.getCoMs();
}

private void getCoMs(){
if(this.sObjects.isEmpty()){
return;}
Float sumX=0.0f;
Float sumY=0.0f;
this.mass=0.0f;
//get the total mass
for(ObjectSim o:this.sObjects){
this.mass+=o.mass;
sumX+=o.CoMx*o.mass;
sumY+=o.CoMy*o.mass;}

this.CoMx = sumX/this.mass;
this.CoMy = sumY/this.mass;
}
}
