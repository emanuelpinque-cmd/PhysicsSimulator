import java.util.HashMap;

public class ObjectUpdater{
Integer firstId;
Integer lastId;
HashMap<Integer,ObjectSim> objects;

public ObjectUpdater(Integer first,Integer last,HashMap<Integer,ObjectSim> objects) {
this.firstId = first;
this.lastId = last;
this.objects = objects;
}



}
