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
Float size;
Integer deep;
ArrayList<ObjectSim> sObjects;
Scene actualScene;

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


NE = new Square(this,size/2,size/2);
NO = new Square(this,-size/2,size/2);

SE = new Square(this,size/2,-size/2);
SO = new Square(this,-size/2,-size/2);

}

public Square(Square dad,Float x,Float y){
this.x=x;
this.y=y;
this.dad=dad;

this.actualScene=dad.actualScene;
this.deep=dad.deep+1;
this.size=dad.size/2;
//filter objects
sObjects = new ArrayList<>();
this.updateObjects();

if((this.sObjects.size()<2)||(this.deep>99))
return;

float center = this.size/2;

NE = new Square(this,this.x+center,this.y+center);
NO = new Square(this,this.x-center,this.y+center);

SE = new Square(this,this.x+center,this.y-center);
SO = new Square(this,this.x-center,this.y-center);

}

public void updateObjects(){
//filter objects
for(ObjectSim o:dad.sObjects){
if((o.CoMx<(x+size))&&((x-size)<o.CoMx)&&(o.CoMy<(y+size))&&((y-size)<o.CoMy))
this.sObjects.add(o);
}}
}
