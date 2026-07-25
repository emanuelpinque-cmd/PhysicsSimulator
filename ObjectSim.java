import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
public abstract class ObjectSim{
Float CoMx;
Float CoMy;
Float mass;
Float density;
Float volume;
Float speedX;
Float speedY;

//BetterLogicWithArrayList?
ArrayList<Force> forces;
//HashMap with the reference of the objId
HashMap<Integer,CcColisionForce> cccForces;
//this should be next
Force sum;
Scene actualScene;
Grid actualGrid;
Cell actualCell;
Boolean isFixed=false;
Integer Objectid;
Integer xCell;
Integer yCell;
ArrayList<ObjectSim> neightbords;
public ObjectSim(Float posX,Float posY)
{
this.CoMx=posX;
this.CoMy=posY;
this.speedX=0.0f;
this.speedY=0.0f;
this.sum = new LinearForce(0.0f,0.0f   );
this.forces = new ArrayList<>();
this.cccForces = new HashMap<>();
this.neightbords = new ArrayList<>();
}

public void addForce(Force f){
f.applyObj = this;
if(f instanceof CcColisionForce)
{
CcColisionForce cccForce = (CcColisionForce)f;
cccForces.put(cccForce.targetCircle.Objectid,cccForce);}
else{forces.add(f);}
this.updateSum();
}

public void updateSum(){
    Float totalX = 0.0f;
    Float totalY = 0.0f;
    ArrayList<Force> totalForces = new ArrayList<>(forces);
    totalForces.addAll(cccForces.values());
    for (Force f : totalForces) {
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
    for(Force f : forces){
        f.update();
    }
    for(CcColisionForce f : cccForces.values()){ 
        f.update();
    }
    this.updateSum();
}

public void showStats(){
System.out.println("pos:"+this.CoMx+","+this.CoMy);    
System.out.println("speed:"+this.speedX+","+this.speedY);   
}


//has a bug :( when a object pass the cells are cloned
//deprecated method, use updateCell2, but this method is working, so i will keep it for now
//in the future i will remove it to rename updateCell2 to updateCell
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

public Boolean checkCell(){
return (this.xCell == this.actualCell.cord.x()) && (this.yCell == this.actualCell.cord.y()); }

//Better method (WIP)
public void updateCell2(){
updateCellInfo();
//System.out.println(this.yCell);
if(this.checkCell())
{return;}
//System.out.println("object pass cell");
this.actualGrid.moveObject2Cells(this,new Cord(xCell, yCell));
System.out.println("Objects on neighbordhood of "+this.actualCell.cord.x()+","+this.actualCell.cord.y());
for(ObjectSim o:this.neightbords)
{
System.out.println(o.Objectid);
}
System.out.println("the actual object ("+this.Objectid+") has "+this.cccForces.size()+" colisions forces");

}

public void updateCellInfo(){
this.xCell = (int)(this.CoMx/this.actualGrid.size);
this.yCell = (int)(this.CoMy/this.actualGrid.size);}

public void initializeCell(){
this.updateCellInfo();
Cord tempCord = new Cord(xCell,yCell);
if(!this.actualGrid.cells.containsKey(tempCord))
{
//if dont exists create one
Cell cell = new Cell(this.xCell,this.yCell,this.actualGrid);
this.actualGrid.addCell(cell);
this.actualCell = cell;
}
else{
this.actualCell = this.actualGrid.cells.get(tempCord);}

this.actualCell.addObj(this);
this.actualCell.updateNeighbors();
this.updateNeighbors();
this.updateCCcolision();
System.out.println("Objects on neighbordhood of "+this.actualCell.cord.x()+","+this.actualCell.cord.y());
for(ObjectSim o:this.neightbords)
{
System.out.println(o.Objectid);
}
System.out.println("the actual object ("+this.Objectid+") has "+this.cccForces.size()+" colisions forces");
}
//update the objects neighbords
public void updateNeighbors(){
this.neightbords.clear();
for(Cell c:this.actualCell.neighbors){
this.neightbords.addAll(c.objects);}}

public void updateCCcolision(){
//clear the old colision forces
//this.cccForces.clear();
this.removeCCforces();
Circle c;
Circle thisc;
for(ObjectSim o:this.neightbords)
{
if(!o.equals(this))
{
thisc = (Circle) this;
c =(Circle) o;

System.out.println("added force "+thisc.Objectid+" to "+c.Objectid);
System.out.println("added force "+c.Objectid+" to "+thisc.Objectid);
this.addForce(new CcColisionForce(c, 10.0f, 0.0f));    
c.addForce(new CcColisionForce(thisc, 10.0f, 0.0f)); 
}
}
}

public void removeCCforces(){
for(ObjectSim o:neightbords)
{
//remove allForces with references to the actualObj
if(o.cccForces.containsKey(this.Objectid)){
System.out.println("removed force "+o.Objectid +" to "+this.Objectid);
o.cccForces.remove(this.Objectid);}
}
//and clear all colision force of the actual object
for (CcColisionForce f:cccForces.values()){
System.out.println("removed force "+f.applyObj.Objectid + "to"+f.targetCircle.Objectid);
}
this.cccForces.clear();
}
public abstract void draw(Graphics g, int panelWidth, int panelHeight);
}
