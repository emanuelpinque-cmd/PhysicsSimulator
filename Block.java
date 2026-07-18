public class Block extends ObjectSim{
    Float sizeX;
    Float sizeY;
    Float sizeZ;

public Block(Float size,Float posx,Float posy)
{
super(posx,posy);
this.sizeX=size;
this.sizeY=size;
this.sizeZ=1.0f;
this.density = 1.0f;
this.volume =sizeX*sizeY*sizeZ;
this.mass = this.volume * this.density;

}


}
