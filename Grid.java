//A grid for objects in the world
import java.util.HashMap;
public class Grid {
Scene actualScene;
Float size=1.0f;
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



}