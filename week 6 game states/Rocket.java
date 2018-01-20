import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 */
public class Rocket extends Mover
{
    
    boolean touchingasteroid = false;
    
    //add Global varables to Rocket class(only global to methods in THIS rocket object)
    double speed = 1.25;
    double maxSpeed = 50;
    double otherSpeed;
    double rotationAccel = 1;
    Bullet currentBullet;
    Space currentWorld;
    int numberBullets = 3;
    int bulletDelay = 20;
    int bulletDelayTimer;
    
    
   
    public void act() 
    {
        currentWorld = (Space) getWorld();
        
        
        //move the ship forwards
        if (Greenfoot.isKeyDown("w")) {
          
        //accelerates rocket when it's lesser than the max speed 
        if (speed < maxSpeed) {
        speed = speed + speed * 0.05;
       }
        move( (int)speed);
    }
    //holding the "s" key stops the rocket from moving forward immediately 
    else if (Greenfoot.isKeyDown("s")) { 
        otherSpeed = 0;
        move((int) speed * 0);
    }
    //deccelerate the rocket until it reaches normal speed, which is 1.25
    else {
        if (speed > 1.25) {
        speed = speed - speed * 0.01;
    }
        
        move((int)speed); }
    
    
    //turn the ship right and accelerate it if "d" is pressed
        if (Greenfoot.isKeyDown("d")) {
            if (rotationAccel < 15) {
        rotationAccel = rotationAccel + rotationAccel * 0.03;}
        turn((int) rotationAccel);
    }  
    //turn the ship left and accelerate it if "a" is pressed
    else if (Greenfoot.isKeyDown("a")) {
           if (rotationAccel < 15) {
            rotationAccel = rotationAccel + rotationAccel * 0.03;}
            turn((int) -rotationAccel);
    
        } 
        //restores speed/acceleration back to 1
       else {
           rotationAccel = 1;
        }

        if (Greenfoot.isKeyDown("space")) {
            if (currentWorld.getObjects( Bullet.class).size() < numberBullets ) {
                if (bulletDelayTimer + bulletDelay < currentWorld.getTime() ) {
                currentWorld.addObject( new Bullet(getRotation()), getX(), getY());
                bulletDelayTimer = currentWorld.getTime();
            }
            }
        }
        
       
   
        if (getX() <= 0) {
            setLocation(getX() + 600, getY());
        }    
        if (getX() >= 600) {
            setLocation(getX() - 600, getY());
        }
        if (getY() <= 0) {
            setLocation(getX(), getY() + 400);
        }
        if (getY() >= 400) {
            setLocation(getX(), getY() - 400);
        }
        
        if (intersects((Actor)getWorld().getObjects(asteroid.class).get(0))) {
         
            Space space = (Space)currentWorld;
            HealthBar healthbar = space.getHealthBar();
            if(touchingasteroid ==false)
            {
                healthbar.loseHealth();
                touchingasteroid = true;
                if(healthbar.health <= 0)
                {    getWorld().addObject( new Explosion(), getX(), getY() );
                     GameOver gameover = new GameOver();
                     currentWorld.addObject(gameover, 300, 200);
                     currentWorld.removeObject(this);
                }
            }
         
        } else{
            touchingasteroid = false;
        }
        
    
}
}


