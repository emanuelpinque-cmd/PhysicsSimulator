import java.util.HashMap;
public class Scene {
LinearForce gravity;
float time = 0.0f;
float step = 0.1f;
Boolean isRunning = true;
Boolean gravityOpt =  false;
HashMap<Integer,ObjectSim> objects;
Integer lastObjectId = 0;
Grid actualGrid;
Square universe;
public Scene(){
objects = new HashMap<>();
gravity = new LinearForce( 0.0f,-9.8f );
actualGrid = new Grid(this);
}

public void addObject(ObjectSim o){
    Force objGravity = new LinearForce(0.0f, this.gravity.compY * o.mass);
    o.addForce(objGravity);
    objects.put(lastObjectId, o);    
    o.Objectid = lastObjectId;
    o.actualScene = this;
    o.actualGrid = this.actualGrid;
    if(gravityOpt == true){
    o.actualUniverse = this.universe;}

    o.initializeCell();
    
    lastObjectId++;
   

}
public void updateNeighborsS(){
 for(ObjectSim o:objects.values())
{o.actualCell.updateNeighbors();}}   

public void updateCellS(){
for(ObjectSim o:objects.values())
{o.updateCell2();}}

public void updateForcesS(){
for(ObjectSim o : objects.values())
{
o.updateForces();    
}
}

public void updateSpeedS(){
for(ObjectSim o : objects.values())
{
o.updateSpeed(step);    
}
}

public void updatePositionS(){
for(ObjectSim o : objects.values())
{
o.updatePosition(this.step);
}
}

public void updateGForcesS(Square universe,float G){
//regenerate universe
initSquare();
for(ObjectSim o : objects.values())
{
o.updateGForces(universe, G);
}
}
public void sceneInit(){
    
}

public void runStep(){
if(!isRunning)
    return;

updateCellS();
if(gravityOpt == true ){
updateGForcesS(this.universe,0.1f);
}

updateForcesS();
updateSpeedS();
updatePositionS();
time +=step;

}


public void setGravity(float f){
this.gravity.compY = f;}

public void addMatrixCircle(Integer N,Integer M,Float separation,float speedX,float speedY,float posX,float posY,float g)
{
float acumPx = 0.0f;
float acumPy= 0.0f;

  for(int k=0;k<M;k++){
       for(int i=0;i<N;i++)
       {
        this.addObject(new Circle(1.0f,posX + acumPx-N*separation/2, posY+acumPy-M*separation/2));
        acumPx+=separation;
        this.objects.get(this.lastObjectId-1).speedX=speedX;
        this.objects.get(this.lastObjectId-1).speedY=speedY;
    }
        acumPy+=separation;
        acumPx=0.0f;
    }
        
    
        
        for(ObjectSim o:this.objects.values()){
        for(int i=0;i<this.objects.size();i++)
        {
        if(o.Objectid!=i){
        Circle c =(Circle) this.objects.get(i);
        //o.addForce(new CcColisionForce(c, 10.0f, 1.0f));
        if(g!=0.0f)
        {o.addForce(new GravityForce(c, 0.1f));}
    }}}}

    public void addSquareOfCircles(Integer N,float separation,float posx,float posy,float speedx){
    float size = N.floatValue()*separation;
    if(N%2==0)
    {
        for(float i=1.0f;i<=N;i++)
        {
        for(float k=1.0f;k<=N;k++)
        {Circle c =new Circle(1.0f,(-(separation/2)-size/2)+i*separation+posx, (-(separation/2)-size/2)+k*separation+posy);
        c.speedX = speedx;
        this.addObject(c);
        
    }

    }
    }        
    

    }

    public void initSquare(){
    this.universe = new Square(this, 4096.0f);
    }



}
