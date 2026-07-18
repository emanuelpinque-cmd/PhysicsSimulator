import java.util.HashMap;
public class Scene {
Force gravity;
Float time = 0.0f;
Float step = 1.0f;
Boolean isRunning = false;
HashMap<Integer,ObjectSim> objects;
Integer lastObjectId = 0;
public Scene(){
objects = new HashMap<>();
gravity = new LinearForce( 0.0f,-9.8f );
}

public void addObject(ObjectSim o){
    lastObjectId++;
    o.addForce(gravity);
    objects.put(lastObjectId, o);    

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

public void runStep(){
if(!isRunning)
    return;
updateSpeedS();
updatePositionS();    

time +=step;

}

}
