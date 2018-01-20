import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Counter extends Actor
{
   int score = 0;
   
    public void act() 
    {
        setImage(new GreenfootImage("Score : " + score, 24, Color.GREEN, Color.BLACK));
    }    
    
    public void addScore()
    {
        score++;
        
    }
}
