
import java.util.HashMap;


public class ForceUpdater extends ObjectUpdater implements Runnable{

    public ForceUpdater(Integer first,Integer last,HashMap<Integer,ObjectSim> objects){
super(first, last, objects);}

@Override
public void run(){
//update all forces
for(int i = firstId;i<=lastId;i++)
{objects.get(i).updateForces();}}

}
