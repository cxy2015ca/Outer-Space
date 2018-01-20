import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 */
public class Bullet extends Mover
{
   Space currentWorld;
   int bulletLife = 1*30;
   int creationTime = -1;
    
    public Bullet( int direction) {
        turn (direction);
        speed = maxSpeed; 
    }
    /**
     *
     */
    public void act() 
    {
        currentWorld = (Space) getWorld();
        
        moveSteadily();
        
        //divide by 60 bc the default is 60frames/second, so now it counts up every second
        //System.out.println( currentWorld.getTime()/60 );
        if (creationTime == -1) {
            creationTime = currentWorld.getTime();
        }
        
        if ( currentWorld.getTime() > (creationTime + bulletLife) ) {
            //destroy this object
            //System.out.println( "DESTROY ME" );
            Space space = (Space)currentWorld;
            Counter counter = space.getCounter();
            counter.addScore();
            currentWorld.removeObject( this );
        }
    }    
}
