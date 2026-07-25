import java.util.ArrayList;
public class Cell {
Cord cord;
Grid ActualGrid;
ArrayList<ObjectSim> objects;
ArrayList<Cell> neighbors;
public Cell(Integer x,Integer y,Grid g){
objects = new ArrayList<>();
neighbors = new ArrayList<>();
this.ActualGrid = g;  
this.cord = new Cord(x,y);
}

public void addObj(ObjectSim o){
this.objects.add(o);
//System.out.println("Object "+o.Objectid+" added to cell: " + this.cord.x() +","+ this.cord.y() );
}

public void rmObj(ObjectSim o){
this.objects.remove(o);
//System.out.println("deleted from cell: " + this.cord.x() +","+ this.cord.y() );
}

//this method can be optimized?
public void updateNeighbors(){
this.neighbors.clear();
for(int i=-1;i<2;i++)   
{for(int k=-1;k<2;k++){
Cord key = new Cord(this.cord.x()+k,this.cord.y()+i);
if(this.ActualGrid.cells.containsKey(key)){
//add the cell to the neighbords list
this.neighbors.add(this.ActualGrid.cells.get(key));
//tell to these cell update neighbords

}}}

}




}