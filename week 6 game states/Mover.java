import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 */
public class Mover extends Actor
{
    //Global variables
     double speed = 1.25;
     double maxSpeed = 20;
     
    public Mover() {
    }
    
    public Mover(int direction) {
        turn(direction);
        speed = (Math.random() *5) +5;
    }
    
    public Mover(double speedIn) {
        speed = speedIn;
 
        turn( Greenfoot.getRandomNumber(360));
    }
    
      public Mover(int direction, double speedIn) {
          turn(direction);
          speed = speedIn;

    }
    

    public void act() 
    {
       moveSteadily();     
  
       
    }    
       
    /**
     * moveSteadily = moves the mover across the screen and wraps the movement across the edge of the screen
     */
    
    public void moveSteadily() {
   
       //move by speed for every tick of the program 
        move( (int)speed);
       //wraps the mover around the screen
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
    }
     
    /**
     * moveSteadily = moves the mover across the screen and wraps the movement across the edge of the screen
     */
    
    public void moveSteadily(int speedIn) {
        speed = speedIn;
        moveSteadily();
    }
}
