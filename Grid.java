//A grid for objects in the world
import java.util.HashMap;
public class Grid {
Scene actualScene;
float size=4.0f;
HashMap<Cord,Cell> cells;
Boolean garbageCollector = true;

public Grid(Scene s)
{this.actualScene=s;
cells = new HashMap<>();
}
public void addCell(Cell c)
{
c.ActualGrid = this;
cells.put(c.cord,c);}

public void rmCell(Cell c)
{
c.ActualGrid = null;
cells.remove(c.cord);
}

public Boolean isEmpty()
{return cells.isEmpty();}


public void moveObject2Cells(ObjectSim o,Cord cordDestination){
Cell source = o.actualCell;
Cell destination;
//if the cell doesnt exists create one else use the existing one
if(this.cells.containsKey(cordDestination)){
//use the existing one
destination = this.cells.get(cordDestination);}
else{
//create one
destination = new Cell(cordDestination.x(),cordDestination.y(), this);}

this.addCell(destination);
o.actualCell = destination;

destination.addObj(o);
source.rmObj(o);

//rmv obj from old cell if is empty
if(source.objects.isEmpty() && garbageCollector){
//System.out.println("removed cell: ("+ source.cord.x()+","+source.cord.y()+")");
this.cells.remove(source.cord);
}

o.actualCell.updateNeighbors();
//System.out.println("Neighbords of obj: "+o.Objectid+":"+o.actualCell.neighbors.size());
o.updateNeighbors();
o.updateCCcolision();

}


}