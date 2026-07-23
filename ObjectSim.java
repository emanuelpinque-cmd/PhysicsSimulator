import java.awt.Graphics;
import java.util.HashMap;
public abstract class ObjectSim{
Float CoMx;
Float CoMy;
Float mass;
Float density;
Float volume;
Float speedX;
Float speedY;
HashMap<Integer,Force> forces;
//this should be next
Integer lastForceId = 0;
Force sum;
Scene actualScene;
Grid actualGrid;
Cell actualCell;
Boolean isFixed=false;
Integer Objectid;

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
f.applyObj = this;
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
if(this.isFixed) return;
this.CoMx += step * this.speedX;
this.CoMy += step * this.speedY;
}

public void updateSpeed(float step){
if(this.isFixed) return;
this.speedX += step * (this.sum.compX/this.mass);
this.speedY += step * (this.sum.compY/this.mass);
}

public void updateForces(){
for(Force f : forces.values()){
f.update();}
this.updateSum();
}

public void showStats(){
System.out.println("pos:"+this.CoMx+","+this.CoMy);    
System.out.println("speed:"+this.speedX+","+this.speedY);   
}


//has a bug :( when a object pass the cells are cloned
public void updateCell(){

int x = (int)(this.CoMx/this.actualGrid.size);
int y = (int)(this.CoMy/this.actualGrid.size);

if(this.actualCell == null)
{
System.out.println("first cell created");
Cell cell = new Cell(x, y,this.actualGrid);
this.actualCell=cell;
this.actualGrid.addCell(cell);
this.actualCell.addObj(this);
this.actualCell.updateNeighbors();
return;
}

//if the cell are same do nothing
if((this.actualCell.cord.x() == x) && (this.actualCell.cord.y() == y) &&(this.actualCell!=null))
{
//System.out.println("on cell");
return;}

//now we change the cell, the new cell exists??

Cord c = new Cord(x,y);
Cell oldCell = this.actualCell;
if(this.actualGrid.cells.containsKey(c) && (this.actualCell!=null))
{

//update the new cell
this.actualCell = this.actualGrid.cells.get(c);
//add obj to the cell
this.actualCell.addObj(this);

//and remove from the other cell
oldCell.rmObj(this);
this.actualCell.updateNeighbors();
return;
}
//Create a cell put the obj and asing the grid to the new Cell
System.out.println("new cell created");
Cell cell = new Cell(x, y,this.actualGrid);
//update 
this.actualCell = cell;
//put the cell on the cells hashmap
this.actualGrid.addCell(cell);
//now i add this obj
this.actualCell.addObj(this);

this.actualCell.updateNeighbors();

oldCell.rmObj(this);
}

public abstract void draw(Graphics g, int panelWidth, int panelHeight);
}
